package org.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksForgotFb extends BaseClass{
	
	@Before
	public void tc1() {
		System.out.println("Befor start");
		launchChrome();
		windowsLarge();
		loadUrl("https://www.facebook.com/");
	}
	
	@After
	public void tc2() {
		System.out.println("After end");
        quit();
	}

}
