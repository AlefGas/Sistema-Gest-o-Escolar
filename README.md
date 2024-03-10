# Sistema-Gestão-Escolar

Sistema de gestão escolar 

## Requisitos

- [ ] Crud de Alunos
- [ ] Crud de Matrículas
- [ ] Crud de Funcionários
- [ ] Autenticação
- [ ] Dashboard

## Documentação

### Endpoints

- [Listar Alunos](#listar-alunos)
- [Cadastrar Alunos](#cadastrar-alunos)
- [Detalhar Alunos](#detalhar-alunos)
- [Apagar Alunos](#apagar-alunos)
- [Atualizar Alunos](#atualizar-alunos)

### Listar Alunos

`GET` /alunos

Retorna um Array com todos os alunos

#### Exemplo de resposta

```js
[
    {
        "RM": 1,
        "nome": "Pedro",
        "turma": "A"
    }
]
```


#### Códigos de resposta

|código| descrição|
|------|----------|
|200| Aluno retornado com sucesso
|401| Não autorizado. Realize a autenticação em /login

### Cadastrar Alunos

`POST` /alunos

Cadastrar um aluno com o corpo de uma requisição

#### Corpo da requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Nome do aluno matriculado
|turma|string|✅|Turma do aluno respectivo

```js
{
    "nome": "Pedro",
    "turma": "A"
}
```

#### Exemplo da resposta

```js
{
    "RM": 1,
    "nome": "Pedro",
    "turma": "A"
}
```

#### Códigos de Resposta

|código|descrição|
|------|---------|
|200| Aluno cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login


### Apagar Alunos

`DELETE` /aluno/`{id}`

Apaga a categoria com o `id` informado no parâmetro de path.


#### Códigos de Resposta

|código|descrição|
|------|---------|
|201| Aluno apagado com sucesso
|401| Não autorizado. Realize a autenticação em /login



### Detalhar Alunos

`GET` /alunos/`{id}`

Retorna os dados do aluno com o `id` informado no parâmetro de path.

#### Exemplo da Resposta

```js
// requisição /aluno/1
{
    "RM": 1,
    "Nome": "Pedro",
    "Turma": "A"
}
```

#### Código de Resposta

|código|descrição|
|------|---------|
|204| Aluno retornado com sucesso
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe categoria com o `id` informado


### Atualizar Alunos

`PUT` /aluno/`{id}`

Atualiza os dados da categoria com o `id` informado na path.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|nome do aluno matriculado
|turma|string|✅|turma do aluno respectivo

```js
{
    "nome": "Pedro",
    "turma": "A"
}
```

#### Exemplo da resposta

```js
{
    "RM": 1,
    "nome": "Pedro",
    "turma": "A"
}
```

#### Códigos de Resposta

|código|descrição|
|------|---------|
|204| Aluno retornado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe categoria com o `id` informado

---
