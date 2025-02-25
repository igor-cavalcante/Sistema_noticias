<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema Notícias</title>
    <link rel="stylesheet" type="text/css" href="estiloNews.css"/>
</head>
<body>

<header>
    <nav class="top-nav">
        <ul>
            <li><a href="/login">Login</a></li>
            <li><a href="/cadastrarReporterView">Criar Conta</a></li>
            <li><a href="/gerenciador">Gerenciador</a></li>
        </ul>
    </nav>
</header>

<div class="container">
    <aside class="sidebar">
        <h2>Lista de Notícias</h2>
        <ul>
            <c:forEach var="noticia" items="${noticias}">
                <li><a href="/noticia/${noticia.getId()}">${noticia.getTitulo()}</a></li>
            </c:forEach>
        </ul>
    </aside>

    <main>
        <!-- Exibir a mensagem de erro se houver -->
        <c:if test="${not empty msg}">
            <div class="error-message">${msg}</div>
        </c:if>

        <h1>Notícias Diárias</h1>

        <!-- Exibição das notícias -->
        <c:forEach var="noticia" items="${noticias}">
            <div class="news-item">
                <h2>${noticia.getTitulo()}</h2>
                <p>${noticia.getLide()}</p>
                <p>${noticia.getCorpo()}</p>
                <p class="date">Data: ${noticia.getData()}</p>
                <p class="date">Reporter: ${noticia.getReporter().getName()}</p>
            </div>
        </c:forEach>
    </main>
</div>

<footer>
    <p>&copy; 2025 Sistema Notícias. Todos os direitos reservados.</p>
</footer>

</body>
</html>
