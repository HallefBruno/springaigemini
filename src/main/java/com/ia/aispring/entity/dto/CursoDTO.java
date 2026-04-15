package com.ia.aispring.entity.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CursoDTO(
	@NotEmpty(message = "O nome é obrigatório") 
	String nome,
	@NotNull(message = "Se ativo ou não é obrigatório")
	Boolean ativo) {
	
}
