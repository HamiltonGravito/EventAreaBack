package com.salesarea.eventarea.resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	byte[] imgUpload;
	Evento eventoSalvo;

	@PostMapping
	public ResponseEntity<Evento> salvar(@RequestBody Evento evento) {
		if (eventoSalvo == null) {
			this.eventoSalvo = new Evento();
		} else {
			eventoSalvo.setImagem(imgUpload);
			System.out.println(eventoSalvo.getImagem());
			eventoSalvo = eventoService.salvarEvento(evento);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalvo);

	}

	@PostMapping("/imagem")
	public void adicionarImagem(@RequestBody MultipartFile file) {
		try {
			imgUpload = file.getBytes();
			eventoSalvo = new Evento();
			/*java.io.File file2 = new java.io.File("C:\\Users\\hamil\\Downloads\\novaimagem.jpg");
			FileOutputStream in = new FileOutputStream(file2) ;  
			in.write(imgUpload);
			in.close();
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
