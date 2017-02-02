package br.com.germano.model;

public class Error {
	
	private String alias;
	private String errorCode;
	private String description;
	
	public Error(){
		
	}
	
	public Error(String alias, String errorCode, String description){
		this.alias = alias;
		this.errorCode = errorCode;
		this.description = description;
		
	}
	
	public Error(String errorCode, String description){
		this.errorCode = errorCode;
		this.description = description;
		
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
