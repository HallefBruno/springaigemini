package com.ia.aispring.controller;

import com.ia.aispring.entity.dto.MatriculaDTO;
import com.ia.aispring.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/matriculas")
public class MatriculaController {
	
	private final MatriculaService matriculaService;

	public MatriculaController(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
	}
	
	@PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody MatriculaDTO matriculaDTO) {
        matriculaService.salvar(matriculaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
	@GetMapping("/busca-inteligente")
    public ResponseEntity<?> buscarMatriculasPorLinguagemNatural(@RequestParam("pergunta") String pergunta) {
        //matriculaService.extrairData(pergunta);
        return ResponseEntity.ok(matriculaService.extrairData(pergunta));
    }
	
}
