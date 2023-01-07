package com.gustavonascimento.CadastroEscolar.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id)
	{
		Aluno aluno=servAlu.findById(id);
		return ResponseEntity.ok(aluno);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Long id,@RequestBody Aluno aluno)
	{
		aluno=servAlu.update(id, aluno);
		return ResponseEntity.ok(aluno);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		servAlu.delete(id);
		return ResponseEntity.noContent().build();
	}
}