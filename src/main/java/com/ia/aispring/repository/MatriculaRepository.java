package com.ia.aispring.repository;

import com.ia.aispring.entity.Matricula;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
	
	public List<Matricula> findByDataInicio(LocalDate dataInicio);
	
}
