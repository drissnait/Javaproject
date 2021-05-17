package relational_operations;

import java.util.ArrayList;
import java.util.List;

import interfaces.TupleIterator;

public class Project_Iterator implements TupleIterator {

	final int[]  columns;
	final TupleIterator operand;
	
	/** unary operator => receives an iterator as input **/
	public  Project_Iterator(TupleIterator operand, int... columns) {
		this.columns=columns;
		this.operand=operand;
	}
	
	@Override
	public void init() {
		operand.init();
	}

	@Override
	public boolean hasNext() {
		return operand.hasNext();
	}

	@Override
	public List<String> next() {
		List<String> tuple=operand.next();
		List<String> newTuple= new ArrayList<String>();
		for(int c: columns){
			newTuple.add(tuple.get(c));
		}
		return newTuple;
	}

	@Override
	public void close() {
		operand.close();
	}

	
}
