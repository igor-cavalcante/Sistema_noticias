<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gerenciador</title>
    <link rel="stylesheet" href="editarNews.css">
</head>
<body>

<!-- Exibir a mensagem de erro se houver -->
<c:if test="${not empty msg}">
    <div class="error-message">
            ${msg}
    </div>
</c:if>

<h1>Formulário para cadastro da notícia</h1>
<form action="/editarNoticia" method="post">
    <input type="hidden" name="id" value="${noticia.getId()}" />
    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo" value="${noticia.getTitulo()}" required />

    <label for="lide">Lide:</label>
    <textarea id="lide" name="lide">${noticia.getLide()}</textarea>

    <label for="corpo">Corpo:</label>
    <textarea id="corpo" name="corpo">${noticia.getCorpo()}</textarea>

    <button type="submit">Salvar Edição</button>
</form>

</body>
</html>