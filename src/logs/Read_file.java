package logs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read_file 
{
	public void Read_file()
	{
		//FileInputStream inputStream = new FileInputStream("foo.txt");
	try(BufferedReader br = new BufferedReader(new FileReader("logs/SCS_CLMS_DUNCAN_CHKEXTRACT_20170403101520.log"))) {
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();
	   
	    while (line != null) {
	    	
	    	if(line.contains("Step"))
	    		System.out.println(line);
	    	if (line.contains("SP_STEP_NO"))
	    		System.out.println("\t"+line.substring(0,10));
	    	
	    	line = br.readLine();
	        /*sb.append(line);
	        sb.append(System.lineSeparator());
	        */
	    }
	   String file_content = sb.toString();
	} 
	
	
	
	
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	public static void main(String[] args) {
		Read_file rf= new Read_file();
		
		rf.Read_file();
		
	}
}
	

