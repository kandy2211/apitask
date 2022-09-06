package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Then;
/**
 * 
 * @author Kandasamy
 * @description used to maintain common steps
 * @date 07/09/2022
 *
 */
public class CommonStep extends BaseClass {
	
	@Then("User verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(int status) {
		int statusCode = getStatusCode(response);
		System.out.println("status:"+statusCode);
		Assert.assertEquals("verify status code",status, statusCode);
	
	}


}
