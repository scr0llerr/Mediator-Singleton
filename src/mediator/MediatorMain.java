package mediator;

public class MediatorMain {

	
	public static void main(String[] args) {
		
		MessageMediator chat = new Chat();
		
		User user1 = new ChatUser(chat, "Ivan");
		User user2 = new ChatUser(chat, "Maria");
		User user3 = new ChatUser(chat, "Peter");
		
		user1.send("hey");
		user2.send("addBot");
		user1.send("cat");
		user1.send("test");
		user3.send("cool");

	}

}
