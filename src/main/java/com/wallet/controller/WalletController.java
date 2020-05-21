package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.wallet.repository.UserRepository;

import com.wallet.entity.Wallet;
import com.wallet.response.Response;
import com.wallet.service.WalletService;
import com.wallet.dto.WalletDto;

@RestController
@RequestMapping("wallet")
public class WalletController {
	
	@Autowired
	private WalletService service;
	@PostMapping
	
public ResponseEntity<Response<Wallet>> create(@Valid @RequestBody WalletDto dto,BindingResult result){
	Response<WalletDto> response = new Response<WalletDto>();
		if(result.hasErrors()) {
		
			result.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()))
			return ResponseEntity.badRequest().body(response);
		}
		
		Wallet w =service.save(this.convertDtoEntity(dto));
		response.setData(this.convertToDtoEntity(w));
		
		return ResponseEntity.ok().body(response);
		
	}
		private Wallet convertDtoEntity(WalletDto dto) {
			Wallet w= new Wallet();
			w.setId(dto.getId());
			w.setName(dto.getName());
			w.setValue(dto.getValue());
			return w;
	}
		private WalletDto convertToDtoEntity(Wallet w) {
			Wallet dto= new Wallet();
			dto.setId(w.getId());
			dto.setName(w.getName());
			dto.setValue(w.getValue());
			return dto;
			
		
	}
}
