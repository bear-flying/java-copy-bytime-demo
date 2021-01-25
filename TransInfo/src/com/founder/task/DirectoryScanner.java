package com.founder.task;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.model.TaskContext;
import com.founder.util.FilePathUtil;
import com.founder.util.FileUtil;

/**
 * 目录扫描线程
 */
public class DirectoryScanner implements Runnable {

	private static Log logger = LogFactory.getLog(DirectoryScanner.class);

	private static SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private TaskContext taskContext;

	private LinkedList<File> vftList = new LinkedList<File>();
	private LinkedList<File> datepathList = new LinkedList<File>();
	private String currentYear = new SimpleDateFormat("yyyy").format(new Date());
	public boolean extFlag;
	
	public DirectoryScanner() {}

	public DirectoryScanner(TaskContext taskContext) {
		this.taskContext = taskContext;
	}

	public void run() {

		startTask();

	}

	private void startTask(){

		String baseDir = taskContext.getBaseDir();
		String targetDir = taskContext.getTargetDir();
		String readWay = taskContext.getReadWay();
		SimpleDateFormat format = new SimpleDateFormat(taskContext.getDateFormat().trim());
		extFlag = taskContext.getFileExt()==null||"".equals(taskContext.getFileExt().trim());
		String datePath = format.format(new Date());
		if("1".equals(readWay)){
			//基本路径下   直接是时间路径
			baseDir = FilePathUtil.normalPath(baseDir, datePath);
			iteraFiles(new File(baseDir));
		}else if("2".equals(readWay)){
			//基本路径下   寻找时间路径 
			findDirectory(new File(baseDir),datePath);
			int datepathSize = datepathList.size();
			for(int k=0;k<datepathSize;k++){
				File dateFile = datepathList.get(k);
				iteraFiles(dateFile);
			}
		}
		targetDir = FilePathUtil.normalPath(targetDir, datePath);
		
		int vftSize = vftList.size();
		boolean result = false;
		int success = 0;
		int fail = 0;
		logger.info("今天需要拷贝"+vftSize+"个文件");
		for(int i=0;i<vftSize;i++){
			File finalFile = vftList.get(i);
			result = moveFileMessage(finalFile, targetDir);
			if(result){
				success++;
			}else{
				fail++;
			}
		}
		String currentTime = formatTime.format(new Date());
		logger.info(currentTime +" 拷贝文件成功个数："+success+"; 失败个数："+fail+";");
		System.out.println(currentTime +" 共拷贝当天文件"+vftSize+"个, 成功个数："+success+"; 失败个数："+fail+";");
	}

	private void findDirectory(File baseFile, String datePath) {
		
		if(baseFile.isDirectory()){
			if(datePath.equals(baseFile.getName())){
				datepathList.add(baseFile.getAbsoluteFile());
			}
			File[] setFiles = baseFile.listFiles();
			if(null!=setFiles){
				for(File file : setFiles){
					findDirectory(file, datePath);
				}
			}
		}	
	}

	private void iteraFiles(File dataFile) {
		if(dataFile.isFile()){
			if(extFlag){
				addFile(dataFile);
			}else{
				String[] exts = taskContext.getFileExt().split("-");
				for (String ext : exts) {
					if(dataFile.getName().endsWith(ext)){
						addFile(dataFile);
						break;
					}
				}
			}
		}else{
			File[] listFiles = dataFile.listFiles();
			if(null!=listFiles){
				for(File file : listFiles){
					iteraFiles(file);
				}
			}
		}
	}
	
	/**
	 * 过滤 只拷贝今年的文件
	 * @param dataFile
	 */
	public void addFile(File dataFile){
		if(dataFile.getName().contains(currentYear)){
			vftList.add(dataFile);
		}
	}
	
	public boolean moveFileMessage(File msgFile, String targetDir){
		
		String targetFile = FilePathUtil.normalPath(targetDir, msgFile.getName());
		if (FileUtil.copyFile(msgFile, targetFile)) {
			//logger.info("拷贝文件成功！");
			return true;
		} else {
			//logger.warn("拷贝文件失败！");
			return false;
		}
		
	}

	public TaskContext getTaskContext() {
		return taskContext;
	}

	public void setTaskContext(TaskContext taskContext) {
		this.taskContext = taskContext;
	}


}
