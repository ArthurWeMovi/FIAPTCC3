package com.Fiap.ServiceSaloon.services.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.Fiap.ServiceSaloon.dto.SignupRequestDTO;
import com.Fiap.ServiceSaloon.dto.UserDto;

public interface AuthService {
	
	UserDto signupClient(SignupRequestDTO signupRequestDTO);
	
	Boolean presentByEmail(String email);

	UserDto signupCompany(SignupRequestDTO signupRequestDTO);

	void authenticate(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken);
}
