package com.sunyu.kafka.storage;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageStorage {
	
	private List<String> storage = new ArrayList<>();
	
	public void put(String message){
		storage.add(message);
	}
	
	public String toString(){
		StringBuffer info = new StringBuffer();
		storage.forEach(msg->info.append(msg).append("<br/>"));
		return info.toString();
	}
	
	public void clear(){
		storage.clear();
	}
}
