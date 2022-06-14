package org.stepdefinition;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends BaseClass {
	
	
	
	
	@Given("user should launch the chrome browser and load the url")
	public void user_should_launch_the_chrome_browser_and_load_the_url() {
//	    launchChrome();
//	    windowsLarge();
//	    loadUrl("https://www.facebook.com/");
	}

	@When("user should type valid username and invalid password")
	public void user_should_type_valid_username_and_invalid_password(DataTable d) throws IOException {
	    PomCucu p = new PomCucu();
	    List<String> al = d.asList();
	    String username = al.get(0);
	    String pass = al.get(1);
	    send(p.getUser(), username);
	    send(p.getPass(), pass);
	}

	@When("user shiuld check login buttons")
	public void user_shiuld_check_login_buttons() {
	    PomCucu p = new PomCucu();
	    btnclic(p.getBtn());
	}

	@Then("user should navigate to incorrect credential page")
	public void user_should_navigate_to_incorrect_credential_page() {
	    System.out.println(driver.getTitle());
	    quit();
	}
	
	
	@When("user should type invalid username and valid password")
	public void user_should_type_invalid_username_and_valid_password() throws IOException {
		    PomCucu p = new PomCucu();
		    send(p.getUser(), ExcelData(2, 0));
		    send(p.getPass(), ExcelData(2, 1));
	}
	
	@Given("User has to be in login functionality")
	public void user_has_to_be_in_login_functionality() {
	    
	}

	@When("User has to click forgot password")
	public void user_has_to_click_forgot_password() {
	    driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
		System.out.println("login");
	}

	@Then("User search account with phone number")
	public void user_search_account_with_phone_number() {
	    driver.findElement(By.id("identify_email")).sendKeys("9876541230");
	    driver.findElement(By.id("did_submit")).click();
	    quit();
		System.out.println("end");
	}
	

}




