  # language: pt
  Funcionalidade: Criação de posts via API

  Como um consumidor da API
  Eu quero criar um post
  Para que ele seja registrado corretamente no sistema

  Scenario: Criar post com sucesso
  Given possuo um token válido
  And possuo dados válidos para criar um post
  When eu envio a requisição de criação do post
  Then a API deve retornar o status 201
  And a resposta deve seguir o contrato esperado

  Funcionalidade → sobre o que é
  Narrativa → por que isso existe
  Scenario → um exemplo real
  Given → condições iniciais
  When → ação
  Then → resultado esperado
  And → complementos


  Esse arquivo descreve o comportamento esperado da API em linguagem natural.
  Ele não executa testes, ele documenta o que deve acontecer.
  A automação em Java garante que esse comportamento está sendo respeitado.