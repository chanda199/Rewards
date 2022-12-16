package com.assignment.test.modal;

public class CustomerReward {
	private String name;
	private int rewards[];
	private final int MONTH_COUNT = 12;

	public CustomerReward(String name) {
		this.name = name;
		this.rewards = new int[MONTH_COUNT + 1];
	}

	public void addReward(int month, int reward) {
		rewards[month] = reward;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getRewards() {
		return rewards;
	}

	public void setRewards(int[] rewards) {
		this.rewards = rewards;
	}

	public int getMONTH_COUNT() {
		return MONTH_COUNT;
	}

	@Override
	public String toString() {
		String s = "Customer: " + name + "\n";
		for (int i = 1; i <= MONTH_COUNT; i++) {
			s += "Month " + i + ": Rewards " + rewards[i] + "\n";
		}
		return s;
	}

}
