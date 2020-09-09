package com.salesarea.eventarea.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.salesarea.eventarea.enumeration.Categoria;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq", initialValue = 1, allocationSize = 1)
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "evento_seq")
	private Long id;
	private String nome;
	private LocalDate data;
	private LocalTime hora;
	@Column(name = "quantidade_pessoas" )
	private Integer quantidadeMaximaDePessoas;
	private String descricao;
	private String imagemPath;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	@Embedded
	private Endereco endereco;
	
}
