package com.pojo;
/**
 * 
 * @author Kandasamy
 * @description used to maintain change profile pic output pojo 
 * @date 07/09/2022
 *
 */
public class ChangeProfilePic_Output_Pojo {
	 private int status;
	 private String message;
	 private ChangeProfilepic data;
	 private int cart_count;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ChangeProfilepic getData() {
		return data;
	}
	public void setData(ChangeProfilepic data) {
		this.data = data;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}

}
