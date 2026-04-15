package com.ia.aispring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "alunos", uniqueConstraints = {
    @UniqueConstraint(name = "uk_aluno_cpf", columnNames = "cpf")
})
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer idade;
	private LocalDate dataNascimento;
	private String cpf;
	@OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;
	
	public Aluno() {}
	
	public Aluno(Long id) {
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = StringUtils.getDigits(cpf);
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "Aluno{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + '}';
	}

	
}
