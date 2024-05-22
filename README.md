# Event City TDD

Bem-vindo ao projeto desafio "Event City"!   
Event City trata-se do desenvolvimento TDD de uma API Rest com Java e Spring Boot.   
O projeto é um "desafio" do curso Java Spring Expert da Devsuperior.


## Objetivo

O objetivo deste projeto foi implementar as funcionalidades necessárias para que todos os testes automatizados fornecidos no código fonte passassem com sucesso. Segui os princípios do TDD, onde os testes são escritos antes da implementação do código.

## Descrição do Sistema

O sistema desenvolvido consiste em dois componentes principais:
* Eventos
* Cidades  

A relação entre esses componentes é de muitos-para-um (N-1), onde vários eventos podem ocorrer em uma única cidade. 
![Modelo Conceitual](https://github.com/diesantana/assets/blob/main/img/desafioEventCityTDD/domain-model.jpg?raw=true)

## Estrutura do Projeto

O projeto está organizado da seguinte forma:    

```src/main/java```: Contém o código-fonte do sistema.  
- ```controllers/```: Controladores REST para exposição das APIs.
- ```controllers/exceptionsHandlers```: Contém as classes que interceptam exceções
- ```dto/```: Contém as classes DTO'S para trafegar os dados entre camadas. 
- ```entities/```: Definições das classes Event e City.
- ```services/```: Lógica de negócios para gerenciamento de eventos e cidades.
- ```repositories/```:  Interfaces para persistência de dados.

```src/test/java```: Contém os testes de integração.

## Tecnologias utilizadas
- Java JDK 17
- Spring Boot 3.1.0
- Spring Boot Test
- Spring Data JPA: Para a persistência de dados e acesso ao banco de dados.
- Maven: Para gerenciamento de dependências.
- H2 Database: Como banco de dados para ambiente de testes.

## Considerações Finais
Este projeto me proporcionou uma excelente oportunidade para praticar TDD e reforçar meus conhecimentos em desenvolvimento de software orientado por testes com Spring Boot.