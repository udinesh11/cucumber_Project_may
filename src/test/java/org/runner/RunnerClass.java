package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions (features= "src\\test\\resources\\Feature Files", glue="org.stepdefinition", dryRun=false
, strict=true,tags={"@smoke"}

)
public class RunnerClass {

}
