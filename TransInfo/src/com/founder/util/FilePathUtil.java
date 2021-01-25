package com.founder.util;

//import java.io.File;

public final class FilePathUtil {
	
	public static String normalPath(String folder, String fileName){
		
		String separator = "/";
		folder = folder.replace("/", separator);
		folder = folder.replace("\\", separator);
		fileName = fileName.replace("/", separator);
		fileName = fileName.replace("\\", separator);
		if(!folder.endsWith(separator)){
			folder += separator;
		}
		if(fileName.startsWith(separator)){
			fileName = fileName.substring(1);
		}
		return folder + fileName;
		
	}

}
