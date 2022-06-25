package com.mrodriguezul.votaciones.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.mrodriguezul.votaciones.dto.CandidateDto;
import com.mrodriguezul.votaciones.dto.CreateCandidateDto;
import com.mrodriguezul.votaciones.entity.CandidateEntity;
import com.mrodriguezul.votaciones.mapper.CandidateMapper;
import com.mrodriguezul.votaciones.repository.CandidateRepository;



@Service
public class CandidateServiceImpl implements CandidateService {
	
	private final CandidateRepository candidateRepository;
	private final CandidateMapper candidateMapper;	

	public CandidateServiceImpl(CandidateRepository candidateRepository, CandidateMapper candidateMapper) {
		super();
		this.candidateRepository = candidateRepository;
		this.candidateMapper = candidateMapper;
	}
	
	@Override
	public List<CandidateDto> findAll() {
		List<CandidateEntity> candidateEntities = candidateRepository.findAll();
		return candidateEntities.stream().map(candidateMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public CandidateDto create(CreateCandidateDto createCandidateDto) {
		CandidateEntity candidateEntity = candidateMapper.toEntity(createCandidateDto);
		
		candidateEntity = candidateRepository.save(candidateEntity);
		return candidateMapper.toDto(candidateEntity);
	}

	@Override
	public CandidateDto findById(Integer id) {
		Optional<CandidateEntity> candidateEntity = candidateRepository.findById(id);
		if(candidateEntity.isPresent()) {
			return candidateMapper.toDto(candidateEntity.get());
		}else {
			return null;
		}		
	}

}
