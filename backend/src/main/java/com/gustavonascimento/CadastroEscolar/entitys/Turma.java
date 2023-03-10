package com.gustavonascimento.CadastroEscolar.entitys;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int capacidade;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_escola")
	private Escola escola;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "alunos_turma",
	joinColumns = @JoinColumn(name="turma_id"),
	inverseJoinColumns = @JoinColumn(name="aluno_id"))
	private Set<Aluno> alunos=new HashSet<>();
	
	public Turma() 
	{}
	
	public Turma(Long id, String nome, int capacidade, Escola escola) 
	{
		super();
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.escola = escola;
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

	public int getCapacidade() 
	{
		return capacidade;
	}

	public void setCapacidade(int capacidade) 
	{
		this.capacidade = capacidade;
	}

	public Escola getEscola() 
	{
		return escola;
	}

	public void setEscola(Escola escola) 
	{
		this.escola = escola;
	}

	public Set<Aluno> getAlunos() 
	{
		return alunos;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(escola, nome);
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
		Turma other = (Turma) obj;
		return Objects.equals(escola, other.escola) && Objects.equals(nome, other.nome);
	}
}