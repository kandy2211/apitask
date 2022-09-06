package com.stepdefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangeProfilePic_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * 
 * @author Kandasamy
 * @description used to maintain change profile picture related steps
 * @date 07/09/2022
 *
 */

public class TC3_ChangeProfilePicStep extends BaseClass {

	@Given("User add headers and bearer authorization for accessing upload profile picture endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingUploadProfilePictureEndpoints() {
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");

		h.add(h1);
		h.add(h2);
		h.add(h3);

		Headers headers = new Headers(h);

		addHeaders(headers);
	}

	@When("User add form data for adding profile picture")
	public void userAddFormDataForAddingProfilePicture() throws FileNotFoundException, IOException {
		formData("profile_picture", new File(System.getProperty("user.dir") + getPropertyFileValue("profilepic")));

	}

	@When("User send {string} request for changeProfilePic endpoint")
	public void userSendRequestForChangeProfilePicEndpoint(String post) {
		response = requestMethodType(post, Endpoints.CHANGEPROFILEPIC);

	}

	@Then("User verify the changeProfilePic response message matches {string}")
	public void userVerifyTheChangeProfilePicResponseMessageMatches(String updateProfileExp) {
		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);

		String updateProfileActual = changeProfilePic_Output_Pojo.getMessage();
		Assert.assertEquals("verify profile picture updated", updateProfileExp, updateProfileActual);

	}

}
