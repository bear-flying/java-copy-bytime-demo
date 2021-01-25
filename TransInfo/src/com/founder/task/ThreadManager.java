package com.founder.task;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.model.TaskContext;

public class ThreadManager {
	
	private static Log logger = LogFactory.getLog(ThreadManager.class);
	
	private DirectoryScanner directoryScanner;
	
	private TaskContext taskContext;
	
	public ThreadManager(){}
	
	public void startThread(){
		//检查目录
		createDir();
		//开启扫描线程
		logger.info("开启扫描线程" + directoryScanner);
		directoryScanner.setTaskContext(taskContext);
		Thread thread = new Thread(directoryScanner);
		thread.setName("dir_scanner_thread");
		thread.start();
		
	}
	
	private void createDir(){
		
		String baseDir = taskContext.getBaseDir();
		File file = new File(baseDir);
		if(!file.exists()){
			file.mkdirs();
		}
		
		String targetDir = taskContext.getTargetDir();
		file = new File(targetDir);
		if(!file.exists()){
			file.mkdirs();
		}
	}

	public DirectoryScanner getDirectoryScanner() {
		return directoryScanner;
	}

	public void setDirectoryScanner(DirectoryScanner directoryScanner) {
		this.directoryScanner = directoryScanner;
	}

	public TaskContext getTaskContext() {
		return taskContext;
	}

	public void setTaskContext(TaskContext taskContext) {
		this.taskContext = taskContext;
	}

}
