package com.madhan.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

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

class ShopServiceimplTest {

	@Autowired
	ShopServiceimpl ssi;
	
	WebDriver webdriver;
	@BeforeEach
	void init(){
	webdriver = new ChromeDriver();
	}
	@Test
	void testAddShop() {
		webdriver.get("http://localhost:3000/add");
    	webdriver.findElement(By.name("prname")).sendKeys("avengers");
    	webdriver.findElement(By.name("available")).sendKeys("45");
    	webdriver.findElement(By.name("userrating")).sendKeys("10");
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
//	void testGetShop() {
//		assertNotNull(ssi.getShop(4));
//	}

	@Test
	void testGetAllShop() {
		webdriver.get("http://localhost:3000/view");
	}

//	@Test
//	void testUpdateShop() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testDeleteShop() {
//		webdriver.get("http://localhost:3000/view");
//	    webdriver.findElement(By.cssSelector("tr:nth-child(4) .ms-1").id("delete")).click();
//	    WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofMillis(500));
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = webdriver.switchTo().alert();
//		String txt = alert.getText();
//		alert.accept();
//		assertEquals("Do you want to delete", txt);
//	}

}
