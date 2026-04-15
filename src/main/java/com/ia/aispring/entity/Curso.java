package com.ia.aispring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.List;

@Entity
@Table(name = "cursos", uniqueConstraints = {
    @UniqueConstraint(name = "uk_nome_curso", columnNames = "nome")
})
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Boolean ativo;
	@OneToMany(mappedBy = "curso")
    private List<Matricula> matriculas;
	
	public Curso() {}
	
	public Curso(String nome, Boolean ativo) {
		this.nome = nome;
		this.ativo = ativo;
	}
	
	public Curso(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "Curso{" + "id=" + id + ", nome=" + nome + ", ativo=" + ativo + '}';
	}

	
}
