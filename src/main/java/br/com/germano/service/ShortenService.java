package br.com.germano.service;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import br.com.germano.model.Url;

public interface ShortenService {
	
	Collection<Url> findAll();
	
	Url create(String url);
	
	Url save(Url url);
	
	ResponseEntity<?> createWithAlias(String url, String alias);
	
}
