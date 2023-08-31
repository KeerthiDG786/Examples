package com.mob.sts.controller;

public class Failur {
	
	private  String message;
	private int code;
	public String getMessage() {
		return message;
	}
	public  void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Failur [message=" + message + ", code=" + code + "]";
	}
	public Failur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Failur(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}
	Failur failur=new Failur();
	public Failur msg(String message,int code)
	{
		failur.setMessage("No deatils found");
		failur.setCode(401);
		return failur;
	}
	

}
