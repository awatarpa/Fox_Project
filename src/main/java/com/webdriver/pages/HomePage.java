package com.webdriver.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.webdriver.repository.Locators;
import com.webdriver.utils.TestBase;

public class HomePage {
public WebDriver driver;

	
	@FindBy(how = How.XPATH, using = Locators.SHOWS)
	public WebElement showsbtn;
	

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void showsClick()   {
	PageFactory.initElements(driver, this);
	WebDriverWait wait = new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(showsbtn)).click();;
	
	
	}

	
}
