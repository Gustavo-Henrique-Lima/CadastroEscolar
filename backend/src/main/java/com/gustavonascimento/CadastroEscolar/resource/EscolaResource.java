package com.gustavonascimento.CadastroEscolar.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.CadastroEscolar.entitys.Escola;
import com.gustavonascimento.CadastroEscolar.service.EscolaService;

@RestController
@RequestMapping(value="/escolas")
public class EscolaResource {

	
	@Autowired
	private EscolaService servEsc;
	
	@GetMapping
	public ResponseEntity<List<Escola>> findAll()
	{
		List<Escola> escola=servEsc.findAll();
		return ResponseEntity.ok(escola);
	}
}