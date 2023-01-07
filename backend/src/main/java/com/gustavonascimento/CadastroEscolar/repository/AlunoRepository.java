package com.gustavonascimento.CadastroEscolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gustavonascimento.CadastroEscolar.entitys.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	@Query(nativeQuery=true,value="DELETE FROM ALUNOS_TURMA WHERE aluno_id=?1;")
	void deletar(Long id);
}