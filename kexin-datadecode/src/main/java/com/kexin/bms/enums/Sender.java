package com.kexin.bms.enums;

public enum Sender {

	OTHER("其他系统"),
	PANEL("组合仪表");
	
	private String name;
	
	private Sender(String name){
		this.name = name;
	}
	
}
