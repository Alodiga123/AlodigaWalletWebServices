package com.alodiga.wallet.respuestas;


import com.alodiga.wallet.common.model.AccountBank;
import com.alodiga.wallet.common.model.NaturalPerson;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "NaturalPersonResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class NaturalPersonResponse extends Response implements Serializable {

	private static final long serialVersionUID = -5826822375335798732L;

	public NaturalPerson naturalPerson;        
        
	public NaturalPersonResponse() {
		super();
	}

	public NaturalPersonResponse(ResponseCode codigo) {
		super(new Date(), codigo.getCodigo(), codigo.name());
		this.naturalPerson = null;
	}

	public NaturalPersonResponse(ResponseCode codigo,
			String mensajeRespuesta) {
		super(new Date(), codigo.getCodigo(), mensajeRespuesta);
		this.naturalPerson = null;
	}

	public NaturalPersonResponse(ResponseCode codigo,
			String mensajeRespuesta, NaturalPerson naturalPerson) {
		super(new Date(), codigo.getCodigo(), mensajeRespuesta);
		this.naturalPerson = naturalPerson;
	}

}

