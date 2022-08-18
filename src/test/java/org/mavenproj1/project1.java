package org.mavenproj1;

import java.io.IOException;
import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class project1 extends BaseClass{
	public static void main(String[] args) throws IOException {
		browserLaunch();
		maxWindow();
	    launchUrl("https://www.facebook.com"); 
	    getPageTitle();
		getCurrentPageUrl();
		WebElement email = driver.findElement(By.id("email"));
		
	    pasTxt("selenium", email);
        WebElement pass = driver.findElement(By.name("pass"));
        pasTxt("1234", pass);
        WebElement login = driver.findElement(By.name("login"));
        log(login);
        okAlert();
        confirmAlert();
       promptAlert("rtyui");
       takeScreenShot("C:\\Users\\Mohan\\eclipse-workspace\\Dayfour\\screenshot//amazon.png");
       javaScriptExescrup(login);
       WebElement tabletext= driver.findElement(By.xpath("//table[@id='customer']']"));
      particularData(tabletext, 0, 2);
     
     WebElement month = driver.findElement(By.id("month"));
     javaScriptExesendkey(login," pri@gmail.com");
  selectVal(month, "11");
   selectIndex(month, 8);  
     
     
     
     
     
     
	}
}
	
	