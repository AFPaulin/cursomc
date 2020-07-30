package com.example.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Cidade;
import com.example.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	// readOnly = true indica que dado sera apenas lido reduzido o tempo de lock 
	// do banco de dados
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
	
	
}
