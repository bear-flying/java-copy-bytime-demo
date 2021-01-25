package com.founder.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MessageQueue {
	
	private static final int QUEUELEN = 1000;
	
	private Set<String> messageQueue;
	
	public MessageQueue(){
		
		messageQueue = new HashSet<String>();
		
	}
	
	public synchronized boolean isFull(){
		
		if(messageQueue.size() >= QUEUELEN){
			return true;
		}
		return false;
		
	}
	
	public synchronized boolean isEmpty(){
		
		if(messageQueue.size() <= 0){
			return true;
		}
		return false;
		
	}
	
	public synchronized void addMessage(String fileName){
		
		messageQueue.add(fileName);
		
	}
	
	public synchronized String getMessage(){
		
		if(isEmpty()){
			return null;
		}
		Iterator<String> it = messageQueue.iterator();
		String message = it.next();
		it.remove();
		return message;
		
	}

}
