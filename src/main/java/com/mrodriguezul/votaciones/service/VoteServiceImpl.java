package com.mrodriguezul.votaciones.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mrodriguezul.votaciones.dto.CreateVoteDto;
import com.mrodriguezul.votaciones.dto.VoteDto;
import com.mrodriguezul.votaciones.entity.VoteEntity;
import com.mrodriguezul.votaciones.mapper.VoteMapper;
import com.mrodriguezul.votaciones.repository.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService{
	
	private final VoteRepository voteRepository;	
	private final VoteMapper voteMapper;	

	public VoteServiceImpl(VoteRepository voteRepository, VoteMapper voteMapper) {
		super();
		this.voteRepository = voteRepository;
		this.voteMapper = voteMapper;
	}

	@Override
	public List<VoteDto> findAll() {
		List<VoteEntity> voteEntities = voteRepository.findAll();
		return voteEntities.stream().map(voteMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<VoteDto> findAllByCandidate(Integer idCandidate) {
		List<VoteEntity> voteEntities = voteRepository.findAllByCandidate(idCandidate);
		return voteEntities.stream().map(voteMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public VoteDto create(CreateVoteDto createVoteDto) {		
		VoteEntity voteEntity = voteMapper.toEntity(createVoteDto);
		voteEntity = voteRepository.save(voteEntity);
		return voteMapper.toDto(voteEntity);	
		
	}

}
