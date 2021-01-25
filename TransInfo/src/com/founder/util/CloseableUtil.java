package com.founder.util;

import java.io.Closeable;
import java.io.IOException;

public class CloseableUtil {
	
	public static void close(Closeable stream){
		
		try{
			if(stream != null){
				stream.close();
			}
		}catch(IOException exp){
			
		}
		
	}

}
