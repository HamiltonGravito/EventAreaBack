package com.salesarea.eventarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.salesarea.eventarea.model.Evento;

@Repository
@EnableJpaRepositories
public interface EventoRepository extends JpaRepository<Evento, Long> {

	@Query(value = "SELECT nextval('imagem_seq')", nativeQuery = true)
	Long correnteValueSeqImagem();
}
