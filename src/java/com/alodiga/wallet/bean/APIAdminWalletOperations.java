package com.alodiga.wallet.bean;

import com.alodiga.wallet.common.model.AccountBank;
import com.alodiga.wallet.common.model.AccountTypeBank;
import com.alodiga.wallet.common.model.Bank;
import com.alodiga.wallet.common.model.BankOperation;
import com.alodiga.wallet.common.model.City;
import com.alodiga.wallet.common.model.CollectionType;
import com.alodiga.wallet.common.model.CollectionsRequest;
import com.alodiga.wallet.common.model.Country;
import com.alodiga.wallet.common.model.DocumentsPersonType;
import com.alodiga.wallet.common.model.LegalPerson;
import com.alodiga.wallet.common.model.NaturalPerson;
import com.alodiga.wallet.common.model.Person;
import com.alodiga.wallet.common.model.PersonClassification;
import com.alodiga.wallet.common.model.PersonType;
import com.alodiga.wallet.common.model.PhonePerson;
import com.alodiga.wallet.common.model.Product;
import com.alodiga.wallet.common.model.Sequences;
import com.alodiga.wallet.common.model.State;
import com.alodiga.wallet.common.model.StatusAccountBank;
import com.alodiga.wallet.common.model.StatusTransactionApproveRequest;
import com.alodiga.wallet.common.model.Transaction;
import com.alodiga.wallet.common.model.TransactionApproveRequest;
import com.alodiga.wallet.respuestas.AccountBankListResponse;
import com.alodiga.wallet.respuestas.AccountBankResponse;
import com.alodiga.wallet.respuestas.CityListResponse;
import com.alodiga.wallet.respuestas.CollectionRequestListResponse;
import com.alodiga.wallet.respuestas.CollectionTypeListResponse;
import com.alodiga.wallet.respuestas.CountryListResponse;
import com.alodiga.wallet.respuestas.DocumentsPersonTypeListResponse;
import com.alodiga.wallet.respuestas.LegalPersonResponse;
import com.alodiga.wallet.respuestas.NaturalPersonResponse;
import com.alodiga.wallet.respuestas.PersonTypeListResponse;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import com.alodiga.wallet.respuestas.ResponseCode;
import com.alodiga.wallet.respuestas.StateListResponse;
import com.alodiga.wallet.respuestas.TransactionApproveRequestResponse;

import com.alodiga.wallet.utils.Constants;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless(name = "FsProcessorWebPortal", mappedName = "ejb/FsProcessorWebPortal")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class APIAdminWalletOperations {

    @PersistenceContext(unitName = "AlodigaWalletPU")
    private EntityManager entityManager;

    private static final Logger logger = Logger.getLogger(APIAdminWalletOperations.class);

    public PersonTypeListResponse getPersonTypesBycountryId(Long countryId) {
        List<PersonType> personTypes = new ArrayList<PersonType>();

        try {
            personTypes = (List<PersonType>) entityManager.createNamedQuery("PersonType.findBycountryId", PersonType.class).setParameter("countryId", countryId).getResultList();
            if (personTypes.size() <= 0) {
                return new PersonTypeListResponse(ResponseCode.NOT_PERSON_TYPE, "NOT_PERSON_TYPE");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new PersonTypeListResponse(ResponseCode.ERROR_INTERNO, "Error loading personType");
        }

        return new PersonTypeListResponse(ResponseCode.EXITO, "", personTypes);
    }

    public DocumentsPersonTypeListResponse getDocumentPersonTypesBypersonTypeId(Long personTypeId) {
        List<DocumentsPersonType> documentsPersonTypes = new ArrayList<DocumentsPersonType>();

        try {
            documentsPersonTypes = (List<DocumentsPersonType>) entityManager.createNamedQuery("DocumentsPersonType.findBypersonTypeId", DocumentsPersonType.class).setParameter("personTypeId", personTypeId).getResultList();
            if (documentsPersonTypes.size() <= 0) {
                return new DocumentsPersonTypeListResponse(ResponseCode.NOT_DOCUMENTS_PERSON_TYPE, "NOT_DOCUMENTS_PERSON_TYPE");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DocumentsPersonTypeListResponse(ResponseCode.ERROR_INTERNO, "Error loading DOCUMENTS_PERSON_TYPE");
        }

        return new DocumentsPersonTypeListResponse(ResponseCode.EXITO, "", documentsPersonTypes);
    }

    public CollectionTypeListResponse getCollectionTypesBycountryId(Long countryId) {
        List<CollectionType> collectionTypes = new ArrayList<CollectionType>();

        try {
            collectionTypes = (List<CollectionType>) entityManager.createNamedQuery("CollectionType.findBycountryId", CollectionType.class).setParameter("countryId", countryId).getResultList();
            if (collectionTypes.size() <= 0) {
                return new CollectionTypeListResponse(ResponseCode.NOT_COLLECTION_TYPE, "NOT_COLLECTION_TYPE");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CollectionTypeListResponse(ResponseCode.ERROR_INTERNO, "Error loading COLLECTION_TYPE");
        }

        return new CollectionTypeListResponse(ResponseCode.EXITO, "", collectionTypes);
    }

    public CollectionRequestListResponse getCollectionRequestsBycollectionTypeId(Long collectionTypeId) {
        List<CollectionsRequest> collectionsRequests = new ArrayList<CollectionsRequest>();

        try {
            collectionsRequests = (List<CollectionsRequest>) entityManager.createNamedQuery("CollectionsRequest.findBycollectionTypeId", CollectionsRequest.class).setParameter("collectionTypeId", collectionTypeId).getResultList();
            if (collectionsRequests.size() <= 0) {
                return new CollectionRequestListResponse(ResponseCode.NOT_COLLECTION_REQUEST, "NOT_COLLECTION_REQUEST");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CollectionRequestListResponse(ResponseCode.ERROR_INTERNO, "Error loading COLLECTION_TYPE");
        }

        return new CollectionRequestListResponse(ResponseCode.EXITO, "", collectionsRequests);
    }

    public CountryListResponse getCountries() {
        List<Country> countries = null;
        try {
            countries = entityManager.createNamedQuery("Country.findAll", Country.class).getResultList();

        } catch (Exception e) {
            return new CountryListResponse(ResponseCode.ERROR_INTERNO, "Error loading countries");
        }
        return new CountryListResponse(ResponseCode.EXITO, "", countries);
    }

    public StateListResponse getStatesByCountryId(Long countryId) {
        List<State> states = new ArrayList<State>();

        try {
            states = (List<State>) entityManager.createNamedQuery("State.findBycountryId", State.class).setParameter("countryId", countryId).getResultList();
            if (states.size() <= 0) {
                return new StateListResponse(ResponseCode.ERROR_INTERNO, "Error loading states");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new StateListResponse(ResponseCode.ERROR_INTERNO, "Error loading states");
        }

        return new StateListResponse(ResponseCode.EXITO, "", states);
    }

    public CityListResponse getCitiesByStateId(Long stateId) {
        List<City> citys = new ArrayList<City>();

        try {
            citys = (List<City>) entityManager.createNamedQuery("City.findBystateId", City.class).setParameter("stateId", stateId).getResultList();
            if (citys.size() <= 0) {
                return new CityListResponse(ResponseCode.ERROR_INTERNO, "Error loading cities");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CityListResponse(ResponseCode.ERROR_INTERNO, "Error loading cities");
        }

        return new CityListResponse(ResponseCode.EXITO, "", citys);
    }

    public Sequences getSequencesByDocumentTypeByOriginApplication(Long documentTypeId, Long originApplicationId) {

        try {
            Sequences sequences = (Sequences) entityManager.createNamedQuery("Sequences.findBydocumentType_idByoriginApplicationId", Sequences.class).setParameter("documentTypeId", documentTypeId).setParameter("originApplicationId", originApplicationId).getSingleResult();
            return sequences;
        } catch (NoResultException e) {
            return null;
        }

    }

    private String generateNumberSequence(Sequences s) {
        String secuence = "";
        try {
            Integer numberSequence = s.getCurrentValue() > 1 ? s.getCurrentValue() : s.getInitialValue();
            s.setCurrentValue(s.getCurrentValue() + 1);
            //saveSequences(s);
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            secuence = ((s.getOriginApplicationId().getId().equals(Constants.ORIGIN_APPLICATION_APP_ALODIGA_WALLET_ID)) ? "APP-" : "ADM-")
                    .concat(s.getDocumentTypeId().getAcronym()).concat("-")
                    .concat(String.valueOf(year)).concat("-")
                    .concat(numberSequence.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return secuence;
    }

    public TransactionApproveRequestResponse saveTransactionApproveRequest(Long unifiedRegistryUserId, Long productId, Long transactionId, Long bankOperationId, Long documentTypeId, Long originApplicationId) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date curDate = new Date();

        try {
            TransactionApproveRequest approveRequest = new TransactionApproveRequest();
            approveRequest.setUnifiedRegistryUserId(unifiedRegistryUserId);
            Product product = entityManager.find(Product.class, productId);
            approveRequest.setProductId(product);
            Transaction transaction = entityManager.find(Transaction.class, transactionId);
            approveRequest.setTransactionId(transaction);
            BankOperation bankOperation = entityManager.find(BankOperation.class, bankOperationId);
            approveRequest.setBankOperationId(bankOperation);
            Sequences sequences = getSequencesByDocumentTypeByOriginApplication(documentTypeId, originApplicationId);
            String numberSequence = generateNumberSequence(sequences);
            approveRequest.setRequestNumber(numberSequence);
            String DateToStr = format.format(curDate);
            Date fechaDate = null;
            fechaDate = format.parse(DateToStr);
            approveRequest.setRequestDate(fechaDate);
            StatusTransactionApproveRequest statusTransactionApproveRequest = entityManager.find(StatusTransactionApproveRequest.class, Constants.STATUS_TRANSACTION_APPROVED_REQUEST);
            approveRequest.setStatusTransactionApproveRequestId(statusTransactionApproveRequest);
            approveRequest.setCreateDate(new Timestamp(new Date().getTime()));
            entityManager.persist(approveRequest);
            return new TransactionApproveRequestResponse(ResponseCode.EXITO, "", approveRequest);
        } catch (NoResultException e) {
            e.printStackTrace();
            return new TransactionApproveRequestResponse(ResponseCode.ERROR_INTERNO, "Error");
        } catch (Exception e) {
            e.printStackTrace();
            return new TransactionApproveRequestResponse(ResponseCode.ERROR_INTERNO, "Error");
        }

    }

    public AccountBankResponse saveAccountBank(Long unifiedRegistryId, String accountNumber, Long bankId, Integer accountTypeBankId) {

        try {
            AccountBank accountBank = new AccountBank();
            accountBank.setUnifiedRegistryId(unifiedRegistryId);
            accountBank.setAccountNumber(accountNumber);
            Bank bank = entityManager.find(Bank.class, bankId);
            accountBank.setBankId(bank);
            StatusAccountBank statusAccountBank = entityManager.find(StatusAccountBank.class, Constants.STATUS_ACCOUNT_BANK);
            accountBank.setStatusAccountBankId(statusAccountBank);
            AccountTypeBank accountTypeBank = entityManager.find(AccountTypeBank.class, accountTypeBankId);
            accountBank.setAccountTypeBankId(accountTypeBank);
            accountBank.setCreateDate(new Timestamp(new Date().getTime()));
            entityManager.persist(accountBank);
            return new AccountBankResponse(ResponseCode.EXITO, "", accountBank);
        } catch (Exception e) {
            e.printStackTrace();
            return new AccountBankResponse(ResponseCode.ERROR_INTERNO, "Error");
        }

    }

    public AccountBankListResponse getAccountBankByUser(Long unifiedRegistryId) {
        List<AccountBank> accountBanks = new ArrayList<AccountBank>();

        try {
            accountBanks = (List<AccountBank>) entityManager.createNamedQuery("AccountBank.findByUnifiedRegistryId", AccountBank.class).setParameter("unifiedRegistryId", unifiedRegistryId).getResultList();
            if (accountBanks.size() <= 0) {
                return new AccountBankListResponse(ResponseCode.ERROR_INTERNO, "Error loading account bank");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AccountBankListResponse(ResponseCode.ERROR_INTERNO, "Error loading account bank");
        }

        return new AccountBankListResponse(ResponseCode.EXITO, "", accountBanks);
    }



    public AccountBankResponse updateAccountBankByAccountNumber(Long unifiedRegistryId, String accountNumberOld,String accountNumberCurrent, Long bankId) {

        try {
            AccountBank accountBanks = (AccountBank) entityManager.createNamedQuery("AccountBank.findByUnifiedRegistryIdByAccountNumberByBankIdByStatusAccountId", AccountBank.class).setParameter("unifiedRegistryId", unifiedRegistryId).setParameter("accountNumber", accountNumberOld).setParameter("bankId", bankId).getSingleResult();
            accountBanks.setAccountNumber(accountNumberCurrent);
            accountBanks.setUpdateDate(new Timestamp(new Date().getTime()));
            entityManager.merge(accountBanks);
            return new AccountBankResponse(ResponseCode.EXITO, "", accountBanks);
        } catch (Exception e) {
            e.printStackTrace();
            return new AccountBankResponse(ResponseCode.ERROR_INTERNO, "Error");
        }

    }

    public NaturalPersonResponse saveBusinessApplicantNaturalPerson(Person person, NaturalPerson naturalPerson, PhonePerson phonePerson) {

        try {
            //Guardo person
            person.setCreateDate(new Timestamp(new Date().getTime()));
            if (person.getEmail() != null) {
                person.setEmail(person.getEmail());
            } else {
                person.setEmail(null);
            }
            person.setPersonTypeId(person.getPersonTypeId());
            //person.setPersonClassificationId(person.getPersonClassificationId());
            PersonClassification personClassification = entityManager.find(PersonClassification.class, Constants.NATURAL_PERSON);
            person.setPersonClassificationId(personClassification);
            if (person.getWebSite() != null) {
                person.setWebSite(person.getWebSite());
            } else {
                person.setWebSite(null);
            }
            person.setCountryId(person.getCountryId());
            entityManager.persist(person);
            //Guardo Natural Person
            naturalPerson.setPersonId(person);
            naturalPerson.setDocumentsPersonTypeId(naturalPerson.getDocumentsPersonTypeId());
            naturalPerson.setIdentificationNumber(naturalPerson.getIdentificationNumber());
            if (naturalPerson.getIdentificactionNumberOld() != null) {
                naturalPerson.setIdentificactionNumberOld(naturalPerson.getIdentificactionNumberOld());
            } else {
                naturalPerson.setIdentificactionNumberOld(null);
            }
            naturalPerson.setDueDateDocumentIdentification(naturalPerson.getDueDateDocumentIdentification());
            naturalPerson.setFirstName(naturalPerson.getFirstName());
            naturalPerson.setLastName(naturalPerson.getLastName());
            if (naturalPerson.getMarriedLastName() != null) {
                naturalPerson.setMarriedLastName(naturalPerson.getMarriedLastName());
            } else {
                naturalPerson.setMarriedLastName(null);
            }
            naturalPerson.setGender(naturalPerson.getGender());
            naturalPerson.setPlaceBirth(naturalPerson.getPlaceBirth());
            naturalPerson.setDateBirth(naturalPerson.getDateBirth());
            naturalPerson.setCivilStatusId(naturalPerson.getCivilStatusId());
            if (naturalPerson.getProfessionId() != null) {
                naturalPerson.setProfessionId(naturalPerson.getProfessionId());
            } else {
                naturalPerson.setProfessionId(null);
            }
            naturalPerson.setCreateDate(new Timestamp(new Date().getTime()));
            entityManager.persist(naturalPerson);
            //Guardo Phone Number
            phonePerson.setCountryId(phonePerson.getCountryId());
            phonePerson.setCountryCode(phonePerson.getCountryCode());
            phonePerson.setAreaCode(phonePerson.getAreaCode());
            phonePerson.setNumberPhone(phonePerson.getNumberPhone());
            phonePerson.setPersonId(person);
            phonePerson.setPhoneTypeId(phonePerson.getPhoneTypeId());
            if (phonePerson.getExtensionPhoneNumber() != null) {
                phonePerson.setExtensionPhoneNumber(phonePerson.getExtensionPhoneNumber());
            } else {
                phonePerson.setExtensionPhoneNumber(null);
            }
            phonePerson.setIndMainPhone(phonePerson.getIndMainPhone());
            phonePerson.setCreateDate(new Timestamp(new Date().getTime()));
            entityManager.persist(phonePerson);
            return new NaturalPersonResponse(ResponseCode.EXITO, "", naturalPerson);
        } catch (Exception e) {
            e.printStackTrace();
            return new NaturalPersonResponse(ResponseCode.ERROR_INTERNO, "Error");
        }

    }

    public LegalPersonResponse saveBusinessApplicantLegalPerson(Person person,LegalPerson legalPerson, PhonePerson phonePerson) {

        try {
            //Guardo person
            person.setCreateDate(new Timestamp(new Date().getTime()));
            if (person.getEmail() != null) {
                person.setEmail(person.getEmail());
            } else {
                person.setEmail(null);
            }
            person.setPersonTypeId(person.getPersonTypeId());
            //person.setPersonClassificationId(person.getPersonClassificationId());
            PersonClassification personClassification = entityManager.find(PersonClassification.class, Constants.LEGAL_PERSON);
            person.setPersonClassificationId(personClassification);
            if (person.getWebSite() != null) {
                person.setWebSite(person.getWebSite());
            } else {
                person.setWebSite(null);
            }
            person.setCountryId(person.getCountryId());
            entityManager.persist(person);
            //Guardo Legal Person
            legalPerson.setCreateDate(new Timestamp(new Date().getTime()));
            legalPerson.setPersonId(person);
            legalPerson.setDocumentsPersonTypeId(legalPerson.getDocumentsPersonTypeId());
            legalPerson.setIdentificationNumber(legalPerson.getIdentificationNumber());
            if (legalPerson.getTradeName() != null) {
                legalPerson.setTradeName(legalPerson.getTradeName());
            } else {
                legalPerson.setTradeName(null);
            }            
            legalPerson.setBusinessName(legalPerson.getBusinessName());
            legalPerson.setBusinessCategoryId(legalPerson.getBusinessCategoryId());
            legalPerson.setRegisterNumber(legalPerson.getRegisterNumber());
            legalPerson.setDateInscriptionRegister(legalPerson.getDateInscriptionRegister());
            legalPerson.setPayedCapital(legalPerson.getPayedCapital());           
            entityManager.persist(legalPerson);
            //Guardo Phone Number
            phonePerson.setCountryId(phonePerson.getCountryId());
            phonePerson.setCountryCode(phonePerson.getCountryCode());
            phonePerson.setAreaCode(phonePerson.getAreaCode());
            phonePerson.setNumberPhone(phonePerson.getNumberPhone());
            phonePerson.setPersonId(person);
            phonePerson.setPhoneTypeId(phonePerson.getPhoneTypeId());
            if (phonePerson.getExtensionPhoneNumber() != null) {
                phonePerson.setExtensionPhoneNumber(phonePerson.getExtensionPhoneNumber());
            } else {
                phonePerson.setExtensionPhoneNumber(null);
            }
            phonePerson.setIndMainPhone(phonePerson.getIndMainPhone());
            phonePerson.setCreateDate(new Timestamp(new Date().getTime()));
            entityManager.persist(phonePerson);
            return new LegalPersonResponse(ResponseCode.EXITO, "", legalPerson);
        } catch (Exception e) {
            e.printStackTrace();
            return new LegalPersonResponse(ResponseCode.ERROR_INTERNO, "Error");
        }

    }
    
   
    
}
