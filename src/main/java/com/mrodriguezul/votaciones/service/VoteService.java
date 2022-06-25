package com.mrodriguezul.votaciones.service;

import java.util.List;

import com.mrodriguezul.votaciones.dto.CreateVoteDto;
import com.mrodriguezul.votaciones.dto.VoteDto;

public interface VoteService {
	List<VoteDto> findAll();
	List<VoteDto> findAllByCandidate(Integer idCandidate);
	VoteDto create(CreateVoteDto createVoteDto);
}
