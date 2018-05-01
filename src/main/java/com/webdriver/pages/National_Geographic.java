package com.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.repository.Locators;

public class National_Geographic {

	public WebDriver driver;
	String[][] tabArray;
	String duplicateMovie=null;
	
	@FindBy(how = How.XPATH, using = Locators.NATIONAL_GEOGRAPHIC)
	public WebElement nationalgeo;
	
	public National_Geographic(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String moviesVerify(String movie) throws InterruptedException {
		
		PageFactory.initElements(driver, this);
			
		java.util.List<WebElement> links = driver.findElements(By.className("Tile_info_28rKd"));// MovieTile_titleText_1Q4bx
	
		
		for (int i = 0; i<=links.size()-1; i=i+1)

		{ 
			

			if(movie.equals(links.get(i).getText()))
			{
				System.out.println("Movie is duplicate");
				duplicateMovie= movie;

			}
			
		}
		
        return duplicateMovie;
		
		}
	
	    public void  nationalGeographicClick()   {
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(nationalgeo)).click();
	
		}

}
