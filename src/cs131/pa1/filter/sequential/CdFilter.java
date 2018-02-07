package cs131.pa1.filter.sequential;

import java.io.File;

import cs131.pa1.filter.Filter;
import cs131.pa1.filter.Message;

public class CdFilter {
	 
	
	
	
	public static String process(String directory, String command){
		
		
		
		if(command.equals(".")){
			return directory;
		} else if(command.equals("..")){
			int i=directory.lastIndexOf(Filter.FILE_SEPARATOR);
			//System.out.println(i);
			return directory.substring(0, i);
		}else if(!new File(directory+Filter.FILE_SEPARATOR+command).exists()){
			String s=Message.DIRECTORY_NOT_FOUND.toString().replace("%s", "cd "+command);
			
			System.out.print(s);         
			return null;
		}else {
			return directory+Filter.FILE_SEPARATOR+command;
		}
	}
	
	
	
}