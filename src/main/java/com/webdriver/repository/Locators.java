package com.webdriver.repository;

public class Locators {

	//Login Locators 
	public static final String Login_Tab = "//*[@id='path-1']"; //xpath
	public static final String Account_Sign_in =".Account_signIn_Q0B7n"; //cssSelector
	public static final String User_Name = "//input[@name='signinEmail']"; //xpath
	public static final String Password = "//input[@name='signinPassword']"; //xpath
	public static final String Sign_In_Tab =".Account_signinButtonDesktop_2SO1g > button:nth-child(1)";//cssSelector 
		
	//HomePage Locators
	public static final String SHOWS = "//a[contains(@href,'/shows/')]";// xpath
	
	//Shows Locators
	public static final String FX = "//*[@class='PageHeaderBrowse_tab_19aN7 PageHeaderBrowseAltHeader_tab_2Lzol' and text()='FX']";// xpath
	
	//National Geographic Locators
	public static final String NATIONAL_GEOGRAPHIC = "//*[@class='PageHeaderBrowse_tab_19aN7 PageHeaderBrowseAltHeader_tab_2Lzol' and text()='National Geographic']";// xpath

	//Fox Sports Locators
	public static final String FOX_SPORTS = "//*[@class='PageHeaderBrowse_tab_19aN7 PageHeaderBrowseAltHeader_tab_2Lzol' and text()='FOX Sports']";// xpath

	//AllShows class locator
	public static final String ALLSHOWS = "//*[@class='PageHeaderBrowse_tab_19aN7 PageHeaderBrowseAltHeader_tab_2Lzol' and text()='All Shows']";// xpath
		
	

}
