package cs131.pa1.filter.sequential;

import java.util.LinkedList;

import cs131.pa1.filter.Message;

public class WcFilter extends SequentialFilter{

	
	
	
	@Override
	public void process(){
		if(input==null){
			System.out.print(Message.REQUIRES_INPUT.toString().replace("%s", "wc"));
		}else{
		output=new LinkedList<String>();
		int lines=0;
		int words=0;
		int chars=0;
		
		while(!input.isEmpty()){
			String line = input.poll();
			lines++;
			words+=line.split("\\s+").length;
			chars+=line.length();
			/*for(int i=0; i<line.length()-1; i++){		
				if(line.charAt(i)!=' '){
					words++;
					while(line.charAt(i)!=' ' & i<line.length()-1){
						chars++;
						i++;
					}
					i-=1;
				}else{
					chars++;
				}
			}*/
		}
		output.add(lines + " "+ words+" "+ chars);
	}
	}
	
	
	@Override
	protected String processLine(String line) {
		// TODO Auto-generated method stub
		return null;
	}
	
}