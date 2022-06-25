package com.mrodriguezul.votaciones.dto;

import java.io.Serializable;

public class CreateCandidateDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String names;
    private String surnames;
    private String birthdate;
    private String proposal;
    private String politicalParty;
    
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getSurnames() {
		return surnames;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getProposal() {
		return proposal;
	}
	public void setProposal(String proposal) {
		this.proposal = proposal;
	}
	public String getPoliticalParty() {
		return politicalParty;
	}
	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}
    
    
}
