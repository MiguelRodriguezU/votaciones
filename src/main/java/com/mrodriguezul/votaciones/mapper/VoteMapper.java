package com.mrodriguezul.votaciones.mapper;

import org.springframework.stereotype.Component;

import com.mrodriguezul.votaciones.dto.CandidateDto;
import com.mrodriguezul.votaciones.dto.CreateCandidateDto;
import com.mrodriguezul.votaciones.dto.CreateVoteDto;
import com.mrodriguezul.votaciones.dto.VoteDto;
import com.mrodriguezul.votaciones.entity.CandidateEntity;
import com.mrodriguezul.votaciones.entity.VoteEntity;

@Component
public class VoteMapper {
	
	public VoteDto toDto(VoteEntity voteEntity) {
		if(voteEntity == null) {
			return null;
		}
		VoteDto voteDto = new VoteDto();
		voteDto.setIdVote(voteEntity.getIdVote());
		
		return voteDto;	
	}
	
	public VoteEntity toEntity(CreateVoteDto createVoteDto) {
		if(createVoteDto == null) {
			return null;
		}
		VoteEntity voteEntity = new VoteEntity();
		
		voteEntity.setIdVote(0);
		voteEntity.setCandidateEntity(new CandidateEntity(createVoteDto.getIdCandidate()));		
		
		return voteEntity;	
	}

}
