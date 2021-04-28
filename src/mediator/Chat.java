package mediator;

import java.util.ArrayList;
import java.util.List;

import singleton.ChatBot;

public class Chat implements MessageMediator {

	private List<User> users;
	private ChatBot chatBot;
	
	public Chat() {
		this.users = new ArrayList<>();
	}

	@Override
	public void sendMessage(String message, User user) {
		
		if (!this.users.contains(user)) {
			return;
		}
		
		if(message == "addBot") {
			this.chatBot = ChatBot.getInstance();
			System.out.println("Chat bot added!");
		}
		
		if (chatBot != null) {
			if (chatBot.isMessageAllowed(message)) {
				for(User chatUser: this.users) {
					if (chatUser != user) {
						chatUser.receive(message);
					}
				}
			} else {
				removeUser(user);
			} 
		} else {
			for(User chatUser: this.users) {
				if (chatUser != user) {
					chatUser.receive(message);
				}
			}
		} 
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void removeUser(User user) {
		this.users.remove(user);
	}

}
