package com.ia.aispring.entity.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


public record MatriculaDTO(
	@NotNull(message = "Aluno é obrigatório") Long idAluno, 
	@NotNull(message = "Curso é obrigatório") Long idCurso, 
	@NotNull(message = "Data de inicio é obrigatória") LocalDate dataInicio, 
	@NotNull(message = "Data do termino é obrigatória") LocalDate dataTermino) {
	
}
