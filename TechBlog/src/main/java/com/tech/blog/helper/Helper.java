package com.tech.blog.helper;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helper {

	public static  boolean deleteFile(String path) {
		boolean f = false;

		try {
			File file = new File(path);
			file.delete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}  
	
	public static boolean saveFile(InputStream is,String path) {
		boolean f=false; 
		try {
			byte b[]=new byte[is.available()];
			is.read(b);        // read from b
			FileOutputStream fos=new FileOutputStream(path);
			fos.write(b);
			fos.flush();
			fos.close(); 
			f=true;
			
		}catch(Exception e){
			e.printStackTrace(); 
		}
		return f;
	}
}
