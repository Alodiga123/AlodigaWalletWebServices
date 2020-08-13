package com.alodiga.wallet.respuestas;



import com.alodiga.wallet.common.model.PersonHasAddress;

import java.io.Serializable;
import java.util.Date;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "PersonHasAddressResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonHasAddressResponse extends Response implements Serializable {

	private static final long serialVersionUID = -5826822375335798732L;

	public PersonHasAddress personHasAddress;        
        
	public PersonHasAddressResponse() {
		super();
	}

	public PersonHasAddressResponse(ResponseCode codigo) {
		super(new Date(), codigo.getCodigo(), codigo.name());
		this.personHasAddress = null;
	}

	public PersonHasAddressResponse(ResponseCode codigo,
			String mensajeRespuesta) {
		super(new Date(), codigo.getCodigo(), mensajeRespuesta);
		this.personHasAddress = null;
	}

	public PersonHasAddressResponse(ResponseCode codigo,
			String mensajeRespuesta, PersonHasAddress personHasAddress) {
		super(new Date(), codigo.getCodigo(), mensajeRespuesta);
		this.personHasAddress = personHasAddress;
	}

}

