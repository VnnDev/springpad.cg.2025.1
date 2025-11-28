# Criar um pad

Ao acessar a rota `/novo` o usuário logado pode cadastrar um novo pad na sua biblioteca.

Para implementar, insira ou ajuste as partes:

 - [ ] Crie `com.projetos.springpad.controller.pad.NewController.java`
 - [ ] Ajuste `src/main/resources/templates/layouts/header.html`
 - [ ] Ajuste `com.projetos.springpad.model.PadsModel.java`
 - [ ] Ajuste `src/main/resources/static/css/style.css`
 - [ ] Ajuste `src/main/resources/templates/pad/new.html`

Em `header.html`, corrigimos o link para um novo "pad" que agora é `/novo`.

Os ajustes em `PadsModel.java` corrigem uma falha na inserção da data em `pad.createdAt`, mas, talvez, isso já tenha sido feito antes.

Em `NewController` temos as duas rotas:
 - `GET /novo` exibe o formulário disponível em `new.html`;
 - `POST /novo` recebe os campos do formulário e processa o novo "pad".

Em `style.css` apenas adicionamos a classe `.pad-content` para ajustar a fonte do `textarea`.
