package ru.itis.ruzavin.infsecondsemsemesterwork.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ruzavin.infsecondsemsemesterwork.exceptions.UserAlreadyExistsException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ModelAndView handleUserAlreadyExists() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userAlreadyExists");
		modelAndView.setStatus(HttpStatus.TEMPORARY_REDIRECT);
		return modelAndView;
	}
}
