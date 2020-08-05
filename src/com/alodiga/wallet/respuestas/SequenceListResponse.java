package com.alodiga.wallet.respuestas;


import com.alodiga.wallet.common.model.Sequences;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SequenceListResponse extends Response {

	public List<Sequences> sequenceses;
	
	public SequenceListResponse() {
		super();
	}
	
	public SequenceListResponse(ResponseCode code) {
		super(new Date(), code.getCodigo(), code.name());
		this.sequenceses = null;
	}
	
	public SequenceListResponse(ResponseCode code, String mensaje) {
		super(new Date(), code.getCodigo(), mensaje);
		this.sequenceses = null;
	}

	public SequenceListResponse(ResponseCode code, String mensaje, List<Sequences> sequenceses) {
		super(new Date(), code.getCodigo(), mensaje);
		this.sequenceses = sequenceses;
	}
        
}
