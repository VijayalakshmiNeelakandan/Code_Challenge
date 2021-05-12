package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import io.restassured.RestAssured;
import org.junit.Test;
import shared.WebserviceEndpoints;

public class ApplicationStatusStep {

	@Steps
	RestAPI application;
	
	@Given("the application is running")
	public void the_application_is_running() {
		Assert.assertNotNull(application.getResponseCode());
	}

	@When("I check the application status")
	public void i_check_the_application_status() {
		Assert.assertNotNull(application.getResponseCode());
	}

	@Then("the API should return 200")
	public void the_api_should_return() {
		Assert.assertEquals(application.getResponseCode(), 200);
	}

}
