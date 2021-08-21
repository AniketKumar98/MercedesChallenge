package com.example.hackerearth.mercedeschallenge.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackerearth.mercedeschallenge.Request.StoreDataRequest;
import com.example.hackerearth.mercedeschallenge.entity.MercedeschallengeEntity;
import com.example.hackerearth.mercedeschallenge.repository.ChallengeRepository;

@Service
public class MercedesService {
	
	@Autowired
	ChallengeRepository challengeRepository;
	
	public void store(StoreDataRequest data) {
		MercedeschallengeEntity e=new MercedeschallengeEntity();
		e.setFrom(data.getFromdate());
		e.setTo(data.getTodate());
		e.setName(data.getName());
		e.setOccur(data.getOccur());
		challengeRepository.save(e);
	}
	
	public Iterable<MercedeschallengeEntity> getdata(){
		return challengeRepository.findAll();
	}
	
	public void delete(int id){
		challengeRepository.deleteById(id);
	}
	
	public void storedataedit(StoreDataRequest data) {
//		challengeRepository.update(data.getName(), data.getOccur(), data.getFromdate(), data.getTodate(), data.getId());
	}

}
