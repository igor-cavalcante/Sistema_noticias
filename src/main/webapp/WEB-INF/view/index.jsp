<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Continuando com Spring MVC</title>
</head>
<body>

<header>
    <nav>
        <ul>
            <li>
                <a href="#">teste noticia</a>
            </li>
            <li>
                <a href="#">Login</a>
            </li>
            <li>
                <a href="/cadastrarReporter">cadastrar</a>
            </li>
        </ul>

    </nav>
</header>
    <h1>Noticias Diárias</h1>

<!-- Exibir a mensagem de erro se houver -->
<c:if test="${not empty msg}">
    <div style="color: red; font-weight: bold;">
            ${msg}
    </div>
</c:if>

</body>
</html>