package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.AddAddress_Input_Pojo;
import com.pojo.AddAddress_Output_Pojo;
import com.pojo.DeleteUserAddress_Input_Pojo;
import com.pojo.DeleteUserAddress_Output_Pojo;
import com.pojo.GetUserAddresses_Output_Pojo;
import com.pojo.UpdateUserAddress_Input_Pojo;
import com.pojo.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * 
 * @author Kandasamy
 * @description used to maintain address step related methods
 * @date 07/09/2022
 *
 */
public class TC2_AddressStep extends BaseClass {
	Response response;
	static String addressId;
	

	@Given("User add headers and bearer authorization for accessing address endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		h.add(h1);
		h.add(h2);
		h.add(h3);

		Headers headers = new Headers(h);

		addHeaders(headers);

	}

	@When("User add request body for Add new address {string},{string},{string},{string},{string},{string},{string}, {string}, {string} and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		AddAddress_Input_Pojo addAddress_Input_Pojo = new AddAddress_Input_Pojo(first_name, last_name, mobile,
				apartment, Integer.valueOf(state), Integer.valueOf(city), Integer.valueOf(country), zipcode, address,
				address_type);
		addBodyObject(addAddress_Input_Pojo);
	}

	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String post) {
		response = requestMethodType(post, Endpoints.ADDUSERADDRESS);

	}

	@Then("User verify the addUserAddress response message matches {string}")
	public void userVerifyTheAddUserAddressResponseMessageMatches(String addAddressMsg) {
		
		AddAddress_Output_Pojo addAddress_Output_Pojo = response.as(AddAddress_Output_Pojo.class);
		
		String addAddressActual = addAddress_Output_Pojo.getMessage();
		Assert.assertEquals("verify add address msg", addAddressMsg, addAddressActual);
		
		int address_id = addAddress_Output_Pojo.getAddress_id();
		
		addressId = String.valueOf(address_id);
		

	}

	@When("User add request body for updating existing address {string} , {string},{string},{string},{string},{string},{string},{string}, {string}, {string} and {string}")
	public void userAddRequestBodyForUpdatingExistingAddressAnd(String addressid, String first_name, String last_name, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String address_type) {
	  
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(addressId, first_name, last_name, mobile, apartment,Integer.valueOf(state),Integer.valueOf(city),Integer.valueOf(country), zipcode, address, address_type);
		addBodyObject(updateUserAddress_Input_Pojo);

	}

	@When("User send {string} request for updateUserAddress endpoint")
	public void userSendRequestForUpdateUserAddressEndpoint(String put) {
		 response = requestMethodType(put, Endpoints.UPDATEUSERADDRESS);

	}

	@Then("User verify the updateUserAddress response message matches {string}")
	public void userVerifyTheUpdateUserAddressResponseMessageMatches(String updateAddressMsg) {
		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		
		String updateAddressActual = updateUserAddress_Output_Pojo.getMessage();
		System.out.println("update:"+updateAddressActual);
		Assert.assertEquals("verify update address msg",updateAddressMsg,updateAddressActual);

	}

	@When("User add request body for deleting address")
	public void userAddRequestBodyForDeletingAddress() {
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(addressId);
		addBodyObject(deleteUserAddress_Input_Pojo);

	}

	@When("User send {string} request for deleteUserAddress endpoint")
	public void userSendRequestForDeleteUserAddressEndpoint(String delete) {
		 response = requestMethodType(delete, Endpoints.DELETEUSERADDRESS);

	}

	@Then("User verify the deleteUserAddress response message matches {string}")
	public void userVerifyTheDeleteUserAddressResponseMessageMatches(String deleteUserAddressMsg) {
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		
		String deleteUserMsgActual = deleteUserAddress_Output_Pojo.getMessage();
		
		Assert.assertEquals("verify delete user address msg",deleteUserAddressMsg,deleteUserMsgActual );

	}

	@Given("User send {string} request for getUserAddresses endpoint")
	public void userSendRequestForGetUserAddressesEndpoint(String get) {
		 response = requestMethodType(get, Endpoints.GETUSERADDRESSES);
		

	}

	@Then("User verify the getUserAddresses response message matches {string}")
	public void userVerifyTheGetUserAddressesResponseMessageMatches(String getUserAddressMsg) {
		GetUserAddresses_Output_Pojo getUserAddresses_Output_Pojo = response.as(GetUserAddresses_Output_Pojo.class);
		

		String getUserAddressMsgActual = getUserAddresses_Output_Pojo.getMessage();

		Assert.assertEquals("verify ok msg",getUserAddressMsg,getUserAddressMsgActual);

	}

}
