package com.gustavonascimento.CadastroEscolar.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gustavonascimento.CadastroEscolar.entitys.Escola;
import com.gustavonascimento.CadastroEscolar.entitys.Turma;
import com.gustavonascimento.CadastroEscolar.repository.EscolaRepository;
import com.gustavonascimento.CadastroEscolar.repository.TurmaRepository;
import com.gustavonascimento.CadastroEscolar.service.exceptions.DatabaseException;
import com.gustavonascimento.CadastroEscolar.service.exceptions.ResourceNotFoundException;


@Service
public class EscolaService {

	@Autowired
	private EscolaRepository repoEsc;
	
	@Autowired
	private TurmaRepository repoTurm;
	
	public List<Escola> findAll()
	{
		return repoEsc.findAll();
	}
	
	public Escola findById(Long id)
	{
		Optional<Escola> escola=repoEsc.findById(id);
		return escola.orElseThrow(()->new ResourceNotFoundException(id));
	}
	
	public Escola insert(@Valid Escola escola)
	{
		return repoEsc.save(escola);
	}
	
	public void delete(Long id)
	{
		try
		{
			repoEsc.deleteById(id);
		}
		catch(ResourceNotFoundException e)
		{
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Escola update(Long id,Escola escola) 
	{
		try
		{
			Escola esc=repoEsc.getReferenceById(id);
			updateData(esc, escola);
			return repoEsc.save(esc);			
		}
		catch(EntityNotFoundException e) 
		{
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void addTurma(Long idEscola,Long idTurma)
	{
		try
		{
			Escola esc=repoEsc.getReferenceById(idEscola);
			try
			{
				Turma tur=repoTurm.getReferenceById(idTurma);	
				tur.setEscola(esc);
				repoTurm.save(tur);
			}
			catch(EntityNotFoundException e)
			{
				throw new ResourceNotFoundException(idTurma);
			}
		}
		catch(DataIntegrityViolationException e)
		{
			throw new ResourceNotFoundException(idEscola);
		}
	}
	
	private void updateData(Escola esc1,Escola esc2) 
	{
		esc1.setNome(esc2.getNome());
		esc1.setEndereco(esc2.getEndereco());
	}
}