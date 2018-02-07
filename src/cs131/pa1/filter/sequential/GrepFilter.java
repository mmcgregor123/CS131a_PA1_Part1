package cs131.pa1.filter.sequential;

import java.util.LinkedList;

import cs131.pa1.filter.Message;

public class GrepFilter extends SequentialFilter{
	private String w;
	
	public GrepFilter(String word){
		w=word;
		output=new LinkedList<String>();

	}
	
	@Override
	public void process(){
		if(input==null){
			System.out.print(Message.REQUIRES_INPUT.toString().replace("%s", "grep "+ w));
		}else{
		
		while (!input.isEmpty()){
			String line = input.poll();
			String processedLine = processLine(line);
			if (processedLine != null){
				output.add(processedLine);
			}
		}	
		}
	}
	
	
	@Override
	protected String processLine(String line) {
		
		
		if(line.contains(w)){
			return line;
		}
		
		return null;
	}
	
}