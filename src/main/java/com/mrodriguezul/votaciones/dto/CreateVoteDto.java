package com.mrodriguezul.votaciones.dto;

import java.io.Serializable;

public class CreateVoteDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idCandidate;
	

	public CreateVoteDto() {
		super();
	}

	public CreateVoteDto(Integer idCandidate) {
		super();
		this.idCandidate = idCandidate;
	}

	public Integer getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(Integer idCandidate) {
		this.idCandidate = idCandidate;
	}
	
}
