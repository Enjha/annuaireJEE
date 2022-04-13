package mybootapp.web;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mybootapp.model.Person;

@Service
public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "person.firstName");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "person.lastName");

		if (person.getFirstName().equals(null)) {
			errors.rejectValue("firstName", "person.firstName.required");
		}if (person.getLastName().equals(null)) {
			errors.rejectValue("lastName", "person.LastName.required");
		}if (person.getEmail().equals(null)) {
			errors.rejectValue("email", "person.email.required");
		}
	}

}