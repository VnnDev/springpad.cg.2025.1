# Editar Pad

A rota `/edita/{id}` localiza e abre o "pad" para edição se:

 - O usuário logado é "owner" do "pad", caso contrário, vai para `/ver/{id}`
 - O "pad" está com `status.ON`, caso contrário, vai para `/` 

Ao salvar as alterações, vai para `/ver/{id}` com uma mensagem de sucesso.

 - [ ] Altere `src/main/resources/templates/pad/view.html`
 - [ ] Crie `com.projetos.springpad.controller.pad.EditController`
 - [ ] Crie `src/main/resources/templates/pad/edit.html`

Em `view.html` adicionamos uma caixa de alerta para as mensagens.

`EditController.java` controla os endpoint `GET /edita/{id}` que exibe o formulário e `POST /edita/{id}` quue processa as modificações.


