package com.personal.account.entity;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
