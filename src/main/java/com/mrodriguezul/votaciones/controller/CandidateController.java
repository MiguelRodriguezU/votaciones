package com.mrodriguezul.votaciones.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mrodriguezul.votaciones.beans.CandidateResponse;
import com.mrodriguezul.votaciones.dto.CandidateDto;
import com.mrodriguezul.votaciones.dto.CreateCandidateDto;
import com.mrodriguezul.votaciones.dto.CreateVoteDto;
import com.mrodriguezul.votaciones.dto.VoteDto;
import com.mrodriguezul.votaciones.service.CandidateService;
import com.mrodriguezul.votaciones.service.VoteService;
import static com.mrodriguezul.votaciones.util.Constantes.*;


@RestController
@RequestMapping("/v1/candidates")
public class CandidateController {	
	
	private final CandidateService candidateService;
	private final VoteService voteService;

	public CandidateController(CandidateService candidateService, VoteService voteService) {
		this.candidateService = candidateService;
		this.voteService = voteService;
	}
	
	@GetMapping(produces = "application/json;charset=utf-8")
	public ResponseEntity<List<CandidateDto>> findAll(){
		return ResponseEntity.ok(candidateService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ResponseEntity<?> create(@RequestBody CreateCandidateDto createCandidateDto) {
		if(createCandidateDto == null) {
			return new ResponseEntity<CandidateResponse>(new CandidateResponse(CANDIDATO_CODIGO_NO_ESPECIFICADO,CANDIDATO_MENSAJE_NO_ESPECIFICADO), HttpStatus.UNPROCESSABLE_ENTITY);			
		}
		CandidateDto candidateDto = candidateService.create(createCandidateDto);
		return ResponseEntity.ok(candidateDto);
	}
	
	@GetMapping(value = "/{id}/votes", produces = "application/json;charset=utf-8")
	public ResponseEntity<?> findVotes(@PathVariable("id") Integer id){
		if(id != null) {
			List<VoteDto> votesDto = new ArrayList<VoteDto>();
			CandidateDto candidateDto = candidateService.findById(id);
			if(candidateDto != null) {
				votesDto = voteService.findAllByCandidate(id);
				return ResponseEntity.ok(votesDto);
			}else {
				return new ResponseEntity<CandidateResponse>(new CandidateResponse(CANDIDATO_CODIGO_CODIGO_INCORRECTO,CANDIDATO_MENSAJE_CODIGO_CODIGO_INCORRECTO), HttpStatus.UNPROCESSABLE_ENTITY);
			}			
		}else {
			return new ResponseEntity<CandidateResponse>(new CandidateResponse(CANDIDATO_CODIGO_NO_ESPECIFICA_CODIGO,CANDIDATO_MENSAJE_CODIGO_NO_ESPECIFICA_CODIGO), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@RequestMapping(value = "/{id}/votes", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ResponseEntity<?> createVote(@PathVariable("id") Integer id) {
		if(id != null) {			
			CandidateDto candidateDto = candidateService.findById(id);
			if(candidateDto != null) {
				VoteDto voteDto = voteService.create(new CreateVoteDto(candidateDto.getId()));
				return ResponseEntity.ok(voteDto);
			}else {
				return new ResponseEntity<CandidateResponse>(new CandidateResponse(CANDIDATO_CODIGO_CODIGO_INCORRECTO,CANDIDATO_MENSAJE_CODIGO_CODIGO_INCORRECTO), HttpStatus.UNPROCESSABLE_ENTITY);
			}			
		}else {
			return new ResponseEntity<CandidateResponse>(new CandidateResponse(CANDIDATO_CODIGO_NO_ESPECIFICA_CODIGO,CANDIDATO_MENSAJE_CODIGO_NO_ESPECIFICA_CODIGO), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
