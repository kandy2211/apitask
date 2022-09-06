package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

/**
 * 
 * @author Kandasamy
 * @description used to maintain runner class
 * @date 07/09/2022
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(dryRun=false,publish=true,monochrome=true,snippets=SnippetType.CAMELCASE,stepNotifications=true,
plugin= {"json:\\target\\output.json"},features="src\\test\\resources\\Features",glue="com.stepdefinition")
public class TestRunnerClass {
	
	@AfterClass
	public static void afterclass() {
		
		 Reporting.generateJVMreport(System.getProperty("user.dir")+"\\target\\output.json");
		 
		
		
	}
	
	
	

}
