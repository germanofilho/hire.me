package br.com.germano.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.germano.service.RetrieveService;

@RestController
public class RetrieveController {
	
	@Autowired
	private RetrieveService retrieveService;
	
	@RequestMapping(value="/u/{alias}", method = RequestMethod.GET)
	public ResponseEntity<?> accessUrl(HttpServletResponse response, @PathVariable("alias") String alias) throws IOException{
		ResponseEntity<?> url = retrieveService.accessUrl(response, alias);
		return url;
	}
	
}
