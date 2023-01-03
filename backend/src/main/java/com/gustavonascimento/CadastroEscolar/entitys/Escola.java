package com.gustavonascimento.CadastroEscolar.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Escola implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="O nome é obrigatório")
	private String nome;
	@NotEmpty(message="O endereço é obrigatório")
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	@OneToMany(mappedBy="escola")
	private List<Turma> turmas=new ArrayList<>();
	
	public Escola()
	{}

	public Escola(Long id, String nome, Endereco endereco)
	{
		super();
		this.id = id;
		this.nome = nome;
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

	public Endereco getEndereco() 
	{
		return endereco;
	}

	public void setEndereco(Endereco endereco) 
	{
		this.endereco = endereco;
	}
	
	public List<Turma> getTurmas() 
	{
		return turmas;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(endereco, id, nome);
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
		Escola other = (Escola) obj;
		return Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
}