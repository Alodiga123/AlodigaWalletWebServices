package com.alodiga.wallet.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.log4j.Logger;
import com.alodiga.wallet.bean.APIOperations;
import com.alodiga.wallet.model.Code;
import com.alodiga.wallet.model.Country;
import com.alodiga.wallet.respuestas.BalanceHistoryResponse;
import com.alodiga.wallet.respuestas.BankListResponse;
import com.alodiga.wallet.respuestas.CollectionListResponse;
import com.alodiga.wallet.respuestas.CountryListResponse;
import com.alodiga.wallet.respuestas.CumplimientResponse;
import com.alodiga.wallet.respuestas.LanguageListResponse;
import com.alodiga.wallet.respuestas.ProductListResponse;
import com.alodiga.wallet.respuestas.ProductResponse;
import com.alodiga.wallet.respuestas.Response;
import com.alodiga.wallet.respuestas.TopUpCountryListResponse;
import com.alodiga.wallet.respuestas.TopUpInfoListResponse;
import com.alodiga.wallet.respuestas.UserHasProductResponse;
import com.alodiga.wallet.respuestas.TransactionListResponse;
import com.alodiga.wallet.respuestas.TransactionResponse;
import javax.persistence.EntityManager;

@WebService
public class APIAlodigaWallet {

    private static final Logger logger = Logger
            .getLogger(APIAlodigaWallet.class);

    @EJB
    private APIOperations operations;

    //coment 6
    @WebMethod
    public ProductResponse saveProduct(
            @WebParam(name = "enterprise") String enterpriseId,
            @WebParam(name = "category") String categoryId,
            @WebParam(name = "productIntegrationTypeId") String productIntegrationTypeId,
            @WebParam(name = "name") String name,
            @WebParam(name = "taxInclude") boolean taxInclude,
            @WebParam(name = "status") boolean status,
            @WebParam(name = "referenceCode") String referenceCode,
            @WebParam(name = "rateUrl") String rateUrl,
            @WebParam(name = "accesNumberUrl") String accesNumberUrl,
            @WebParam(name = "isFree") boolean isFree,
            @WebParam(name = "isAlocashproduct") boolean isAlocashproduct,
            @WebParam(name = "symbol") String symbol) {
        return operations.saveProduct(Long.valueOf(enterpriseId), Long.valueOf(categoryId), Long.valueOf(productIntegrationTypeId), name, taxInclude, status, referenceCode, rateUrl, accesNumberUrl, isFree, isAlocashproduct, symbol);
    }

    //coment21
    //cambio267810
    @WebMethod
    public UserHasProductResponse saveUserHasProduct(
            @WebParam(name = "userId") String userId,
            @WebParam(name = "productId") String producId) {
        return operations.saveUserHasProduct(Long.valueOf(userId), Long.valueOf(producId));
    }

    @WebMethod
    public UserHasProductResponse saveUserHasProductDefault(
            @WebParam(name = "userId") String userId) {
        return operations.saveUserHasProductDefault(Long.valueOf(userId));
    }

    @WebMethod
    public ProductListResponse getProductsByUserId(
            @WebParam(name = "userId") String userId) {
        return operations.getProductsByUserId(Long.valueOf(userId));
    }

    @WebMethod
    public CountryListResponse getCountries() {
        return operations.getCountries();
    }

    @WebMethod
    public BankListResponse getBankApp() {
        return operations.getBankApp();
    }

    @WebMethod
    public BankListResponse getBankByCountryApp(
            @WebParam(name = "countryId") String countryId) {
        return operations.getBankByCountryApp(Long.valueOf(countryId));
    }

    @WebMethod
    public TransactionResponse savePaymentShop(
            @WebParam(name = "cryptogramaShop") String cryptogramShop,
            @WebParam(name = "emailUser") String emailUser,
            @WebParam(name = "productId") Long productId,
            @WebParam(name = "amountPayment") Float amountPayment,
            @WebParam(name = "conceptTransaction") String conceptTransaction,
            @WebParam(name = "cryptogramaUser") String cryptogramUser,
            @WebParam(name = "idUserDestination") Long idUserDestination) {

        return operations.savePaymentShop(cryptogramShop, emailUser, productId, amountPayment,
                conceptTransaction, cryptogramUser, idUserDestination);
    }

    @WebMethod
    public TransactionResponse saveTransferBetweenAccount(
            @WebParam(name = "cryptogramUserSource") String cryptogramUserSource,
            @WebParam(name = "emailUser") String emailUser,
            @WebParam(name = "productId") Long productId,
            @WebParam(name = "amountTransfer") Float amountTransfer,
            @WebParam(name = "conceptTransaction") String conceptTransaction,
            @WebParam(name = "cryptogramUserDestination") String cryptogramUserDestination,
            @WebParam(name = "idUserDestination") Long idUserDestination) {

        return operations.saveTransferBetweenAccount(cryptogramUserSource, emailUser, productId, amountTransfer,
                conceptTransaction, cryptogramUserSource, idUserDestination);
    }

    @WebMethod
    public TransactionResponse previewExchangeProduct(
            @WebParam(name = "emailUser") String emailUser,
            @WebParam(name = "productSourceId") Long productSourceId,
            @WebParam(name = "productDestinationId") Long productDestinationId,
            @WebParam(name = "amountExchange") Float amountExchange,
            @WebParam(name = "includedAmount") int includedAmount) {
        return operations.previewExchangeProduct(emailUser, productSourceId, productDestinationId, amountExchange, includedAmount);
    }

    @WebMethod
    public TransactionResponse exchangeProduct(
            @WebParam(name = "emailUser") String emailUser,
            @WebParam(name = "productSourceId") Long productSourceId,
            @WebParam(name = "productDestinationId") Long productDestinationId,
            @WebParam(name = "amountExchange") Float amountExchange,
            @WebParam(name = "conceptTransaction") String conceptTransaction,
            @WebParam(name = "includedAmount") int includedAmount) {
        return operations.exchangeProduct(emailUser, productSourceId, productDestinationId, amountExchange, conceptTransaction, includedAmount);

    }

    @WebMethod
    public TopUpInfoListResponse topUpList(
            @WebParam(name = "receiverNumber") String receiverNumber,
            @WebParam(name = "phoneNumber") String phoneNumber) {
        return operations.getTopUpInfo(receiverNumber, phoneNumber);
    }

    @WebMethod
    public TransactionListResponse getTransactionsByUserIdApp(
            @WebParam(name = "userId") String userId,
            @WebParam(name = "maxResult") String maxResult) {
        return operations.getTransactionsByUserIdApp(Long.valueOf(userId), Integer.valueOf(maxResult));
    }

    @WebMethod
    public TransactionResponse manualWithdrawals(
            @WebParam(name = "bankId") Long bankId,
            @WebParam(name = "emailUser") String emailUser,
            @WebParam(name = "accountBank") String accountBank,
            @WebParam(name = "amountWithdrawal") Float amountWithdrawal,
            @WebParam(name = "productId") Long productId,
            @WebParam(name = "conceptTransaction") String conceptTransaction) {
        return operations.manualWithdrawals(bankId, emailUser, accountBank, amountWithdrawal, productId, conceptTransaction);
    }

    @WebMethod
    public TransactionResponse manualRecharge(
            @WebParam(name = "bankId") Long bankId,
            @WebParam(name = "emailUser") String emailUser,
            @WebParam(name = "referenceNumberOperation") String referenceNumberOperation,
            @WebParam(name = "amountRecharge") Float amountRecharge,
            @WebParam(name = "productId") Long productId,
            @WebParam(name = "conceptTransaction") String conceptTransaction) {
        return operations.manualRecharge(bankId, emailUser, referenceNumberOperation, amountRecharge, productId, conceptTransaction);
    }

    @WebMethod
    public CountryListResponse getCountriesHasBank(
            @WebParam(name = "userId") Long userId) {
        return operations.getCountriesHasBank(userId);
    }

    //no esta 
    @WebMethod
    public ProductListResponse getProductsByBankId(
            @WebParam(name = "bankId") String bankId,
            @WebParam(name = "userId") String userId) {
        return operations.getProductsByBankId(Long.valueOf(bankId), Long.valueOf(userId));
    }

    //Desarrollado por Kerwin 2102019
    @WebMethod
    public BalanceHistoryResponse getBalanceHistoryByProductAndUser(
            @WebParam(name = "userId") Long userId,
            @WebParam(name = "productId") Long productId) {
        return operations.getBalanceHistoryByUserAndProduct(userId, productId);
    }

    @WebMethod
    public TransactionResponse saveRechargeTopUp(
            @WebParam(name = "emailUser") String emailUser,
            @WebParam(name = "productId") Long productId,
            @WebParam(name = "cryptogramUser") String cryptogramUser,
            @WebParam(name = "skudId") String skudId,
            @WebParam(name = "destinationNumber") String destinationNumber,
            @WebParam(name = "senderNumber") String senderNumber,
            @WebParam(name = "amountRecharge") Float amountRecharge,
            @WebParam(name = "amountPayment") Float amountPayment,
            @WebParam(name = "language") String language) {

        return operations.saveRechargeTopUp(emailUser, productId, cryptogramUser, skudId, destinationNumber, senderNumber,
                amountRecharge, amountPayment, language);
    }

    @WebMethod
    public TopUpCountryListResponse getTopUpCountries() {
        return operations.getTopUpCountries();
    }

    @WebMethod
    public LanguageListResponse getLanguage() {
        return operations.getLanguage();
    }

    @WebMethod
    public ProductListResponse getProductsPayTopUpByUserId(
            @WebParam(name = "userId") String userId) {
        return operations.getProductsPayTopUpByUserId(Long.valueOf(userId));
    }

    @WebMethod
    public ProductListResponse getProductsIsExchangeProductUserId(
            @WebParam(name = "userId") String userId) {
        return operations.getProductsIsExchangeProductUserId(Long.valueOf(userId));
    }

    @WebMethod
    public void sendMailTest() {
        operations.sendmailTest();
    }

    @WebMethod
    public String sendSmsSimbox(
            @WebParam(name = "phoneNumber") String phoneNumber,
            @WebParam(name = "text") String text,
            @WebParam(name = "userId") Long userId) {
        return operations.sendSmsSimbox(phoneNumber, text, userId);
    }

    @WebMethod
    public CumplimientResponse getCumplimientStatus(
            @WebParam(name = "userId") String userId) {
        return operations.getCumplimientStatus(Long.valueOf(userId));
    }
    
    
    @WebMethod
    public CollectionListResponse getValidateCollection(
            @WebParam(name = "userId") String userId,
            @WebParam(name = "language") String language) {
        return operations.getValidateCollection(Long.valueOf(userId), language);
    }
    
    
    @WebMethod
    public CollectionListResponse saveCumplimient(
            @WebParam(name = "userId") Long userId,
            @WebParam(name = "imgDocument") byte[] imgDocument,
            @WebParam(name = "imgProfile") byte[] imgProfile,
            @WebParam(name = "estado") String estado,
            @WebParam(name = "ciudad") String ciudad,
            @WebParam(name = "zipCode") String zipCode,
            @WebParam(name = "addres1") String addres1) {
        return operations.saveCumplimient(Long.valueOf(userId),imgDocument, imgProfile, estado,ciudad,zipCode,addres1);
    }
  
    
    @WebMethod
    public Country getCountryCode(
            @WebParam(name = "strAni") String strAni) {
        return operations.getCountryCode(strAni);
    }
    
    
    
    
    
    
    
    
}
