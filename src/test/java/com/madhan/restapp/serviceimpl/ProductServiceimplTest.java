package com.madhan.restapp.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

class ProductServiceimplTest {
	
	@Autowired
	ProductServiceimpl psi;

	WebDriver webdriver;
	@BeforeEach
	void init(){
		webdriver = new ChromeDriver();

	}
	
	@Test
	void testAddProduct() {
    	webdriver.get("http://localhost:3000/addproduct");
    	webdriver.findElement(By.name("pname")).sendKeys("avengers");
    	webdriver.findElement(By.name("category")).sendKeys("toys");
    	webdriver.findElement(By.name("price")).sendKeys("1000");
    	webdriver.findElement(By.name("deliverydate")).sendKeys("11224");
    	webdriver.findElement(By.name("sellername")).sendKeys("praba");
    	webdriver.findElement(By.id("submit")).click();
    	WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = webdriver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		System.out.println(txt);
		assertEquals("Data added Successfully", txt);
	}




//	@Test
//	void testGetProduct() {
//		assertNotNull(psi.getProduct(4));
//	}

	@Test
	void testGetAllProduct() {
		webdriver.get("http://localhost:3000/viewproduct");
	}

	@Test
	void testUpdateProduct() {
		webdriver.get("http://localhost:3000/editproduct/5");
//    	webdriver.findElement(By.name("id")).sendKeys("");
		webdriver.findElement(By.name("pname")).clear();
    	webdriver.findElement(By.name("pname")).sendKeys("barbie");
		webdriver.findElement(By.name("category")).clear();
    	webdriver.findElement(By.name("category")).sendKeys("toys");
		webdriver.findElement(By.name("price")).clear();
    	webdriver.findElement(By.name("price")).sendKeys("1000");
		webdriver.findElement(By.name("deliverydate")).clear();
    	webdriver.findElement(By.name("deliverydate")).sendKeys("11224");
		webdriver.findElement(By.name("sellername")).clear();
    	webdriver.findElement(By.name("sellername")).sendKeys("ram");
    	webdriver.findElement(By.id("update")).click();
    	WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = webdriver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("User updated successfully", txt);

	
	}

//	@Test
//	void testDeleteProduct() {
//		webdriver.get("http://localhost:3000/viewproduct");
//	    webdriver.findElement(By.cssSelector("tr:nth-child(4) .ms-1")).click();
//	    WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofMillis(500));
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = webdriver.switchTo().alert();
//		String txt = alert.getText();
//		alert.accept();
//		assertEquals("Do you want to delete", txt);
//	}

}
