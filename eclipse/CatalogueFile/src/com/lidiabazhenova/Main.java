package com.lidiabazhenova;


import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;


public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder htmlContent = new StringBuilder();
		htmlContent.append("<table b order='1' cellpadding='5' style='border-collapse: collapse; border: 1px solid black;'>");
		htmlContent.append("<tr><th>Тип</th><th>???</th><th>???? ????????</th><th>??????</th></tr>");
		
		File folder = new File("d:/");
		
		File[] listOfFiles = folder.listFiles();
		for (File directoryItem : listOfFiles) {
			htmlContent.append("<tr>");
			htmlContent.append("<td>").append(directoryItem.getName()).append("</td>");
			
			if (directoryItem.isDirectory()) {
				htmlContent.append("<td>").append("DIR").append("</td>");
			} else if (directoryItem.isFile()) {
				htmlContent.append("<td>").append("FILE").append("</td>");
			} else {
				htmlContent.append("<td>").append("").append("</td>");				
			}
						
			BasicFileAttributes attr = Files.readAttributes(directoryItem.toPath(), BasicFileAttributes.class);			
			htmlContent.append("<td>").append(attr.creationTime()).append("</td>");
			 
			if (directoryItem.isDirectory()) {
				htmlContent.append("<td>").append(folderSize(directoryItem)).append("</td>");
			} else if (directoryItem.isFile()) {
				htmlContent.append("<td>").append(directoryItem.length()).append("</td>");
			} else {
				htmlContent.append("<td>").append("").append("</td>");				
			}
			
			htmlContent.append("</tr>");
		}		
		
		htmlContent.append("</table>");		
		
		PrintWriter htmlFile = new PrintWriter("d:/123456.html");
		htmlFile.println(htmlContent.toString());
		htmlFile.close();
	}
	
	public static long folderSize(File directory) {
	    long length = 0;
	    for (File file : directory.listFiles()) {
	        if (file.isFile())
	            length += file.length();
	        else
	            length += folderSize(file);
	    }
	    return length;
	}
	
	/*
	 * 		BufferedReader input = new BufferedReader(new FileReader(FILE_NAME));
		Writer output = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
		String line = null;
		while ((line = input.readLine()) != null) {
			System.out.println(line);
			output.write(line);
		}

		input.close();
		output.close();
	 */

	
}
