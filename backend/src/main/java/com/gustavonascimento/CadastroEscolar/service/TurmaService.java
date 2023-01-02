package com.gustavonascimento.CadastroEscolar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.CadastroEscolar.entitys.Turma;
import com.gustavonascimento.CadastroEscolar.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repoTur;
	
	
	public List<Turma> findall()
	{
		return repoTur.findAll();
	}
}