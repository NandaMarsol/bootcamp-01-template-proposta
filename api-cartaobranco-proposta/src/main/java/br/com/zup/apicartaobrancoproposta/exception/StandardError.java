package br.com.zup.apicartaobrancoproposta.exception;

import java.util.List;

public class StandardError {
	
	private List<String> messages;

	public StandardError(List<String> messages) {
		super();
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "StandardError [messages=" + messages + "]";
	}
	
	

}
