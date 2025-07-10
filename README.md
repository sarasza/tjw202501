<b>Sistema de Gestão Acadêmica</b>

Primeiro passo para o funcionamento do código é alterar o login do banco MySql no arquivo <b>application.properties</b>

O login de administrador para acessar o sistema é:<br>
<b>Usuário: </b> admin@gmail.com<br>
<b>Senha: </b> T@ylor13

No navegador, o link para acesso é:<br>
<b>http://localhost:8080/login</b>

Nesse link principal, após o login, irá aparecer todos os outros links necessários para cadastros de <b>Aluno</b>, <b>Professor</b>, <b>Disciplina</b>, <b>Turma</b> e <b>Matrícula</b>

O projeto foi desenvolvido no VSCode, então o ideal é clonar o arquivo e rodar na mesma IDE.
Para rodar, precisa colocar no terminal o seguinte comando: <b>mvn spring-boot:run</b>

Requisitos:
<b>Java JDK 17</b>
<b>MySQL 8.0+</b>
<b>Maven 3.8+</b>
