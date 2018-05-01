package com.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FxPage {

	public WebDriver driver;
	String[][] tabArray;
	String duplicateMovie=null;
	
	public FxPage(WebDriver driver)
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
		
		
		String[][] data=new String[4][1];

return duplicateMovie;
		
		}

}
