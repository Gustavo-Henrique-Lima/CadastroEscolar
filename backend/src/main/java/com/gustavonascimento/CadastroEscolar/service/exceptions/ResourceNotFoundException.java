package com.gustavonascimento.CadastroEscolar.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id)
	{
		super("O id "+id+" não pertence a nenhum item cadastrado");
	}
}