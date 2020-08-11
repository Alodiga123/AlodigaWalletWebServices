package com.alodiga.wallet.respuestas;


import com.alodiga.wallet.common.model.AccountBank;
import com.alodiga.wallet.common.model.LegalPerson;
import com.alodiga.wallet.common.model.NaturalPerson;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "LegalPersonResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LegalPersonResponse extends Response implements Serializable {

	private static final long serialVersionUID = -5826822375335798732L;

	public LegalPerson legalPerson;        
        
	public LegalPersonResponse() {
		super();
	}

	public LegalPersonResponse(ResponseCode codigo) {
		super(new Date(), codigo.getCodigo(), codigo.name());
		this.legalPerson = null;
	}

	public LegalPersonResponse(ResponseCode codigo,
			String mensajeRespuesta) {
		super(new Date(), codigo.getCodigo(), mensajeRespuesta);
		this.legalPerson = null;
	}

	public LegalPersonResponse(ResponseCode codigo,
			String mensajeRespuesta, LegalPerson legalPerson) {
		super(new Date(), codigo.getCodigo(), mensajeRespuesta);
		this.legalPerson = legalPerson;
	}

}

