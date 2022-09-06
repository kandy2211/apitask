package com.stepdefinition;

import org.junit.Assert;
import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.Login_Output_Pojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * 
 * @author Kandasamy
 * @description used to maintain Login step related methods
 * @date 07/09/2022 
 *
 */
public class TC1_LoginStep extends BaseClass {
	Response response;
	static String logtoken;

	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept", "application/json");

	}

	@Given("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() {
		basicAuthentication("kanthasamy2211@gmail.com", "Kandasamy@22");

	}

	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String post) {
		response = requestMethodType(post, Endpoints.POSTMANBASCIAUTHLOGIN);

	}

	
	@Then("User verify the login response body first_name present as {string} and get the logtoken saved")
	public void userVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String firstName) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals("verify first name field ", firstName, first_name);

		logtoken = login_Output_Pojo.getData().getLogtoken();

	}

}
