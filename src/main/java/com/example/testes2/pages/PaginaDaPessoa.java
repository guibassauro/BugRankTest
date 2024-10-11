package com.example.testes2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaDaPessoa {
    public static WebElement element = null;

    public static WebElement pessoaCadastro(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/p/span"));
        return element;
    }

    public static WebElement pessoaSaldo(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/p/span"));
        return element; 
    }

    public static WebElement sairDaPagina(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/a"));
        return element;
    }

    public static WebElement botaoPaginaDeposito(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[1]/a/span/img"));
        return element;
    }

    public static String salvaNumeroDaConta(WebDriver driver){
        String cadastro  = PaginaDaPessoa.pessoaCadastro(driver).getText();
        String numeroDaConta = "";
        if(cadastro.length() == 5){
            numeroDaConta = cadastro.substring(0, 3);
        }

        if(cadastro.length() == 4){
            numeroDaConta = cadastro.substring(0, 2);
        }

        return numeroDaConta;
    }

    public static String salvaCodigo(WebDriver driver){
        String cadastro = PaginaDaPessoa.pessoaCadastro(driver).getText();
        String codigo = "";

        if(cadastro.length() == 5){
            codigo = cadastro.substring(4, 5);
        }

        if(cadastro.length() == 4){
            codigo = cadastro.substring(3,4);
        }

        return codigo;
    }
}
