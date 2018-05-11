package com.codebind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileSplitter {
	public String partONE(String fullname) throws FileNotFoundException{
		String line;
		String part[];
		int count=1;
		 
		 //Pattern pattern = Pattern.compile("Vitals");
		 //Pattern pattern = Pattern.compile("^Physical\s+Examination");
		 //Pattern pattern = Pattern.compile("^Assessment\s+");
		 //Pattern pattern = Pattern.compile("^Plan\s+");
		 
		 try{			 
			 FileInputStream fis = new FileInputStream(fullname);
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			 
			 //FileOutputStream fos = new FileOutputStream(fullname+count+".txt");
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fullname+count+".txt")));
			 while ((line=br.readLine())!=null){
				 /*
				 Matcher matcher = pattern.matcher(line);
				 if (matcher.find()) break;
				 */
				 part = line.split("Vitals");
				 bw.write(line);
				 if(line.contains("Vitals")){
					 break;
				 }
				 			 
			 }
			 bw.close();
			 count++;
			 //fos.close();
			 
			 BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fullname+count+".txt")));
			 //bw1.write(line);
			 while ((line=br.readLine())!=null){
				 bw1.write(line);
				 /*
				 Matcher matcher = pattern.matcher(line);
				 if (matcher.find()) break;
				 */
				 if(line.contains("Assessment")){
					 break;
				 }			 
			 }
			 bw1.close();
			 count++;
			 
			 BufferedWriter bw11 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fullname+count+".txt")));
			 //bw11.write(line);
			 while ((line=br.readLine())!=null){
				 bw11.write(line);
				 /*
				 Matcher matcher = pattern.matcher(line);
				 if (matcher.find()) break;
				 */
				 if(line.contains("Plan")){
					 break;
				 }			 
			 }
			 bw11.close();
			 count++;
			 
			 
			 
			 BufferedWriter bw1111 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fullname+count+".txt")));
			 //bw1111.write(line);
			 while ((line=br.readLine())!=null){
				 bw1111.write(line);			 
			 }
			 bw1111.close();
			 br.close();
		 }
		 catch (IOException e)
	     {
	         e.printStackTrace();
	     }
		return null;
	
	}
}