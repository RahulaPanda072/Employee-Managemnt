package com.employee.management.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class EmployeeUtils {

	public File isFileAvailable() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(".").getFile() + "/employee.txt");
		 if (file.exists()) {
			 return file;
		 } else {
			 return null;
		 }
	}
	
	public File checkAndCreateFile() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(".").getFile() + "/employee.txt");
	    if (file.createNewFile()) {
	        System.out.println("File is created!");
	    } else {
	        System.out.println("File already exists.");
	    }
	    return file;
	}
}
