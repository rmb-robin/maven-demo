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
		String nameToRtn = fullname+"1"+".txt";
		
		 FileInputStream fis = new FileInputStream(fullname);
		 FileOutputStream fos = new FileOutputStream(nameToRtn);
		 
		 //Pattern pattern = Pattern.compile("Vitals");

		 try{
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			 while ((line=br.readLine())!=null){
				 //Matcher matcher = pattern.matcher(line);
				 if(line.contains("^(.*)Vitals$")){
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
	public String partTWO(String fullname) throws FileNotFoundException{
		String line;
		String nameToRtn = fullname+"2"+".txt";
		
		 FileInputStream fis = new FileInputStream(fullname);
		 FileOutputStream fos = new FileOutputStream(nameToRtn);
		 Pattern pattern1 = Pattern.compile("^(.*)Vitals$");
		 Pattern pattern2 = Pattern.compile("^(.*)NeurologicPsychiatric$");
		 //Pattern pattern2 = Pattern.compile("bigeminy during hospitalization.");

		 try{
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			 while ((line=br.readLine())!=null){
				 Matcher matcher = pattern1.matcher(line);
				 if(matcher.find()){
					 break;
				 }
								 
			 }
			 while ((line=br.readLine())!=null){
				 Matcher matcher = pattern2.matcher(line);
				 if(matcher.find()){
					 break;
				 }
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
	public String partTHREE(String fullname) throws FileNotFoundException{
		String line;
		String nameToRtn = fullname+"3"+".txt";
		
		 FileInputStream fis = new FileInputStream(fullname);
		 FileOutputStream fos = new FileOutputStream(nameToRtn);
		 Pattern pattern1 = Pattern.compile("NeurologicPsychiatric");
		 Pattern pattern2 = Pattern.compile("bigeminy during hospitalization");
		 //Pattern pattern2 = Pattern.compile("bigeminy during hospitalization.");

		 try{
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			 while ((line=br.readLine())!=null){
				 Matcher matcher = pattern1.matcher(line);
				 if(matcher.find()){
					 break;
				 }
								 
			 }
			 while ((line=br.readLine())!=null){
				 Matcher matcher = pattern2.matcher(line);
				 if(matcher.find()){
					 break;
				 }
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
	public String partFOUR(String fullname) throws FileNotFoundException{
		String line;
		String nameToRtn = fullname+"4"+".txt";
		
		 FileInputStream fis = new FileInputStream(fullname);
		 FileOutputStream fos = new FileOutputStream(nameToRtn);
		 Pattern pattern1 = Pattern.compile("bigeminy during hospitalization.");
		 //Pattern pattern2 = Pattern.compile("bigeminy during hospitalization");
		 //Pattern pattern2 = Pattern.compile("bigeminy during hospitalization.");

		 try{
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			 while ((line=br.readLine())!=null){
				 Matcher matcher = pattern1.matcher(line);
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
