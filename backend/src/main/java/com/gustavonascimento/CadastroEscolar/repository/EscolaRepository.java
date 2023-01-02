package com.gustavonascimento.CadastroEscolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavonascimento.CadastroEscolar.entitys.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Long>{

}