package com.ia.aispring.service;

import com.ia.aispring.entity.Curso;
import com.ia.aispring.entity.dto.CursoDTO;
import com.ia.aispring.entity.mapper.CursoMapper;
import com.ia.aispring.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoService {
	
	private final CursoRepository cursoRepository;
	private final CursoMapper mapper;

	public CursoService(CursoRepository cursoRepository, CursoMapper mapper) {
		this.cursoRepository = cursoRepository;
		this.mapper = mapper;
	}
	
	@Transactional
	public void salvar(CursoDTO cursoDTO) {
		Curso curso = mapper.toEntity(cursoDTO);
		cursoRepository.save(curso);
	}
	
}
