# Este é o projeto Api Livraria  

## FrameWork Ultilizado foi o Springboot

Foi solicitado a entidade Livro e os seguintes atributos:

● id

● titulo 

● autor

● isbn

● anoDePublicacao

e os endpoints CREATE, READ ALL, READ ONE, UPTADE E DELETE

A solução encontrada consistiu na utilização de métodos simples que executam cada função listada, com o devido tratamento de erro caso o livro não seja encontrado. Especificamente para os tratamentos de erro, foi utilizado o **`@ControllerAdvice`** para padronizar as exceções.


-------------------------------------------------------------------------------------------
Para fazer o projeto rodar na sua maquina , será preciso seguir os seguintes passos



1. Baixar o arquivo do projeto do repositorio do github

__Link__: https://github.com/joaog31/API_Livraria

2. Extrair o arquivo na pasta onde deseja armazenar o projeto
3. Abrir o terminal da pasta para rodar os comandos de instalação

### Caso seu SO seja windows

1. primeiro comando a ser usado para baixar as dependencias é: `./mvnw.cmd install` 
2. Segundo comando vai ser `./mvnw.cmd spring-boot:run`

Caso os testes deem erro ultilize o seguinte comando abaixo:
`./mvnw.cmd install -DskipTests`

### Caso seu SO seja Linux
1. Primeiro comando é: `/mvnw install`
2. Segundo comando  é: `/mvnw spring-boot:run`

Caso os testes deem erro ultilize o seguinte comando abaixo: `./mvnw install -DskipTests`