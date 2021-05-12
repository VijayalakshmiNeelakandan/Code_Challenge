package steps;

import java.util.List;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import responseDto.Location;
import responseDto.Network;
import responseDto.NetworkResponse;
import shared.WebserviceEndpoints;

public class ValidateCityStep {

	@Steps
	RestAPI application;

	private static Logger logger = LoggerFactory.getLogger(ValidateCityStep.class);

	@When("the city is frankfurt")
	public void i_run_the_api_endpoint_get_city() {
		NetworkResponse networkResponse = application.getResponse();
	    
		for (Network network : networkResponse.getNetworks()) {
            if (network.getLocation().getCity().toLowerCase().equals("frankfurt")) {
				Assert.assertEquals(network.getLocation().getCity().toLowerCase(), "frankfurt");
            }
        }
	}

	@Then("Validate if the country is Germany")
	public void the_country_returned_match_the_expected_response() {
		NetworkResponse networkResponse = application.getResponse();

		for (Network network : networkResponse.getNetworks()) {
			if (network.getLocation().getCity().toLowerCase().equals("frankfurt")) {
				Assert.assertEquals(network.getLocation().getCountry().toUpperCase(), "DE");
			}
		}

	}
	
	@Then("Retreive the latitude and longitude of Frankfurt")
	public void the_city_returned_should_match_the_expected_response() {
		NetworkResponse networkResponse = application.getResponse();

		for (Network network : networkResponse.getNetworks()) {
			if (network.getLocation().getCity().toLowerCase().equals("frankfurt") ) {
				Assert.assertNotNull(network.getLocation().getLatitude());
				Assert.assertNotNull(network.getLocation().getLongitude());

				logger.info("The Longitude is "+ String.valueOf(network.getLocation().getLongitude()));
				logger.info("The Latitude is "+ String.valueOf(network.getLocation().getLatitude()));

			}
		}
	
	}

}
