package com.mrodriguezul.votaciones.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "candidate")
public class CandidateEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String names;
    private String surnames;
    private String birthdate;
    private String proposal;
    
    @OneToMany(mappedBy = "candidateEntity", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<VoteEntity> voteEntities;
    
    @Column(name = "politicalparty")
    private String politicalParty;
    
    
	public CandidateEntity(Integer id) {
		super();
		this.id = id;
	}
	
	public CandidateEntity() {
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
	public List<VoteEntity> getVoteEntities() {
		return voteEntities;
	}
	public void setVoteEntities(List<VoteEntity> voteEntities) {
		this.voteEntities = voteEntities;
	}
	
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", names=" + names + ", surnames=" + surnames + ", birthdate=" + birthdate
				+ ", proposal=" + proposal + ", politicalParty=" + politicalParty + "]";
	}

}
