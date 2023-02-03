package com.capgemini.medicalboot.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	WebDriver driver = new ChromeDriver();;
	
		 
		 
	@Given("^Open the chrome and launch the application$")
	public void open_the_chrome_and_launch_the_application() throws Throwable {

		driver.get("http://localhost:4200/login");
		driver.manage().window().maximize();
		  
	}

	@When("^Enter the valid email$")
	public void enter_the_valid_email() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("simran@gmail.com");
	}

	@When("^Enter the valid password$")
	public void enter_the_valid_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("simran");
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

	}

	@Then("^the ProductList page must be displayed$")
	public void the_ProductList_page_must_be_displayed() throws Throwable {
		System.out.println("Operation is Done");
		Thread.sleep(2000);
		// driver.close();
	}

	@When("^Click on add Product link\\.$")
	public void click_on_add_Product_link() throws Throwable {

		driver.findElement(By.id("admin-add-product")).click();
	}

	@When("^add all the Product information avaliable\\.$")
	public void add_all_the_Product_information_avaliable() throws Throwable {
		driver.findElement(By.name("productName")).sendKeys("combifalm");
		driver.findElement(By.name("productCategory")).sendKeys("Health Care");
		driver.findElement(By.name("productDescription")).sendKeys("Relief from headache");
		driver.findElement(By.name("productQuantity")).sendKeys("1");
		driver.findElement(By.name("productPrice")).sendKeys("23.2");
	}

	@Then("^It add present product details\\.$")
	public void it_add_present_product_details() throws Throwable {
		driver.findElement(By.xpath("//button[contains(.,'Add')]")).click();
		Thread.sleep(3000);
		driver.close();
	}

	@When("^Click on update button$")
	public void click_on_update_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	}

	@When("^add all updated the Product information avaliable\\.$")
	public void add_all_updated_the_Product_information_avaliable() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.id("price")).sendKeys("26");
	}

	@Then("^It will add updated product details\\.$")
	public void it_will_add_updated_product_details() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/div/form/div[6]/button[2]")).click();
	}

	@Then("^Click on Cross Link$")
	public void click_on_Cross_Link() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[1]/button/span")).click();
		Thread.sleep(3000);
		driver.close();

	}

	@When("^Click on delete button$")
	public void click_on_delete_button() throws Throwable {

		driver.findElement(By.xpath("//button[contains(.,'Delete')]")).click();
		Thread.sleep(3000);
		driver.close();

	}
}// end of class
