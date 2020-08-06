package com.alodiga.wallet.respuestas;


import com.alodiga.wallet.common.model.AccountBank;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountBankListResponse extends Response {

	public List<AccountBank> accountBanks;
	
	public AccountBankListResponse() {
		super();
	}
	
	public AccountBankListResponse(ResponseCode code) {
		super(new Date(), code.getCodigo(), code.name());
		this.accountBanks = null;
	}
	
	public AccountBankListResponse(ResponseCode code, String mensaje) {
		super(new Date(), code.getCodigo(), mensaje);
		this.accountBanks = null;
	}

	public AccountBankListResponse(ResponseCode code, String mensaje, List<AccountBank> accountBanks) {
		super(new Date(), code.getCodigo(), mensaje);
		this.accountBanks = accountBanks;
	}
        
}
