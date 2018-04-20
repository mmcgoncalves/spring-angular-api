package com.code.helpdesk.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.code.helpdesk.domain.ChangeStatus;
import com.code.helpdesk.domain.Ticket;
import com.code.helpdesk.repository.ChangeStatusRepository;
import com.code.helpdesk.repository.TicketRepository;
import com.code.helpdesk.service.TicketService;

@Component
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ChangeStatusRepository changeStatusRepository;

	public Ticket createOrUpdate(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}

	public Optional<Ticket> findById(String id) {
		return this.ticketRepository.findById(id);
	}

	public void delete(String id) {
		this.ticketRepository.deleteById(id);
	}

	public Page<Ticket> listTicket(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.ticketRepository.findAll(pages);
	}
	
	public Iterable<Ticket> findAll() {
		return this.ticketRepository.findAll();
	}
	
	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		Pageable pages = PageRequest.of(page, count);
		return this.ticketRepository.findByUserIdOrderByDateDesc(pages,userId);
	}

	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return this.changeStatusRepository.save(changeStatus);
	}
	
	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		return this.changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
	}
	
	public Page<Ticket> findByParameters(int page, int count,String title,String status,String priority) {
		Pageable pages = PageRequest.of(page, count);
		return this.ticketRepository.
				findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
				title,status,priority,pages);
	}
	
	public Page<Ticket> findByParametersAndCurrentUser(int page, int count,String title,String status,
			String priority,String userId) {
		Pageable pages = PageRequest.of(page, count);
		return this.ticketRepository.
				findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
				title,status,priority,userId,pages);
	}
	
	public Page<Ticket> findByNumber(int page, int count,Integer number){
		Pageable pages = PageRequest.of(page, count);
		return this.ticketRepository.findByNumber(number, pages);
	}
	
	public Page<Ticket> findByParametersAndAssignedUser(int page, int count,String title,String status,
			String priority,String assignedUserId) {
		Pageable pages = PageRequest.of(page, count);
		return this.ticketRepository.
				findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(
				title,status,priority,assignedUserId,pages);
	}
}
