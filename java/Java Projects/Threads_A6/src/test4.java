import java.util.*;

public class test4
{

 public static HashSet<Integer> s1= new HashSet<>();// created hashset
 public static Set<Integer> set = Collections.synchronizedSet(s1); //added that set to synchronized set

 public static void main(String[] args) {
 creation c1 =new creation();//object creation
  second s = new second();
 }

 static class creation implements Runnable {//runnable interface

  public creation() {
   Thread thread = new Thread(this);//created thread
   thread.start();
  }

  @Override
  public void run() {
   for (int i = 0; i < 10000; i++) {
    set.add(i);
   }
  }
 }
 
 static class second implements Runnable {//runnable interface

  public second() {
   Thread thread = new Thread(this);//created thread
   thread.start();
  }

  @Override
  public void run() {//running a thread
   try {
    while (true) {
    	synchronized(set)//setting up lock through synchronized so only one thread will access the set at a time and 
    	                 //then run next thread
    {
     for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
        
      System.out.println(iterator.next());
     }     
    }
     Thread.sleep(1000);//this will suspend the thread for 1000 ms
    }
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }
 }
}