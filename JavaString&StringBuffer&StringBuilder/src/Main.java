
/**Just a simple snippet to see the difference and performance clues about these three string structures
 * @author barin.huseyin
 *
 */
public class Main {
	
	
	static final int COUNTER=5*10000;
	
	/**Key Differences between them  
	 * 
	 * String        :immutable  and thread-safe  
	 * (String a="ali"  then  a+=" veli"   ok the reference for the object named "ali" is not available now. a new object created name "ali veli") 
	 * so later this unreferenced  object will be collected by gc. 
	 * 
	 * StringBuffer  :mutable String object simply. Thread-Safe. performance can be lower than builder and string but overall StringBuffer is the best option
	 * if you make a lot concatination or similar jobs.
	 * 
	 * 
	 * StringBuilder :mutable and NOT THREAD-SAFE objects. You should handle with them. Because of not existent of thread-synchronized cost, 
	 * StringBuilders are faster than StringBuffer.
	 * 
	 * 
	 * NOT: If you think which one I should use? Answer can be easy, if you are sure that your app is not multithreaded(single thread) for accessing your string values.
	 * you can use obviously StringBuilders. Again you can use also String or StringBuffer but 
	 * String has the overhead ---to initialize each time the string is modified. and StringBuffer has threading control cost.
	 * 
	 * 
	 * 
	 * Some Results can be seen:
	 * 
	 * String : The time passed: 5272 ms
	   String Builder : The time passed: 5 ms
	   String Buffer : The time passed: 6 ms
	 * 
	 */
	
	
	public void showTimePassed(long time,String s){
		
		System.out.println(String.format("%s : The time passed: %d ms",s,System.currentTimeMillis()-time));
	}
	
	
	public  void doStringBufferTest(){
		
		StringBuffer stringBuffer=new StringBuffer();
		long t=System.currentTimeMillis();
		
		for(int i=COUNTER;i-->0;){
			stringBuffer.append(""+i);
		}
		
		showTimePassed(t, "String Buffer");
		
	}
	
	public void doStringBuilderTest(){
		
		StringBuilder stringBuilder=new StringBuilder();
		long t=System.currentTimeMillis();
		
		for(int i=COUNTER;i-->0;){
			stringBuilder.append(""+i);
		}
		showTimePassed(t, "String Builder");
	}
	
	
	public void doStringTest(){
		
		String string=new String();
		long t=System.currentTimeMillis();
		
		for(int i=COUNTER;i-->0;){
			string+=""+i;   //NEVER DO THIS :(
		}
		showTimePassed(t, "String");
		
	}
	
	
	public Main(){
		
		doStringTest();
		doStringBuilderTest();
		doStringBufferTest();
		
		System.gc();
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new Main();
	}


}
