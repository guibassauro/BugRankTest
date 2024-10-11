package com.example.testes2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BugRankHomeLogin {
    
    public static WebElement element = null;

    public static WebElement botaoColocarEmailDoLogin(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[1]/input"));
        return element;
    }

    public static WebElement botaoColocarSenhaDoLogin(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[2]/div/input"));
        return element;
    }

    public static WebElement botaoDeLogin(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[1]"));
        return element;
    }

    public static void fazLogin(String email, String senha, WebDriver driver){
        BugRankHomeLogin.botaoColocarEmailDoLogin(driver).sendKeys(email);
        BugRankHomeLogin.botaoColocarSenhaDoLogin(driver).sendKeys(senha);

        BugRankHomeLogin.botaoDeLogin(driver).click();
    }
}
