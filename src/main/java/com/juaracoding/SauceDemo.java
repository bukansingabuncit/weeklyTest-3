package com.juaracoding;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SauceDemo {
    public static void main(String[] args) {

        //public void setUp () {
        String path = "C:\\MyTools\\chromedriver.exe\\";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        System.out.println("Open Browser");

        // Test case login Sauce Demo
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();

        if (username.equals(username) && password.equals(password)) {
            System.out.println("Berhasil Masuk");
        } else {
            assert false : "Epic sadface: Username and password do not match any user in this service";
            System.out.println("Gagal Masuk. Periksa Kembali Username dan Password Anda");
        }


        // validasi status login
        WebElement products = driver.findElement(By.xpath("//span[@class='title']"));
        String getProducts = products.getText();
        if (getProducts.equals("Products")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }


        // Test case pilih barang
        WebElement pilihBarang = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        //String namaBarang = pilihBarang.findElement(By.id("add-to-cart-sauce-labs-bike-light")).getText();
        pilihBarang.click();

        // fitur keranjang & periksa barang
        WebElement keranjang = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        keranjang.click();

        if (keranjang.equals(keranjang)) {
            System.out.println("Barang ditambahkan ke Keranjang");
        } else {
            assert false : "2";
            System.out.println("Keranjang sudah penuh");
        }




        WebElement periksaPesanan = driver.findElement(By.id("checkout"));
        periksaPesanan.click();

        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement postalCode = driver.findElement(By.name("postalCode"));
        firstName.sendKeys("singa");
        lastName.sendKeys("buncit");
        postalCode.sendKeys("12345");

        WebElement selanjutnya = driver.findElement(By.id("continue"));
        selanjutnya.click();

        // laman pembayaran
        WebElement selesaikan = driver.findElement(By.id("finish"));
        selesaikan.click();


        // validasi status pesanan
        WebElement checkOut = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        String getCheckOut = checkOut.getText();
        if (getCheckOut.equals("Checkout: Complete!")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Close Browser");

    }

    }

