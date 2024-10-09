package BridgeLabs_Collection_List;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Policy {
	private Integer policyID;
	private String type;
	private double premium;
	private double coverageAmount;
	private LocalDate expiryDate;

	public Policy(Integer policyID, String type, double premium, double coverageAmount, LocalDate expiryDate) {
		super();
		this.policyID = policyID;
		this.type = type;
		this.premium = premium;
		this.coverageAmount = coverageAmount;
		this.expiryDate = expiryDate;
	}

	public Integer getPolicyID() {
		return policyID;
	}

	public void setPolicyID(Integer policyID) {
		this.policyID = policyID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Policy [policyID=" + policyID + ", type=" + type + ", premium=" + premium + ", coverageAmount="
				+ coverageAmount + ", expiryDate=" + expiryDate + "]";
	}

}

public class PolicyManager {

	private HashMap<Integer, Policy> hashMap;
	private TreeMap<LocalDate, Policy> treeMap;
	private LinkedHashMap<Integer, Policy> linkedHashMap;

	public PolicyManager() {
		hashMap = new HashMap<Integer, Policy>();
		treeMap = new TreeMap<LocalDate, Policy>();
		linkedHashMap = new LinkedHashMap<Integer, Policy>();
	}

	public void addPolicy(Policy policy) {
		hashMap.put(policy.getPolicyID(), policy);
		treeMap.put(policy.getExpiryDate(), policy);
		linkedHashMap.put(policy.getPolicyID(), policy);
	}

	public void displayAllPolicy() {
		System.out.println("All Policies");
		for (Entry<Integer, Policy> entrySet : hashMap.entrySet()) {
			System.out.println(entrySet);
		}
	}

	public void removePolicy(Integer policyID) {
		Policy policy = hashMap.get(policyID);
		if (policy != null) {
			hashMap.remove(policyID);
			treeMap.remove(policy.getExpiryDate());
			linkedHashMap.remove(policyID);
			System.out.println("Policy " + policyID + " removed.");
		} else {
			System.out.println("Policy not found!");
		}
	}

	public Policy getPolicyByID(Integer policyID) {
		return hashMap.get(policyID);
	}

	public void displayPoliciesByExpiryDate() {
		System.out.println("Policies sorted by expiry date:");
		for (Entry<LocalDate, Policy> entry : treeMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public void displayPoliciesInInsertionOrder() {
		System.out.println("Policies in insertion order:");
		for (Map.Entry<Integer, Policy> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		PolicyManager manager = new PolicyManager();
		Policy p1 = new Policy(101, "Health", 500.0, 10000.0, LocalDate.now().plusMonths(1));
		Policy p2 = new Policy(102, "Life", 1000.0, 50000.0, LocalDate.now().plusWeeks(3));
		Policy p3 = new Policy(103, "Auto", 300.0, 20000.0, LocalDate.now().plusDays(45));

		manager.addPolicy(p1);
		manager.addPolicy(p2);
		manager.addPolicy(p3);

		manager.displayAllPolicy();
		manager.removePolicy(103);
		manager.getPolicyByID(102);
		manager.displayPoliciesByExpiryDate();
		manager.displayPoliciesInInsertionOrder();
	}
}
