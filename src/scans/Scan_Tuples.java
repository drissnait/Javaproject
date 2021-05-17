package scans;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.LineIterator;
import interfaces.TupleIterator;

public class Scan_Tuples implements TupleIterator {
	
	
	public final LineIterator lines;
	public final String sep; /** separator for tuples's elements **/
	

	/** constructor **/
	public Scan_Tuples(LineIterator lines, String sep) {
		 this.lines=lines;
		 this.sep=sep;
	}
	
	@Override
	public void init() {
		lines.init();	
	}

	@Override
	public boolean hasNext() {
		return lines.hasNext();
	}

	@Override
	public List<String> next() {
		String line=lines.next();
		
		String[] fields = line.split(sep);
	     List<String> stringList = new ArrayList<String>(Arrays.asList(fields));
		
		return stringList;
	}

	@Override
	public void close() {
		lines.close();
	}

}
