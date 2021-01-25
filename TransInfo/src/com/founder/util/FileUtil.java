package com.founder.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {
	
	private static Log logger = LogFactory.getLog(FileUtil.class);
	
	public static void write(String bytes, String path) throws Exception{
		
		File file = new File(path);
		File dir = file.getParentFile();
		if(!dir.exists()){
			dir.mkdirs();
		}
		if(!file.exists()){
			file.createNewFile();
		}
		org.apache.commons.io.FileUtils.writeStringToFile(file, bytes, "utf-8");
		
	}

	public static void write(byte[] bytes, String path) throws Exception {

		File file = new File(path);
		write(bytes, file);

	}

	public static void write(byte[] bytes, File file) throws Exception {

		File dir = file.getParentFile();
		if(!dir.exists()){
			dir.mkdirs();
		}
		if(!file.exists()){
			file.createNewFile();
		}
		org.apache.commons.io.FileUtils.writeByteArrayToFile(file, bytes);
		
	}

	public static boolean moveFile(String sourceFile, String targetFile) {

		File filesource = new File(sourceFile);
		File filetarget = new File(targetFile);
		return moveFile(filesource, filetarget);

	}

	public static boolean moveFile(File sourceFile, File targetFile) {

		try {
			org.apache.commons.io.FileUtils.copyFile(sourceFile, targetFile);
			if (sourceFile.exists()) {
				sourceFile.delete();
			}
			return true;
		} catch (IOException e) {
			return false;
		}

	}
	
	public static boolean copyFile(String sourceFile, String targetFile){
		
		File filesource = new File(sourceFile);
		File filetarget = new File(targetFile);
		try {
			if(!filesource.exists()){
				return false;
			}
			org.apache.commons.io.FileUtils.copyFile(filesource, filetarget);
			return true;
		} catch (IOException exp) {
			logger.error("文件复制出现异常{src:" + sourceFile + ", dest: " + filetarget + "}", exp);
			return false;
		}
		
	}
	
	public static boolean copyFile(File sourceFile, String targetFile){
		
		File filetarget = new File(targetFile);
		try {
			if(!sourceFile.exists()){
				return false;
			}
			org.apache.commons.io.FileUtils.copyFile(sourceFile, filetarget);
			return true;
		} catch (IOException exp) {
			logger.error("文件复制出现异常{src:" + sourceFile + ", dest: " + filetarget + "}", exp);
			return false;
		}
		
	}
	
}
