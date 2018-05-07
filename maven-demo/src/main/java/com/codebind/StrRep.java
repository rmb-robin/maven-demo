package com.codebind;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class StrRep {
	public void place(String name) {
	File f = new File(name);
    try
    {
        String ENDL = System.getProperty("line.separator");

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(f));
        String ln;
        while((ln = br.readLine()) != null)
        {
            sb.append(ln
                .replace("Signature", "Signature")
                 ).append(ENDL);
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
	}
}