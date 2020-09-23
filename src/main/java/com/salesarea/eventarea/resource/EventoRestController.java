package com.salesarea.eventarea.resource;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.salesarea.eventarea.aws.S3Service;
import com.salesarea.eventarea.model.Evento;
import com.salesarea.eventarea.service.EventoService;

@RestController
@CrossOrigin
@RequestMapping("/evento")
public class EventoRestController {

	@Autowired
	private EventoService eventoService;
	@Autowired
	private S3Service s3Service;

	@PostMapping
	public ResponseEntity<Evento> salvar(@RequestBody Evento evento) {
		evento.setImagemPath(evento.getImagemPath().substring(1, evento.getImagemPath().length() - 1));
		Evento eventoSalvo = eventoService.salvarEvento(evento);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalvo);
	}

	@PostMapping("/imagem")
	public ResponseEntity<String> adicionarImagem(@RequestParam MultipartFile file) {
		File arquivo = null;
		String pathAWS = "https://eventarea.s3-us-west-1.amazonaws.com/";
		try {
			arquivo =  eventoService.salvarImagem(file);
			System.out.println(arquivo.getName());
			s3Service.uploadFile(arquivo, arquivo.getName());
		} catch (Exception e) {
			System.out.println("Erro ao Salvar Imagem: " + e);
		}finally {
			if(arquivo.exists()) {
				arquivo.delete();
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(pathAWS + arquivo.getName());
	}
	
	@GetMapping
	public ResponseEntity<List<Evento>> retornarEventos() {
		List<Evento> eventos = eventoService.retornarEventos();
		return ResponseEntity.status(HttpStatus.OK).body(eventos);
	}
}
