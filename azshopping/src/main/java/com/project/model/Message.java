package com.project.model;

public class Message {

	private String type,messagebody;
	
	public Message(String typ,String mbody) {
		type=typ;
		messagebody=mbody;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessagebody() {
		return messagebody;
	}

	public void setMessagebody(String messagebody) {
		this.messagebody = messagebody;
	}

	
	
}
