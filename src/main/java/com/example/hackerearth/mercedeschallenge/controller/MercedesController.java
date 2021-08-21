package com.example.hackerearth.mercedeschallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackerearth.mercedeschallenge.Request.StoreDataRequest;
import com.example.hackerearth.mercedeschallenge.entity.MercedeschallengeEntity;
import com.example.hackerearth.mercedeschallenge.service.MercedesService;

import antlr.collections.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api")
public class MercedesController {
	
	@Autowired
	MercedesService mercedesService;
	
	@PostMapping("/store")
	public void storedata(@RequestBody StoreDataRequest s){
		mercedesService.store(s);
	}
	
	@PostMapping("/storeedit")
	public void storedataedit(@RequestBody StoreDataRequest s){
		mercedesService.storedataedit(s);
	}
	
	@GetMapping("/get")
	public Iterable<MercedeschallengeEntity> getdata(){
		return mercedesService.getdata();
	}
	
	@GetMapping("/delete")
	public void delete(@RequestParam int id){
		mercedesService.delete(id);
	}
}
