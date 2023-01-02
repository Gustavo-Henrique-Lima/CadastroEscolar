package com.gustavonascimento.CadastroEscolar.entitys;

import java.io.Serializable;
import java.util.Objects;

public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private int capacidade;
	private Escola escola;
	
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