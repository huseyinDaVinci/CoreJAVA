import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public abstract class DownloadURLBase {
	
	
	
	
	public void process(String url) throws MalformedURLException, IOException{
		
		
		URLConnection urlConnection=new URL(url).openConnection();
		
		InputStream input=urlConnection.getInputStream();
		
		try{
			processDataURL(input);
        } finally {
            input.close();
        }

		
	}
	
	
	
	public abstract void processDataURL(InputStream input) throws IOException;
	

}
