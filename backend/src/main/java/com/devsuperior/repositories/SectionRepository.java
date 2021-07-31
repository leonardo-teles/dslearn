package com.devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

}
