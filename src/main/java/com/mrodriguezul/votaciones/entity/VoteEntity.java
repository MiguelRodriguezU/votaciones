package com.mrodriguezul.votaciones.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vote")
public class VoteEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idVote;
    
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private CandidateEntity candidateEntity;

	public Integer getIdVote() {
		return idVote;
	}

	public void setIdVote(Integer idVote) {
		this.idVote = idVote;
	}

	public CandidateEntity getCandidateEntity() {
		return candidateEntity;
	}

	public void setCandidateEntity(CandidateEntity candidateEntity) {
		this.candidateEntity = candidateEntity;
	}

	@Override
	public String toString() {
		return "VoteEntity [idVote=" + idVote + ", candidateEntity=" + candidateEntity + "]";
	}
	
}
