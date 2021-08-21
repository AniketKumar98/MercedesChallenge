package com.example.hackerearth.mercedeschallenge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="challenge")
public class MercedeschallengeEntity {
	
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	  private Integer id;
	
		@Column(name="fromdate")
	  private Date from;
		@Column(name="todate")
	  private Date to;
		
		@Column(name="Name")
		  private String name;
	
		@Column(name="occur")
		  private String occur;
		
		
		public String getOccur() {
			return occur;
		}
		public void setOccur(String occur) {
			this.occur = occur;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Date getFrom() {
			return from;
		}
		public void setFrom(Date from) {
			this.from = from;
		}
		public Date getTo() {
			return to;
		}
		public void setTo(Date to) {
			this.to = to;
		}
}
