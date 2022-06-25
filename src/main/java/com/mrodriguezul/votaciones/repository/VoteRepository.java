package com.mrodriguezul.votaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrodriguezul.votaciones.entity.VoteEntity;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Integer>{
	
	@Query(value = "select v.* from Vote v where id = ?1", nativeQuery = true)
    List<VoteEntity> findAllByCandidate(Integer idCandidate);

}
