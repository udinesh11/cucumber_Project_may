package org.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Actions at;
	public static Select s;
	public static Robot r;
	
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
}
	
	public static void windowsLarge() {
		driver.manage().window().maximize();
		

	}
	   public static void loadUrl(String url) {
		driver.get(url);

	}
	 //6 
		public static void send(WebElement ele,String value) {
			ele.sendKeys(value);
			
		}
	 //7
		public static void btnclic(WebElement ele) {
			ele.click();

		}
		//scrolls
		public static void scrolls(String arg, WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript(arg, ele);
			

		}
		// gettext
		public static void printtxt(WebElement ele) {
			String t = ele.getText();
			System.out.println(t);
			
			

		}
		// moveto elemnts
		public static void moveElemnt(WebElement ele) {
			at = new Actions(driver);
			at.moveToElement(ele).perform();
			

		}
		//leftclick
		public static void leftclick(WebElement ele) {
			at = new Actions(driver);
			at.doubleClick(ele).perform();
			

		}
		//rightclick
		public static void rightClick(WebElement ele) {
			at = new Actions(driver);
			at.contextClick(ele).perform();
			

		}
		//dragnd drop
		public static void dragdrop(WebElement ele, WebElement txt) {
			at = new Actions(driver);
			at.dragAndDrop(ele, txt).perform();
			
		}
		//keydown
		public static void keydown(WebElement ele,Keys shift,String txt) {
			at = new Actions(driver);
		  at.keyDown(ele, shift).sendKeys(txt).perform();
			

		}
		//keyup
		public static void keyup(WebElement ele,String key) {
			at = new Actions(driver);
		  at.keyUp(ele, key).build().perform();

		}
		// 44 Selector
		public static void Selectindex(WebElement ele, int i) {
		    s = new Select(ele);
			s.selectByIndex(i);

		}
		//45 Selector
		public static void Selectvisibletxt(WebElement ele, String txt) {
			s = new Select(ele);
			s.selectByVisibleText(txt);

		}
		// gettext
				public static void printvalue(WebElement ele) {
					String t = ele.getAttribute("value");
					System.out.println("order number - "+ t);
					
					

				}
		// Total number of rows
				public static void TotalNumberRowsColumn(String path,String sheet) throws IOException {
					
					File f = new File(path);
					//Read file
					FileInputStream fin = new FileInputStream(f);
					//type of workbook
					Workbook w = new XSSFWorkbook(fin);
					//get sheet
					
					Sheet s = w.getSheet(sheet);
					int r = s.getPhysicalNumberOfRows();
					System.out.println("Total number of rows - "+r);
					Row cell = s.getRow(0);
					short tcells = cell.getLastCellNum();
					System.out.println("Total number of columns -"+tcells);
	

				}
				// IterateAllvalues
				public static void IterateAllValues(String path, String sheet) throws IOException {
					File f = new File(path);
					//Read file
					FileInputStream fin = new FileInputStream(f);
					//type of workbook
					Workbook w = new XSSFWorkbook(fin);
					//get sheet
					Sheet s = w.getSheet(sheet);
					//Iterate All values
					for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
						Row row = s.getRow(i);
						for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
							Cell cell = row.getCell(j);
							System.out.println(cell);
							
						}
						
					}
					

				}
				//Insert new row
				public static void NewRow(String path, String sheet) throws IOException {
					File f = new File(path);
					//Read file
					FileInputStream fin = new FileInputStream(f);
					//type of workbook
					Workbook w = new XSSFWorkbook(fin);
					//get sheet
					Sheet s = w.getSheet(sheet);
					Row cr = s.createRow(3);
					FileOutputStream fout = new FileOutputStream(f);
					w.write(fout);
					System.out.println("sucess");
				
				
		
}
				// Createfile
				public static void Createfile(String txt, String sheet) throws IOException {
					File f = new File(txt);
					FileInputStream fin = new FileInputStream(f);
					Workbook w = new XSSFWorkbook(fin);
					Sheet s = w.createSheet(sheet);
					
					
					

				}
				// Exceldata
				public static String ExcelData(int rowNumber,int cellNumber) throws IOException {
					File f = new File("C:\\Users\\Dinesh\\eclipse-workspace\\MayFramework\\Excel\\Facebook details.xlsx");
					//Read file
					FileInputStream fin = new FileInputStream(f);
					//type of workbook
					Workbook w = new XSSFWorkbook(fin);
					//get sheet
					Sheet s = w.getSheet("Sheet1");
					//get row
					Row row = s.getRow(rowNumber);
					//get cell
					Cell cell = row.getCell(cellNumber);
					int cellType = cell.getCellType();
					String value = " ";
					if (cellType==1) {
						value = cell.getStringCellValue();
						
					}
					else if (DateUtil.isCellDateFormatted(cell)) {
						Date d = cell.getDateCellValue();
						SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
						value = sd.format(d);
				
					}
					else {
						double cellvalue = cell.getNumericCellValue();
						long l = (long)cellvalue;
						value = String.valueOf(l);
						
					}
					return value;

				}
				//Updatethe value
				public static void hotelupdate(WebElement ele ) throws IOException {
					File f = new File("C:\\Users\\Dinesh\\eclipse-workspace\\MayFramework\\Excel\\HotelReg.xlsx");
					//Read file
					FileInputStream fin = new FileInputStream(f);
					//type of workbook
					Workbook w = new XSSFWorkbook(fin);
					//get sheet
					Sheet s = w.getSheet("Sheet1");
					//get row
					
					
						Row row = s.getRow(1);
						Cell cell = row.createCell(16);
						String t = ele.getAttribute("value");
				        cell.setCellValue(t);
				        
					
					FileOutputStream fout = new FileOutputStream(f);
					w.write(fout);
					System.out.println("sucess");
					

					
					
					
						
					}
				//Details
				public static String Details(int rowNumber, int cellNumber) throws IOException {
					File f = new File("C:\\Users\\Dinesh\\eclipse-workspace\\MayFramework\\Excel\\Facebook details.xlsx");
					FileInputStream fin = new FileInputStream(f);
					Workbook w = new XSSFWorkbook(fin);
					Sheet s = w.getSheet("Sheet1");
					Row row = s.getRow(rowNumber);
					Cell cell = row.getCell(cellNumber);
					int cellType = cell.getCellType();
					String value = " ";
					if (cellType==1) {
						value = cell.getStringCellValue();
						
					}
					else {
						double ncellvalue = cell.getNumericCellValue();
						long l = (long)ncellvalue;
						value = String.valueOf(l);
					}
						return value;
					}

				//update details in fb
				public static void updateFb(WebElement ele ) throws IOException {
					File f = new File("C:\\Users\\Dinesh\\eclipse-workspace\\MayFramework\\Excel\\Facebook details.xlsx");
					//Read file
					FileInputStream fin = new FileInputStream(f);
					//type of workbook
					Workbook w = new XSSFWorkbook(fin);
					//get sheet
					Sheet s = w.getSheet("Sheet1");
					//get row
					
					
						Row row = s.getRow(1);
						Cell cell = row.createCell(2);
						
                         if (ele.getText().equalsIgnoreCase("The password that you've entered is incorrect. Forgotten password?")| ele.getText().equalsIgnoreCase("The email address or mobile number you entered isn't connected to an account. Find your account and log in."))  {
							
							cell.setCellValue("Login fail");
						}
                         
                         else {
                        	 cell.setCellValue("Login Sucess");

						}
//						String t = ele.getText();
//				        cell.setCellValue(t);
				        
					
					FileOutputStream fout = new FileOutputStream(f);
					w.write(fout);
					System.out.println("sucess");
					

				}
				//Date and time
				public static void dateAndTime() {
//					SimpleDateFormat d = new SimpleDateFormat("MM-dd-YYYY");
					Date d = new Date();
					System.out.println(d.toString());

				}
				
				//quit
				public static void quit() {
					driver.quit();

				}
				
				//27
				public static void kpress(int txt) throws AWTException {
					r = new Robot();
					r.keyPress(txt);
					
				}
				//28
				public static void krelease(int txt) throws AWTException {
					r = new Robot();
					r.keyRelease(txt);
					
				}
				
				
	
	

}
