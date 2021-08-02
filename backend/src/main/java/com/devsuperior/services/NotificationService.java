package com.devsuperior.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dto.NotificationDTO;
import com.devsuperior.entities.Notification;
import com.devsuperior.entities.User;
import com.devsuperior.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	
	public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable) {
		User user = authService.authenticated();
		Page<Notification> page = repository.find(user, false, pageable);
		
		return page.map(x -> new NotificationDTO(x));
	}
}
