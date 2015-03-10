package org.learn.interview.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 联系http api
 * 
 * @author admin
 *
 */
public class HttpTest {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://cnblog.com");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			Map<String, List<String>>  fields = con.getHeaderFields();
			for (String string : fields.keySet()) {
				System.out.println(string);
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String temp = null;
			while((temp=br.readLine())!=null){
				System.out.println(temp);
			}
			con.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
