package es.uniovi.asw.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.springframework.util.Assert;



public class Simple {
  
  @Given("^That I have the application initialized$")
  public void that_I_have_the_application_initialized() throws Throwable {
      System.out.println("Initialization...");
  }

  @Given("^I say hi$")
  public void i_say_hi() throws Throwable {
    System.out.println("Saying hi");
  }

  @When("^I login$")
  public void i_login() throws Throwable {
    System.out.println("Doing login...");
  }

  @Then("^Everything works$")
  public void everything_works() throws Throwable {
    int x = 3;
    assertEquals(x,3);
  }



}
