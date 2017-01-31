package com.nga.resourcelink;

import static com.nga.util.GeneralFunc.*;
import static com.nga.util.AppFunc.*;
import static com.nga.global.Global.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TC {
	@Test
	public static void f(){
		try{
			doSanityCheck();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@AfterTest
	public static void close(){
		logoutResourceLink();
	}	
	@BeforeTest
	public static void ff(){
		launchApplication(rlURL);
		loginToResourceLink(userName, passWord);
	}
}
