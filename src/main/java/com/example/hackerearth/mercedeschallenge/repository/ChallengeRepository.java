package com.example.hackerearth.mercedeschallenge.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.hackerearth.mercedeschallenge.entity.MercedeschallengeEntity;

public interface ChallengeRepository extends CrudRepository<MercedeschallengeEntity, Integer> {
	
//	@Transactional
//	@Modifying
//	@Query("update MercedeschallengeEntity m set m.name= :name , m.from = :from , m.to = :to, m.occur = :occur where m.id = :id")
//	public int update(@Param("name") String name,@Param("occur") String occur,@Param("from") Date fromdate,@Param("to") Date todate,@Param("id") Integer id);
}	
