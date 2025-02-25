<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gerenciador</title>
</head>
<body>
<!-- Exibir a mensagem de erro se houver -->
<c:if test="${not empty msg}">
    <div style="color: red; font-weight: bold;">
            ${msg}
    </div>
</c:if>

<h1>Bem vindo de volta</h1>

<h1><a href="/cadastrarNoticiaView" >Cadastrar noticia</a></h1>
</body>
</html>