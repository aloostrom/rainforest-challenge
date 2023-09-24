import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
 

public class UrlReader {
	String address;
	String forward;
	String message;
	
    public UrlReader(String link) throws Exception {
    	
    	this.address = link;

        URL myurl = new URL(null, this.address, new sun.net.www.protocol.https.Handler());;
        HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
        con.setRequestProperty ( "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0" );
        InputStream ins = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader in = new BufferedReader(isr);
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            JsonParser parser = new JsonParser(inputLine);
            //Return these as class attributes since main definitely cares about them
            this.forward = parser.getJsonMap().get("follow");
            this.message = parser.getJsonMap().get("message");
        }
        in.close();
    }
    
    //nothing exciting, just some getters
    public String getForward() {
    	return this.forward;
    }
    
    public String getMessage() {
    	return this.message;
    }
}