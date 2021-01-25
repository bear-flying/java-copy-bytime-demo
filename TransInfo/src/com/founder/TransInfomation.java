package com.founder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.founder.model.Version;
import com.founder.task.ThreadManager;

public class TransInfomation {
	
	static String[] springXmls = {
			"classpath:applicationContext.xml",
			"classpath:spring_quartz.xml"
	};
	
	static ApplicationContext factory = new ClassPathXmlApplicationContext(springXmls);

	static ThreadManager threadManager = null;
	
	public static void main(String[] args) {
		
		Version version = (Version)getBean("version");
		System.out.println("启动拷贝程序成功, 版本号 " + version.getVersion()+";");
		//threadManager = (ThreadManager)getBean("threadManager");
		//threadManager.startThread();
		while(true){}
	}
	
	public void start(){
		threadManager = (ThreadManager)getBean("threadManager");
		threadManager.startThread();
	}
	
	
	
	public static Object getBean(String beanName){
		
		return factory.getBean(beanName);
		
	}

}
