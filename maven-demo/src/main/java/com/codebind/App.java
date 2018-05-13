package com.codebind;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import com.google.gson.Gson;


public class App {

    public static void main(String[] args){
    	
    	//StrRep r = new StrRep();
        InputStream is = null;
        OutputStream out =null;
        //String outPutFile="E:/notice/errorpdf/1.txt";
        String dirPathIn="C:/Users/Bryan/Documents/Rabhu/MST/PDFs/";
        String dirPathOut="C:/Users/Bryan/Documents/Rabhu/MST/TXTs/";
        File dir = new File(dirPathIn);
        String[] filenames = dir.list();
        String justname, fullname, nameAfterPhNo;
        String OrgId = "5af454323209dd4f7caca37a";   		
    
        int lenFiles = filenames.length;
        try {
            for(int i=0;i<lenFiles;i++){
            	System.out.println(filenames[i]+" : "+filenames[i]+".txt");
            	is = new BufferedInputStream(new FileInputStream(new File(dirPathIn+filenames[i])));
                out= new FileOutputStream(dirPathOut+filenames[i]+".txt");
                Parser parser = new AutoDetectParser();
                ContentHandler handler = new BodyContentHandler(out);

                Metadata metadata = new Metadata();

                parser.parse(is, handler, metadata, new ParseContext());
                
                justname = dirPathOut+filenames[i];
                fullname = dirPathOut+filenames[i]+".txt";
                String name=afterPhNo(justname, fullname);                         
                
                SentenceTextRequest request =  createSentenceTextRequest(name) ; 		//Populate sentence text request with file content data
                request.getDiscreteData().setOrganizationId(OrgId);		//Added OrgID
                System.out.println(request.getDiscreteData().getOrganizationId());
                request.getDiscreteData().setPatientAccount(filenames[i]); //Added PatientAccount
                String body = new Gson().toJson(request);
	            System.out.println(body);  
	            //String response = PostJSON_Request.PostJSON(body);
	            //System.out.println(response);
               // }
            }
            Metadata metadata = new Metadata();
            for (String name : metadata.names()) {
                String value = metadata.get(name);

                if (value != null) {
                    System.out.println("Metadata Name:  " + name);
                    System.out.println("Metadata Value: " + value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                    out.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private static SentenceTextRequest createSentenceTextRequest(String path){
    	/*
    	 * 1. extract the text from the file
    	 * 2. find the actual sentences (texts)
    	 * 3. set the text property to sentenceTextRequest
    	 * 4. create a new dicrete data on the sentenceTextRequest
    	 * 5. Return the sentenceTextRequest object
    	 */
    	File f = new File(path);
    	StringBuilder sb = new StringBuilder();
    	String ln;
        try
        {
            //String ENDL = System.getProperty("line.separator");          

            BufferedReader br = new BufferedReader(new FileReader(f));
           
            while((ln = br.readLine()) != null)
            {
            	ln=ln.replaceAll("/",  " ");
            	ln=ln.replaceAll("\"", " ");
                sb.append(ln
                    .replace("�", ".")
                     );             
                
                        
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(sb.toString());
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        SentenceTextRequest str = new SentenceTextRequest();
		str.setText(sb.toString());
		//DiscreteData dd= str.getDiscreteData();		
    	return str;
    }

	private static String afterPhNo(String justname, String fullname) throws FileNotFoundException{
		String line;
		String nameToRtn = justname+"afterPhNo"+".txt";
		
		 FileInputStream fis = new FileInputStream(fullname);
		 FileOutputStream fos = new FileOutputStream(justname+"afterPhNo"+".txt");
		 
		 Pattern pattern = Pattern.compile("\\d\\d\\d-\\d\\d\\d\\d");
	
		 try{
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			 while ((line=br.readLine())!=null){
				 
				 Matcher matcher = pattern.matcher(line);
				 if(matcher.find()){
					 break;
				 }
				 
			 } 
			 while ((line=br.readLine())!=null){
				 
				 bw.write(line);
			 }
			 br.close();
			 bw.close();
		 }
		 catch (IOException e)
	     {
	         e.printStackTrace();
	     }
		return nameToRtn;
	}


}