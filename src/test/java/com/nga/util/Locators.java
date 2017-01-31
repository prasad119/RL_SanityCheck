package com.nga.util;

import org.openqa.selenium.By;

public class Locators {
	public static class TextBox{
		public static final By LOGIN_USERNAME_TEXTBOX = By.xpath("//input[@id='j_username']");
		public static final By LOGIN_PASSWORD_TEXTBOX = By.xpath("//input[@id='j_password']");
	}
	public static class Button{
		public static final By LOGIN_SIGNIN_BUTTON = By.xpath("//input[@id='doLogin']");
		public static final By HOME_TAB_BUTTON = By.xpath("//div[@widgetid='aurora_widgets__TabButton_1']//div[@class='dijitTabContent dijitLayoutContainer']");
		public static final By SQL_ERROR_OK_BUTTON = By.xpath("//span[contains(text(),'366 - SQL ERROR: ')]//ancestor::div//input[@value='OK']");
		public static final By PAGE_FORCE_CLOSE_BUTTON = By.xpath("//span[text()='Force close']");
	}
	public static class Links{
		public static final By HOME_SIGNOUT_LINK = By.xpath("//a[text()='sign out']");
		public static final By NEW_STARTER_CLOSE_LINK = By.xpath("//span[text()='New Starter']/..//img[@class='closeImage']");
	}
	public static class ComboBox{
		public static final By FASTPATH_COMBO = By.xpath("//div[@class='fastPathHolder']//div[contains(@class,'fastPathInput')]");
	}
	public static class Dialog{
		public static final By SQL_ERROR_DIALOG = By.xpath("//span[contains(text(),'366 - SQL ERROR: ')]");
		public static final By AUTO_ROLLBACK_DIALOG = By.xpath("//div[text()='Automatic Rollback Alert']");
	}
	public static class Label{
		public static final By HRPAYNEW_EMPLOYEENO_LABEL = By.xpath("//span[text()='Employee Number']");
	}
}
