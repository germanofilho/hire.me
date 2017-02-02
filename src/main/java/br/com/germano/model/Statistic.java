package br.com.germano.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Statistic {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(targetEntity=Url.class, mappedBy="statistics", fetch=FetchType.EAGER)
	private String time_taken;
	
	public Statistic(){
		
	}

	public String getTime_taken() {
		return time_taken;
	}

	public void setTime_taken(String time_taken) {
		this.time_taken = time_taken;
	}

}
