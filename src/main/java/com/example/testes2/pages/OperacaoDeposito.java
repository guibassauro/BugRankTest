package com.example.testes2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OperacaoDeposito {
    
    private static WebElement element = null;
    
    public static WebElement boxContaDoDeposito(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[3]/form/div[1]/div[1]/input"));
        return element;
    }

    public static WebElement boxDigitoDoDeposito(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[3]/form/div[1]/div[2]/input"));
        return element;
    }

    public static WebElement boxValorDoDeposito(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[3]/form/div[2]/input"));
        return element;
    }

    public static WebElement boxDescricaoDoDeposito(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[3]/form/div[3]/input"));
        return element;
    }

    public static WebElement botaoFazerDeposito(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button"));
        return element;
    }

    public static WebElement botaoFecharPopUp(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[5]/div/div[2]/a"));
        return element;
    }

    public static WebElement botaoVoltarAoMenu(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/a"));
        return element;
    }

    public static void fazDeposito(String numeroDaConta, String digitoDaConta, String valor, String descricao, WebDriver driver){
        PaginaDaPessoa.botaoPaginaDeposito(driver).click();

        espera(1000);
        OperacaoDeposito.boxContaDoDeposito(driver).sendKeys(numeroDaConta);
        OperacaoDeposito.boxDigitoDoDeposito(driver).sendKeys(digitoDaConta);
        OperacaoDeposito.boxValorDoDeposito(driver).sendKeys(valor);
        OperacaoDeposito.boxDescricaoDoDeposito(driver).sendKeys(descricao);

        OperacaoDeposito.botaoFazerDeposito(driver).click();

        espera(1000);
        OperacaoDeposito.botaoFecharPopUp(driver).click();

        espera(1000);
        OperacaoDeposito.botaoVoltarAoMenu(driver).click();

    }

    public static void espera(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
