package com.code.helpdesk.domain.enums;

public enum StatusEnum {
	New,
	Assign,
	Resolved,
	Approved,
	Disapproved,
	Close;
	
	public static StatusEnum getStatus(String status) {
		switch (status) {
		case "New": return New;
		case "Assign": return Assign;
		case "Resolved": return Resolved;
		case "Approved": return Approved;
		case "Disapproved": return Disapproved;
		case "Close": return Close;
		default:
			return New;
		}
	}
	
}
