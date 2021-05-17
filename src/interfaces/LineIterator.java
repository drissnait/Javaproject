package interfaces;


/** iterator: reads the lines one by one **/
public interface LineIterator {
	 public void init();
	 public boolean hasNext();
	 public String next();
	 public void close();
}
