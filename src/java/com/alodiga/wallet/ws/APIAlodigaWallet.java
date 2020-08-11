package com.alodiga.wallet.ws;

import com.alodiga.wallet.bean.APIAdminWalletOperations;
import com.alodiga.wallet.common.model.AccountBank;
import com.alodiga.wallet.common.model.LegalPerson;
import com.alodiga.wallet.common.model.NaturalPerson;
import com.alodiga.wallet.common.model.Person;
import com.alodiga.wallet.common.model.PersonClassification;
import com.alodiga.wallet.common.model.PhonePerson;
import com.alodiga.wallet.common.model.Sequences;
import com.alodiga.wallet.respuestas.AccountBankListResponse;
import com.alodiga.wallet.respuestas.AccountBankResponse;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.log4j.Logger;

import com.alodiga.wallet.respuestas.CityListResponse;

import com.alodiga.wallet.respuestas.CollectionRequestListResponse;
import com.alodiga.wallet.respuestas.CollectionTypeListResponse;
import com.alodiga.wallet.respuestas.CountryListResponse;

import com.alodiga.wallet.respuestas.DocumentsPersonTypeListResponse;
import com.alodiga.wallet.respuestas.LegalPersonResponse;
import com.alodiga.wallet.respuestas.NaturalPersonResponse;

import com.alodiga.wallet.respuestas.PersonTypeListResponse;

import com.alodiga.wallet.respuestas.StateListResponse;

import com.alodiga.wallet.respuestas.TransactionApproveRequestResponse;

import java.text.ParseException;

@WebService
public class APIAlodigaWallet {

    private static final Logger logger = Logger
            .getLogger(APIAlodigaWallet.class);

    @EJB
    private APIAdminWalletOperations walletOperations;

    @WebMethod
    public PersonTypeListResponse getPersonTypesBycountryId(
            @WebParam(name = "countryId") Long countryId) {
        return walletOperations.getPersonTypesBycountryId(countryId);
    }

    @WebMethod
    public DocumentsPersonTypeListResponse getDocumentPersonTypesBypersonTypeId(
            @WebParam(name = "personTypeId") Long personTypeId) {
        return walletOperations.getDocumentPersonTypesBypersonTypeId(personTypeId);
    }

    @WebMethod
    public CollectionTypeListResponse getCollectionTypesBycountryId(
            @WebParam(name = "countryId") Long countryId) {
        return walletOperations.getCollectionTypesBycountryId(countryId);
    }

    @WebMethod
    public CollectionRequestListResponse getCollectionRequestsBycollectionTypeId(
            @WebParam(name = "collectionTypeId") Long collectionTypeId) {
        return walletOperations.getCollectionRequestsBycollectionTypeId(collectionTypeId);
    }

    @WebMethod
    public StateListResponse getStatesByCountryId(
            @WebParam(name = "countryId") Long countryId) {
        return walletOperations.getStatesByCountryId(countryId);
    }

    @WebMethod
    public CityListResponse getCitiesByStateId(
            @WebParam(name = "stateId") Long stateId) {
        return walletOperations.getCitiesByStateId(stateId);
    }

    @WebMethod
    public CountryListResponse getCountries() {
        return walletOperations.getCountries();
    }

    @WebMethod
    public TransactionApproveRequestResponse saveTransactionApproveRequest(
            @WebParam(name = "unifiedRegistryUserId") Long unifiedRegistryUserId,
            @WebParam(name = "productId") Long productId,
            @WebParam(name = "transactionId") Long transactionId,
            @WebParam(name = "bankOperationId") Long bankOperationId,
            @WebParam(name = "documentTypeId") Long documentTypeId,
            @WebParam(name = "originApplicationId") Long originApplicationId) throws ParseException {
        return walletOperations.saveTransactionApproveRequest(unifiedRegistryUserId, productId, transactionId, bankOperationId, documentTypeId, originApplicationId);
    }

    @WebMethod
    public Sequences getSequencesByDocumentTypeByOriginApplication(
            @WebParam(name = "documentTypeId") Long documentTypeId,
            @WebParam(name = "originApplicationId") Long originApplicationId) {
        return walletOperations.getSequencesByDocumentTypeByOriginApplication(documentTypeId, originApplicationId);
    }
    
    @WebMethod
    public AccountBankResponse saveAccountBank(
            @WebParam(name = "unifiedRegistryId") Long unifiedRegistryId,
            @WebParam(name = "accountNumber") String accountNumber,
            @WebParam(name = "bankId") Long bankId,
            @WebParam(name = "accountTypeBankId") Integer accountTypeBankId) {
        return walletOperations.saveAccountBank(unifiedRegistryId, accountNumber,bankId,accountTypeBankId);
    }
    
    @WebMethod
    public AccountBankListResponse getAccountBankByUser(
            @WebParam(name = "unifiedRegistryId") Long unifiedRegistryId) {
        return walletOperations.getAccountBankByUser(unifiedRegistryId);
    }
    

    @WebMethod
    public AccountBankResponse updateAccountBankByAccountNumber(
            @WebParam(name = "unifiedRegistryId") Long unifiedRegistryId,
            @WebParam(name = "accountNumberOld") String accountNumberOld,
            @WebParam(name = "accountNumberCurrent") String accountNumberCurrent,
            @WebParam(name = "bankId") Long bankId) {
        return walletOperations.updateAccountBankByAccountNumber(unifiedRegistryId, accountNumberOld,accountNumberCurrent,bankId);
    }
    
   
    
    @WebMethod
    public NaturalPersonResponse saveBusinessApplicantNaturalPerson(
            @WebParam(name = "person") Person person,
            @WebParam(name = "naturalPerson") NaturalPerson naturalPerson,
            @WebParam(name = "phonePerson") PhonePerson phonePerson) {
        return walletOperations.saveBusinessApplicantNaturalPerson(person, naturalPerson,phonePerson);
    }
    
    @WebMethod
    public LegalPersonResponse saveBusinessApplicantLegalPerson(
            @WebParam(name = "person") Person person,
            @WebParam(name = "legalPerson") LegalPerson legalPerson,
            @WebParam(name = "phonePerson") PhonePerson phonePerson) {
        return walletOperations.saveBusinessApplicantLegalPerson(person, legalPerson,phonePerson);
    }

}
