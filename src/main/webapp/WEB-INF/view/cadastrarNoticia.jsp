<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gerenciador</title>
</head>
<body>

<h1>Form para cadastro da notícia</h1>

<form action="/inserirNoticia" method="POST" enctype="multipart/form-data">
    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo" required><br><br>

    <label for="lide">Lide:</label>
    <input type="text" id="lide" name="lide" required><br><br>

    <label for="corpo">Corpo da Notícia:</label>
    <textarea id="corpo" name="corpo" required></textarea><br><br>

    <label for="imagem">Imagem:</label>
    <input type="file" id="imagem" name="imagem" accept="image/*"><br><br>

    <button type="submit">Salvar</button>
</form>




</body>
</html>