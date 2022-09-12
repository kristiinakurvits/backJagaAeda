package com.teamProject.backJagaAeda.validation;


import com.teamProject.backJagaAeda.domain.user.User;
import com.teamProject.backJagaAeda.infrastructure.exception.BusinessException;
import com.teamProject.backJagaAeda.infrastructure.exception.DataNotFoundException;

import java.util.Optional;

public class ValidationService {

    public static final String INCORRECT_LOGIN_DETAILS = "Kasutajanimi või parool on vale";
//   public static final String CUSTOMER_NOT_EXISTS = "Sellist klienti ei eksisteeri";
//
//
//    public static final String INSUFFICIENT_FUNDS = "Kontol pole piisavalt vahendeid tehingu sooritamiseks";
//    public static final String MINIMUM_DEPOSIT_REQUIREMENT = "Miinumum deposiidi nõue";
//    public static final Integer MINIMUM_DEPOSIT_AMOUNT = 5;
//
//    public static final String DEPOSIT_OVER_LIMIT = "Deposiidi limiit on ületatud";
//    public static final String WITHDRAW_OVER_LIMIT = "Raha väljavõtmise limiit on ületatud";


    public static void validateUserExists(Optional<User> user) {
        if (user.isEmpty()) {
            throw new BusinessException(INCORRECT_LOGIN_DETAILS, "Kasutajanimi või parool on vale. Proovi uuesti");
        }
    }

//    public static void validateAccountExists(Optional<Account> account, Integer accountId) {
//        if (account.isEmpty()) {
//            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Sellist kontot ID'ga " + accountId + " ei leitud");
//        }
//    }
//
//    public static void validateAccountExists(Optional<Account> account, String accountNumber) {
//        if (account.isEmpty()) {
//            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Sellist kontot kontonubriga " + accountNumber + " ei leitud");
//        }
//    }
//
//    public static void validateEnoughBalance(Integer amount, Account account) {
//        if (account.getBalance() - amount < 0) {
//            throw new BusinessException(INSUFFICIENT_FUNDS, "Kontol " + account.getAccountNumber() +
//                    " pole piisavalt vahendeid. Kontojääk on: " + account.getBalance());
//        }
//    }
//
//    public static void validateDepositAmount(Integer amount) {
//        if (amount < MINIMUM_DEPOSIT_AMOUNT) {
//            throw new BusinessException(MINIMUM_DEPOSIT_REQUIREMENT, "Miinimum deposiit alates €" + MINIMUM_DEPOSIT_AMOUNT);
//        }
//    }


}
