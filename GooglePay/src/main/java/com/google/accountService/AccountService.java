package com.google.accountService;

import java.util.List;
import org.springframework.data.repository.query.Param;
import com.google.entity.AccountDetails;

public interface AccountService {

	List<AccountDetails> getAllAccounts();

	AccountDetails getAccountRecordByAccountId(@Param("aid") Integer id);

	List<AccountDetails> accountBalance(double balance);

	AccountDetails saveAccountDetails(AccountDetails details);
}
