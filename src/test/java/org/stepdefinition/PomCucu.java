package org.stepdefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomCucu extends BaseClass {
  
	public PomCucu() {
		PageFactory.initElements(driver, this);
	}
	
	//FaceBook
	
	
	
	
	public WebElement getUser() {
		return user;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getBtn() {
		return btn;
	}

	@FindBy (xpath = "//input[@id='email']")
	private WebElement user;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement pass;
	
	@FindBy (xpath = "//button[@name='login']")
	private WebElement btn;
	
	
	
	
}
