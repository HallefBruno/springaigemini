package com.ia.aispring.entity.mapper;

import com.ia.aispring.entity.Curso;
import com.ia.aispring.entity.dto.CursoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CursoMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "matriculas", ignore = true)
	Curso toEntity(CursoDTO dto);
	
    CursoDTO toDto(Curso entity);
	
}
