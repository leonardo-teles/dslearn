package com.devsuperior.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dto.UserDTO;
import com.devsuperior.entities.User;
import com.devsuperior.repositories.UserRepository;
import com.devsuperior.services.exception.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new UserDTO(entity);
	}	
	
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
