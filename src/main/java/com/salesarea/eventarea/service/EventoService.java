package com.salesarea.eventarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesarea.eventarea.model.Evento;
import com.salesarea.eventarea.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	public Evento salvarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
}
