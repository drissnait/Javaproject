package scans;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import interfaces.LineIterator;

/**Iterator that reads line by line a file 
 * The file (is final) is given as input in the constructor**/
public class Scan_Lines implements LineIterator {

	public final String file;
	
	
	/** for the iterator **/
	BufferedReader bufferedReader=null;
	String line=null;
	
	public Scan_Lines(String file){
		this.file=file;
	}
		
	
   public void init(){
	   try {
		    if (bufferedReader!=null) bufferedReader.close();
		   
		    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		    
		    line = bufferedReader.readLine();
		    
		    /** measurements if end of file:**/
		    if(line==null) {
		    		bufferedReader.close();
		    		bufferedReader=null;
		    }
		    
	   } catch (IOException e) {
		    bufferedReader=null;
		    line=null;
		    e.printStackTrace();
		   }
   }
	
   public boolean hasNext(){
	    if(bufferedReader==null) return false;
	    return true;
   }
   
   public String next(){
	   try {
	   String result=line;
	   
	   /** advance to next line **/
	   line = bufferedReader.readLine();
	   
	   /** measurements if end of file:**/
	    if(line==null) {
	    		bufferedReader.close();
	    		bufferedReader=null;
	    }
	    
	    return result;
	    
	   } catch (IOException e) {
		    bufferedReader=null;
		    line=null;
		    e.printStackTrace();
		    return null;
		   }
   }
   
   public void close(){
	   try {
		    bufferedReader.close();  
	   } catch (IOException e) {
		    bufferedReader=null;
		    line=null;
		    e.printStackTrace();
		   }
   }

}
