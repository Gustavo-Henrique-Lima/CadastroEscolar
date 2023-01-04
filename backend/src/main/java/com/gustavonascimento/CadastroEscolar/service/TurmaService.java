package com.gustavonascimento.CadastroEscolar.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
public class TurmaService {
	
	@Autowired
	private TurmaRepository repoTur;
	
	@Autowired
	private EscolaRepository repoEsc;
	
	public List<Turma> findall()
	{
		return repoTur.findAll();
	}
	
	public Turma findById(Long id)
	{
		Optional<Turma> turma =repoTur.findById(id);
		return turma.orElseThrow(()->new ResourceNotFoundException(id));
	}
	
	public Turma insert(Turma turma)
	{
		return repoTur.save(turma);
	}
	
	public void delete(Long id)
	{
		try
		{
			repoTur.deleteById(id);
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
	
	public Turma update(Long id,Turma turma)
	{
		try
		{
			Turma turma1=repoTur.getReferenceById(id);
			updateData(turma1,turma);
			return repoTur.save(turma1);
		}
		catch(EntityNotFoundException e) 
		{
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Turma turma1,Turma turma2)
	{
		turma1.setNome(turma2.getNome());
		turma1.setEscola(turma2.getEscola());
		turma1.setCapacidade(turma2.getCapacidade());
	}
	
	public void addTurma(Long idEscola,Long idTurma)
	{
		try
		{
			Escola esc=repoEsc.getReferenceById(idEscola);
			try
			{
				Turma tur=repoTur.getReferenceById(idTurma);	
				tur.setEscola(esc);
				repoTur.save(tur);
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
}