package com.ia.aispring.entity.dto;

import com.ia.aispring.validacao.IdadeMinimaInteiro;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import com.ia.aispring.validacao.IdadeMinimaLocalDate;

public record AlunoDTO (
	@NotEmpty(message = "O nome é obrigatório") String nome,
	
	@IdadeMinimaInteiro
	@NotNull(message = "A idade é obrigatória") 
	Integer idade,
	
	@NotEmpty(message = "O cpf é obrigatório")
	@Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos")
	String cpf,
	
	@IdadeMinimaLocalDate
	@NotNull(message = "A data de nascimento é obrigatória") 
	LocalDate dataNascimento) {
}
