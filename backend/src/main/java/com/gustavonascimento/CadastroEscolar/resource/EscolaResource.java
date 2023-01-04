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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Escola> findById(@PathVariable Long id)
	{
		Escola escola=servEsc.findById(id);
		return ResponseEntity.ok(escola);
	}
	
	@PostMapping
	public ResponseEntity<Escola> insert(@Valid @RequestBody Escola escola)
	{
		escola=servEsc.insert(escola);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(escola.getId()).toUri();
		return ResponseEntity.created(uri).body(escola);
	}
	
	@PutMapping(value="/{idEsc}/{idTurm}")
	public ResponseEntity<Void> addTurma(@PathVariable Long idEsc,@PathVariable Long idTurm)
	{
		servEsc.addTurma(idEsc,idTurm);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<Escola> atualizar(@PathVariable Long id, @RequestBody Escola escola)
	{
		escola=servEsc.update(id, escola);
		return ResponseEntity.ok().body(escola);
	}
		
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		servEsc.delete(id);
		return ResponseEntity.noContent().build();
	}
}