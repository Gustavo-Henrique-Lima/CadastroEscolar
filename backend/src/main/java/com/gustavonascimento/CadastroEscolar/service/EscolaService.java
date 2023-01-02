package com.gustavonascimento.CadastroEscolar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.CadastroEscolar.entitys.Escola;
import com.gustavonascimento.CadastroEscolar.repository.EscolaRepository;

@Service
public class EscolaService {

	@Autowired
	private EscolaRepository repoEsc;
	
	public List<Escola> findAll()
	{
		return repoEsc.findAll();
	}
}