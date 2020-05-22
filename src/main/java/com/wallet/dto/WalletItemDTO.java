package com.wallet.dto;

import java.math.BigDecimal;
import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class WalletItemDTO {

	private Long ID;
	@NotNull(message="Insira o ID da carteira")
	private Long wallet;
	@NotNull(message="Informe uma  data")
	private Date date;
	@NotNull(message="Informe um  tipo")
	private String type;
	@NotNull(message ="Informe uma descrição")
	@Length(min =5, message ="A descriação deve ter no minimo 5 carctares")
	private String description;
	@NotNull(message = "Informe um valor")
	private BigDecimal value;
}
