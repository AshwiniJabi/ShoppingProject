package com.testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/features",
		glue = {"com/stepdefinations"}
		,tags = "@CreateProduct"
		
		)
public class TestRunner {

}
