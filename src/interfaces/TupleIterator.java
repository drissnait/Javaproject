package interfaces;

import java.util.ArrayList;
import java.util.List;

/** iterator: reads the lines one by one **/
public interface TupleIterator {
	 public void init();
	 public boolean hasNext();
	 public List<String> next();
	 public void close();
}
