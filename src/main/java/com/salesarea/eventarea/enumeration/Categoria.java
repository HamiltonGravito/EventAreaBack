package com.salesarea.eventarea.enumeration;

import lombok.Getter;

public enum Categoria {

	CORPORATIVO("Corporativo"), EDUCACIONAL("Educacional"), ENTRETENIMENTO("Entretenimento"), ESPORTIVO("Esportivo"),
	POLITICO("Político"), RELIGIOSO("Religioso");
	
	@Getter private String descricao;
	
	Categoria(String descricao) {
		this.descricao = descricao;
	}
}
