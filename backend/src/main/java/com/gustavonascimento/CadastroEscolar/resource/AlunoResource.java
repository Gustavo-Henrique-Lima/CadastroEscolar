package com.gustavonascimento.CadastroEscolar.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.CadastroEscolar.entitys.Aluno;
import com.gustavonascimento.CadastroEscolar.service.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService servAlu;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll()
	{
		List<Aluno> alunos=servAlu.findAll();
		return ResponseEntity.ok(alunos);
	}
}