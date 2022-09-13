package emart.validation;

public class Validator {
	
	public static void main(String[] args) {
		System.out.println(isPasswordValid("ab123"));
	}
	
	public static boolean isPasswordValid(String password) {
	    boolean isValid = true;
	    int letterEndpoint = password.length() - 3;
	    if (letterEndpoint < 2 || letterEndpoint > 4)
	        isValid = false;
	    else {
	        for (int i = 0; i < password.length(); i++) {
	            if (i > 0 && i < letterEndpoint && !Character.isAlphabetic(password.charAt(i))) {
	                isValid = false;
	                break;
	            }
	            if (i >= password.length() - 3 && !Character.isDigit(password.charAt(i))) {
	                isValid = false;
	                break;
	            }
	        }
	    }
	    return isValid;
	}
}
