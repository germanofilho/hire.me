package br.com.germano.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.germano.model.Url;
import br.com.germano.service.ShortenService;
@RestController
public class ShortenController {
	
	@Autowired
	private ShortenService shortenService;
	
	
	//Return list of ALL urls
	@RequestMapping(value="/url", method = RequestMethod.GET)
	public ResponseEntity<Collection<Url>> getUrl(){
		Collection<Url> url = shortenService.findAll();
		return new ResponseEntity<Collection<Url>>(url, HttpStatus.OK);
	}
	
	//create shorten url without custom alias
	@RequestMapping(value="/create", method = RequestMethod.POST, params = "url")
	public @ResponseBody Url putUrl(@RequestParam("url") String url){
		Url urlObj = shortenService.create(url);
		return urlObj;
	}
	
	//create shorten url with custom alias
	@RequestMapping(value="/create", method = RequestMethod.POST, params = {"url", "alias"})
	public ResponseEntity<?> putUrlAlias(@RequestParam("url") String url, 
			@RequestParam("alias") String alias){
			ResponseEntity<?> urlObj = shortenService.createWithAlias(url, alias);
			return urlObj;
	}
	
}
