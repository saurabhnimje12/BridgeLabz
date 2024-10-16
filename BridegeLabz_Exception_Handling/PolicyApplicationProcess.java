package BridegeLabz_Exception_Handling;

class InvalidAgeException extends RuntimeException {
	public InvalidAgeException(String mesg) {
		super(mesg);
	}
}

class PoorDrivingRecordException extends RuntimeException {
	public PoorDrivingRecordException(String mesg) {
		super(mesg);
	}
}

class HealthIssueException extends RuntimeException {
	public HealthIssueException(String mesg) {
		super(mesg);
	}
}

public class PolicyApplicationProcess {
	int age;
	int drivingRecord;
	boolean healthIssue;

	public PolicyApplicationProcess(int age, int drivingRecord, boolean healthIssue) {
		super();
		this.age = age;
		this.drivingRecord = drivingRecord;
		this.healthIssue = healthIssue;
	}

	public static void check(PolicyApplicationProcess policyApplicationProcess) {
		if (policyApplicationProcess.age < 18) {
			throw new InvalidAgeException("Age is below 18");
		} else if (policyApplicationProcess.drivingRecord < 3) {
			throw new PoorDrivingRecordException("Your Driving Record is below 3");
		} else if (!policyApplicationProcess.healthIssue) {
			throw new HealthIssueException("You have Health Issue");
		} else {
			System.out.println("You Are Fit and Eligible");
		}
	}

	public static void main(String[] args) {
		try {
			check(new PolicyApplicationProcess(19, 4, true));
		} catch (InvalidAgeException | PoorDrivingRecordException | HealthIssueException e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}
}
