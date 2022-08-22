package org.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	    public static WebDriver driver;
	    public static Actions a ;
		public static Alert alt; 
	    public static TakesScreenshot tk;  
	    public static JavascriptExecutor js;
		public static Select s;
	    //1.BROWSER LAUNCH
		public static void browserLaunch() {
		 WebDriverManager.chromiumdriver().setup();
		 driver=new ChromeDriver();	
		}
		//2.MAXIMIZE THE WINDOW
		public static void maxWindow() {
		driver.manage().window().maximize();
		}
		//WEBDRIVER METHOD 
            
        //1.getTitle()
        public static void getPageTitle() {
    	 String title = driver.getTitle();
 	     System.out.println(title);
         }
        //2.getCurrentUrl()
        public static void getCurrentPageUrl() {
	    String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
	     }
        //3.get()
        public static void launchUrl(String url) {
        driver.get(url);
         }
       //4.getWindowHandle()
        public static void getWindowHandle() {
       	 String windowHandle = driver.getWindowHandle();
    	 System.out.println(windowHandle);
         }
       //5.getWindowHandles()
        public static void getWindowHandles() {
         Set< String> windowHandles = driver.getWindowHandles();
       	 System.out.println(windowHandles);
         }
       //6.close()
        public static void webPageClose() {
        driver.close();
        }
       //7.quit()
        public static void browserQuit() {
        driver.quit();
            }
        //WEBELEMENTS METHODS 
            //1.sendKeys()
            public static void pasTxt(String text, WebElement txtbox) {
        	txtbox.sendKeys(text); 
        	 }
            //2.click()
            public static void log(WebElement txt) {
            txt.click();		
    	     } 
            //3.getText()
            public static void getText() { 
               	alt = driver.switchTo().alert();
                String txxt= alt.getText();
                System.out.println(txxt);
                }
            //4.getAttribute()
                public static void getAttribute(WebElement element, String value) {
                String attributeval = element.getAttribute(value);
                System.out.println(attributeval);
                }
    
	//ACTIONS 
                //1.moveToElement()
    public static void actionsMoveToEle(WebElement text1) {
    	a = new Actions(driver);
    	a.moveToElement(text1).perform();
    }
               //2.dragAndDrop()
    public static void actionsDragAndDrop(WebElement sourcetxt, WebElement desttxt) {
    	a = new Actions(driver);
        a.dragAndDrop(sourcetxt, desttxt).perform();
	}
               //3.doubleClick()    
    public static void actionsDoubleClk(WebElement clicktext) {
    	a = new Actions(driver);
        a.doubleClick(clicktext).perform();
    }
               //4.contextClick
    public static void actionsContextClk(WebElement contextclk) {
    	a = new Actions(driver);
        a.contextClick(contextclk).perform();
    }
    
    //ALERT 
    //1.simple alert
    public static void okAlert() { 
    	alt = driver.switchTo().alert();
    	alt.accept();   
    }
    //2.conform alert
    public static void confirmAlert() { 
    	alt = driver.switchTo().alert();
    	alt.dismiss();
    }
    //3.prompt alert
    public static void promptAlert(String alttxt) { 
    	alt = driver.switchTo().alert();
    	alt.sendKeys(alttxt);
    }
    
    //TAKE SCREEN SHOT
   	public static void takeScreenShot(String screentext) throws IOException { 
   	tk=(TakesScreenshot)driver;
    File source = tk.getScreenshotAs(OutputType.FILE); 
    File dest=new File(screentext);
    FileUtils.copyFile(source, dest);
    }	
   	
   	//JAVA SCRIPT EXECUTION
   	//1.scrolldown
    public static void javaScriptExescrup(WebElement scrollup) { 
    	js =(JavascriptExecutor)driver;
    	js.executeScript("arguments[0]scrollIntoView(true)", scrollup);
    	}
    //2.scrollup
    public static void javaScriptExescrdwn(WebElement scrolldown) { 
    	js =(JavascriptExecutor)driver;
    	js.executeScript("arguments[0]scrollIntoView(false)", scrolldown);
        }
    //3.sendKeys()
    public static void javaScriptExesendkey(WebElement ttext,String intext) { 
    	js =(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].setAttribute('value','intext')", ttext);
        }
    //4.click()
    public static void javaScriptExeclk(WebElement ttext) { 
    	js =(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()", ttext);
        }
    
    //WEBTABLE
    //TABLE COUNT
    public static void tableSize(List<WebElement> tab) {
    	System.out.println("total no of table :"+tab.size());
    }
    //Display Table Heading Only 
    public static void displayTableHeading(WebElement webEle) { 
    List<WebElement> allRows = webEle.findElements(By.tagName("tr")); 
    WebElement firstRow = allRows.get(0); 
    List<WebElement> heading = firstRow.findElements(By.tagName("th")); 
    for (int j = 0; j < heading.size(); j++) { 
    WebElement headData = heading.get(j); 
    System.out.println(headData.getText()); 
    } 
    }
    
    // DISPLAYING PARTICULAR DATA
    	
    public static void particularData(WebElement tabletext, int rowposition,int dataposition)  {
    	 
      List<WebElement> row = tabletext.findElements(By.tagName("tr"));
      WebElement rows = row.get(rowposition);
      List<WebElement> data = rows.findElements(By.tagName("td"));
      WebElement datas = data.get(dataposition);
      String texttable = datas.getText();
      System.out.println(texttable);
    
    }  
    //DISPLAY TABLE
     public static void tabledisplay (WebElement webele) { 
    	 
    	List<WebElement> allrow = webele.findElements(By.tagName("tr"));
    	for(int i=0; i<allrow.size(); i++){
    		WebElement row = allrow.get(i);
    		List<WebElement> heading = row.findElements(By.tagName("th"));
    		for(int j=0; j<heading.size(); j++) {
    			WebElement headings = heading.get(j);
    			
    			System.out.println(headings.getText());}
    		
    			List<WebElement> data = row.findElements(By.tagName("td"));
    			for (int k = 0; k < data.size(); k++) {
    				WebElement datas = data.get(k);
    				System.out.println(datas.getText());
					} 	 		
    	}
    	}
     
     //FRAMES
     //1. USING ID
     public static void frameId(String id) {
    	 driver.switchTo().frame(id);
     }
     //Name
     public static void frameName(String name) {
    	 driver.switchTo().frame(name);
     }
     //WebElement
     public static void frameWebElement(WebElement element) {
    	 driver.switchTo().frame(element);
     }
     //Using Index
     public static void frameIndex(int index) {
    	 driver.switchTo().frame(index);       	 
     }
     //parentFrame
     public static void frameParent() {
    	 driver.switchTo().parentFrame();
     }
     // defaultContent
     public static void defaultContent() {
    	 driver.switchTo().defaultContent();
     } 
  
    //SELECT
    //1.SELECT BY VALUE 
    public static void selectVal(WebElement refelement, String text1) {
	s=new Select(refelement);
	s.selectByValue(text1);
    }
    //2.SELECT BY INDEX
	public static void selectIndex(WebElement refelement,int value1) {
	s=new Select(refelement);
	s.selectByIndex(value1);
	}
	//3.SELECT BY VISIBLE TEXT
	public static void selectvis(WebElement refelement,String valuevisible) {
	s=new Select(refelement);
	s.selectByVisibleText(valuevisible);
	}
	//4.ISMULTIPLE
	public static void multi(WebElement refelement) {
		s=new Select(refelement);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}
	//5.getALLSelectedOptions()
	public static void allSelectOptions(WebElement refelement) {
		s=new Select(refelement);
		s.getAllSelectedOptions();
		}
	//6.getOptions()
	public static void allOptions(WebElement refelement) {
		s=new Select(refelement);
		s.getOptions();
		}
	//7.getFirstSelectedOption()
	public static void getFirst(WebElement refelement) {
		s=new Select(refelement);
		s.getFirstSelectedOption();
		}
	//8.deselectByValue()
	public static void deselectval(WebElement refelement, String txt) {
		s=new Select(refelement);
		s.deselectByValue(txt);
		}
	//9.deselectByIndex()
	public static void deselectindx(WebElement refelement, int index) {
		s=new Select(refelement);
		s.deselectByIndex(index);
		}
	//10.deselectByVisibleText()
	public static void deselectindx(WebElement refelement, String txt) {
		s=new Select(refelement);
		s.deselectByVisibleText(txt);
		}
	//11.deselectAll()
	public static void deselectindx(WebElement refelement) {
		s=new Select(refelement);
		s.deselectAll();
		}
	//WAITS
	//1.ImplicitWait
	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
	}
	//2.ExplicitWait
	//alertIsPresent Wait
	public static void alertIsPresentWait(long sec) {
		WebDriverWait w=new WebDriverWait(driver,sec);
		w.until(ExpectedConditions.alertIsPresent());
	}
	//3.fluent wait
	//invisibilityOf()
	public static void fluentMilliSec(long milliSec,long pollingSec,WebElement element) {
	FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(milliSec)).
			pollingEvery(Duration.ofMillis(pollingSec)).ignoring(Throwable.class);
	f.until(ExpectedConditions.invisibilityOf(element));
	}
	//alertIsPresent()
	public static void fluentSec(long sec,long pollingSec) {
	FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).
			pollingEvery(Duration.ofSeconds(pollingSec)).ignoring(Throwable.class);
	f.until(ExpectedConditions.alertIsPresent());
	} 
	private void priya() {
		System.out.println("priya");
		System.out.println("Test1");
	}
}
  
    
    
    
    
    
    
    
     
