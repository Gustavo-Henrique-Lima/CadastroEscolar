package com.gustavonascimento.CadastroEscolar.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gustavonascimento.CadastroEscolar.entitys.Aluno;
import com.gustavonascimento.CadastroEscolar.entitys.Turma;
import com.gustavonascimento.CadastroEscolar.repository.AlunoRepository;
import com.gustavonascimento.CadastroEscolar.repository.TurmaRepository;
import com.gustavonascimento.CadastroEscolar.service.exceptions.DatabaseException;
import com.gustavonascimento.CadastroEscolar.service.exceptions.ResourceNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repoAlu;
	
	@Autowired
	private TurmaRepository repoTurm;
	
	public List<Aluno> findAll()
	{
		return repoAlu.findAll();
	}
	public Aluno insert(Aluno aluno)
	{
		return repoAlu.save(aluno);
	}
	
	public Aluno findById(Long id)
	{
		Optional<Aluno> aluno=repoAlu.findById(id);
		return aluno.orElseThrow(()->new ResourceNotFoundException(id));
	}
	
	public void delete(Long id)
	{
		try
		{
			Aluno aluno=repoAlu.getReferenceById(id);
			for(Turma id_turma:aluno.getTurmas())
			{
				id_turma.getAlunos().remove(aluno);
				repoTurm.save(id_turma);
			}
			repoAlu.deleteById(id);
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
	public Aluno update(Long id,Aluno aluno2)
	{
		try
		{
			Aluno aluno1=repoAlu.getReferenceById(id);
			updateData(aluno1, aluno2);
			return repoAlu.save(aluno1);
		}
		catch(EntityNotFoundException e)
		{
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Aluno aluno1,Aluno aluno2)
	{
		aluno1.setNome(aluno2.getNome());
		aluno1.setDataNascimento(aluno2.getDataNascimento());
		aluno1.setEndereco(aluno2.getEndereco());
	}
	
	public void addAluno(Long idTurma,Long idAluno)
	{
		try
		{
			Turma turma=repoTurm.getReferenceById(idTurma);
			try
			{
				Aluno aluno=repoAlu.getReferenceById(idAluno);
				turma.getAlunos().add(aluno);
				repoTurm.save(turma);
			}
			catch(EntityNotFoundException e)
			{
				throw new ResourceNotFoundException(idTurma);
			}
		}
		catch(EntityNotFoundException e)
		{
			throw new ResourceNotFoundException(idTurma);
		}
	}
}