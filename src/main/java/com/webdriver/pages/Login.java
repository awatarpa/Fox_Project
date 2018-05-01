package com.webdriver.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.repository.Locators;

public class Login {
	

	public WebDriver driver;
	@FindBy(how = How.XPATH, using = Locators.Login_Tab)
	public WebElement logintab;
	@FindBy(how = How.CSS, using = Locators.Account_Sign_in)
	public WebElement signin;
	@FindBy(how = How.XPATH, using = Locators.User_Name)
	public WebElement username;
	@FindBy(how = How.XPATH, using = Locators.Password)
	public WebElement password;
	@FindBy(how = How.CSS, using = Locators.Sign_In_Tab)
	public WebElement signin_tab;
		

	public Login(WebDriver driver)
	{
			this.driver=driver;
	}
		

	public void LoginClick(String Username,String Password )   {
	PageFactory.initElements(driver, this);
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(logintab)).click();
	wait.until(ExpectedConditions.elementToBeClickable(signin)).click();
	username.sendKeys(Username);
	password.sendKeys(Password);
	
	wait.until(ExpectedConditions.elementToBeClickable(signin_tab)).click();
		

	}

}
