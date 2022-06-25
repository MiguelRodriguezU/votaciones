package com.mrodriguezul.votaciones.service;

import java.util.List;

import com.mrodriguezul.votaciones.dto.CandidateDto;
import com.mrodriguezul.votaciones.dto.CreateCandidateDto;
import com.mrodriguezul.votaciones.dto.VoteDto;
import com.mrodriguezul.votaciones.entity.CandidateEntity;

public interface CandidateService {
	
	List<CandidateDto> findAll();
	CandidateDto findById(Integer id);
	CandidateDto create(CreateCandidateDto candidateEntity);	

}
