package com.founder.model;


public class TaskContext {
	
//	private MessageQueue messageQueue;
	
	private String baseDir;
	
	private String targetDir;
	
	private String readWay;
	
	private String fileExt; 
	
	private String dateFormat;
	
	public TaskContext(){
//		messageQueue = new MessageQueue();
	}

//	public MessageQueue getMessageQueue() {
//		return messageQueue;
//	}

//	public void setMessageQueue(MessageQueue messageQueue) {
//		this.messageQueue = messageQueue;
//	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public String getTargetDir() {
		return targetDir;
	}

	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}

	public String getReadWay() {
		return readWay;
	}

	public void setReadWay(String readWay) {
		this.readWay = readWay;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

}
