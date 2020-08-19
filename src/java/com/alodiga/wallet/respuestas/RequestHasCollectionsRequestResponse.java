package com.alodiga.wallet.respuestas;




import com.alodiga.wallet.common.model.RequestHasCollectionRequest;

import java.io.Serializable;
import java.util.Date;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "RequestHasCollectionsRequestResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestHasCollectionsRequestResponse extends Response implements Serializable {

	private static final long serialVersionUID = -5826822375335798732L;

	public RequestHasCollectionRequest requestHasCollectionRequest;        
        
	public RequestHasCollectionsRequestResponse() {
		super();
	}

	public RequestHasCollectionsRequestResponse(ResponseCode codigo) {
		super(new Date(), codigo.getCodigo(), codigo.name());
		this.requestHasCollectionRequest = null;
	}

	public RequestHasCollectionsRequestResponse(ResponseCode codigo,
			String mensajeRespuesta) {
		super(new Date(), codigo.getCodigo(), mensajeRespuesta);
		this.requestHasCollectionRequest = null;
	}

	public RequestHasCollectionsRequestResponse(ResponseCode codigo,
			String mensajeRespuesta, RequestHasCollectionRequest requestHasCollectionRequest) {
		super(new Date(), codigo.getCodigo(), mensajeRespuesta);
		this.requestHasCollectionRequest = requestHasCollectionRequest;
	}

}

