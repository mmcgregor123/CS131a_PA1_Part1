package cs131.pa1.filter.sequential;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import cs131.pa1.filter.Filter;
import cs131.pa1.filter.Message;

public class SequentialCommandBuilder {
	static String Directory;
	
	public static String createFiltersFromCommand(String command, String d) {
		Directory=d;
		List<SequentialFilter> list= new LinkedList<SequentialFilter>();
		String [] commands= command.split("\\|");
		String finalCommand=commands[commands.length-1]; 
		String[] a= null;
		PrintFilter pf= null;
		if (finalCommand.contains(">")){
			a=finalCommand.split(">");
			commands[commands.length-1]=a[0];
			if(a[0].equals("")){
				System.out.print(Message.REQUIRES_INPUT.toString().replace("%s", ">"+a[1]));
				return Directory;
			}
			
		}else {
			
			pf=determineFinalFilter(commands[commands.length-1]);
		
		}
		
		SequentialFilter lastFilter= constructFilterFromSubCommand(commands[0]);
		if(lastFilter!=null){
		list.add(lastFilter);
		lastFilter.process();
		}else{
			return Directory;
		}
		for (int i=1; i<commands.length; i++){
			SequentialFilter filter= constructFilterFromSubCommand(commands[i]);
			if(filter==null){
				return Directory;
			}else{
			list.add(filter);
			lastFilter.setNextFilter(filter);
			filter.process();
			lastFilter= filter;
		}
		}
		if (a!= null){
			if(a.length==1){
				System.out.print(Message.REQUIRES_PARAMETER.toString().replace("%s", ">"));
				return Directory;
			}
			
			SequentialFilter finalFilter;
			try {
				
				finalFilter = new RedirectFilter(a[1].substring(1), Directory);
				finalFilter.setPrevFilter(list.get(list.size()-1));
				finalFilter.process();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(pf!=null){
			
			pf.setPrevFilter(list.get(list.size()-1));
			pf.process();
			
		}
		return Directory;
	}
	
	private static PrintFilter determineFinalFilter(String command){
		while (command.startsWith(" ")){
			command=command.substring(1);
		}
		
		String[] words= command.split(" ");
		
		if(words[0].equals("pwd")|| words[0].equals("ls") || words[0].equals("cat") || words[0].equals("grep") || words[0].equals("wc") || words[0].equals("uniq") ){
			
			return new PrintFilter();
		}
		
		return null;
	}
	
	private static String adjustCommandToRemoveFinalFilter(String command){
		return null;
	}
	
	private static SequentialFilter constructFilterFromSubCommand(String subCommand){
		while (subCommand.startsWith(" ")){
			subCommand=subCommand.substring(1);
		}
		String [] s= subCommand.split(" ");
		

		if(s[0].equals("cat")){
			if(s.length==1){
				System.out.print(Message.REQUIRES_PARAMETER.toString().replace("%s", "cat"));

				return null;
			}else if(!new File(s[1]).exists()){
				System.out.print(Message.FILE_NOT_FOUND.toString().replace("%s", "cat "+s[1]));

				return null;
			}else{
			
			
			return new CatFilter(s[1]);
			}
		} 
		else if(s[0].equals("pwd")){
			return new PwdFilter(Directory);
		}else if (s[0].equals("cd")){
			if(s.length==1){
				System.out.print(Message.REQUIRES_PARAMETER.toString().replace("%s", "cd"));
			}else{
			
			Directory=CdFilter.process(Directory, s[1]) ;
			}
		}else if(s[0].equals("ls")){
			return new LsFilter(Directory);		
		
		} else if (s[0].equals("grep")){
			if(s.length==1){
				System.out.print(Message.REQUIRES_PARAMETER.toString().replace("%s", "grep"));
				return null;
			}
			return new GrepFilter(s[1]);
		} else if(s[0].equals("wc")){
			return new WcFilter();
		} else if (s[0].equals("uniq")){
			return new UniqFilter();
		}
			else{
		
			System.out.print(Message.COMMAND_NOT_FOUND.toString().replace("%s", subCommand));
		}
		return null;
	}
	
	private static boolean linkFilters(List<SequentialFilter> filters){
		return false;
	}
}
