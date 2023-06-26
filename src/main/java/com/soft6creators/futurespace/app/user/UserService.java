package com.soft6creators.futurespace.app.user;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.soft6creators.futurespace.app.account.Account;
import com.soft6creators.futurespace.app.account.AccountService;
import com.soft6creators.futurespace.app.address.Address;
import com.soft6creators.futurespace.app.address.AddressService;
import com.soft6creators.futurespace.app.mailsender.MailSenderService;
import com.soft6creators.futurespace.app.tradingaccount.TradingAccount;
import com.soft6creators.futurespace.app.tradingaccount.TradingAccountService;

import net.bytebuddy.utility.RandomString;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private AddressService addressService;

	@Autowired
	AccountService accountService;
	@Autowired
	MailSenderService mailSenderService;
	@Autowired
	TradingAccountService tradingAccountService;

	public User addUser(User user) {
		if (checkUser(user.getEmail())) {
			return new User();
		}
		String randomCode = RandomString.make(6);
		// user.setVerificationCode(randomCode);
		user.setActive(true);
		user.setReferralId(user.getFullName().trim() + "-" + RandomString.make(6));
		if (user.getReferral() != null) {
			User userReferral = userRepository.findByReferralId(user.getReferral().getReferralId());
			if (userReferral != null) {
				user.setReferral(userReferral);
			} else {
				User wrongReferral = new User();
				wrongReferral.setReferral(user.getReferral());
				return wrongReferral;
			}
		}

		// try {
		// sendVerificationEmail(user);
		// } catch (MessagingException e) {
		// e.printStackTrace();
		// } catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		Account account = new Account();
		if (user.getReferral() != null) {
			account.setAccountBalance(0.0);
		} else {
			account.setAccountBalance(0.0);
		}
		accountService.addAccount(account);
		user.setAccount(account);
		TradingAccount tradingAccount = new TradingAccount();
		tradingAccountService.addTradingAccount(tradingAccount);
		user.setTradingAccount(tradingAccount);
		return userRepository.save(user);
	}

	public boolean resend(String email) {
		Optional<User> user = userRepository.findById(email);
		try {
			sendVerificationEmail(user.get());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public Optional<User> getUser(String email) {
		return userRepository.findById(email);
	}

	private boolean checkUser(String email) {
		return userRepository.existsById(email);
	}

	private void sendVerificationEmail(User user) throws MessagingException, UnsupportedEncodingException {
		String toAddress = user.getEmail();
		String subject = "StandardFX (One time password)";
		String content = " <div>\n" + "        <style>\n" + "            #container {\n"
				+ "                padding: 12px; font-family: Arial, Helvetica, sans-serif;\n" + "            }\n"
				+ "            @media only screen and (min-width: 800px) {\n" + "              #container {\n"
				+ "                padding: 10% 35%;\n" + "              }\n" + "            }\n"
				+ "          </style>\n"
				+ "        <div id=\"container\" style=\"box-shadow: 1px 1px 10px rgb(236, 236, 236);\">\n"
				+ "            <div style=\"\n" + "                 padding: 8px 16px;\n"
				+ "                 background-color: rgb(0, 39, 21);\n" + "                 color: white;\n"
				+ "                 font-family: Arial, Helvetica, sans-serif;\n" + "               \">\n"
				+ "                <p style=\"font-size: 20px; font-weight: bold;\">\n"
				+ "                    StandardFX\n" + "                </p>\n" + "            </div>\n"
				+ "            <div style=\"\n" + "                 padding: 12px;\n"
				+ "                 font-family: Arial, Helvetica, sans-serif;\n"
				+ "                 margin-top: 0px;\n" + "               \">\n"
				+ "                <p style=\"font-weight: 600; font-size: 18px\">\n"
				+ "                    Confirm your Registration\n" + "                </p>\n"
				+ "                <p style=\"font-size: 14px; color: rgb(0, 39, 21)\">\n"
				+ "                    Welcome to StandardFX\n" + "                </p>\n"
				+ "                <p style=\"font-size: 14px; color: rgb(34, 34, 34)\">\n"
				+ "                    Here is your account activation code\n" + "                </p>\n"
				+ "                <p style=\"color: rgb(0, 50, 235); font-weight: 600\">" + user.getVerificationCode()
				+ "</p>\n"
				+ "                <p style=\"font-size: 14px; font-weight: bold; color: rgb(34, 34, 34)\">\n"
				+ "                    Security tips:\n" + "                </p>\n" + "                <ol style=\"\n"
				+ "                   font-size: 14px;\n" + "                   font-weight: bold;\n"
				+ "                   padding-left: 20px;\n" + "                   color: rgb(54, 54, 54);\n"
				+ "                   line-height: 18px;\n" + "                 \">\n"
				+ "                    <li>Never give your password to anyone</li>\n" + "                    <li>\n"
				+ "                        Never call any phone number for someone claiming to be StandardFX\n"
				+ "                        Support\n" + "                    </li>\n" + "                    <li>\n"
				+ "                        Never send any money to anyone claiming to be a member of\n"
				+ "                        StandardFX team\n" + "                    </li>\n"
				+ "                    <li>Enable Google Two Factor Authentication.</li>\n" + "                </ol>\n"
				+ "                <p style=\"font-size: 12px; color: rgb(34, 34, 34)\">\n"
				+ "                    If you don't recognize this activity, please contact our customer\n"
				+ "                    support immediately.\n" + "                </p>\n"
				+ "                <p style=\"font-size: 12px; color: rgb(34, 34, 34)\">StandardFX Team</p>\n"
				+ "                <p style=\"font-size: 12px; color: rgb(34, 34, 34)\">\n"
				+ "                    This is an automated message, Please do not reply\n" + "                </p>\n"
				+ "            </div>\n" + "        </div>\n" + "    </div>";

		mailSenderService.sendEmail(toAddress, subject, content);
	}

	public boolean verify(String verificationCode) {
		User user = userRepository.findByVerificationCode(verificationCode);
		if (user == null || user.isActive()) {
			return false;
		} else {
			user.setVerificationCode(null);
			user.setActive(true);
			userRepository.save(user);
			return true;
		}
	}

	public User signIn(String email, String password) {
		Optional<User> user = userRepository.findByEmailAndPassword(email, password);
		return user.get();
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(String userEmail) {
		userRepository.deleteById(userEmail);
	}

	public List<Address> addUsers(List<Address> addresses) {
		List<Address> userAddresses = new ArrayList<>();
		Address userAddress2 = null;
		for (Address address : addresses) {
			User user = new User();
			user.setFullName(address.getUser().getFullName());
			user.setEmail(address.getUser().getEmail());
			user.setPassword(address.getUser().getPassword());
			user.setReferral(null);
			user.setDate(address.getUser().getDate());

			User addedUser = addUser(user);

			Address userAddress = new Address();
			userAddress.setUser(addedUser);
			userAddress.setCountry(address.getCountry());
			userAddress.setState(address.getState());
			userAddress.setCity(address.getCity());
			userAddress.setAddressLine1(address.getAddressLine1());
			userAddress.setAddressLine2(address.getAddressLine2());
			userAddress.setCitizen(address.isCitizen());
			userAddress.setZipCode(address.getZipCode());
			userAddress.setMobileNumber(address.getMobileNumber());
			userAddress.setSource(address.getSource());

			userAddress2 = addressService.addAddress(userAddress);

		}
		userAddresses.add(userAddress2);
		return userAddresses;
	}

}
