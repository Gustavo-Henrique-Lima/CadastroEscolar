package com.gustavonascimento.CadastroEscolar.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavonascimento.CadastroEscolar.entitys.Aluno;
import com.gustavonascimento.CadastroEscolar.entitys.Turma;
import com.gustavonascimento.CadastroEscolar.service.AlunoService;
import com.gustavonascimento.CadastroEscolar.service.TurmaService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService servAlu;
	
	@Autowired
	private TurmaService servTur;
	
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
	
	@PostMapping(value="/{id}")
	public ResponseEntity<Aluno> insert(@PathVariable Long id,@RequestBody Aluno aluno)
	{
		Turma turma=servTur.findById(id);
		if(!turma.equals(null) && turma.getAlunos().size()<turma.getCapacidade())
		{
			aluno=servAlu.insert(aluno);
			servAlu.addAluno(id,aluno.getId());
			URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(turma.getId()).toUri();
			return ResponseEntity.created(uri).body(aluno);
		}
		return ResponseEntity.badRequest().body(aluno);
	}
}