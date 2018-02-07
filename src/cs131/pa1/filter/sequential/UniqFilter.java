package cs131.pa1.filter.sequential;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class UniqFilter extends SequentialFilter{
	LinkedHashSet<String> l=new LinkedHashSet<String>();
	
	
	public UniqFilter(){
		output=new LinkedList<String>();
	}
	@Override
	protected String processLine(String line) {
		if(!l.contains(line)){
			l.add(line);
			return line;
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
}