package br.com.germano.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.germano.Singleton;
import br.com.germano.model.Error;
import br.com.germano.model.Url;

@Service
public class RetrieveServiceBean implements RetrieveService {

	@Override
	public ResponseEntity<?> accessUrl(HttpServletResponse response, String alias) throws IOException {
		
		if(Singleton.getShortenMap() == null || !Singleton.getShortenMap().containsKey(alias)){
			Error error = new Error("002", "SHORTENED URL NOT FOUND");
			return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
		} 
		Url url = Singleton.getShortenMap().get(alias);
		
		//increments view in the shorten url
		url.setViews(url.getViews() +1);
		
		response.sendRedirect(url.getUrlDst());			
		return null;
	}
}
