package com.gustavonascimento.CadastroEscolar.entitys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	@NotEmpty(message="O logradouro é obrigatório")
	private String logradouro;
	private String complemento;
	@NotEmpty(message="O bairro é obrigatório")
	private String bairro;
	@NotEmpty(message="A cidade é obrigatória")
	private String cidade;
	@NotEmpty(message="O estado é obrigatório")
	private String estado;
	
	public Endereco()
	{}

	public Endereco(Long id, String logradouro, String complemento, String bairro, String cidade, String estado) 
	{
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getLogradouro() 
	{
		return logradouro;
	}

	public void setLogradouro(String logradouro) 
	{
		this.logradouro = logradouro;
	}

	public String getComplemento() 
	{
		return complemento;
	}

	public void setComplemento(String complemento) 
	{
		this.complemento = complemento;
	}

	public String getBairro() 
	{
		return bairro;
	}

	public void setBairro(String bairro) 
	{
		this.bairro = bairro;
	}

	public String getCidade() 
	{
		return cidade;
	}

	public void setCidade(String cidade) 
	{
		this.cidade = cidade;
	}

	public String getEstado() 
	{
		return estado;
	}

	public void setEstado(String estado) 
	{
		this.estado = estado;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(bairro, cidade, complemento, estado, logradouro);
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
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(estado, other.estado)
				&& Objects.equals(logradouro, other.logradouro);
	}
}