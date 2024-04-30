package utilities;

import com.github.javafaker.Faker;

public class FakerTestData {

	private static Faker faker = new Faker();

	public static String generatePhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public static String generateEmailAddress() {
		return faker.internet().emailAddress();
	}

	public static String generateFirstName() {
		return faker.name().firstName();
	}

	public static String generateLastName() {
		return faker.name().lastName();
	}

	public static String generateFullName() {

		return faker.name().fullName();
	}

	public static String generateAdress() {
		return faker.address().fullAddress();
	}

}
