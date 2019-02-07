# SOC Teste

Possui as seguintes funcionalidades:
* Cadastro de Exames;
* Consulta de Exames;
* Web Service para cadastro e consulta de exames.

## Requisitos

* Java 8;
* Maven 3.

# Aplicação Web

## Como executar

Executar o comando abaixo na pasta raíz do projeto: 

``` bash
mvn jetty:run
```

## Como acessar

Acessar a url http://localhost:8080/soc-teste/index.jsp

# Web Service

## Como executar

Executar o main da classe ExameServerPublisher.java

## WSDL

O WSDL publicado fica disponível em http://localhost:8081/br.com.tpa.soc_teste.ws?wsdl
