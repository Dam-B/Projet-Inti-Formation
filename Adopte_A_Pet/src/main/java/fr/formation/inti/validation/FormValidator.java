package fr.formation.inti.validation;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import fr.formation.inti.Iservices.IIndividualsService;
import fr.formation.inti.entities.Individual;


@Component
public class FormValidator {
	@Autowired
	private IIndividualsService indivService;

	// common-validator library.
	private EmailValidator emailValidator = EmailValidator.getInstance();

	public boolean supports(Class<?> aClass) {
		return Individual.class.equals(aClass);
	}

	public void validate(Object target, Errors errors) {
		Individual indivForm = (Individual) target;

		// Check the fields of AppUserForm.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.appUserForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.appUserForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salaire", "NotEmpty.appUserForm.salaire");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.appUserForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "NotEmpty.appUserForm.startDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.appUserForm.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manager", "NotEmpty.appUserForm.manager");

		if (!this.emailValidator.isValid(indivForm.getMail())) {
			// Invalid email.
			errors.rejectValue("email", "Pattern.appUserForm.email");
		} else if (indivForm.getUser() == null) {
			Individual bddIndiv = indivService.findByMail(indivForm.getMail());
			if (bddIndiv != null) {
				// Email has been used by another account.
				errors.rejectValue("email", "Duplicate.appUserForm.email");
			}
		}

	}
}
