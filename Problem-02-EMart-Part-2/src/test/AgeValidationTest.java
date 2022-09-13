package test;

import org.junit.Assert;
import org.junit.Test;

import EMartEmployee.AgeValidation;

public class AgeValidationTest {

	@Test
	public void ageValidationTestValid() {
		Assert.assertTrue(new AgeValidation().isAgeValid(25));
	}
	
	@Test
	public void ageValidationTestInvalid() {
		Assert.assertFalse(new AgeValidation().isAgeValid(16));
	}
}
