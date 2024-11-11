package org.ProblemStatements;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim {
    private int claimId;
    private int policyNumber;
    private double claimAmount;
    private LocalDate claimDate;
    private String status;

    public Claim(int claimId, int policyNumber, double claimAmount, LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", policyNumber=" + policyNumber +
                ", claimAmount=" + claimAmount +
                ", claimDate=" + claimDate +
                ", status='" + status + '\'' +
                '}';
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        ArrayList<Claim> claimsList = new ArrayList<>();
        claimsList.add(new Claim(101, 12345, 12000, LocalDate.now(), "Approved"));
        claimsList.add(new Claim(102, 12346, 3000, LocalDate.now(), "Rejected"));
        claimsList.add(new Claim(103, 12345, 18000, LocalDate.now(), "Approved"));
        claimsList.add(new Claim(104, 12348, 14000, LocalDate.now(), "Rejected"));
        claimsList.add(new Claim(105, 12348, 2000, LocalDate.now(), "Approved"));
        claimsList.add(new Claim(106, 12345, 72000, LocalDate.now(), "Approved"));
        claimsList.add(new Claim(107, 12348, 42000, LocalDate.now(), "Rejected"));
        claimsList.add(new Claim(108, 12346, 22000, LocalDate.now(), "Approved"));

//        1. Filter: Select claims that are in the "Approved" status and have a claimAmount greater than $5,000.
        claimsList.stream()
                .filter(claim -> claim.getStatus().equals("Approved") && claim.getClaimAmount() > 5000)
                .forEach(System.out::println);
        System.out.println("==========================================");

//        2. Group: Group these claims by policyNumber.
        Map<Integer, List<Claim>> collect = claimsList.stream().collect(Collectors.groupingBy(Claim::getPolicyNumber));
        collect.forEach((policyNumber, claimlist) -> {
            System.out.println("Claim Id : " + policyNumber);
            claimlist.forEach(System.out::println);
        });
        System.out.println("==========================================");

//        3. Aggregate: For each policy, calculate the total claimAmount and the average claimAmount.

        Double total = claimsList.stream()
                                .filter(claim -> claim.getStatus().equals(("Approved")))
                                .collect(Collectors.summingDouble(Claim::getClaimAmount));
        System.out.println("Total Claim Amount : " + total);

        Double average = claimsList.stream()
                                    .filter(claim -> claim.getStatus().equals(("Approved")))
                                    .collect(Collectors.averagingDouble(Claim::getClaimAmount));
        System.out.println("Average Claim Amount : " + average);
        System.out.println("==========================================");

//        4. Top N: Identify the top 3 policies with the highest total claim amounts.
        claimsList.stream()
                    .sorted(Comparator.comparing(Claim::getClaimAmount).reversed())
                    .limit(3).forEach(System.out::println);
    }
}
