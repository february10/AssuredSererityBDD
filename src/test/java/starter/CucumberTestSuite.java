package starter;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import starter.stepdefinitions.BookSearchDefinition;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features"
)
public class CucumberTestSuite {

	
}
