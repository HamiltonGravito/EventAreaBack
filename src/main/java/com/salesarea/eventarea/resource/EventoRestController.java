package com.salesarea.eventarea.resource;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.salesarea.eventarea.model.Evento;
import com.salesarea.eventarea.service.EventoService;

@RestController
@CrossOrigin
@RequestMapping("/evento")
public class EventoRestController {

	@Autowired
	private EventoService eventoService;

	

	@PostMapping
	public ResponseEntity<Evento> salvar(@RequestBody Evento evento) {
		Evento eventoSalvo = eventoService.salvarEvento(evento);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalvo);

	}

	@PostMapping("/imagem")
	public ResponseEntity<File> adicionarImagem(@RequestParam MultipartFile file) {
		File arquivo =  eventoService.salvarImagem(file);
		return ResponseEntity.status(HttpStatus.CREATED).body(arquivo);
	}
}
