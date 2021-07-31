package com.devsuperior.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.entities.User;
import com.devsuperior.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email);
		
		if (user == null) {
			LOGGER.error("User not found: " + email);
			throw new UsernameNotFoundException("e-Mail not found");
		}
		
		LOGGER.info("User found: " + email);
		
		return user;
	}
}
