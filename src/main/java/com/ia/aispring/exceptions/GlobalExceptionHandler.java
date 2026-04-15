package com.ia.aispring.exceptions;

import com.ia.aispring.entity.dto.ex.ErroValidacaoDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErroValidacaoDTO>> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<ErroValidacaoDTO> erros = new ArrayList<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			erros.add(new ErroValidacaoDTO(error.getField(), error.getDefaultMessage()));
		});

		ex.getBindingResult().getGlobalErrors().forEach(error -> {
			erros.add(new ErroValidacaoDTO(error.getObjectName(), error.getDefaultMessage()));
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroValidacaoDTO> handleDuplicatedData(DataIntegrityViolationException ex) {
        String mensagem = "Recurso já cadastrado.";
        
        if (ex.getMessage().contains("uk_aluno_email")) {
            mensagem = "Este e-mail já está em uso no sistema.";
        }

        ErroValidacaoDTO erro = new ErroValidacaoDTO("conflito", mensagem);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
	
	@ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErroValidacaoDTO> responseStatusException(ResponseStatusException ex) {
        ErroValidacaoDTO erro = new ErroValidacaoDTO("", ex.getReason());
        return ResponseEntity.status(ex.getStatusCode()).body(erro);
    }

}