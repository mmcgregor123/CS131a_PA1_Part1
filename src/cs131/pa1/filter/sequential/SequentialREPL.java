package cs131.pa1.filter.sequential;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import cs131.pa1.filter.Message;

public class SequentialREPL {

	static String currentWorkingDirectory;
	
	public static void main(String[] args) throws NullPointerException  {
		
		@SuppressWarnings("resource")
		Scanner input= new Scanner(System.in);
		currentWorkingDirectory=System.getProperty("user.dir");
		System.out.print(Message.WELCOME);
		System.out.print(Message.NEWCOMMAND);
		String command= input.nextLine();
		while(!command.equals("exit")) {
			//SequentialCommandBuilder cb= new SequentialCommandBuilder();
			currentWorkingDirectory=SequentialCommandBuilder.createFiltersFromCommand(command, currentWorkingDirectory);
			//System.out.println(currentWorkingDirectory);
			System.out.print(Message.NEWCOMMAND);
			command= input.nextLine();
			
		}
		System.out.print(Message.GOODBYE);
		
	}

	

}
