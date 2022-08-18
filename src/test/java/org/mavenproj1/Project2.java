package org.mavenproj1;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Project2 extends BaseClass {

	public static void main(String[] args) {
		browserLaunch();
		maxWindow();
        launchUrl("https://www.flipkart.com");
        getPageTitle();
        WebElement movtoele = driver.findElement(By.xpath("//div[text()='Electronics']"));
        actionsMoveToEle(movtoele);
        
        }

}
