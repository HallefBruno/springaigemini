package com.ia.aispring.controller;

import com.ia.aispring.entity.dto.CursoDTO;
import com.ia.aispring.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {
	
	private final CursoService cursoService;
	
	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	@PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody CursoDTO cursoDTO) {
        cursoService.salvar(cursoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
}
