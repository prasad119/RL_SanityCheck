package com.nga.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nga.global.Global.*;

import java.util.concurrent.TimeUnit;

public class GeneralFunc {
	public static WebDriver driver = null;
	public static boolean status = true;
	public static boolean launchApplication(String url){
		try{
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(delay180, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			if(!driver.getCurrentUrl().equalsIgnoreCase(url)){
				status = false;
				return status;
			}
			return status;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean isElementExists(By element) {
		try {
			driver.findElement(element);
		} catch (NoSuchElementException e) {
			System.out.println("The status of the element "+element+" is "+status);
			status = false;
		}
		return status;		
	}
	
	public static boolean waitForElementPresent(By element){
		try{
			new WebDriverWait(driver, delay180).until(ExpectedConditions.presenceOfElementLocated(element));
			return status;
		}
		catch(NoSuchElementException e){
			status = false;
			System.out.println("The status of the element "+element+" is "+status);
		}
		return status;
	}
	
	public static boolean closeBrowser(){
		try{
			Thread.sleep(delay10);
			driver.close();
			driver.quit();
		}
		catch(Exception e){
			e.printStackTrace();
			status = false;
		}
		return status;
	}
	public static boolean inputText(By element, String text){
		try{
			WebElement elementl = null;
			status = waitForElementPresent(element);
			if(status){
				elementl = driver.findElement(element);
				elementl.sendKeys(text);
				Thread.sleep(delay1);
				elementl.click();
				
			}
			return status;
		}
		catch(Exception e){
			System.out.println("The status of the element "+element+" is "+status);
			status = false;
		}
		return status;
	}
	public static boolean clickButton(By element){
		try{
			status = waitForElementPresent(element);
			if(status){
				WebElement elementToClick = driver.findElement(element);
				elementToClick.click();
				return status;
			}
		}
		catch(Exception e){
			System.out.println("The status of the element "+element+" is "+status);
			status = false;
		}
		return status;
	}
	public static boolean waitForElementVisible(By element){
		try{
			new WebDriverWait(driver, delay180).until(ExpectedConditions.visibilityOfElementLocated(element));
		}
		catch(NoSuchElementException e){
			System.out.println("The status of the element "+element+" is "+status);
			status = false;
		}
		return status;
	}
	public static boolean switchFrame(boolean statuss){
		try{
			if(statuss != false){
				driver.switchTo().defaultContent();				
			}
			else{
				WebElement frameElement = driver.findElement(By.xpath("//iframe[contains(@id,'_iframe')]"));
				driver.switchTo().frame(frameElement);
			}
		}
		catch(NoSuchFrameException e){
			e.printStackTrace();
			status = false;
		}
		return status;
	}
}
