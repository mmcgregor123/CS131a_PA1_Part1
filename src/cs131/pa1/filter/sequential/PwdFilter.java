package cs131.pa1.filter.sequential;

import java.util.LinkedList;

import cs131.pa1.filter.Message;

public class PwdFilter extends SequentialFilter{
	static String directory;
	
	public PwdFilter(String d){
	output=new LinkedList<String>();
	directory=d;
	}
	
	@Override
	protected String processLine(String line) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void process(){
		//String dir = System.getProperty("user.dir");
		if (input!=null){
			System.out.print(Message.CANNOT_HAVE_INPUT.toString().replace("%s", "pwd"));
			
		}else{
		output.add(directory);
		}
	}
	
}