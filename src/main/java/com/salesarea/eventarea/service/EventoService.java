package com.salesarea.eventarea.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.salesarea.eventarea.model.Evento;
import com.salesarea.eventarea.repository.EventoRepository;

@Service
@CrossOrigin
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	public Evento salvarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	public File salvarImagem(MultipartFile arquivo) {
		byte[] imgUpload;
		Long proximoId = eventoRepository.correnteValueSeqImagem();
		Path path = Paths.get("src/main/resources/imgtemp/", String.valueOf(proximoId) + arquivo.getOriginalFilename());
		try {
			imgUpload = arquivo.getBytes();
			FileOutputStream in = new FileOutputStream(path.toFile());
			in.write(imgUpload);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path.toFile();
	}
	
	public List<Evento> retornarEventos(){
		List<Evento> eventos = eventoRepository.findAll();
		return eventos;
	}
}
