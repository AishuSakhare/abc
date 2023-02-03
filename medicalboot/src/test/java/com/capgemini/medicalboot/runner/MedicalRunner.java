package com.capgemini.medicalboot.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"com.capgemini.medicalboot"},tags = {"@tag4"})
public class MedicalRunner {
	//,tags = {"@tag2"}
}
