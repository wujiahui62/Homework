package Exercise24_13;

import java.util.Iterator;

public class FibonacciIterator implements Iterable<Integer>{
	private int n;
	
	public FibonacciIterator(int n){
		this.n = n;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Fibonacci();
	}

	private class Fibonacci implements java.util.Iterator<Integer>{
		int f0 = 0;
		int f1 = 1;
		int f2 = 1;
		int count = 0;
		int max = 0;

		 @Override
			public boolean hasNext() {
				return max <= n;
			}
			
			@Override
			public Integer next() {
				if(count == 0)
					f2 = 0;
				else if(count == 1)
					f2 = 1;
				else{
					f2 = f0 + f1;
					f0 = f1;
					f1 = f2;
				}
				count++;
				max = f0 + f1;
				return f2;
		}
	}
}
