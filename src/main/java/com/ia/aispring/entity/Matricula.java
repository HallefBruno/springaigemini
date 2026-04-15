package com.ia.aispring.entity;

import com.ia.aispring.validacao.IntervaloDataValido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

@IntervaloDataValido
@Entity
@Table(name = "matriculas", uniqueConstraints = {
    @UniqueConstraint(
        name = "uk_aluno_curso", 
        columnNames = {"aluno_id", "curso_id"}
    )
})
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDate dataMatricula;
	
	@FutureOrPresent(message = "A data de início deve ser hoje ou uma data futura")
	private LocalDate dataInicio;
	
	@Future(message = "A data de término deve ser uma data futura")
	private LocalDate dataTermino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	@Override
	public String toString() {
		return "Matricula{" + "id=" + id + ", aluno=" + aluno + ", curso=" + curso + ", dataMatricula=" + dataMatricula + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + '}';
	}

}
