package com.wallet.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserWalletDTO {
	
	private Long id;
	@NotNull(message ="Informe o Id do Usuário")
	private Long users;
	@NotNull(message ="Informe o Id da Carteira")
	private Long wallet;

}
