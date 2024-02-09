package com.sims.policyproject.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Policy {
	
	@Id
	private String policyNumber;
	private String policyPerson;
	private String phoneNumber;
	private String address;
	private Integer termDuration;
	private LocalDate effectiveDate;
	private LocalDate expirationDate;
	private Integer premium;
	//private List<String> coverages;
	
	
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPolicyPerson() {
		return policyPerson;
	}
	public void setPolicyPerson(String policyPerson) {
		this.policyPerson = policyPerson;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getTermDuration() {
		return termDuration;
	}
	public void setTermDuration(Integer termDuration) {
		this.termDuration = termDuration;
	}
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Integer getPremium() {
		return premium;
	}
	public void setPremium(Integer premium) {
		this.premium = premium;
	}
//	public List<String> getCoverages() {
//		return coverages;
//	}
//	public void setCoverages(List<String> coverages) {
//		this.coverages = coverages;
//	}
	

	
}
