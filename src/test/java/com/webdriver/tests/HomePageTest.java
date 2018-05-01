package com.webdriver.tests;

import java.awt.Scrollbar;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webdriver.pages.AllShows;
import com.webdriver.pages.ExcelDriven;
import com.webdriver.pages.FoxSports;
import com.webdriver.pages.FxPage;
import com.webdriver.pages.HomePage;
import com.webdriver.pages.Login;
import com.webdriver.pages.National_Geographic;
import com.webdriver.pages.Shows;
import com.webdriver.repository.Locators;
import com.webdriver.utils.TestBase;

public class HomePageTest extends TestBase {
	
	public static WebDriver driver;
	public static String[][] datafx=new String[4][1];
	public static String[][] dataFoxSports=new String[4][1];
	public static String[][] dataNationalGeo=new String[4][1];
	public static String[][] dataAllShows=new String[4][1];
	
	public static int row=0;
	
	@Test(testName = "TC-1",priority=1,enabled=true)
	public void initialize() throws IOException, InterruptedException
	{
		//Initialize
		driver=initializeDriver();
		
		
		//Login Button click
		String Username=prop.getProperty("UserName");
		String Password="Password";
		
		Login signin=new Login(driver);
		signin.LoginClick(Username, Password);
		
		driver.close();
		
		driver=initializeDriver();

		//Shows Button click
		HomePage page = new HomePage(driver);
		page.showsClick();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    Thread.sleep(3000);
	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,40000)");
		Thread.sleep(8000);
		
	}
	
	@Test(testName = "TC-2",priority=2,enabled=true)
	public void updateDataMovies() throws IOException, InterruptedException
	{
		String xlsFilePath=prop.getProperty("xlsFilePath");
		String Sheetname="Sheet1";
		Shows sh=new Shows(driver);
	    String[][] obj=sh.movies();
		ExcelDriven excel=new ExcelDriven();
		excel.updateXLSRow(xlsFilePath, Sheetname, obj);
		
	}
	
	@Test(testName = "TC-3",priority=3,enabled=true)
	public void fxPage() {
		//fx button click
		Shows sh=new Shows(driver);
		sh.fxClick();
		
	}
	
	@Test(testName = "TC-4",priority=4,enabled=true,dataProvider = "getData")
    public void testDataFx(String movie) throws InterruptedException {
		
		FxPage fx=new FxPage(driver);
		String str=fx.moviesVerify(movie);
		
		int col=0;
		if(str!=null)
		{
			datafx[row][col]=str;
			row++;
			System.out.println("FxArray"+str+row);
		
		}
		
    }
	
	@Test(testName = "TC-5",priority=5,enabled=true)
	public void duplicateFx()
	{
		if(datafx[0][0]!=null)
		{	
		String xlsFilePath=prop.getProperty("xlsFilePathnew");
		String Sheetname="Sheet2";
		ExcelDriven excel=new ExcelDriven();
		excel.updateXLSRow(xlsFilePath, Sheetname, datafx);
		}
		else {
			System.out.print("Fx tab has no duplicate movies");
		}
		
	}
	
	@Test(testName = "TC-6",priority=6,enabled=true)
	public void foxSportsPage() {
		//foxSports button click
		FoxSports fs=new FoxSports(driver);
		fs.foxSportsClick();
		
	}
	
	@Test(testName = "TC-7",priority=7,enabled=true,dataProvider = "getData")
    public void testDataFoxSports(String movie) throws InterruptedException {
		
		FoxSports fs=new FoxSports(driver);
		String str=fs.moviesVerify(movie);
		
		int col=0;
		if(str!=null)
		{
			dataFoxSports[row][col]=str;
			row++;
			System.out.println("FoxSportsArray"+str+row);
		
		}
		
    }
	
	@Test(testName = "TC-8",priority=8,enabled=true)
	public void duplicateFoxSports()
	{
		if(dataFoxSports[0][0]!=null)
		{	
		String xlsFilePath=prop.getProperty("xlsFilePathnew");
		String Sheetname="Sheet3";
		ExcelDriven excel=new ExcelDriven();
		excel.updateXLSRow(xlsFilePath, Sheetname, dataFoxSports);
		}
		else {
			System.out.print("FoxArray tab has no duplicate movies");
		}
		
	}
	
	@Test(testName = "TC-9",priority=9,enabled=true)
	public void nationalGeographicPage() {
		//Nayional Geographic button click
		National_Geographic ng=new National_Geographic(driver);
		ng.nationalGeographicClick();
		
	}
	
	@Test(testName = "TC-10",priority=10,enabled=true,dataProvider = "getData")
    public void testDataNationalGeographic(String movie) throws InterruptedException {

		National_Geographic ng=new National_Geographic(driver);
		String str=ng.moviesVerify(movie);
		
		int col=0;
		if(str!=null)
		{
			dataNationalGeo[row][col]=str;
			row++;
			System.out.println("National Geo Array"+str+row);
		
		}
		
    }
	
	@Test(testName = "TC-11",priority=11,enabled=true)
	public void duplicateNationalGeographic()
	{
		if(dataNationalGeo[0][0]!=null)
		{	
		String xlsFilePath=prop.getProperty("xlsFilePathnew");
		String Sheetname="Sheet4";
		ExcelDriven excel=new ExcelDriven();
		excel.updateXLSRow(xlsFilePath, Sheetname, dataNationalGeo);
		}
		else {
			System.out.print("National Geographic tab has no duplicate movies");
		}
		
	}



	@Test(testName = "TC-12",priority=12,enabled=true)
	public void allShowsPage() throws InterruptedException {
		//AllShows button click
		AllShows allshow=new AllShows(driver);
		allshow.allShowsClick();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    Thread.sleep(3000);
	
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    for (int second = 0;; second++) {
	            if(second >=60){
	                break;
	            }
	                jse.executeScript("window.scrollBy(0,800)", ""); //y value '800' can be altered
	                Thread.sleep(3000);
	    }
	    
		Thread.sleep(5000);
		
	}
	
	@Test(testName = "TC-13",priority=13,enabled=true,dataProvider = "getData")
    public void testDataAllShows(String movie) throws InterruptedException, IOException {

		String xlsFilePathnew=prop.getProperty("xlsFilePathnew");
		String Sheetname="Sheet1";
		AllShows allshow=new AllShows(driver);
		String str=allshow.moviesVerify(movie,Sheetname,xlsFilePathnew);
		
		
		int col=0;
		if(str!=null)
		{
			dataAllShows[row][col]=str;
			row++;
			System.out.println("DataAllShowsArray"+str+row);
		
		}
		
    }
	@Test(testName = "TC-14",priority=14,enabled=true)
	public void duplicateAllShows()
	{
		if(dataAllShows[0][0]!=null)
		{	
		String xlsFilePath=prop.getProperty("xlsFilePathnew");
		String Sheetname="Sheet1";
		ExcelDriven excel=new ExcelDriven();
		excel.updateXLSRow(xlsFilePath, Sheetname, dataAllShows);
		}
		
		
	}
	
    @DataProvider
    public static Object[][] getData() throws Exception {

    	String xlsFilePath=prop.getProperty("xlsFilePath");
		String Sheetname="Sheet1";
		ExcelDriven excel=new ExcelDriven();
        Object[][] data =excel.getCellData(xlsFilePath,Sheetname);
        return data;
    }

	

}
	
	

