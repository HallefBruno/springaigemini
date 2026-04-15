package com.ia.aispring.service;

import com.ia.aispring.entity.Aluno;
import com.ia.aispring.entity.dto.AlunoDTO;
import com.ia.aispring.entity.mapper.AlunoMapper;
import com.ia.aispring.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlunoService {
	
	private final AlunoRepository alunoRepository;
	private final AlunoMapper mapper;

	public AlunoService(AlunoRepository alunoRepository, AlunoMapper mapper) {
		this.alunoRepository = alunoRepository;
		this.mapper = mapper;
	}
	
	@Transactional
	public void salvar(AlunoDTO alunoDTO) {
		Aluno aluno = mapper.toEntity(alunoDTO);
		alunoRepository.save(aluno);
	}
	
}
