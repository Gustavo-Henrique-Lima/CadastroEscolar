package com.gustavonascimento.CadastroEscolar.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="O nome é obrigatório")
	private String nome;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dataNascimento;
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	@ManyToMany(mappedBy = "alunos")
	private Set<Turma> turmas=new HashSet<>();

	public Aluno()
	{}

	public Aluno(Long id, @NotEmpty(message = "O nome é obrigatório") String nome, LocalDate dataNascimento,
			Endereco endereco) 
	{
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public LocalDate getDataNascimento() 
	{
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) 
	{
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() 
	{
		return endereco;
	}

	public void setEndereco(Endereco endereco) 
	{
		this.endereco = endereco;
	}

	public Set<Turma> getTurmas() 
	{
		return turmas;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}
}