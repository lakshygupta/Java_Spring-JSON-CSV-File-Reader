package com.lakshy.project.java.assignment.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lakshy.project.java.assignment.JavaAssignmentApplication;
import com.lakshy.project.java.assignment.models.OrderDTO;
import com.lakshy.project.java.assignment.models.OrderPojo;

@Service
public class CommandLineService {
	String[] args = null;
	String line = null;
	boolean error = false;
	ArrayList<OrderDTO> orderDtoAL = new ArrayList<>();
	
	
	public void fetchArgs() {
		args = JavaAssignmentApplication.getArgs();
	}
	
	public void CSVReader() {
		this.fetchArgs();
		int countLine = 0;
		try {
			File file = new File(args[0]);
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line=br.readLine())!= null) {
				String[] data = line.split(",");
				data[0] = data[0].substring(1);
				OrderPojo orderPojo = new OrderPojo();
				orderPojo.setOrderId(Integer.parseInt(data[0]));
				orderPojo.setAmount(Double.parseDouble(data[1]));
				orderPojo.setCurrency(data[2]);
				orderPojo.setComment(data[3].substring(0,data[3].length()-1));
				orderPojo.setFilename(file.getName());
				orderPojo.setLine(++countLine);
				orderPojo.setResult("OK");
				OrderDTO orderDtoObj = new OrderDTO();
				orderDtoObj = this.Mapper(orderPojo);
				orderDtoObj.setId(orderDtoObj.getId());
				orderDtoObj.incrId();
				orderDtoAL.add(orderDtoObj);
			}
		} catch (Exception e) {
			System.out.println("Error occured in CMD LINE SERVICE CSV");
			e.printStackTrace();
		}
	}
	
	public void JSONReader() {
		this.fetchArgs();
		int countLine = 0;
		try {
			File file = new File(args[1]);
			JsonReader reader = new JsonReader(new FileReader(file));
			OrderPojo[] orderPojos = new Gson().fromJson(reader, OrderPojo[].class);
			for(OrderPojo obj : orderPojos) {
				obj.setFilename(file.getName());
				obj.setLine(++countLine);
				obj.setResult("OK");
				OrderDTO orderDtoObj = new OrderDTO();
				orderDtoObj = this.Mapper(obj);
				orderDtoObj.setId(orderDtoObj.getId());
				orderDtoObj.incrId();
				orderDtoAL.add(orderDtoObj);
			}
			
		} catch (Exception e) {
			System.out.println("Error occured in CMD LINE SERVICE JSON");
			e.printStackTrace();
		}
		this.Printer();
	}
	
	public void Printer() {
		for(int i=0;i<orderDtoAL.size();i++) {
			System.out.println(orderDtoAL.get(i).toString());
		}
	}
	
	public OrderDTO Mapper(OrderPojo opj) {
		OrderDTO odo = new OrderDTO();
		odo.setAmount(opj.getAmount());
		odo.setComment(opj.getComment());
		odo.setCurrency(opj.getCurrency());
		odo.setFilename(opj.getFilename());
		odo.setLine(opj.getLine());
		odo.setOrderId(opj.getOrderId());
		odo.setResult(opj.getResult());
		return odo;
	}
	
}
