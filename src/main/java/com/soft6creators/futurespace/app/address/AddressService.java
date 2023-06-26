package com.soft6creators.futurespace.app.address;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.soft6creators.futurespace.app.account.AccountRepository;
import com.soft6creators.futurespace.app.accounttype.AccountType;
import com.soft6creators.futurespace.app.accounttype.AccountTypeRepository;
import com.soft6creators.futurespace.app.tradingaccount.TradingAccountRepository;
import com.soft6creators.futurespace.app.user.UserRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AccountTypeRepository accountTypeRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TradingAccountRepository tradingAccountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public Address addAddress(Address address) {
		AccountType accountType = new AccountType();
		accountType.setAccountTypeId(1);
		address.setAccountType(accountType);
		return addressRepository.save(address);
	}
	
	public Optional<Address> getAddress(int addressId) {
		return addressRepository.findById(addressId);
	}
	
	public Address getAddressByEmail(String email) {
		return addressRepository.findByUserEmail(email);
	}
	public List<Address> getAddresses() {
		
		 return (List<Address>) addressRepository.findAll();
	}
	
	public List<Address> addAddresses(@RequestBody List<Address> addresses) {
		for (Address address : addresses) {
			accountRepository.save(address.getUser().getAccount());
			tradingAccountRepository.save(address.getUser().getTradingAccount());
			userRepository.save(address.getUser());
			accountTypeRepository.save(address.getAccountType());
			addressRepository.save(address);
		}
		return (List<Address>) addressRepository.findAll();
	}
}
