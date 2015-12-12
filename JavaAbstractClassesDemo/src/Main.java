import java.io.IOException;
import java.io.InputStream;



/*So beutiful structure Abstraction*/

public class Main {

	
	//Actually this is the same like the structure "decorators" in Pyhton 
	
	//Make an abstract class then create subclass and extend it from abstract class than force the subclass the override some methods. 
	
	
	/* You cannot initiate the Abstract class only you can use polymorphizm or subclass and extend it 
	 * If you add abstract method you can override this and you can change structre as the decorater in Python
	 * 
	 * ex. You want to download the content of URL given 
	 * 
	 * Abstract class -->  then the normal method add to abstract class and a abstract method   
	 * 
	 * DownloadURLImpl downloadURLImpl=new DownloadURLImpl();
	 * downloadURLImpl.process("http://jenkov.com");     process()--not abstract method  in the Base Abstract Class
	 * 
	 * public abstract void processDataURL(InputStream input) throws IOException;  in the abstract base class. 
	 * 
	 * 
	 * 
	 * */
	
	
	public Main(){
		
		
		DownloadURLImpl downloadURLImpl=new DownloadURLImpl();
	
		try {
			downloadURLImpl.process("http://jenkov.com");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new Main();

	}

}
