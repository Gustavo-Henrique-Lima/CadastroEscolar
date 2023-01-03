package com.gustavonascimento.CadastroEscolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavonascimento.CadastroEscolar.entitys.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}