package ioModify;


/*
 * 例子:输入目录:  D:\test.txt;
 * 		   输入行:     3
 * 		   输入内容:  new third
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.io.*;

public class Modifytxt {
	 public static void replaceTxtByLineNo(String path,int lineNo,String newStr) {
	        String temp = "";
	        try {
	            File file = new File(path);
	            FileInputStream fis = new FileInputStream(file);
	            InputStreamReader isr = new InputStreamReader(fis);
	            BufferedReader br = new BufferedReader(isr);
	            StringBuffer buf = new StringBuffer();

	            for (int j = 1; (temp = br.readLine()) != null; j++) {
	                if(j==lineNo){
	                    buf = buf.append(newStr);
	                }else{
	                    buf = buf.append(temp);
	                }
	                buf = buf.append(System.getProperty("line.separator"));
	            }

	            br.close();
	            FileOutputStream fos = new FileOutputStream(file);
	            PrintWriter pw = new PrintWriter(fos);
	            pw.write(buf.toString().toCharArray());
	            pw.flush();
	            pw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void main(String[] s) throws IOException {
	    	Scanner in = new Scanner(System.in);
	    	
	    	System.out.println("请输入目录");
	    	String path = in.next();
	    	File f = new File(path);
	    	if ( f.exists() == false ) {
	    		System.out.println("文件不存在，创建了新文件");
	    		f.createNewFile();
	    		return;
	    	}
	    	System.out.println("请输入行数");
	    	int row = in.nextInt();
	    	System.out.println("请输入要更新的内容");
	    	String content = in.next();
	        replaceTxtByLineNo(path,row,content);
	    }
}
