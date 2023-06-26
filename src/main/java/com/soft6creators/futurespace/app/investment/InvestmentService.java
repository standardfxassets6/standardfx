package com.soft6creators.futurespace.app.investment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft6creators.futurespace.app.account.Account;
import com.soft6creators.futurespace.app.account.AccountRepository;
import com.soft6creators.futurespace.app.crypto.Crypto;
import com.soft6creators.futurespace.app.crypto.CryptoService;

@Service
public class InvestmentService {

	@Autowired
	private InvestmentRepository investmentRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CryptoService cryptoService;

	public Investment addInvestment(Investment investment) {
		Crypto crypto = cryptoService.getCryptoByName(investment.getCurrency().getCrypto());
		Optional<Account> account = accountRepository.findById(investment.getAccount().getAccountId());
		Optional<Investment> currentInvestment = investmentRepository
				.findByAccountAccountId(account.get().getAccountId());
		if (currentInvestment.isPresent()) {
			investment.setInvestmentId(currentInvestment.get().getInvestmentId());
		}
		account.get().setAccountBalance(investment.getInvestedAmount());
		investment.setCurrency(crypto);
		investment.setActive(true);

		if (account.get().getInterestPreference() == null) {
			account.get().setInterestPreference(investment.getCurrency());
		}
		accountRepository.save(account.get());

		return investmentRepository.save(investment);
	}

	public Investment continueInvestment(Investment investment) {
		Crypto crypto = cryptoService.getCryptoByName(investment.getCurrency().getCrypto());
		Optional<Account> account = accountRepository.findById(investment.getAccount().getAccountId());
		Optional<Investment> previousInvestment = investmentRepository
				.findByAccountAccountId(account.get().getAccountId());
		investment.setInvestmentId(previousInvestment.get().getInvestmentId());
		investment.setStartDate(previousInvestment.get().getStartDate());
		account.get().setAccountBalance(investment.getInvestedAmount());
		investment.setCurrency(crypto);
		investment.setActive(true);

		if (account.get().getInterestPreference() == null) {
			account.get().setInterestPreference(investment.getCurrency());
		}
		accountRepository.save(account.get());

		return investmentRepository.save(investment);
	}

	public boolean cancelInvestment(int investmentId) {
		Optional<Investment> investment = investmentRepository.findById(investmentId);
		investment.get().setActive(false);
		investmentRepository.save(investment.get());
		return investment.get().isActive();
	}

	public Optional<Investment> getInvestmentByAccount(int accountId) {
		return investmentRepository.findByAccountAccountId(accountId);
	}

	public Optional<Investment> getInvestMent(int investmentId) {
		return investmentRepository.findById(investmentId);
	}

	public void deleteInvestMent(int investmentId) {
		investmentRepository.deleteById(investmentId);
	}

	public List<Investment> getInvestMents() {
		return (List<Investment>) investmentRepository.findAll();
	}

	public boolean investmentComplete(int investmentId, int roi) {
		Optional<Investment> investment = investmentRepository.findById(investmentId);
		investment.get().setActive(false);
		investmentRepository.save(investment.get());
		Optional<Account> account = accountRepository.findById(investment.get().getAccount().getAccountId());
		account.get().setAccountBalance(roi);
		accountRepository.save(account.get());
		return true;
	}

	public void deleteInvestment(int investmentId) {
		investmentRepository.deleteById(investmentId);
	}
        public List<Investment> addInvestments(List<Investment> investments) {
		return (List<Investment>) investmentRepository.saveAll(investments);
	}
}
