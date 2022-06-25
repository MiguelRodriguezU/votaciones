package com.mrodriguezul.votaciones;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mrodriguezul.votaciones.entity.CandidateEntity;
import com.mrodriguezul.votaciones.repository.CandidateRepository;
import com.mrodriguezul.votaciones.service.CandidateService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CandidateServiceTest {
	@Autowired
	private CandidateService candidateService;
	
	@MockBean
	private CandidateRepository candidateRepository;
	
	public void testGetCandidateRepository() throws Exception{
		
		Optional<CandidateEntity> optCandidate = Optional.of(createCandidate());
	    when(candidateRepository.findById(1)).thenReturn(optCandidate);
	    assert candidateService.findById(1).getFullName().contains("Rafael");
	}
	  private CandidateEntity createCandidate() {
		  CandidateEntity candidateEntity = new CandidateEntity();
		  candidateEntity.setId(1);
		  candidateEntity.setNames("Rafael");
		  candidateEntity.setSurnames("Lopez");
		  candidateEntity.setBirthdate("01/01/1962");
		  candidateEntity.setProposal("Sin Impuestos para todos");
		  candidateEntity.setPoliticalParty("Renovación Popular");
		  
		  return candidateEntity;
	  }
	
}
