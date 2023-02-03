package com.capgemini.medicalboot.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStepDefination {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();

	@Given("^Open the chrome and open the appliaction$")
	public void open_the_chrome_and_open_the_appliaction() throws Throwable {
		driver.get("http://localhost:4200/login");
		driver.manage().window().maximize();
	}

	@When("^Enter the valid user email$")
	public void enter_the_valid_user_email() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("priti@gmail.com");
	}

	@When("^Enter the valid user password$")
	public void enter_the_valid_user_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("priti");
	}

	@When("^click on user login  button$")
	public void click_on_user_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

	@Then("^the user ProductList page must be displayed$")
	public void the_user_ProductList_page_must_be_displayed() throws Throwable {
		System.out.println("Operation is Done");
		Thread.sleep(2000);
		// driver.close();
	}

	@When("^Click on add button\\.$")
	public void click_on_add_button() throws Throwable {

		driver.findElement(By.xpath("/html/body/app-root/app-user-product-list/div/table/tbody/tr/td[6]/button"))
				.click();
	}

	@When("^Enter quantity in textfield\\.$")
	public void enter_quantity_in_textfield() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.name("productQuantity")).sendKeys("1");
	}

	@When("^Click on add button of popup\\.$")
	public void click_on_add_button_of_popup() throws Throwable {
		Thread.sleep(3000);
//		//Thread.sleep(1000);
//        //driver.findElement(By.xpath("//*[@id=\"btnAddCust\"]")).click();
//        WebElement el = driver.findElement(By.className("btn btn-outline-dark"));
//        el.click();
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/div/form/div[2]/button[2]")).click();
	}

	@When("^Click on cross link\\.$")
	public void click_on_cross_link() throws Throwable {
		Thread.sleep(3000);
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("//*[@id=\"btnAddCust\"]")).click();
		// WebElement el = driver.findElement(By.className("btn btn-outline-dark"));
		// el.click();
		// driver.findElement(By.className("btn btn-outline-dark"));
		// driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/div/form/div[2]/button[2]")).click();

		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[1]/button/span")).click();
	}

	@Then("^Open user cart link$")
	public void open_user_cart_link() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"user-cart\"]")).click();
	}

	@Then("^Click on Buy Button$")
	public void click_on_Buy_Button() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-user-cart/div/table/tbody/tr[1]/td[6]/button")).click();
	}

	@Then("^Click on Pay Button$")
	public void click_on_Pay_Button() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/div/form/div[4]/button")).click();
	}
	
	@Then("^Click on cross link of that popup$")
	public void click_on_cross_link_of_that_popup() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[1]/button/span")).click();
	}
	
	@When("^Click discussion board link$")
	public void click_discussion_board_link() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.id("user-discussion-board")).click();
	}

	@When("^Enter message on text field$")
	public void enter_message_on_text_field() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.name("message")).sendKeys("hello");
	}

	@Then("^Click on Message Button\\.$")
	public void click_on_Message_Button() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-user-discussion-board/div/div[2]/div/div/form/button"))
				.click();
	}

	@Then("^Add product logout$")
	public void add_product_logout() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"collapsibleNavId\"]/ul[2]/li/button")).click();
		driver.close();
	}
}// end of class
