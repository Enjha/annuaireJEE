package mybootapp.web;

import mybootapp.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        String firstNameValidation = firstNameValidation(person.getFirstName());
        String lastNameValidation = lastNameValidation(person.getLastName());
        //birthDay
        String emailValidation = emailValidation(person.getEmail());
        String websiteValidation = webSiteValidation(person.getWebsite());
        String passwordValidation = passwordValidation(person.getPassword());

        if (!firstNameValidation.equals("ok")) {
            errors.rejectValue("firstName", firstNameValidation);
        }
        if (!lastNameValidation.equals("ok")) {
            errors.rejectValue("lastName", lastNameValidation);
        }
        if (!emailValidation.equals("ok")) {
            errors.rejectValue("email", emailValidation);
        }
        if (!websiteValidation.equals("ok")) {
            errors.rejectValue("email", websiteValidation);
        }
        if (!passwordValidation.equals("ok")) {
            errors.rejectValue("password", passwordValidation);
        }


    }

    String firstNameValidation(String name) {
        String email_pattern = "^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$";
        Pattern pat = Pattern.compile(email_pattern);
        Matcher mat = pat.matcher(name);
        if (name.length() > 20) {
            return "person.firstName.toolong";
        } else if (name.length() <= 0) {
            return "person.firstName.tooshort";
        } else if (!mat.matches()) {
            return "person.firstName.invalid";
        } else
            return "ok";
    }

    String lastNameValidation(String name) {
        String email_pattern = "^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$";
        Pattern pat = Pattern.compile(email_pattern);
        Matcher mat = pat.matcher(name);
        if (name.length() > 20) {
            return "person.lastName.toolong";
        } else if (name.length() <= 0) {
            return "person.lastName.tooshort";
        } else if (!mat.matches()) {
            return "person.lastName.invalid";
        } else
            return "ok";
    }

    String emailValidation(String email) {
        String email_pattern = "^[a-zA-Z0-9_#$%&’*+/=?^.-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(email_pattern);
        Matcher mat = pat.matcher(email);
        if (email.length() > 30) {
            return "person.email.toolong";
        } else if (email.length() <= 0) {
            return "person.email.tooshort";
        } else if (!mat.matches()) {
            return "person.email.invalid";
        } else
            return "ok";
    }

    String webSiteValidation(String webSite) {
        String email_pattern = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$";
        Pattern pat = Pattern.compile(email_pattern);
        Matcher mat = pat.matcher(webSite);
        if (webSite.length() > 200) {
            return "person.website.toolong";
        } else if (webSite.length() <= 0) {
            return "person.website.tooshort";
        } else if (!mat.matches()) {
            return "person.website.invalid";
        } else
            return "ok";
    }

    String passwordValidation(String password) {
        String email_pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pat = Pattern.compile(email_pattern);
        Matcher mat = pat.matcher(password);

        if (password.length() <= 0) {
            return "person.password.null";
        } else if (password.length() < 8) {
            return "person.password.tooshort";
        } else if (password.length() > 20) {
            return "person.password.toolong";
        } else if (!mat.matches()) {
            return "person.password.invalid";
        } else
            return "ok";
    }
}