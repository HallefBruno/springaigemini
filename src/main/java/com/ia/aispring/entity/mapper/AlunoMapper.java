package com.ia.aispring.entity.mapper;

import com.ia.aispring.entity.Aluno;
import com.ia.aispring.entity.dto.AlunoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
	
	//@Mapping(source = "nomeAluno", target = "nome")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "matriculas", ignore = true)
    Aluno toEntity(AlunoDTO dto);
	
    AlunoDTO toDto(Aluno entity);
	
}
