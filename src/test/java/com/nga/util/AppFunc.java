package com.nga.util;

import static com.nga.util.GeneralFunc.*;
import static com.nga.util.Locators.TextBox.*;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import static com.nga.util.Locators.Button.*;
import static com.nga.util.Locators.Links.*;
import static com.nga.util.Locators.ComboBox.*;
import static com.nga.util.Locators.Label.*;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.nga.global.Global.*;

public class AppFunc {
	public static boolean status = true;
	private static boolean sqlStatus = true;
	private static boolean forceCloseStatus = true;
	public static boolean loginToResourceLink(String userName, String passWord){
		try{
			status = waitForElementPresent(LOGIN_USERNAME_TEXTBOX);
			if(!status){
				Assert.fail();
			}
			inputText(LOGIN_USERNAME_TEXTBOX, userName);
			inputText(LOGIN_PASSWORD_TEXTBOX, passWord);
			clickButton(LOGIN_SIGNIN_BUTTON);
			status = waitForElementVisible(HOME_SIGNOUT_LINK);
			if(!status){
				Assert.fail();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			status = false;
		}
		return status; 
	}

	public static void goToScreen(String screen){
		try{
			String [] splitValue = screen.split("#");
			Stream<String> screensStream = Arrays.stream(splitValue);
			screensStream.forEach(screenValue -> {clickButton(By.xpath("//div[contains(text(),'"+screenValue+"')]"));});
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static boolean logoutResourceLink(){
		try{
			status = waitForElementVisible(HOME_SIGNOUT_LINK);
			if(!status){
				Assert.fail();
			}
			clickButton(HOME_SIGNOUT_LINK);
			status = waitForElementVisible(LOGIN_SIGNIN_BUTTON);
			if(!status){
				Assert.fail();
			}
			closeBrowser();
		}
		catch(Exception e){
			e.printStackTrace();
			status = false;
		}
		return status;
	}

	public static boolean doSanityCheck(){
		try{
			status = waitForElementVisible(HOME_TAB_BUTTON);
			if(!status){
				Assert.fail();
			}
			clickButton(HOME_TAB_BUTTON);
			status = waitForElementVisible(FASTPATH_COMBO);
			if(!status){
				Assert.fail();
			}
			goToScreen(HRPAYNEW);
			switchFrame(true);
			switchFrame(false);
			status = waitForElementVisible(HRPAYNEW_EMPLOYEENO_LABEL);
			if(status){
				switchFrame(true);
				Thread.sleep(delay10);
				clickButton(NEW_STARTER_CLOSE_LINK);
				JOptionPane.showMessageDialog(null, "Sanity already Done for this Environment");
			}
			else{
				status = waitForElementVisible(SQL_ERROR_OK_BUTTON);
				if(!status){
					Assert.fail();
				}
				do{
					clickButton(SQL_ERROR_OK_BUTTON);
					sqlStatus = isElementExists(SQL_ERROR_OK_BUTTON);}
				while(sqlStatus != true);
				if(sqlStatus != true){
					do{
						clickButton(NEW_STARTER_CLOSE_LINK);
						forceCloseStatus = isElementExists(PAGE_FORCE_CLOSE_BUTTON);}
					while(forceCloseStatus != true);
				}
				JOptionPane.showMessageDialog(null, "Sanity check Done for this Environment");
				doSanityCheck();
			}
			

		}
		catch(Exception e){
			e.printStackTrace();
			status = false;
		}
		return status;
	}

}
