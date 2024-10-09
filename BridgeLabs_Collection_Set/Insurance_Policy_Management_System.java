package BridgeLabs_Collection_Set;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

class Policy {

	// Pending

	int policy_Number; // (unique identifier)
	String policyholderName;
	LocalDate expiryDate;
	String coverageType; // (e.g., Health, Auto, Home)
	double premiumAmount;

	public Policy(Integer policy_Number, String policyholderName, LocalDate expiryDate, String coverageType,
			Double premiumAmount) {
		super();
		this.policy_Number = policy_Number;
		this.policyholderName = policyholderName;
		this.expiryDate = expiryDate;
		this.coverageType = coverageType;
		this.premiumAmount = premiumAmount;
	}

}

public class Insurance_Policy_Management_System {

	private HashSet<Policy> policyHashSet;
	private LinkedHashSet<Policy> policyLinkedHashSet;
	private TreeSet<Policy> policyTreeSet;

	public Insurance_Policy_Management_System() {
		policyHashSet = new HashSet<Policy>();
		policyLinkedHashSet = new LinkedHashSet<Policy>();
		policyTreeSet = new TreeSet<Policy>();
	}

	public void storeUniquePoliciesHashSet(Policy poly) {
		LocalDate date = LocalDate.now().plusMonths(1);
		poly.expiryDate = date;
		policyHashSet.add(poly);
	}

	public void storeUniquePoliciesLinkedHashSet(Policy poly) {
		LocalDate date = LocalDate.now().plusMonths(1);
		poly.expiryDate = date;
		policyLinkedHashSet.add(poly);
	}

	public void storeUniquePoliciesTreeSet(Policy poly) {
		LocalDate date = LocalDate.now().plusMonths(1);
		poly.expiryDate = date;
		policyTreeSet.add(poly);
	}

}
