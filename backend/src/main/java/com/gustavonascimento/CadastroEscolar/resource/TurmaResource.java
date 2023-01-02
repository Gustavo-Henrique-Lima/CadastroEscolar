package com.gustavonascimento.CadastroEscolar.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.CadastroEscolar.entitys.Turma;
import com.gustavonascimento.CadastroEscolar.service.TurmaService;

@RestController
@RequestMapping(value="/turmas")
public class TurmaResource {

	@Autowired
	private TurmaService servTur;
	
	@GetMapping
	public ResponseEntity<List<Turma>> findAll()
	{
		List<Turma> turmas=servTur.findall();
		return ResponseEntity.ok(turmas);
	}
}