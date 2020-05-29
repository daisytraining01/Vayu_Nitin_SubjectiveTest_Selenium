package picnic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WordPress {
	private static WebDriver driver = null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
ArrayList sl=new ArrayList();

		String homePage = "https://wordpress.com/?aff=58022&cid=8348279";
		
		System.setProperty("webdriver.chrome.driver", "src/main/java/driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(homePage);
		
		Actions actions = new Actions(driver);
       
     
     System.out.println("Done Mouse hover on from Menu");
     Thread.sleep(5000);
     //Now Select 'Rock' from sub menu which has got displayed on mouse hover of 'Music'
     Thread.sleep(5000);
     String[] sa={"products","features","resources"};
     for (int i = 0; i < sa.length; i++) {
		
	
     WebElement subMenuOption = driver.findElement(By.xpath("//button[@data-dropdown-trigger='"+sa[i]+"']")); 
     //Mouse hover menuOption 'Rock'
     Thread.sleep(5000);
     actions.moveToElement(subMenuOption).perform();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		Iterator<WebElement> iter = links.iterator();


		// To print list of links in the Website
		System.out.println("List of links in the website");
		while (iter.hasNext()) {
			String url = iter.next().getText();
			System.out.println(url);
			if(url==null)
			sl.add(url);
			
		}
		
		
     }
     
     
     
     
     XSSFWorkbook workbook = new XSSFWorkbook();
     XSSFSheet sheet = workbook.createSheet("Tabledata");

     int rn = 0;
     System.out.println("Writing in  excel");

     for (Object[] datatype : tableval) {
         Row row = sheet.createRow(rn++);
         int cn = 0;
         for (Object field : datatype) {
             Cell cell = row.createCell(cn++);
             if (field instanceof String) {
                 cell.setCellValue((String) field);
             } else if (field instanceof Integer) {
                 cell.setCellValue((Integer) field);
             }
         }
     }

     try {
         FileOutputStream outputStream = new FileOutputStream("src/main/java/driver/webtable.xlsx");
         workbook.write(outputStream);
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }finally {
         workbook.close();
     }

     System.out.println("Done");
		
	}
		
	}
	

}
