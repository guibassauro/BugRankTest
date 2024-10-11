package com.example.testes2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BugRankHome {

    private static WebElement element = null;
    
    public static WebElement botaoDeRegistrar(WebDriver driver){    
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[2]"));
        return element;
    }

    public static WebElement botaoRegistrarEmail(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[2]/input"));
        return element;
    }

    public static WebElement botaoRegistrarNome(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[3]/input"));
        return element;
    }

    public static WebElement botaoRegistrarSenha(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[4]/div/input"));
        return element;
    }

    public static WebElement botaoConfirmarSenha(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[5]/div/input"));
        return element;
    }

    public static WebElement botaoConfirmarComSaldo(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[6]/label/label"));
        return element;
    }

    public static WebElement botaoConfirmarCriacaoDeLogin(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/button"));
        return element;
    }

    public static WebElement botaoFecharNotificacaoDeCriacao(WebDriver driver){
        element = driver.findElement(By.id("btnCloseModal"));
        return element;
    }

    public static void registraPessoa(String email, String nome, String senha, WebDriver driver){
        Actions actions = new Actions(driver);

        BugRankHome.botaoDeRegistrar(driver).click();

        BugRankHome.botaoRegistrarEmail(driver).sendKeys(email);
        BugRankHome.botaoRegistrarNome(driver).sendKeys(nome);
        BugRankHome.botaoRegistrarSenha(driver).sendKeys(senha);
        BugRankHome.botaoConfirmarSenha(driver).sendKeys(senha);

        espera(1000);
        BugRankHome.botaoConfirmarComSaldo(driver).click();

        actions.moveToElement(BugRankHome.botaoConfirmarCriacaoDeLogin(driver)).click().perform();

        espera(1000);
        actions.moveToElement(BugRankHome.botaoFecharNotificacaoDeCriacao(driver)).click().perform();
        
    }

    public static void espera(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
