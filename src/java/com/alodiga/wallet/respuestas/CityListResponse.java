package com.alodiga.wallet.respuestas;


import com.alodiga.wallet.common.model.City;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CityListResponse extends Response {

	public List<City> citys;
	
	public CityListResponse() {
		super();
	}
	
	public CityListResponse(ResponseCode code) {
		super(new Date(), code.getCodigo(), code.name());
		this.citys = null;
	}
	
	public CityListResponse(ResponseCode code, String mensaje) {
		super(new Date(), code.getCodigo(), mensaje);
		this.citys = null;
	}

	public CityListResponse(ResponseCode code, String mensaje, List<City> citys) {
		super(new Date(), code.getCodigo(), mensaje);
		this.citys = citys;
	}
        
}
