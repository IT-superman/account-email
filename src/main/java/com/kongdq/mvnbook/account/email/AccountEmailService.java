package com.kongdq.mvnbook.account.email;

import com.kongdq.mvnbook.account.email.exception.AccountEmailException;

public interface AccountEmailService {

    public void sendEmail(String to, String subject, String htmlText) throws AccountEmailException;
}
