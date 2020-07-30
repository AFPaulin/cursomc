package com.example.cursomc.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Produto;
import com.example.cursomc.dto.CategoriaDTO;
import com.example.cursomc.dto.ProdutoDTO;
import com.example.cursomc.resources.utils.URL;
import com.example.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		 Produto obj = service.find(id);
		 return ResponseEntity.ok().body(obj);
		 } 
	
	// GET - Recuperar dados - não aceita enviar dados no corpo da requisição então
	// os dados são passados como parametro no url
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value ="nome", defaultValue = "") String nome,
			@RequestParam(value ="categorias", defaultValue = "") String categorias,
			@RequestParam(value ="page", defaultValue = "0") Integer page,
			@RequestParam(value ="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value ="orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value ="direction", defaultValue = "ASC") String direction
			) {
		List<Integer> ids = URL.decodeIntList(categorias);
		String nomeDecoded = URL.decodeParam(nome);
		 Page<Produto> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		 Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
		 return ResponseEntity.ok().body(listDto);
		 } 
	
	
}
