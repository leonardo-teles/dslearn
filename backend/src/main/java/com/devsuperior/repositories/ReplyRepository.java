package com.devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.entities.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
