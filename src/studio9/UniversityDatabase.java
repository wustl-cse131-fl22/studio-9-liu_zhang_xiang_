package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> resultMap;
	
	public UniversityDatabase() {
		resultMap = new HashMap<>();
	}

	public void addStudent(String accountName, Student student) {
		resultMap.put(accountName, student);
	}

	public int getStudentCount() {
		return resultMap.size();
	}

	public String lookupFullName(String accountName) {
		// TODO: Complete according to studio instructions
		Student resultStudent = resultMap.get(accountName);
		if (resultStudent==null) {
			return null;
		} else {
			String name = resultStudent.getFullName();
			return name;
		}
	}

	public double getTotalBearBucks() {
		double balance = 0.0;
		for(Entry<String, Student> sEntry : resultMap.entrySet()) {
			balance += sEntry.getValue().getBearBucksBalance();
		}
		return balance;
	}
}
