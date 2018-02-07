package cs131.pa1.filter.sequential;

import java.io.File;
import java.util.LinkedList;

import cs131.pa1.filter.Message;

public class LsFilter extends SequentialFilter{
	private String d;
	
	
	public LsFilter (String dir){
		output=new LinkedList<String>();
		d=dir;
	}
	
	@Override
	public void process (){
		if(input!=null){
			System.out.print(Message.CANNOT_HAVE_INPUT.toString().replace("%s", "ls"));
			
		}else{
		
		File directory = new File(d);
		File[] contents = directory.listFiles();
		for(int i=0; i<contents.length; i++){
			output.add(contents[i].getName());
		}
		}
	}
	
	@Override
	protected String processLine(String line) {
		// TODO Auto-generated method stub
		return null;
	}
	
}