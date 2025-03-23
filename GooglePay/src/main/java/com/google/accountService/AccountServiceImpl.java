package com.google.accountService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.accountDao.AccountGenerationDao;
import com.google.entity.AccountDetails;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountGenerationDao dao;

	@Override
	public List<AccountDetails> getAllAccounts() {
		return dao.getAllAccounts();
	}

	@Override
	public AccountDetails getAccountRecordByAccountId(Integer id) {
		return dao.getAccountRecordByAccountId(id);
	}

	@Override
	public List<AccountDetails> accountBalance(double balance) {
		return dao.accountBalance(balance);
	}

	@Override
	public AccountDetails saveAccountDetails(AccountDetails details) {
		return dao.save(details);
	}

}
