package com.arthurcruz.orderssystem.domain.enums;

public enum ClientType {

	NATURAL_PERSON(1, "Natural Person"), //Pessoa fisica
	LEGAL_PERSON(2, "Legal Person") //Juridica
;

	private int cod;
	private String description;
	
	private ClientType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}


	public String getDescription() {
		return description;
	}

	public static ClientType toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(ClientType c : ClientType.values()) {
			if(cod.equals(c.getCod())) {
				return c;
			}
		}
		
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
