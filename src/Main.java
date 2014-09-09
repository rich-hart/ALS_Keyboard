
class Main{
	public static void main(String[] args) throws Exception {
		
		ChatServer s = new ChatServer();
		//String[] args = {};
		s.main(args);
		
		Keyboard k = new Keyboard();
		ChatClient c = new ChatClient();
	}
	
}