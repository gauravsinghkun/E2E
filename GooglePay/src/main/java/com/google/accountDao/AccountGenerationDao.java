package com.google.accountDao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.google.entity.AccountDetails;

public interface AccountGenerationDao extends CrudRepository<AccountDetails, Integer> {

	@Query("from com.google.entity.AccountDetails")
	List<AccountDetails> getAllAccounts();

	@Query("from com.google.entity.AccountDetails where accountId=:aid")
	AccountDetails getAccountRecordByAccountId(@Param("aid") Integer id);

	@Query("from com.google.entity.AccountDetails where accountBalance>=:balance")
	List<AccountDetails> accountBalance(double balance);

}
