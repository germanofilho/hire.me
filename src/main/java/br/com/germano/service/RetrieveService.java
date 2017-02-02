package br.com.germano.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

public interface RetrieveService {
	
	ResponseEntity<?> accessUrl(HttpServletResponse response, String alias) throws IOException;
}
