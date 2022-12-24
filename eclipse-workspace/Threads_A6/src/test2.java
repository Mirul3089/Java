
public class test2 {
	
	static Integer sum = 0;//wrapper

	public static void main(String[] args) {
		
		addition a2 = new addition();
		//Runnable A = new addition();
		Thread thread1 = new Thread(a2); //new thread
		
		
		
		try {
		//synchronized(a2) 
			//{
		thread1.start();  //staring thread
		//thread1.sleep(500); //with synchronization
		//thread1.join();
			//}
		}
		catch ( Exception e) {
	         System.out.println(e);
	      }
		
	}
}
    class addition implements Runnable { // running a thread
		public void run() {
			for (int i = 0; i < 1000; i++) 
			{
			System.out.println("sum for "+i+ " Thread = " + test2.sum);
			test2.sum ++;
			}
			
		}
	}