package academy;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test {

			//Declaracion de Variables
			static WebDriver driver;
			static JavascriptExecutor js = (JavascriptExecutor) driver;
			String region = "Me";
			
			public static void main(String[] args) throws InterruptedException, IOException {
				// TODO Auto-generated method stub
				browser("chrome");

			}
	@SetBrowser	
	public static void browser(String browser) throws InterruptedException, IOException
	{
		switch (browser) {
			case "firefox":
				System.setProperty("webdriver.Gecko.driver", "C:\\geckodriver.exe");
				driver= new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.Gecko.driver", "C:\\chromedriver.exe");
				driver= new ChromeDriver();
				break;
			case "opera":
				System.setProperty("webdriver.Gecko.driver", "C:\\operadriver.exe");
				driver= new OperaDriver();
				break;
		}
		Ejecuta();
				
	}
	public static void Ejecuta() throws InterruptedException, IOException
	{
		//nos dirijimos a la pagina
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				//buscamos el elemento "search" y lo guardamos en una variable Webelement
				 driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Me");
				 Thread.sleep(500);
				 driver.findElement(By.xpath("//div[@id='ui-id-7']")).click();
				
				 driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/fieldset[1]/select[1]")).click();
				 Select options = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/fieldset[1]/select[1]")));			
				 options.selectByValue("option1");
				Thread.sleep(600);
				 driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/fieldset[1]/select[1]")).sendKeys(Keys.ESCAPE);
				 driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/fieldset[1]/select[1]")).click();	
				 Thread.sleep(600);
				 options.selectByValue("option2");
				 driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/fieldset[1]/select[1]")).sendKeys(Keys.ESCAPE);

				 buscaTablaIngenieros("//div[@class='tableFixHead']//table[@id='product']//tbody");
				 //Entra al Iframe
				 driver.switchTo().frame("courses-iframe");
				 
				 System.out.println(driver.findElement(By.xpath("//li[contains(text(),'His mentorship program is most after in the softwa')]")).getText());
				 //Sale al frame principal
				    driver.switchTo().defaultContent();
				//div[@class='left-align']//table[@id='product']
				 
				 
				 
				 driver.findElement(By.id("openwindow")).click();
			
				 
				 // Store the current window handle
				 String winHandleBefore = driver.getWindowHandle();

				 // Perform the click operation that opens new window

				 // Switch to new window opened
				 for(String winHandle : driver.getWindowHandles()){
				     driver.switchTo().window(winHandle);
				 }
                Thread.sleep(500);
				 // Perform the actions on new window
				 try{
String[] frases = {"30 day Money Back Guarantee","SELF PACED ONLINE TRAINING","IN DEPTH MATERIAL","LIFETIME INSTRUCTOR SUPPORT","RESUME PREPARATION"};
						
	for (int i = 0; i <frases.length; i ++)
	{
			driver.findElement(By.xpath("//*[text()='"+frases[i]+"']"));
			System.out.println("Elemento encontrado: "+frases[i]);
	}
						//driver.findElement(By.xpath("//*[text()='30 day Money Back Guarantee']"));
			       }

			        catch (Exception e)
				 		{ 
			        	System.out.println("Error en paso 4 TC-ID:nw-dp1 Elemento no encontrado");
			        	}

				 // Close the new window, if that window no more required
				 driver.close();
				 driver.switchTo().window(winHandleBefore);
				 
				 
				 driver.findElement(By.xpath("//a[@id='opentab']")).click();
				 //switch tab
				 String originalTab = driver.getWindowHandle();
				 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				
				   driver.switchTo().window(tabs.get(1));
				 
				 //definimos el webelement para hacer scroll
				   Thread.sleep(6000);
				 WebElement element =  driver.findElement(By.cssSelector(".btn.btn-primary.view-all-courses-btn"));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
				 Thread.sleep(500); 

				
				 //hacemos screenshot
				 tomaScreenshot(driver,"C://nt-dp1.png");
				   driver.switchTo().window(tabs.get(0));
				   
				   driver.findElement(By.cssSelector("#name")).sendKeys("Stori Card");
				   driver.findElement(By.cssSelector("#alertbtn")).click();
				   Alert alert = driver.switchTo().alert();
				  System.out.println(alert.getText());
				  Thread.sleep(2000);
				  alert.accept();
				  
				   driver.findElement(By.cssSelector("#name")).sendKeys("Stori Card");
				   
				   driver.findElement(By.cssSelector("#confirmbtn")).click();
				   if (alert.getText().equals("Hello Stori Card, Are you sure you want to confirm?"))
				   {
						  System.out.println("El texto coincide con "+ alert.getText());

				   }
				   else {
						  System.out.println("El texto no coincide Paso 6 fallido " +alert.getText());

				   }
					  Thread.sleep(2000);
					  alert.accept();
					  
						 buscaTabla( "//div[@class='left-align']//table[@id='product']");
				//WebDriverWait wait = new WebDriverWait(driver,30);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-close")));
			    //driver.findElement(By.cssSelector(".icon-close")).click();
		        
			    //bajamos
			    //js.executeScript("window.scrollBy(0,1000)");
				//Thread.sleep(5000);//
		//selecionamos el primer articulo
				//driver.findElement(By.xpath("//div[@class='item-url item-n-1 first_item_gaia_page_1']//img[1]")).click();
				
				//Agregamos el producto al carrito
				Thread.sleep(6000);//
				driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
				Thread.sleep(5000);//
		//Vamos a la pagina de carrito
				driver.findElement(By.xpath("//span[text()='Ver carrito']")).click();
				
	}
	public static void tomaScreenshot(WebDriver _driver,String nombreArchivo) throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)_driver);
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                File DestFile=new File(nombreArchivo);
                FileHandler.copy(SrcFile, DestFile);
	}
	
	public static void buscaTabla(String headerLoc)
	{
//		 WebElement table = driver.findElement(By.xpath("//table[@id='product']"));

		
	List<WebElement> allHeadersEle = driver.findElements(By.xpath(headerLoc));
	List<String> allHeaderNames = new ArrayList<String>();
	for (WebElement header : allHeadersEle) {
		String headerName = header.getText();
		allHeaderNames.add(headerName);
	}
	
	
	List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();

//total de columnas
	String rowLoc = headerLoc+"//tr";
	List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
	// empeszamos a buscar los rows

	for (int i = 2; i <= allRowsEle.size(); i++) {
		
		String specificRowLoc = headerLoc+"//tr["+ i +"]";
				List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc))
				.findElements(By.tagName("td"));
		
		LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
		//buscamos por celda
		for (int j = 0; j < allColumnsEle.size(); j++) {
			
			String cellValue = allColumnsEle.get(j).getText().toString();
			
			if (cellValue.equals("25"))
			{
			eachRowData.put(allColumnsEle.get(j-1).getText(), cellValue);
			allTableData.add(eachRowData);
			}
		}		

	}
System.out.println(allTableData.size()+" Elementos tienen el costo de 25");
	System.out.println(allTableData);
	}
	public static void buscaTablaIngenieros(String headerLoc)
	{
//		 WebElement table = driver.findElement(By.xpath("//table[@id='product']"));

		

	
	
	List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();

//total de columnas
	String rowLoc = headerLoc+"//tr";
	List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
	// empeszamos a buscar los rows

	for (int i = 1; i < allRowsEle.size(); i++) {
		
		String specificRowLoc = headerLoc+"//tr["+ i +"]";
				List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc))
				.findElements(By.tagName("td"));
		
		LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
		//buscamos por celda
		for (int j = 0; j < allColumnsEle.size(); j++) {
			
			String cellValue = allColumnsEle.get(j).getText().toString();
			if (cellValue.equals("Engineer"))
			{
			eachRowData.put(allColumnsEle.get(j-1).getText(), cellValue);
			allTableData.add(eachRowData);
			}
		}		

	}
	System.out.println(allTableData);
	}
	
}

