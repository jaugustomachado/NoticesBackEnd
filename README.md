Projeto BackEnd - API REST - SPRINGBOOT - Sistema de avisos (Notices)

Implementação de uma API que fornece operações necessárias codificar de um sistema CRUD (create, read, update, delete) de avisos.


Arquivos chave do repositório:
SQLScript.sql (NoticesBackEnd/src/) - Código para criação do banco de dados utilizando o MYSQL

Packages do Programa: controller, exceptions, model, repository e service (NoticesBackEnd/src/main/java/Augusto/notices/)

endpoints da API (controler):

URL:"http://localhost:8080"
@RequestMapping({ "/notices" })

O programa é capaz de listar todos os avisos do banco de dados, fazer uma pesquisa com base no título ou id do aviso (passando o parâmetro respectivo), deleção do aviso (passando o parâmetro id), salvar um novo aviso com título e descrição, fazendo o set da data de publicação automaticamente, fazer o update tanto do título ou da descrição passando o id como referência e por fim realizar o set da data de abertura do aviso(viewing_date) automaticamente quando o usuário abre o aviso no FrontEnd.
