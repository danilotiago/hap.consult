## Hapivida - Consulta de animais
Teste hapivida 

## Arquitetura
Para desenvolvimento deste projeto foi utilizado a arquitetura hexagonal, uma arquitetura simples e de fácil manutenção

## Módulos
Foi criado os seguintes módulos:

- medical-consultation-application
  - Utilizado para algumas configurações gerais.
  - Startup da aplicação.
  - Definição de propriedades de acordo com o ambiente.
- medical-consultation-database (ator secundário conduzido)
    - Utilizado para camada de comunicação com banco de dados.
- medical-consultation-domain
    - Utilizado para camada de domínio, isolando toda a regra de negócio e disponibilizando as portas de acesso.
- medical-consultation-web (ator primário condutor)
    - Utilizado para camada web. disponibiliza as API's necessárias para estímulo dos casos de uso.


## Regras de negócio

Foi criado algumas regras de negócio para melhor exploração do modelo solicitado:

  - Agendamento repetido: Não permite agendamento para o mesmo animal, mesmo veterinário e o mesmo horário.
  - Cancelamento: Não permite o cancelamento caso a data do agendamento seja a mesma da solicitação do cancelamento.

## Testes
Foi criado alguns testes para exemplificar o uso de testes unitários, classe:

```
br.com.hapvida.medicalconsultation.services.ScheduledServiceTest
```

## Bancos de dados
Está configurado a utilização do banco de dados H2 caso execução da aplicação no ambiente local, para os demais ambientes foi configurado o MySql.

## Documentação
Foi adicionao o swagger para a documentação de API's: <br>
http://localhost:8080/medical-consultation/swagger-ui/

## Execução
Podemos executar em diferentes ambientes: LOCAL, DEV, HOMOLOG e PROD, se atentando as propriedades de banco de dados acima.

```
Em primeiro, executar: 
mvn clean install

E para as execuções:

Execução local:
java -jar target/medical-consultation.jar --spring.profiles.active=local

Execução dev:
java -jar target/medical-consultation.jar --spring.profiles.active=dev

Execução homolog:
java -jar target/medical-consultation.jar --spring.profiles.active=homolog

Execução prod:
java -jar target/medical-consultation.jar --spring.profiles.active=prod
```