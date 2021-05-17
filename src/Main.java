import java.util.List;

import interfaces.TupleIterator;
import relational_operations.Project_Iterator;
import scans.Scan_Lines;
import scans.Scan_Tuples;

public class Main {
	
	public static final String dir="/Users/adi/Sync/TP_Movies/new/";
	public static final String films=dir+"films.tsv";
	public static final String persons=dir+"persons2.tsv";
	public static final String casting=dir+"casting2.tsv";
	public static final String directing=dir+"directors2.tsv";
	
	
	public static final TupleIterator planForQuery_ActorsAndTheirBirthyears(){
			Scan_Lines s=new Scan_Lines(persons);
			Scan_Tuples it=new Scan_Tuples(s, "\\t");
			
			Project_Iterator p=new Project_Iterator(it, 1, 2);
			
			return p;
	}
	
	
	public static void main(String [] args)
	{
		TupleIterator it=planForQuery_ActorsAndTheirBirthyears();
		
		it.init();
		for(int i=0; i<100 && it.hasNext(); i++){
			List<String> tuple=it.next();
			System.out.println(i+"    "+tuple);
		}
		it.close();
	
	}
}
