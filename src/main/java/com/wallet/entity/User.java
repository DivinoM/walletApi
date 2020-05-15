package com.wallet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(nullable=false)
		private String password;
		@Column(nullable=false)
		private String nome;
		@Column(nullable=false)
		private String email;
		
		public void setnome(String string) {
			// TODO Auto-generated method stub
			
		}
		public void setemail(String string) {
			// TODO Auto-generated method stub
			
		}
		public void setpassword(String string) {
			// TODO Auto-generated method stub
			
		}
		public Object getEmail() {
			// TODO Auto-generated method stub
			return null;
		}
		
}
