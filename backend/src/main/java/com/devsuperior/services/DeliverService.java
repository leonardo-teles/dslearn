package com.devsuperior.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dto.DeliverRevisionDTO;
import com.devsuperior.entities.Deliver;
import com.devsuperior.repositories.DeliverRepository;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository repository;
	
	@Autowired
	private NotificationService notificationService;
	
	@Transactional
	@PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
	public void saveRevision(Long id, DeliverRevisionDTO dto) {
		Deliver deliver = repository.getOne(id);
		deliver.setStatus(dto.getStatus());
		deliver.setFeedback(dto.getFeedback());
		deliver.setCorrectCount(dto.getCorrectCount());
		
		repository.save(deliver);
		notificationService.saveDeliverNotification(deliver);
	}
}
