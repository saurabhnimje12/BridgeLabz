package org.ProblemStatements;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Fraud {
    private int transactionId;
    private int policyNumber;
    private double amount;
    private LocalDate transactionDate;
    private boolean isFraudulent;

    public Fraud(int transactionId, int policyNumber, double amount, LocalDate transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    public void setIsFraudulent(boolean fraudulent) {
        isFraudulent = fraudulent;
    }

    @Override
    public String toString() {
        return "FraudDetection{" + "transactionId=" + transactionId + ", policyNumber=" + policyNumber + ", amount=" + amount + ", transactionDate=" + transactionDate + ", isFraudulent=" + isFraudulent + '}';
    }
}

public class FraudDetection {
    public static void main(String[] args) {
        ArrayList<Fraud> fraudsList = new ArrayList<>();
        fraudsList.add(new Fraud(101, 12345, 15000, LocalDate.now(), true));
        fraudsList.add(new Fraud(102, 12346, 15000, LocalDate.now(), false));
        fraudsList.add(new Fraud(103, 12345, 15000, LocalDate.now(), true));
        fraudsList.add(new Fraud(104, 12347, 15000, LocalDate.now(), true));
        fraudsList.add(new Fraud(105, 12345, 15000, LocalDate.now(), false));
        fraudsList.add(new Fraud(106, 12347, 15000, LocalDate.now(), false));
        fraudsList.add(new Fraud(107, 12347, 15000, LocalDate.now(), true));
        fraudsList.add(new Fraud(108, 12346, 15000, LocalDate.now(), false));
        fraudsList.add(new Fraud(109, 12346, 15000, LocalDate.now(), true));
        fraudsList.add(new Fraud(1010, 12345, 15000, LocalDate.now(), true));
        fraudsList.add(new Fraud(1011, 12346, 15000, LocalDate.now(), true));
        fraudsList.add(new Fraud(1012, 12347, 15000, LocalDate.now(), false));

//        1. Filter: Select transactions marked as fraudulent (isFraudulent is true) and where the amount exceeds $10,000.
        fraudsList.stream()
                .filter(fraud -> fraud.isFraudulent() == true && fraud.getAmount() > 10000)
                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("==========================================");


//        2. Group: Group these transactions by policyNumber.
        Map<Integer, List<Fraud>> collect = fraudsList.stream().collect(Collectors.groupingBy(Fraud::getPolicyNumber));
        collect.forEach((pNumber, fList) -> {
            System.out.println("Policy Number : " + pNumber);
            fList.forEach(System.out::println);
        });
        System.out.println("==========================================");

//        3. Aggregate: For each policy, calculate the total number of fraudulent transactions and the total amount of fraud.
        Map<Integer, List<Fraud>> collect1 = fraudsList.stream().filter(fraud -> fraud.isFraudulent() == true).collect(Collectors.groupingBy(Fraud::getPolicyNumber));
        collect1.forEach((id, fList) -> {
            Double collect2 = fList.stream().collect(Collectors.summingDouble(Fraud::getAmount));
            System.out.println("ALERT: Policy Number " + id + " has fraudulent transactions with a total fraud amount of $" + collect2);
        });
        System.out.println("==========================================");

//        4. Alert: Generate an alert for policies with more than 5 fraudulent transactions or a total fraud amount exceeding $50,000.
//        Map<Integer, List<Fraud>> collect2 = fraudsList.stream().collect(Collectors.groupingBy(Fraud::getPolicyNumber));
//        collect2.forEach((id, fList) -> {
//            fList.stream().filter(fList.size()  > 5).collect(Collectors.summingDouble(Fraud::getAmount > 50000)).forEach(System.out::println);
//
//        });


    }
}
