package com.salesarea.eventarea.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.salesarea.eventarea.model.Evento;
import com.salesarea.eventarea.repository.EventoRepository;

@Service
public class EventoService {
	
	private static final String path = "C:\\Users\\hamil\\Downloads\\";

	@Autowired
	private EventoRepository eventoRepository;
	
	public Evento salvarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public void salvarImagem(MultipartFile arquivo) {
		byte[] imgUpload;
		File file = null;
		try {
			imgUpload = arquivo.getBytes();
			file = new File(path + "teste.jpg");
			FileOutputStream in = new FileOutputStream(file) ;  
			in.write(imgUpload);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
