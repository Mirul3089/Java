import java.util.HashSet;
import java.util.Iterator;

public class test3 {

	public static HashSet<Integer> set = new HashSet<>();// created hashset

	public static void main(String[] args) {
		creation c1 = new creation();//object creation
		second s = new second();
	}

	static class creation implements Runnable // runnable interface
	{
		public creation() {
			Thread thread = new Thread(this);// thread creation
			thread.start();
		}

		@Override
		public void run() {// running a thread
			for (int i = 0; i < 1000000000; i++) {
				set.add(i); //added data in hashset
			} 
		}
	}

	static class second implements Runnable { // runnable interface

		public second() { 
			Thread thread= new Thread(this);//thread  creation
			thread.start();
		}

		@Override
		public void run() {// running a thread
			try {
				while (true) {
					for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {

						System.out.println(iterator.next());
					}
					Thread.sleep(1000);//this will suspend the thread for 1000 ms
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}