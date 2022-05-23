package com.moura.algalog.algalog.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moura.algalog.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.moura.algalog.algalog.domain.repository.EntregaRepository;
import com.moura.algalog.algalog.model.Entrega;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
	
}
