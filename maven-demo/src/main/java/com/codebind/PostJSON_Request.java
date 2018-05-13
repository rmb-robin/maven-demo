package com.codebind;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
//import org.json.JSONObject;

public class PostJSON_Request {
	
	public static String PostJSON(String text) {
			// set URL to Post Request
           String post_url = "http://10.0.129.218:8080/mst-sentence-service-discovery/webapi/recommandation/save";
           String ret = null;
	    	
	    	HttpURLConnection conn = null;
           
		   try {
			   URL url = new URL(post_url);
			   conn = (HttpURLConnection) url.openConnection();
			   conn.setRequestMethod("POST");
			   conn.setDoOutput(true);
			   conn.setRequestProperty("Accept", "application/json");
			   conn.setRequestProperty("Content-Type", "application/json");
			   OutputStreamWriter streamWriter = new OutputStreamWriter(conn.getOutputStream());
	                
	    		streamWriter.write(text);
	            streamWriter.flush();

	            BufferedReader br = null;
	            try {
	            	br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            } catch(IOException ioe) {;
	            System.out.println(ioe.getMessage());
	            }
	            
	    		String response = null;
	    		StringBuffer buffer = new StringBuffer();
	    		
	    		while ((response = br.readLine()) != null) {
	    			buffer.append(response);
	    		}
	    		
	    		ret = conn.getResponseCode() + "~" + buffer.toString();
	    		
	    	} catch(Exception e) {
	    		Exception t = e;
	    		System.out.println(e.getMessage());
	    	} finally {
	    		if(conn != null)
	    			conn.disconnect();
	    	}
	    	
	    	return ret;
	    }
}