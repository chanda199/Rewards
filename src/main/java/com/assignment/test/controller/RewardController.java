package com.assignment.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.test.modal.CustomerReward;
import com.assignment.test.modal.Reward;
import com.assignment.test.service.RewardService;

@RestController
public class RewardController {
	
	@Autowired
	private RewardService rewardService;
	
	@PostMapping("/rewards")
	public ResponseEntity<List<CustomerReward>> getRewardsForCustomerDetails(@RequestBody Reward reward){
		List<CustomerReward> rewards =rewardService.rewardCalculator(reward);
		return new ResponseEntity<>(rewards,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/rewards/{custname}")
	public ResponseEntity<CustomerReward> getRewardsByCustomerName(@PathVariable String custname){
		
		CustomerReward result = rewardService.getCustomerRewardByName(custname);
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	

}
