package EMartEmployee;

public class AgeValidation {
	public boolean isAgeValid(int age) {
        if(age >= 18 && age <= 40) return true;
        else return false;
    }
}
