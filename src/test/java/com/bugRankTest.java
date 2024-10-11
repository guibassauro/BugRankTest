package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.testes2.pages.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class bugRankTest {
    
    @Test 
    public void testeCriarDuasContasValidasEValidarTransicao(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.get("https://bugbank.netlify.app/");
        
        BugRankHome.registraPessoa("pedro@gmail.com", 
        "Pedro Oliveira", "12345", navegador);

        BugRankHomeLogin.fazLogin("pedro@gmail.com", 
        "12345", navegador);

        BugRankHome.espera(1000);
        String pedroSaldo = PaginaDaPessoa.pessoaSaldo(navegador).getText();
        String pedroNumeroDaConta = PaginaDaPessoa.salvaNumeroDaConta(navegador);
        String pedroDigito = PaginaDaPessoa.salvaCodigo(navegador);

        PaginaDaPessoa.sairDaPagina(navegador).click();
        BugRankHome.espera(1000);
        BugRankHome.registraPessoa("monique@gmail.com", 
        "Monique Oliveira", "12345", navegador);

        BugRankHomeLogin.fazLogin("monique@gmail.com", 
        "12345", navegador);

        BugRankHome.espera(1000);
        String moniqueSaldo = PaginaDaPessoa.pessoaSaldo(navegador).getText();
        
        OperacaoDeposito.fazDeposito(pedroNumeroDaConta, pedroDigito, 
        "500", "Deposito de 500 reais", navegador);

        BugRankHome.espera(1000);
        moniqueSaldo = PaginaDaPessoa.pessoaSaldo(navegador).getText();

        assertEquals(moniqueSaldo, "R$ 500,00");

        PaginaDaPessoa.sairDaPagina(navegador).click();

        BugRankHome.espera(1000);
        BugRankHomeLogin.fazLogin("pedro@gmail.com", "12345", navegador);

        BugRankHome.espera(1000);
        pedroSaldo = PaginaDaPessoa.pessoaSaldo(navegador).getText();

        assertEquals(pedroSaldo, "R$ 1.500,00");
    }
}
