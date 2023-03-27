## Microblog Comente se Dev

![](https://cdn-icons-png.flaticon.com/128/950/950018.png)


:point_right: O projeto se trata de uma API com intuito de simulação de um microblog, onde seus usuários realizam posts contando como está o andamento de um bootcamp Java, tendo a possiblidade de outros devs comentarem as suas postagens.


Dentro da API há a possibilidade de realizar um CRUD em duas situações: Para usuários e Posts.



* Rotas para Usuários: 

GET /users : Lista todos os usuários </br>
GET /users{id} : Busca usuário por Id </br>
GET /users{id}/posts : Buscar posts pelo id do usuário </br>
POST /users : Inserir um novo usuário </br>
PUT /users/{id} : Edita um usuário </br>
DELETE /users/{id} : Deleta um usuário </br>


* Rotas para Posts: 

GET /posts/fullsearch : Busca palabras chaves com a data mínima e máxima </br>
GET /posts/titlesearch : Busca o post pelo título (DESCONTINUADO) </br>
GET /posts/{id} : Busca um post por Id </br>




:construction: O presente projeto está em contínuo aperfeiçoamento e poderá sofrer mudanças a qualquer momento.
