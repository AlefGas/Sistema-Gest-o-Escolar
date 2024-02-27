# Sistema-Gest-o-Escolar
Sistema de gestão escolar 

## Requisitos

-[] Crud De Alunos
-[] Crud de professores
-[] Crud de Coodernadores 
-[] Autencticacao
-[] Dashboard
## Documentação


### Endpoints

-Listar Categoria
-Apagar Categoria
-Detalhar Categoria
-Cadastrar Categoria
-Atualizar Categoria

### Listar Categorias

'GET'/Categoria

Retorna um Array com todas as categorias do Usuario

#### Exemplo de resposta

|código| descrição|
|------|----------|
|200| Categoria retornada com sucesso
|401| Autorizado não autorizado. realize a autenticação em /login

### Cadastrar Categoria 
'POST' /CATEGORIA

Cadastro de uma categoria com o corpo de uma requisição

#### Corpo da requisição
|Campo|tipo|Obrigatorio|descrição|
|-----|----|-----------|---------|
|nome| String| Sim     | um nome curto para identificar a categoria
|icone|String|X        |O nome do icone conforme biblioteca materia lIcons


#### Codigo de Resposta

|201| Categoria Cadastrada com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| não Autorizado. Realize a autenticação em /login

### Detalhar Categoria

'GET' /CATEGORIA

Retorna um objeto com uma categoria por id
#### Corpo da requisição



