package com.example.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Pagamento;
import com.example.cursomc.domain.Pedido;
import com.example.cursomc.domain.Produto;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento , Integer> {

}
