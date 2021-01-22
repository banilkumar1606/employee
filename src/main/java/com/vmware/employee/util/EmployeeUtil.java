package com.vmware.employee.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vmware.employee.exceptions.EmployeeException;
import com.vmware.employee.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeUtil {
	public List<Employee> processInputFile(MultipartFile file){
		List<Employee> empList = new ArrayList<>();
		Scanner sc = null;
		try{
			InputStream inputStream = file.getInputStream();
			sc = new Scanner(inputStream, "UTF-8");
			while(sc.hasNextLine()) {
				 String line = sc.nextLine();
				 String words[] = line.replace(" +"," ").split(" ");
				 Employee emp = new Employee();
				 emp.setEName(words[0]);
				 emp.setAge(Integer.parseInt(words[1]));
				 emp.setId(Integer.parseInt(words[2]));
				 empList.add(emp);
			 }
		}catch(Exception e) {
			log.info("Exception occured while processing the file");
			throw new EmployeeException("Exception occured while processing the file");
		}		
		return empList;
		
	}
}
