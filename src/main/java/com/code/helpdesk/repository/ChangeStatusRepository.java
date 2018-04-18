package com.code.helpdesk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.code.helpdesk.domain.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);
}