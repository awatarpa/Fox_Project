package com.webdriver.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.webdriver.repository.Locators;

public class AllShows {

	public WebDriver driver;
	String[][] tabArray;
	String duplicateMovie=null;
	
	@FindBy(how = How.XPATH, using = Locators.ALLSHOWS)
	public WebElement allshows;
	
	public AllShows(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String moviesVerify(String movie, String sheetname, String xlsFilePathnew) throws InterruptedException, IOException {
		PageFactory.initElements(driver, this);
		
		
		java.util.List<WebElement> links = driver.findElements(By.className("Tile_info_28rKd"));// MovieTile_titleText_1Q4bx
		
		
		System.out.println("length:"+links.size());
		
		
		for (int i = 0; i<=links.size()-1; i=i+1)

		{ 
			

			if(movie.equals(links.get(i).getText()))
			{

			    System.out.println("Movie is duplicate"+movie);
			    duplicateMovie=movie;
				
	         }	
				
        }
			

		return duplicateMovie;
		

		}

	    public void allShowsClick()   {
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(allshows)).click();    
	
}
}
