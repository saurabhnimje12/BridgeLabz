package org.ProblemStatements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class PloicyHolder {
    private int holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PloicyHolder(int holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public int getHolderId() {
        return holderId;
    }

    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "PloicyHolder{" + "holderId=" + holderId + ", name='" + name + '\'' + ", age=" + age + ", policyType='" + policyType + '\'' + ", premiumAmount=" + premiumAmount + '}';
    }
}

public class PolicyHolderRiskAssessment {
    private int holderId;
    private String name;
    private double riskScore;

    public PolicyHolderRiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public int getHolderId() {
        return holderId;
    }

    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return "PolicyHolderRiskAssessment{" + "holderId=" + holderId + ", name='" + name + '\'' + ", riskScore=" + riskScore + '}';
    }

    public static void main(String[] args) {
        ArrayList<PloicyHolder> policysList = new ArrayList<>();
        policysList.add(new PloicyHolder(101, "Alice", 45, "Life", 1200));
        policysList.add(new PloicyHolder(102, "Bob", 45, "Health", 500));
        policysList.add(new PloicyHolder(103, "David", 75, "Life", 1000));
        policysList.add(new PloicyHolder(104, "Charlie", 70, "Life", 2000));
        policysList.add(new PloicyHolder(105, "Eve", 55, "Health", 800));
        policysList.add(new PloicyHolder(105, "Frank", 62, "Health", 1500));

//        1. Filter: Select policyholders with a policyType of "Life" and age greater than 60.
        policysList.stream().filter(policy -> policy.getPolicyType().equals("Life") && policy.getAge() > 60).forEach(System.out::println);
        System.out.println("==========================================");

//        2. Transform: Create a new list of RiskAssessment objects containing holderId, name, and a risk score calculated as premiumAmount / age.
        List<PolicyHolderRiskAssessment> life = policysList.stream()
                .filter(policy -> policy.getPolicyType().equals("Life") && policy.getAge() > 60)
                .map(policy -> new PolicyHolderRiskAssessment(policy.getHolderId(), policy.getName(), policy.getPremiumAmount() / policy.getAge()))
                .collect(Collectors.toList());
        life.forEach(System.out::println);
        System.out.println("==========================================");

//        3. Sort: Sort these risk assessments by the risk score in descending order.
        life.stream().sorted(Comparator.comparing(PolicyHolderRiskAssessment::getRiskScore).reversed()).forEach(System.out::println);
        System.out.println("==========================================");

//        4. Categorize: Group these policy holders into risk categories: "High Risk" for risk scores above 0.5 and "Low Risk" otherwise.


    }
}
