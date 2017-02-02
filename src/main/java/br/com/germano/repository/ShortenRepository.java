package br.com.germano.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.germano.model.Url;

@Repository
public interface ShortenRepository extends JpaRepository<Url, String>{
	
	public Collection<Url> findTop10ByOrderByViewsDesc();

}
