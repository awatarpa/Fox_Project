package com.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.webdriver.repository.Locators;

public class Shows {

public WebDriver driver;
String[][] tabArray;
	
@FindBy(how = How.XPATH, using = Locators.FX)
public WebElement fx;

	public Shows(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String[][] movies() throws InterruptedException {
	PageFactory.initElements(driver, this);
	
	java.util.List<WebElement> links = driver.findElements(By.className("Tile_info_28rKd"));// MovieTile_titleText_1Q4bx
	
	System.out.println("length:"+links.size());
	
	int size = links.size()-1;
	int limit = size - 3;
	

	String[][] data=new String[4][1];
	int row=0;
	int col=0;
	
	for (int i=limit; i<=size; i=i+1)

	{
		String str=links.get(i).getText();
		data[row][col]=str;
		System.out.println(data[row][col]);
		row++;

	}

	
	return data;

	}
	
	public void fxClick()   {
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(fx)).click();
		
		
	}

}
