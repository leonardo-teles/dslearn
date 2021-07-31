package com.devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
