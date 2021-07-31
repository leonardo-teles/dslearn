package com.devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
