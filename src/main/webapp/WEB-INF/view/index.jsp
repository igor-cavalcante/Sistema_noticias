<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema Noticias</title>
    <link rel="stylesheet" type="text/css" href="estiloNews.css"/>
</head>
<style>

</style>
<body>

<header>
    <nav>
        <ul>
            <li>
                <a href="/login">Login</a>
            </li>
            <li>
                <a href="/cadastrarReporterView">Criar Conta</a>
            </li>
            <li>
                <a href="#">Cadastrar Noticia</a>
            <li>
        </ul>
        <hr>
        <ul>
            <li>
                <a href="#">teste noticia</a>
            </li>
        </ul>


    </nav>
</header>

<main>
<!-- Exibir a mensagem de erro se houver -->
<c:if test="${not empty msg}">
    <div style="color: red; font-weight: bold;">
            ${msg}
    </div>
</c:if>

<h1>Noticias Diárias</h1>

</main>
</body>
</html>