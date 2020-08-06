package com.alodiga.wallet.respuestas;

import com.alodiga.wallet.common.model.State;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StateListResponse extends Response {

    public List<State> states;

    public StateListResponse() {
        super();
    }

    public StateListResponse(ResponseCode code) {
        super(new Date(), code.getCodigo(), code.name());
        this.states = null;
    }

    public StateListResponse(ResponseCode code, String mensaje) {
        super(new Date(), code.getCodigo(), mensaje);
        this.states = null;
    }

    public StateListResponse(ResponseCode code, String mensaje, List<State> states) {
        super(new Date(), code.getCodigo(), mensaje);
        this.states = states;
    }

}
