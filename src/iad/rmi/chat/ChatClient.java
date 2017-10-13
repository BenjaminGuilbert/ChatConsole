package iad.rmi.chat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatClient {

	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.getRegistry(args[0]);
			
			ChatConference conf = (ChatConference) registry.lookup("ConfALaCon");
			System.out.println("Conf : " + conf.getName() + " " + conf.getDescription());
			
			ChatParticipantImpl part1 = new ChatParticipantImpl(args[1]);
			System.out.println(part1.getName());
			
			part1.join(conf);
			
			ChatClientConsole chat = new ChatClientConsole(conf, part1);
			chat.run();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
