package com.lakshy.project.java.assignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lakshy.project.java.assignment.service.CommandLineService;

@SpringBootApplication
public class JavaAssignmentApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(JavaAssignmentApplication.class, args);
	}
	
	private static String[] passedArgs;
	public static String[] getArgs() {
		return passedArgs;
	}

	@Override
	public void run(String... args) throws Exception {
		
		passedArgs = args;
		
		CommandLineService cmdLineSrv = new CommandLineService();
		cmdLineSrv.CSVReader();
		cmdLineSrv.JSONReader();
	}	

}
