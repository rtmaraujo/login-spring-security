# login-spring-security
Tela simples de login de usuário com acesso dois links:
Listar Clientes-> acesso permitido apenas para o usuario:joaocarlos senha:admin
Listar Carros-> acesso permitido apenas para o usuario:maria senha:admin

Rest-> com acesso aberto;
- Criar um Cliente
- Alterar um Cliente
- Consultar um Cliente por id
- Listar todos os Clientes salvos
- Remover Cliente por id

## Incluir
  - Spring Boot 1.5.9
  - spring-boot-starter-data-jpa
  - spring-boot-starter-web
  - com.h2database:h2: H2 DB connector
  - spring-boot-devtools
  - spring-boot-starter-test
  - org.springframework.security
  - mockito-core

## Importante properties
application.properties
import.properties

# JDBC Url usar H2 DB arquivo para persistir os dados.
spring.datasource.url=jdbc:h2:file:~/testedb;

# Usar H2 DB Driver
spring.datasource.driver-class-name=org.h2.Driver

## Testes
-Testes Unitários podem ser feitos via IDE;

-Testes para verificar restrição de acesso pode ser feito acessando a url: http://localhost:8080/
usuario:joaocarlos senha:admin -> pode acessar apenas lista de clientes;
usuario:maria senha:admin-> pode acessar apenas lista de carros;
caso queira cadastrar um usuario novo só ir no arquivo import.sql e adicionar em suas respectivas tabelas;
no arquivo LoginApplication mostra como gero a senha;

Testes para chamadas Rest:
-Listar clientes ou carros: realizar chamada Get sem parametros.
http://localhost:8080/clientes
http://localhost:8080/carros

-Adicionar cliente ou carro: realizar chamada Post passando os parametros no body com application/json.  
http://localhost:8080/clientes
http://localhost:8080/carros

-Alterar cliente ou carro: realizar chamada Put passando os parametros a serem alterados no body como application/json e na url o codigo do cliente ou carro a ser alterado.
http://localhost:8080/clientes/{id}
http://localhost:8080/carros/{id}

-Consultar cliente ou carro: realizar chamada Get passando o codigo do cliente ou carro como na url.
http://localhost:8080/clientes/{id}
http://localhost:8080/carros/{id}

-Alterar cliente ou carro: realizar chamada Delete passando o codigo do cliente ou carro que deseja deletar na url.
http://localhost:8080/clientes/{id}
http://localhost:8080/carros/{id}

## Ferramentas
-Spring Tools Suite
-PostMan para realizar as chamadas aos serviços (https://www.getpostman.com/apps), pode ser utilizado qualquer outro correspondente;

## Documentação
-Desenvolvedor (usando Spring Tools Suite):
baixar o projeto do Git;
baixar as dependencias via maven clean install;
executar no Boot Dashboard o projeto especifico;
-Tester:
baixar o projeto do Git;
baixar as dependencias via maven clean install;

fazer as seguintes alterações no pom.xml:
mudar o trecho correspondente ao "org.springframework.boot":
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			 <exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-tomcat</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
adicionar a dependencia:
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<scope>provided</scope>
		</dependency>
alterar o packaging de:
<packaging>jar</packaging>
para
<packaging>war</packaging>
rodar o maven clean install
subir o servidor da sua preferencia;
fazer o deploy do arquivo login-spring-security-0.0.1-SNAPSHOT.war;
