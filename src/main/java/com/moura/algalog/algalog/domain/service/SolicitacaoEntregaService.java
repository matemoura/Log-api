package com.moura.algalog.algalog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moura.algalog.algalog.domain.repository.EntregaRepository;
import com.moura.algalog.algalog.model.Cliente;
import com.moura.algalog.algalog.model.Entrega;
import com.moura.algalog.algalog.model.StatusEntrega;

@Service
public class SolicitacaoEntregaService {

	@Autowired
	private CatalogoClienteService catalogoClienteService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
	
	
}