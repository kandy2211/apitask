package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * 
 * @author Kandasamy
 * @description used to maintain all reusable methods
 * @date 07/09/2022
 *
 */
public class BaseClass {

	RequestSpecification reqspec;
	public static Response response;
	/**
	 * 
	 * @param headers
	 * @description used to add headers
	 */
	public void addHeaders(Headers headers) {
		 reqspec = RestAssured.given().headers(headers);

	}
	/**
	 * @description used to add header
	 * @param key
	 * @param value
	 * 
	 */

	public void addHeader(String key, String value) {
		reqspec = RestAssured.given().header(key, value);

	}
	/**
	 * @description used to add query parameter
	 * @param key
	 * @param value
	 */

	public void addQueryParam(String key, String value) {
		reqspec = reqspec.queryParam(key, value);

	}
	/**
	 * @description used to add path parameter
	 * @param key
	 * @param value
	 */

	public void addPathParam(String key, String value) {
		reqspec = reqspec.param(key, value);
	}
	/**
	 * @description used to add body
	 * @param body
	 * 
	 */
	public void addBody(String body) {
		reqspec = reqspec.body(body);
	}
	/**
	 * @description used to add body object
	 * @param body
	 */

	
	public void addBodyObject(Object body) {

		reqspec=reqspec.body(body);
	}
	/**
	 * @description used to select request method type
	 * @param type
	 * @param endpoint
	 * @return response
	 */
	public Response requestMethodType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqspec.log().all().get(endpoint);
			break;
		case "POST":
			response = reqspec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqspec.log().all().put(endpoint);
			break;
		case "DELETE":
			response = reqspec.log().all().delete(endpoint);
			break;
		default:
			break;
		}
		return response;

	}
	/**
	 * @description used to get the status code
	 * @param response
	 * @return statusCode
	 */


	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}
	/**
	 * @description used to get the response body as string
	 * @param response
	 * @return asString
	 */


	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;

	}
	/**
	 * @description used to get the response body as pretty string
	 * @param response
	 * @return asPrettyString
	 */

	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}
	/**
	 * @description used for basic authentication
	 * @param username
	 * @param password
	 */
	public void basicAuthentication(String username,String password) {
		 reqspec = reqspec.auth().preemptive().basic(username, password);

	}
	/**
	 * @description used to get value form the property file
	 * @param key
	 * @return value
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public  String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();

		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties"));

		String value = (String) properties.get(key);

		return value;

	}
	/**
	 * @descripton used to pass form data
	 * @param key
	 * @param file
	 */
	public void formData(String key,File file) {
		reqspec = reqspec.multiPart(key, file);
	}

}
