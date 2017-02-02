package br.com.germano.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.germano.Singleton;
import br.com.germano.model.Error;
import br.com.germano.model.Statistic;
import br.com.germano.model.Url;
import br.com.germano.repository.ShortenRepository;
import br.com.germano.utils.AliasUtil;

@Service
public class ShortenServiceBean implements ShortenService{


	@Autowired
	private ShortenRepository shortenRepository;
	
	private static String baseUrl = "localhost:8080/u/";
	private static Map<String, Url> shortenMap;
	private long startTime;
	
	@Override
	public Collection<Url> findAll() {
		Collection<Url> url = shortenMap.values();
		return url;
	}

	@Override
	public Url create(String url) {
		startTime = System.currentTimeMillis();
		
		Url urlObj = new Url(url, AliasUtil.createAlias());
		isNeededSetHttp(url, urlObj);
		Statistic statistic = new Statistic();
		urlObj.setUrlShorten(baseUrl + urlObj.getAlias());
		statistic.setTime_taken(getTimeMillis().toString() + " ms");
		urlObj.setStatistics(statistic);
		save(urlObj);
		return urlObj;
	}

	@Override
	public ResponseEntity<?> createWithAlias(String url, String alias) {
		startTime = System.currentTimeMillis();
		if(isValid(alias)){
			Url urlObj = new Url(url);
			isNeededSetHttp(url, urlObj);
			Statistic statistic = new Statistic();
			urlObj.setAlias(alias);
			urlObj.setUrlShorten(baseUrl + urlObj.getAlias());
			statistic.setTime_taken(getTimeMillis().toString() + " ms");
			urlObj.setStatistics(statistic);
			save(urlObj);
			return new ResponseEntity<Url>(urlObj,HttpStatus.OK);
		} else {
			Error error = new Error(alias, "001", "CUSTOM ALIAS ALREADY EXISTS");
			return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
		}
	}
	
	//Save url in Data Store
	@Override
	public Url save(Url url) {
		if(Singleton.getShortenMap() == null){
			shortenMap = new HashMap<String, Url>();
		}
		shortenMap.put(url.getAlias(), url);
		Singleton.setShortenMap(shortenMap);
		return url;
	}
	
	//return time taken
	private Long getTimeMillis(){
		return System.currentTimeMillis() - startTime;
	}
	
	//Verify if alias already exists
	private boolean isValid(String alias){
		if(shortenMap != null){
			if(shortenMap.containsKey(alias)){
				return false;
			}
		}
		return true;
	}
	
	private void isNeededSetHttp(String url, Url urlObj){
		if(!url.contains("http://")){
			urlObj.setUrlDst("http://" + url);
		}
	}
}
