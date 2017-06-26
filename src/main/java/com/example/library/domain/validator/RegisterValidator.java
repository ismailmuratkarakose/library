package com.example.library.domain.validator;

import com.example.library.domain.User;
import com.example.library.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator implements Validator {
	private final UserServiceImpl userService;

	@Autowired
	public RegisterValidator(UserServiceImpl userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(User.class);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User form = (User) o;
		validateUsername(errors, form);
	}

	private void validateUsername(Errors errors, User form) {
		if (userService.getUserByEmail(form.getEmail()) != null) {
			errors.reject("username.exists", "User with this username already exists");
		}
	}
}