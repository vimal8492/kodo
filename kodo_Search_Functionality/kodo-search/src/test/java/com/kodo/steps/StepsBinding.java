package com.kodo.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsBinding {
	
	private WebDriver driver;
	
	
	
	@Given("I am in landing page of the e-commerce application")
	public void i_am_in_landing_page_of_the_e_commerce_application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
	WebElement loginButton=	driver.findElement(By.className("login"));
	loginButton.click();
		
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
		
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	   WebElement email= driver.findElement(By.id("email"));
	   email.sendKeys("kodo.search@test.com");
	   
	   WebElement password=driver.findElement(By.id("passwd"));
	   password.sendKeys("Bamli@8492");
	   
	   WebElement login_Button=driver.findElement(By.id("SubmitLogin"));
	   login_Button.click();
	}

	@Then("I should be taken to home page as logged in user")
	public void i_should_be_taken_to_home_page_as_logged_in_user() {
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		System.out.println("Logged in successfully");
		WebElement logo=driver.findElement(By.id("header_logo"));
		logo.click();
		System.out.println("Landed on home page again");
	   driver.close();
	}
	
	@Given("I am in landing page of the application")
	public void i_am_in_landing_page_of_the_application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		WebElement loginButton=	driver.findElement(By.className("login"));
		loginButton.click();
		
	}

	@Given("Logged in as existing customer")
	public void logged_in_as_existing_customer() {
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		   WebElement email= driver.findElement(By.id("email"));
		   email.sendKeys("kodo.search@test.com");
		   
		   WebElement password=driver.findElement(By.id("passwd"));
		   password.sendKeys("Bamli@8492");
		   
		   WebElement login_Button=driver.findElement(By.id("SubmitLogin"));
		   login_Button.click();
		   
		   driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
			System.out.println("Logged in successfully");
			WebElement logo=driver.findElement(By.id("header_logo"));
			logo.click();
			System.out.println("Landed on home page again");
	}

	@Given("searched for a product from search box")
	@When("I enter a product name in search box")
	public void i_enter_a_product_name_in_search_box() {
	   WebElement searchBox=driver.findElement(By.id("search_query_top"));
	   searchBox.sendKeys("Printed dress");
	   
	   WebElement searchButton=driver.findElement(By.name("submit_search"));
	   searchButton.click();
	   
	}

	@Then("Results are displayed on search page")
	public void results_are_displayed_on_search_page() {
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement searchResult=driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div"));
				if(searchResult.isDisplayed()) {
			System.out.println("Product is searched");
		}
		else {
			System.out.println("Searched product was not available");
		}
				
	    driver.quit();
	}
	
	@When("Product is searched from search box")
	public void product_is_searched_from_search_box() {
			WebElement searchBox=driver.findElement(By.id("search_query_top"));
		   searchBox.sendKeys("Printed dress");
		   
		   WebElement searchButton=driver.findElement(By.name("submit_search"));
		   searchButton.click();
		   driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		   
		   WebElement view=driver.findElement(By.xpath("//*[@id=\'list\']/a/i"));
		   view.click();
		   view.click();
	}

	@When("Add to cart button is pressed")
	public void add_to_cart_button_is_pressed() {
		
		Actions action=new Actions(driver);
		WebElement product=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]"));
	   action.moveToElement(product).perform();
	   
		WebElement addButton=driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div[2]/div[2]/a[1]"));
	   addButton.click();
	}

	@Then("Item should be added to users cart")
	public void item_should_be_added_to_users_cart() {
	    WebElement popUp=driver.findElement(By.id("layer_cart"));
	    if(popUp.isDisplayed()) {
	    	System.out.println("Item is added to cart");
	    }
	    else {
	    	System.out.println("Not added to cart");
	    }
	    driver.quit();
	}
	
	@When("first products image is clicked")
	public void first_products_image_is_clicked() {
		
//		WebElement P1=driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div/div[1]/div/a[1]/img"));
//		if(P1.isDisplayed()) {
//			P1.click();
//		}
//		else {
	    WebElement product=driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[2]/div/div[1]/div/a[1]/img"));
	    product.click();
//		}
	}

	@Then("Product description page for item is displayed")
	public void product_description_page_for_item_is_displayed() {
	   String pageURL=driver.getCurrentUrl();
	   
	   String expectedURL="http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Printed+dress&submit_search=";
		
	   if(pageURL.equalsIgnoreCase(expectedURL)) {
		   System.out.println("Product Page is not opened");
	   }
	   else {
		   System.out.println("PDP is opened");
	   }
	   driver.close();
	}

	@When("invalid product is searched from search box")
	public void invalid_product_is_searched_from_search_box() {
		WebElement searchBox=driver.findElement(By.id("search_query_top"));
		   searchBox.sendKeys("XYZ");
		   
		   WebElement searchButton=driver.findElement(By.name("submit_search"));
		   searchButton.click();
	}

	@Then("an error message is displayed indicating about wrong product")
	public void an_error_message_is_displayed_indicating_about_wrong_product() {
	   WebElement error=driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
	   if(error.isDisplayed()) {
		   System.out.println("No Product was searched");
	   }
	   else {
		   System.out.println("Product was valid");
	   }
	   driver.quit();
	   
	}

	@When("Add to compare button is pressed for dispayed item")
	public void add_to_compare_button_is_pressed_for_dispayed_item() {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Actions action=new Actions(driver);
		WebElement product=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]"));
	   action.moveToElement(product).perform();
	   
	   WebElement compare1=driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div[3]/div[2]/a"));
	   compare1.click();
	}

	@When("Another item is selected for compare")
	public void another_item_is_selected_for_compare() {
		Actions action=new Actions(driver);
		WebElement product1=driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[2]/div/div[1]/div/a[1]/img"));
	   action.moveToElement(product1).perform();
	   
	   WebElement compare2=driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[2]/div/div[3]/div[2]/a"));
	   compare2.click();
	   
	   WebElement compareButton=driver.findElement(By.xpath("//*[@id=\'center_column\']/div[1]/div[2]/form/button"));
	   compareButton.submit();
	   
	}

	@Then("Compare reult page is displayed with both products")
	public void compare_reult_page_is_displayed_with_both_products() {
	    WebElement comparePage=driver.findElement(By.xpath("//*[@id=\'columns\']/div[1]/span[2]"));
	    if(comparePage.isDisplayed()) {
	    	System.out.println("We are on compare page");
	    }
	    else {
	    	System.out.println("Compare page was not opened");
	    }
	    driver.quit();
	}

	@When("Sort By drop down is selected")
	public void sort_By_drop_down_is_selected() {
	    Select sort=new Select(driver.findElement(By.id("selectProductSort")));
	}

	@When("lowest option is clicked")
	public void lowest_option_is_clicked() {
		 Select sortProduct=new Select(driver.findElement(By.id("selectProductSort")));
		 sortProduct.selectByIndex(1);
	}

	@Then("product having lowest price is diplayed first")
	public void product_having_lowest_price_is_diplayed_first() {
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	    driver.quit();
	}


@When("Seaerch result is displayed")
public void seaerch_result_is_displayed() {
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	WebElement searchResult=driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div"));
			if(searchResult.isDisplayed()) {
		System.out.println("Product is searched");
	}
	else {
		System.out.println("Searched product was not available");
	}
}

@When("Application logo is clicked")
public void application_logo_is_clicked() {
	WebElement logo=driver.findElement(By.id("header_logo"));
	logo.click();
}

@When("User is navigated back to home page")
public void user_is_navigated_back_to_home_page() {
    String currentURL=driver.getCurrentUrl();
    
    String homeURL="http://automationpractice.com/index.php";
    if(currentURL.contentEquals(homeURL)) {
    	System.out.println("We are on home page URL");
    }
    else {
    	System.out.println("We are not in home page URL");
    }
    driver.quit();
}

}
