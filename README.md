<p align="center">ToDoList Observer</p>

<p align="center">
    Aplicação API REST de um To Do List desenvolvida seguindo o padrão de projeto Observer.  
</p>  

### Tecnologias utilizadas neste projeto
- [x] API REST
- [x] SpringBoot
- [x] PostgreSQL

### Endpoints

Endpoint para gerenciar a lista de ToDo e itens da lista.

| Método HTTP | Endpoint                   | Descrição                                       |
|-------------|----------------------------|-------------------------------------------------|
| POST        | `/todo/list`               | Endpoint para criar uma lista.                  |
| POST        | `/todo/list/{listId}/item` | Endpoint para adicionar um item na lista.       |
| GET         | `/todo/list/{listId}`      | Endpoint para listar todos os itens uma lista.  |
| GET         | `/todo/item/{itemId}`      | Endpoint para obter um item especifico.         |
| DELETE      | `/todo/item/{itemId}`      | Endpoint para remover um item da lista.         |
| PATCH       | `/todo/item/{itemId}`      | Endpoint para marcar o item como resolvido.     |

### Request

#### - Marcar item como resolvido
#### Endpoint
`http://localhost:8080/todo/item/3`
#### Method 
    - PATCH
#### Body

#### - Remover item da lista
#### Endpoint
`http://localhost:8080/todo/item/3`
#### Method
    - DELETE

#### - Listar um item especifico
#### Endpoint
`http://localhost:8080/todo/item/3`
#### Method
    - GET

#### - Listar os itens de uma lista
#### Endpoint
`http://localhost:8080/todo/list/1`
#### Method
    - GET

#### - Adiconar um item em uma lista.
#### Endpoint
`http://localhost:8080/todo/list/1/item`
#### Method
    - POST
#### Body
```json
{
    "description": "Lavar carro",
    "isDone": true
}
```

#### - Criar uma nova lista.
#### Endpoint
`http://localhost:8080/todo/list`
#### Method
    - POST
#### Body
```json
{
  "items":[
    "Casa",
    "Jardim"
  ]
}
```

### Meus Consagrados
- [x] Higor
- [x] Maria Clara
- [x] Arthur
- [x] Felipe
- [x] Ticiano
- [x] Emanuel
- [x] Michel


- remover uma lista
- criar um nome para lista