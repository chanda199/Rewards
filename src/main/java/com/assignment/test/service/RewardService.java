package com.assignment.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.assignment.test.modal.CustomerReward;
import com.assignment.test.modal.Reward;

@Service
public class RewardService {

	private static final int TXN_RATE = 50;
	private static final int TXN_PERC = 100;
	Map<String, CustomerReward> customerRewards = new HashMap<>();

	private static int calculateRewardPoint(int txnAmount) {
		if (txnAmount <= TXN_RATE) {
			return 0;
		}
		if (txnAmount <= TXN_PERC) {
			return txnAmount - TXN_RATE;
		}
		return (txnAmount - TXN_PERC) * 2 + TXN_RATE;
	}

	public List<CustomerReward> rewardCalculator(Reward rewards) {
		List<CustomerReward> result = new ArrayList<>();
		String custName = rewards.getCustomerName();
		int amt = rewards.getAmount();
		int reward = calculateRewardPoint(amt);
		int month = Integer.parseInt(rewards.getDate().split("-")[1]);
		if (customerRewards.containsKey(custName)) {
			customerRewards.get(custName).addReward(month, reward);
		} else {
			CustomerReward customerReward = new CustomerReward(custName);
			customerReward.addReward(month, reward);
			customerRewards.put(custName, customerReward);
		}
		for (Map.Entry<String, CustomerReward> c : customerRewards.entrySet()) {
			result.add(c.getValue());
		}

		return result;

	}

	public CustomerReward getCustomerRewardByName(String customerName) {
		return customerRewards.get(customerName);
	}

}
