package com.alodiga.wallet.respuestas;

import com.alodiga.plaid.response.ExchangeTokenResponse;
import com.alodiga.plaid.response.RetriveAuthResponse;
import com.alodiga.plaid.response.RetriveBalanceResponse;
import com.alodiga.plaid.response.RetriveIdentityResponse;
import com.alodiga.plaid.response.RetriveIncomeResponse;
import com.alodiga.plaid.response.RetriveTransactionResponse;
import com.alodiga.plaid.response.TokenResponse;
import com.alodiga.wallet.model.Card;
import com.alodiga.wallet.model.Country;
import com.alodiga.wallet.model.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Transient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "RetriveIncomePlaidResponses")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetriveIncomePlaidResponses extends Response implements Serializable {

    private static final long serialVersionUID = -5826822375335798732L;
    
    public List<Product> products;
    public RetriveIncomeResponse retriveIncomeResponse;

 
    public RetriveIncomePlaidResponses() {
    }

    public RetriveIncomePlaidResponses(RetriveIncomeResponse retriveIncomeResponse) {
        super(ResponseCode.EXITO);
        this.retriveIncomeResponse = retriveIncomeResponse;
    }


    
    public RetriveIncomePlaidResponses(RetriveIncomeResponse retriveIncomeResponse, ResponseCode codigo, String mensajeRespuesta) {
        super(new Date(), codigo.getCodigo(), mensajeRespuesta);
        this.retriveIncomeResponse = retriveIncomeResponse;
        
    }

    public RetriveIncomePlaidResponses(ResponseCode codigo,
            String mensajeRespuesta) {
        super(new Date(), codigo.getCodigo(), mensajeRespuesta);
    }

    public RetriveIncomeResponse getRetriveIncomeResponse() {
        return retriveIncomeResponse;
    }

    public void setRetriveIncomeResponse(RetriveIncomeResponse retriveIncomeResponse) {
        this.retriveIncomeResponse = retriveIncomeResponse;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    

}