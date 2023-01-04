package com.gustavonascimento.CadastroEscolar.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Turma> findById(@PathVariable Long id)
	{
		Turma turma=servTur.findById(id);
		return ResponseEntity.ok(turma);
	}
	
	@PostMapping
	public ResponseEntity<Turma> insert(@Valid @RequestBody Turma turma)
	{
		turma=servTur.insert(turma);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(turma.getId()).toUri();
		return ResponseEntity.created(uri).body(turma);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Turma> update(@PathVariable Long id,@RequestBody Turma turma)
	{
		turma=servTur.update(id, turma);
		return ResponseEntity.ok(turma);
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		servTur.delete(id);
		return ResponseEntity.noContent().build();
	}
}