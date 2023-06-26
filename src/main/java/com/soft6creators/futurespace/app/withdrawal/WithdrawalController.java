package com.soft6creators.futurespace.app.withdrawal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WithdrawalController {
	@Autowired
	private WithdrawalService withdrawalService;
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping(method = RequestMethod.POST, value = "/withdrawal")
	public Withdrawal addWithdrawal(@RequestBody Withdrawal withdrawal) {
		return withdrawalService.addWithdrawal(withdrawal);
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping(method = RequestMethod.PUT, value = "/withdrawal")
	public Withdrawal updateWithdrawal(@RequestBody Withdrawal withdrawal) {
		return withdrawalService.addWithdrawal(withdrawal);
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping("/withdrawal/{withdrawalId}")
	public Optional<Withdrawal> getWithdrawal(@PathVariable int withdrawalId) {
		return withdrawalService.getWithdrawal(withdrawalId);
	}
	
	
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping("/user/{userEmail}/withdrawal")
	public List<Withdrawal> getWithdrawalByUser(@PathVariable String userEmail) {
		return withdrawalService.getWithdrawalsByUser(userEmail);
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping("/withdrawals/{withdrawalStatus}")
	public List<Withdrawal> getWithdrawalsByWithdrawalStatus(@PathVariable String withdrawalStatus) {
		return withdrawalService.getWithdrawalsByWithdrawalStatus(withdrawalStatus);
	}

        @CrossOrigin(maxAge = 3600)
	@RequestMapping("/withdrawals")
	public List<Withdrawal> getWithdrawals() {
		return withdrawalService.getWithdrawals();
	}

        @CrossOrigin(maxAge = 3600)
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/withdrawal/{withdrawalId}")
	public void deleteWithdrawal(@PathVariable int withdrawalId) {
		withdrawalService.deleteWithdrawal(withdrawalId);
	}
}
