package com.wallet.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class WalletDto {
	
	private Long Id;
	
	@Length(min=3, message="O nome deve conter no minimo 3 caracteres")
	@NotNull(message="O nome não pode ser nulo")
	private String Name;
	@NotNull(message="Insira um valor para a carteira")
	private BigDecimal Value;
	


}
