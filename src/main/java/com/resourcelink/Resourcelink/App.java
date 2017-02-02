package com.resourcelink.Resourcelink;
public class App{ 
	static int i = 0;
	public static void d(){
		i++;
		if(i<=10){
			System.out.println("p");
			if(i == 2){
				i = 0;
			}
			d();
		}
	}
	public static void main( String[] args )
	{
		d();
	}
	
	

}
