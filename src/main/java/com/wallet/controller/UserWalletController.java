package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserDTO;
import com.wallet.dto.UserWalletDTO;
import com.wallet.entity.User;
import com.wallet.entity.UserWallet;
import com.wallet.response.Response;
import com.wallet.service.UserWalletService;
import com.wallet.util.Bcrypt;

@RestController
@RequestMapping(path ="user-wallet")
public class UserWalletController {

	@Autowired
	private UserWalletService service;
	
	@PostMapping
	public ResponseEntity<Response<UserWalletDTO>> create(@Valid @RequestBody UserWalletDTO dto, BindingResult result){
		Response<UserWalletDTO> response = new Response<UserWalletDTO>();
		
		if (result.hasErrors()){
			result.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);
			
		}
		
		UserWallet uw =service.save(this.convertDTOtoEntity(dto));
		
		response.setdata(this.convertDTOtoEntity(uw));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
		
	}
	
private UserWallet convertDTOtoEntity(@Valid UserWalletDTO dto) {
		
		UserWallet uw = new UserWallet();
		User u= new User();
		
		u.setid(dto.getUsers());
		Wallet w = new Wallet();
		w.setid(dto.getWallet())
		uw.setid(dto.getid());
		uw.setUsers(u);
		uw.setWallet(w);
		return uw;
		
	}
	
	private UserWalletDTO convertEntityTODto(UserWallet uw) {
		UserWalletDTO dto = new UserWalletDTO();
		dto.setId(uw.getId());
		dto.setUsers(uw.getUsers().getId());
		dto.setWallet(uw.getWallet().getId());
		
		return dto;
		
	}
}
