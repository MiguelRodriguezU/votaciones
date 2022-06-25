package com.mrodriguezul.votaciones.mapper;

import org.springframework.stereotype.Component;

import com.mrodriguezul.votaciones.dto.CandidateDto;
import com.mrodriguezul.votaciones.dto.CreateCandidateDto;
import com.mrodriguezul.votaciones.entity.CandidateEntity;

@Component
public class CandidateMapper {
	
	public CandidateDto toDto(CandidateEntity candidateEntity) {
		if(candidateEntity == null) {
			return null;
		}
		CandidateDto candidateDto = new CandidateDto();
		candidateDto.setId(candidateEntity.getId());
		candidateDto.setFullName(candidateEntity.getNames()+" "+ candidateEntity.getSurnames());
		candidateDto.setBirthdate(candidateEntity.getBirthdate());
		candidateDto.setProposal(candidateEntity.getProposal());
		candidateDto.setPoliticalParty(candidateEntity.getPoliticalParty());
		
		return candidateDto;		
	}
	
	public CandidateEntity toEntity(CreateCandidateDto createCandidateDto) {
		if(createCandidateDto == null) {
			return null;
		}
		CandidateEntity candidateEntity = new CandidateEntity();
		
		candidateEntity.setId(0);
		candidateEntity.setNames(createCandidateDto.getNames());
		candidateEntity.setSurnames(createCandidateDto.getSurnames());
		candidateEntity.setBirthdate(createCandidateDto.getBirthdate());
		candidateEntity.setProposal(createCandidateDto.getProposal());
		candidateEntity.setPoliticalParty(createCandidateDto.getPoliticalParty());
		
		return candidateEntity;	
	}

}
