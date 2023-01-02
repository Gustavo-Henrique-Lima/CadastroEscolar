package com.gustavonascimento.CadastroEscolar.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavonascimento.CadastroEscolar.entitys.Endereco;
import com.gustavonascimento.CadastroEscolar.entitys.Escola;
import com.gustavonascimento.CadastroEscolar.entitys.Turma;
import com.gustavonascimento.CadastroEscolar.repository.EscolaRepository;
import com.gustavonascimento.CadastroEscolar.repository.TurmaRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private EscolaRepository repoEsc;
	
	@Autowired
	private TurmaRepository repoTurm;
	
	@Override
	public void run(String... args) throws Exception 
	{
		Escola e1=new Escola(null, "Escola do futuro", new Endereco(null,"Rua das flores, 55", null, "São Pedro", "Belo Jardim", "PE"));
		Escola e2=new Escola(null, "Escola do passado", new Endereco(null,"Rua das pedras,99", null, "Centro", "Belo Jardim", "PE"));
		
		Turma t1=new Turma(null,"Calculo",20, e1);
		Turma t2=new Turma(null,"Programação",20,e1);
		Turma t3=new Turma(null,"Banco de dados",20,e2);
		
		repoEsc.saveAll(Arrays.asList(e1,e2));
		repoTurm.saveAll(Arrays.asList(t1,t2,t3));
	}
}