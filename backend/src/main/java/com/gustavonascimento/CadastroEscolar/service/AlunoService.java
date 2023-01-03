package com.gustavonascimento.CadastroEscolar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.CadastroEscolar.entitys.Aluno;
import com.gustavonascimento.CadastroEscolar.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repoAlu;
	
	public List<Aluno> findAll()
	{
		return repoAlu.findAll();
	}
}