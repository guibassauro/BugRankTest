package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bugRankTest {
    
    @Test 
    public void testeCriarDuasContasValidasEValidarTransicao(){
        // Passo 1. Acessar o site https://bugbank.netlify.app/

        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        Actions actions = new Actions(navegador);

        navegador.get("https://bugbank.netlify.app/");

        // Passo 2. Criar duas contas com Saldo e salvar os seus dados
            // 2.1 Criando a primeira conta

            // entrando na area de registro
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();
        
            //preenchendo os campos
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys("pedro@gmail.com");
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[3]/input")).sendKeys("Pedro Oliveira");
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys("12345");
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[5]/div/input")).sendKeys("12345");

            // especificando que quer saldo
            espera(500);
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[6]/label/label")).click();

            // clicando em registrar
            actions.moveToElement(navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/button"))).click().perform();

            // fechando pop-up de confirmação de criação da conta
            espera(1000);
            actions.moveToElement(navegador.findElement(By.id("btnCloseModal"))).click().perform();

            //Conta 1 Criada!
            //Entrando na conta 1

            // preenchendo os dados da conta 1
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[1]/input")).sendKeys("pedro@gmail.com");
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[2]/div/input")).sendKeys("12345");

            // clickando no botao de login
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[1]")).click();

            // Salvando dados de Pedro Oliveira

            espera(1000);
            String pedroCadastro = navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/p/span")).getText();
            String pedroNumeroDaConta = "";
            String pedroDigito = "";

            if(pedroCadastro.length() == 5){
                pedroNumeroDaConta = pedroCadastro.substring(0, 3);
                pedroDigito = pedroCadastro.substring(4, 5);
            } else if(pedroCadastro.length() == 4){
                pedroNumeroDaConta = pedroCadastro.substring(0, 2);
                pedroDigito = pedroCadastro.substring(3, 4);
            }
            String pedroSaldo = navegador.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/p/span")).getText();

            //saindo da conta 1
            navegador.findElement(By.xpath("/html/body/div/div/div[1]/div/a")).click();

            // Finalizada 1 conta
            // Criando 2 conta

            // clickando em registrar para fazer a 2 conta
            espera(1000);
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();

            // preenchendo os campos da 2 conta
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys("monique@gmail.com");
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[3]/input")).sendKeys("Monique Oliveira");
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys("12345");
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[5]/div/input")).sendKeys("12345");
        
            // especificando que quer saldo
            espera(500);
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[6]/label/label")).click();

            // clickando para registrar conta
            actions.moveToElement(navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/button"))).click().perform();

            // fechando pop-up de confirmação de criação da conta
            espera(500);
            actions.moveToElement(navegador.findElement(By.id("btnCloseModal"))).click().perform();

            // Conta 2 criada!

        // Passo 3. Acessar uma conta e realizar uma transferência de valor para outra
        
            // preenchendo dados da 2 conta
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[1]/input")).sendKeys("monique@gmail.com");
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[2]/div/input")).sendKeys("12345");

            // logando na 2 conta
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[1]")).click();

            // Salvando dados da 2 conta

            espera(1000);
            String moniqueCadastro = navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/p/span")).getText();
            String moniqueNumeroDaConta = "";
            String moniqueDigito = "";

            if(moniqueCadastro.length() == 5){
                moniqueNumeroDaConta = moniqueCadastro.substring(0, 3);
                moniqueDigito = moniqueCadastro.substring(4, 5);
            } else if(moniqueCadastro.length() == 4){
                moniqueNumeroDaConta = moniqueCadastro.substring(0, 2);
                moniqueDigito = moniqueCadastro.substring(3, 4);
            }
            
            String moniqueSaldo = navegador.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/p/span")).getText();

            // clickando para fazer deposito
            navegador.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[1]/a/span/img")).click();

            // preenchendo dados do deposito
            espera(500);
            navegador.findElement(By.xpath("/html/body/div/div/div[3]/form/div[1]/div[1]/input")).sendKeys(pedroNumeroDaConta);
            navegador.findElement(By.xpath("/html/body/div/div/div[3]/form/div[1]/div[2]/input")).sendKeys(pedroDigito);
            navegador.findElement(By.xpath("/html/body/div/div/div[3]/form/div[2]/input")).sendKeys("500");
            navegador.findElement(By.xpath("/html/body/div/div/div[3]/form/div[3]/input")).sendKeys("Deposito de 500 reais");
        
            // clickando em fazer o deposito
            navegador.findElement(By.xpath("/html/body/div/div/div[3]/form/button")).click();


        // Passo 4. Validar a saída e entrada de valores das contas envolvidas

            // fechando pop-up de confirmação de deposito
            espera(500);
            navegador.findElement(By.xpath("/html/body/div/div/div[5]/div/div[2]/a")).click();

            // voltando ao menu da 2 conta
            espera(500);
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/a")).click();
            
            // salvando novo saldo da 2 conta
            espera(500);
            moniqueSaldo = navegador.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/p/span")).getText();

            // Validando saldo da 2 conta
            assertEquals(moniqueSaldo, "R$ 500,00");

            // saindo da conta 2
            navegador.findElement(By.xpath("/html/body/div/div/div[1]/div/a")).click();

            // entrando na conta 1
            espera(500);
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[1]/input")).sendKeys("pedro@gmail.com");
            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[2]/div/input")).sendKeys("12345");

            navegador.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[1]")).click();
        
            // validando salda da 1 conta
            espera(500);
            pedroSaldo = navegador.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/p/span")).getText();

            assertEquals(pedroSaldo, "R$ 1.500,00");

    }

    public void espera(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
