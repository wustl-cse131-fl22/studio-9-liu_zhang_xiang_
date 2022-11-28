package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private int attemptedCredits;
	private int passingCredits;
	private double gradePoints;
	private double bearBucks;

	public Student(String initFirstName, String initLastName, int initid) {
		firstName = initFirstName;
		lastName = initLastName;
		id = initid;
	}
	
	public String getFullName() {
		String fullName = firstName + " " + lastName;
		return fullName;
	}
	
	public int getId() {
		return id;
	}
	
	public void submitGrade(double grade, int credits) {
		if (grade>=1.7) {
			passingCredits+=credits;
		}
		attemptedCredits+=credits;
		gradePoints+=grade*credits;
	}
	
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	
	public int getTotalPassingCredits() {
		return passingCredits;
	}

	public double calculateGradePointAverage() {
		return gradePoints/attemptedCredits;
	}
	
	public String getClassStanding() {
		if (passingCredits<30)
			return "First Year";
		else if (passingCredits>=30&&passingCredits<60)
			return "Sophomore";
		else if (passingCredits>=60&&passingCredits<90)
			return "Junior";
		else
			return "Senior";
	}
	
	public boolean isEligibleForPhiBetaKappa() {
		if (gradePoints/attemptedCredits>=3.6&&passingCredits>=98)
			return true;
		else if (gradePoints/attemptedCredits>=3.8&&passingCredits>=75)
			return true;
		else
			return false;
	}
	
	public void depositBearBucks(double amount) {
		bearBucks += amount;
	}
	
	public void deductBearBucks(double amount) {
		bearBucks -= amount;
	}
	
	public double getBearBucksBalance() {
		return (double) bearBucks;
	}
	
	public double cashOutBearBucks() {
		if (this.getBearBucksBalance()>=10)
		{
			double refund = this.getBearBucksBalance()-10.0;
			bearBucks = 0;
			return refund;
		}
		else
		{
			bearBucks = 0;
			return 0.0;
		}
	}
	

	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
//		bearBucks = this.cashOutBearBucks()+other.cashOutBearBucks();
		if (isHyphenated==true)
		{
			Student c = new Student(firstName, this.lastName+"-"+other.lastName, id);
			c.depositBearBucks(this.cashOutBearBucks()+other.cashOutBearBucks());
			return c;
		}

		else
		{
			Student c = new Student(firstName, lastName, id);
			c.depositBearBucks(this.cashOutBearBucks()+other.cashOutBearBucks());
			return c;
		}
	}
	
	public String toString() {
		return this.getFullName() + " " + this.getId();
	}
}
