package cs131.pa1.filter.sequential;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.print.DocFlavor.URL;

import cs131.pa1.filter.Message;
import junit.framework.Test;

public class CatFilter extends SequentialFilter{
	private String file;
	
	public CatFilter(String f){
		file=f;
		output=new LinkedList<String>();
		
	}
	
	@Override
	public void process(){
		if(input!=null){
			System.out.print(Message.CANNOT_HAVE_INPUT.toString().replace("%s", "cat "+file));
		}else{
		
		File f= new File(file);
		Scanner scan;
			//if(f.exists()){
				//System.out.println("YESSs");
				try {	
					scan = new Scanner(new FileReader(f));
					
					
					while(scan.hasNextLine()){
						String s= scan.nextLine();
						output.add(s);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					//System.out.print(Message.FILE_NOT_FOUND.toString().replace("%s", "cat "+file));
					
				}
			
		}	
			 
		
		
		//System.out.println(output.remove());
		
			
		
		/*while(!output.isEmpty()){
			String s= output.remove();
			System.out.println(s);
		}*/
		
	}

	@Override
	protected String processLine(String line) {
		// TODO Auto-generated method stub
		return null;
	}
}