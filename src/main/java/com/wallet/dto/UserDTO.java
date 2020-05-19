package com.wallet.dto;

import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	
	
	private Long id;
	
	@Email(message="Email invalido")
	
	private String email;
	@Length(min=3,max=50,message="O nome deve conter entre 3 e 50 caracteres")
	
	private String nome;
	@NotNull
	@Length(min=6,message="A senha deve conter no minimo 6 caracteres")
	
	private String password;
	public String getnome;
	public String getPassword;
	
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setId(Long id) {
		this.id = id;
	}

	

	

}
