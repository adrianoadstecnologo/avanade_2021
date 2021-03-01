## Projeto conclusivo do Curso Spring Cloud Gama-Avanade 2021

                                     Api de Conta Corrente 

## Especificações Funcionais

- Autenticar o usuário pelo Login do Cliente
- Alterar os dados cadastrais do Cliente
- Depositar/Sacar da Conta Corrente do Cliente
- Mostrar a situação da Conta Corrente (saldo)
- Mostrar o histórico de Operações

## Especificações Não Funcionais

- As operações de Cliente e Login devem ser feitos com o banco relacional PostgreSql

## Modelagem

Entidade
- Id
- dataCriacao
- dataAtualizacao
- ativo

Cliente
- Nome
- Sobrenome
- Telefone
- Email
- Login

Login
- Senha
- Usuario

ContaCorrente
- Saldo


- Obs: Apesar de ser uma modelagem simples aqui colocada, existem algumas relações bem definidas 
  entre os Objetos de algumas Entidades.
  As Entidades Login e ContaCorrente possuem a relação de composição ou seja: Sem um Cliente as duas não existem.
 
---------------------------

Operação
- Id
- dataCriacao
- ContaCorrente
- valor
- tipo

## Ferramentas e Tecnologias Utilizadas

IDE SPRING TOOL SUIT  
- Justificativa de uso: Um ambiente mais completo para desenvolvimento com o Ecossistema Spring em Geral.
   
MongoDb
- Justificativa de uso: Escolhido para este projeto por ser um banco de SGBD no SQl muito usado nos dias atuais por grandes empresas e projetos.
    
SGBD- PostgreSQL  
- Justificativa de uso: Escolhido para este projeto por ser um SGBD Relacional, com grande capacidade de armazenamento e gerenciamento muito usado em projetos de grande porte.
   
Postman
- Justificativa de uso: Client Rest para testar o funcionamento de API Rest, sem que haja uma FrontEnd.
      
Mavem
- Justificativa de uso: Apesar do mesmo ter o Gradle como opção de uso mais atual. O mavem ainda se matem em grandes projetos e respondendo a altura no que se propõem a fazer. 
    Dentre todas suas diversas funcionalidades, neste projeto usamos o Mavem para cuidar da estrutura de nosso projeto fazendo com que o Mavem gerencie todas Dependências do Projeto, com isso garantimos que todo projeto vai trabalhar com versões compatíveis entre si de libs importadas através do Arquivo POM.XML.Arquivo este que contém todas as dependências e configurações necessárias para nosso projeto funcionar. 
    
    
Spring Boot   
- Justificativa de uso: Para darmos ao projeto um Start mais rápido já que o projeto Spring Boot configura de forma automática uma série de coisas para nosso projeto, dentre essas coisas que posso citar são arquivos xml que temos que configurar na mão as configurações necessárias para o funcionamento do projeto, quando não fazemos uso do Spring Boot.
   Já com o Spring Boot tudo que temos que fazer a principio e Configurar o arquivo Application.propertie, que em si não leva muito tempo para configura-lo. Conseguimos especificar em mínimas linhas configurações importantes para que nossa aplicação realize toda parte de persistência nos SGBD descritos no mesmo.
    
    
Spring Data JPA 
- Justificativa de uso: Com o uso deste Framework, conseguimos de forma rápida implementar uma acamada de acesso a dados. Porque por trás o framework faz o encapsulamento de toda aquela lógica e configurações pesadas, dando a nós recursos mais limpos e objetivos para atender nossas regras de negócio através de anotações e convenções especificas do framework.
  
Hibernate
- Justificativa de uso: O Framework Hibernate é o mais usado para implementar conceitos de mapeamento de objetos relacionais (ORM), ele trabalha de forma muito integrada com as especificações JPA, já que a mesma se deu em boa parte por sua influência. Tornando muito mais claro e fácil de lidar com a persistência já que o mapeamento realizado através de classes(Entidades) criadas no projeto referenciam através de notações especificas nossas tabelas no SGBD..

Spring security
- Justificativa de uso: Usado projeto por a principio fazer parte do Ecossistema Spring e possibilitar uma implementação mais entendível.

Docker
- Justificativa de uso: Para termos mais produtividade quando o assunto é instalação e configuração de SGBD, uma vez que em um único arquivo YAML configuramos e baixamos tudo que precisaremos para Comunicação da nossa Camada de Persistência. Sem mencionar as facilidades diante de suas operações relacionadas aos SGBD como Startar,Parar,Restartar e até mesmo Apagar e Recriar novamente o ambiente todo de SGBD com poucas linhas de comando através de um terminal. Entre outras funcionalidades fantásticas que temos com o uso do docker, container com aplicações e serviços distintos se comunicando entre si, escalabilidade etc.

## Estrutura do Projeto

No projeto e fácil identificar uma estrutura de pacotes e arquivos bem distribuídos de acordo com suas funcionalidades e especializações.
  Com esta estrutura conseguimos saber exatamente onde buscar o que queremos.
  
## Solid e Clean Code

 Aplicamos no projeto técnicas simples do Clean Code a fim de facilitar a escrita e a leitura do código.
 
 As classes foram dadas funções específicas e únicas atendendo o Principio SRP (Principio da responsabilidade única), desta forma conseguimos definir especializações para cada Classe, dando a elas o máximo de reaproveitamento das mesmas em outras partes do projeto. Cada classe com seus atributos e métodos são mais evidenciados no momento em que temos que realizar alguma alteração neles, tendo apenas um lugar especifico para realizar tais alterações.

- No pacote br.com.gama.contacorrente.entidades, se encontra algumas classes com anotações específicas(@Entity) que representam nossas Entidades na base de dados.
Outras como é o caso da Classe Entidade anotada com @MappedSuperclass, não representa uma Entidade mais uma classe Pai que fornecerá seus atributos para outras classes filhas (Extends), utilizando-se do conceito de Herança para evitar duplicidade e redundância de código.

- No pacote br.com.gama.contacorrente.dtdo, se concentram as classes do tipo Data Transfer Object (DTO), que tem como finalidade de otimizar a comunicação e expor/receber somente os atributos(dados) que realmente precisam ser expostos/recebidos evitando que dados sensíveis fiquem expostos e também evitando recebimento de dados da comunicação que não refletem os atributos do  modelo.

- Partindo deste mesmo principio as classes do pacote br.com.gama.contacorrente.form, tem estes mesmos princípios das classes DTOS, porém voltadas para servir como modelo para respostas(ResponsyEntity<>) para o cliente e para pegar(Request) dados vindos geralmente de formulários(dai a convenção FORM).



- As Classes Controllers no pacote br.com.gama.contacorrente.controllers, são anotadas como tal @Controller e nas mesmas se encontram apenas operações de rotas, ou seja são reesposáveis apenas por fazer o encaminhamento da requisição para alguém no caso um Service que possa receber e atender a mesma. Toda regra de negócio como boas práticas se concentra nas Classes anotadas como @Service do pacote br.com.gama.contacorrente.service.


- As Classes Services do pacote br.com.gama.contacorrente.service, são devidamente anotadas com @Service para o spring identificar elas como um serviço e mais tarde poderem ser injetadas nos controllers através da anotação @Autowired.
Nestas Classes deste pacote se concentra toda regra de negocio correspondente a cada serviço que será exposto em nossa API.


- As Classes do pacote br.com.gama.contacorrente.repositorios, representam de fato a nossa camada de persistência no Banco de Dados é através dela que proveremos todas operações em banco de dados como Insert,Update,Delete etc, e também é através dela juntamente com o arquivo Application.properties em uma abstração realizada pelo Framework que temos acesso aos SGBDS configurados.
 Para todas as transações na Base de Dados usamos convenções do JPA ao invés de criarmos nossas próprias querys com JPQL. Para este projeto as informações e manipulações de dados que precisávamos isso foi suficiente.


- Através das Anotações @RestController
@RequestMapping() utilizadas nos Controllers dá para se dizer e verificar que se trata de uma API Rest.
 O que a torna RestFull é que estamos aplicando todos ou parte dos princípios de REST.
 Como exemplo posso citar as chamadas de recursos através de URL padrão ex: http://localhost:8080/cliente, onde o recurso e identificado através dos verbos http anotados adequadamente de acordo com o que se propõem o recurso, são eles: 
  @PutMapping()-Usado para atualizar;
  @DeleteMapping()-Usado para Deletar;
  @PostMapping()-Usado para Salvar/Criar
  @GetMapping()-Usado geralmente para Listar, entre outros verbos http existentes para atender uma API RestFull.
  
  
## Configuração de Ambiente

- Segue o YAML no pacote others para realizar a instalação no Docker para criar o Ambiente de Banco de Dados.

- Um arquivo data.sql também no pacote others para compor uma massa inicial de dados simples.

- Para testar os EndPoints com o client Postman neste mesmo pacote contém um arquivo ContaCorrente.postman_collection.jason

 Agradeço desde já pela atenção.

