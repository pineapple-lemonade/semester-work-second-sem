package ru.itis.ruzavin.infsecondsemsemesterwork.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.itis.ruzavin.infsecondsemsemesterwork.security.details.CustomUserDetails;

@Component
@Slf4j
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {
	@Override
	public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {
		if (authenticationEvent instanceof InteractiveAuthenticationSuccessEvent) {
			// ignores to prevent duplicate logging with AuthenticationSuccessEvent
			return;
		}
		Authentication authentication = authenticationEvent.getAuthentication();
		String password = (String) authentication.getCredentials();
		log.info("Login attempt with username: {} and password: {} Success: {}", authentication.getName(), password, authentication.isAuthenticated());
	}
}
