package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    // Add a new method: findAccounts()

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    String getName();

    void  setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

}
