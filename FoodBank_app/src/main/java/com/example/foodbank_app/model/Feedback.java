package com.example.foodbank_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
		@Column(name = "feedback")
		private String feedback;
		
	
		public Feedback() {
			
		}
		
		public void setID(Long myid) {
			this.id = myid;
		}
		public Long getID(Long myid) {
			return id;
		}
		
		
		
		public Feedback(String feedback) {
			super();
			this.feedback = feedback;
		}

		public String getFeedback() {
			return feedback;
		}

		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		
		
	}



