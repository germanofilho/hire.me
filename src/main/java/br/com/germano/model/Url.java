package br.com.germano.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Url {
	
	@Id
	private String alias;
	
	private String urlShorten;
	
	@JsonIgnore
	private String urlDst;
	
	@OneToOne
	@JoinColumn(name="id")
	private Statistic statistics;
	
	@JsonIgnore
	private int views = 0;
	
	public Url(){
		
	}
	
	public Url(String urlDst, String alias){
		this.urlDst = urlDst;
		this.alias = alias;
	}
	
	public Url(String urlDst){
		this.urlDst = urlDst;
	}
	
	public String getUrlDst() {
		return urlDst;
	}
	
	public void setUrlDst(String urlDst) {
		this.urlDst = urlDst;
	}
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUrlShorten() {
		return urlShorten;
	}

	public void setUrlShorten(String url) {
		this.urlShorten = url;
	}

	public Statistic getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistic statistics) {
		this.statistics = statistics;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

}
