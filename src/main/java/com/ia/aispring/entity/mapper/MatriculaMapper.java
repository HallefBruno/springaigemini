package com.ia.aispring.entity.mapper;

import com.ia.aispring.entity.Matricula;
import com.ia.aispring.entity.dto.MatriculaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatriculaMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "dataMatricula", ignore = true)
	@Mapping(target = "aluno", ignore = true)
	@Mapping(target = "curso", ignore = true)
    Matricula toEntity(MatriculaDTO dto);
	
	@Mapping(target = "idAluno", ignore = true)
	@Mapping(target = "idCurso", ignore = true)
    MatriculaDTO toDto(Matricula entity);
	
}
