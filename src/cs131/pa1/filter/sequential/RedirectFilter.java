package cs131.pa1.filter.sequential;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;

import cs131.pa1.filter.Filter;
import cs131.pa1.filter.Message;

public class RedirectFilter extends SequentialFilter{
	private String filename;
	private String directory;
	
	public RedirectFilter (String f, String d) throws FileNotFoundException {
		filename=f; 
		directory=d;
	}
	
	
	@Override
	public void process(){
		if(input==null){
			System.out.print(Message.REQUIRES_INPUT.toString().replace("%s", "> "+filename));
			
		}else{
		
		File f = new File(directory+Filter.FILE_SEPARATOR+filename);
    	PrintWriter pw;
		try {
			pw = new PrintWriter(f);
			while (!input.isEmpty()){
				String line = input.poll();
				pw.println(line);
			}
			pw.close();
			}
		 catch (FileNotFoundException e) {
			throw new RuntimeException("This should not happen; we are creating a new file.");
		}
		}
    }
		
		
			
	
	
	
	@Override
	protected String processLine(String line) {
		
		return null;
	}
	
}