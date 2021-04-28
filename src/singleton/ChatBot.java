package singleton;

public class ChatBot {

	private static ChatBot instance;
	
	private ChatBot() {
	}

	public static ChatBot getInstance() {
		
		if(instance == null) {
			instance = new ChatBot();
		}
		
		return instance;
	}
	
	public boolean isMessageAllowed(String message) {
		if(message == "cat") {
			System.out.println(message + " is forbidden!");
			return false;
		}
		return true;
	}
	
}
