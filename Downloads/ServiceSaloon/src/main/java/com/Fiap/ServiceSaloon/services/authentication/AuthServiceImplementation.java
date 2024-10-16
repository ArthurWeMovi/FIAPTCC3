package com.Fiap.ServiceSaloon.services.authentication;

import org.springframework.stereotype.Service;

import com.Fiap.ServiceSaloon.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Fiap.ServiceSaloon.dto.SignupRequestDTO;
import com.Fiap.ServiceSaloon.dto.UserDto;
import com.Fiap.ServiceSaloon.entity.User;
import com.Fiap.ServiceSaloon.enums.UserRole;

@Service
public class AuthServiceImplementation implements AuthService {
	
	
@Autowired
private UserRepository userRepository;

public UserDto signupClient(SignupRequestDTO signupRequestDTO) {

User user = new User();

user.setName(signupRequestDTO.getName());

user.setLastName(signupRequestDTO.getName());

user.setEmail(signupRequestDTO.getEmail());

user.setPhone(signupRequestDTO.getPhone());

user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));

user.setRole(UserRole.CLIENT);

return userRepository.save(user).getDto();


}

public Boolean presentByEmail(String email) {
	
return userRepository.findFirstByEmail(email) != null;


   }

public UserDto signupCompany(SignupRequestDTO signupRequestDTO) {

User user = new User();

user.setName(signupRequestDTO.getName());

user.setEmail(signupRequestDTO.getEmail());

user.setPhone(signupRequestDTO.getPhone());

user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));

user.setRole(UserRole.COMPANY);

return userRepository.save(user).getDto();


 }

@Override
public void authenticate(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
	// TODO Auto-generated method stub
	
}
}





