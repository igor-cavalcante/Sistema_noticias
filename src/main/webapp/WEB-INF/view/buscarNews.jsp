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
<style>
    /* Resetando margens e preenchimento do body */
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    header {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        background-color: #333;
        padding: 10px 0;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        z-index: 10;
    }

    header .top-nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
    }

    header .top-nav ul li {
        margin: 0 20px; /* Maior espaçamento entre os itens */
    }

    header .top-nav ul li a {
        color: white;
        text-decoration: none;
        font-weight: bold;
        font-size: 18px;
    }

    header .top-nav ul li a:hover {
        text-decoration: underline;
    }

    .container {
        display: flex;
        margin-top: 10px; /* Espaço para o cabeçalho */
    }

    .sidebar {
        width: 220px; /* Tamanho da barra lateral */
        background-color: #333;
        padding-top: 20px;
        box-shadow: 2px 0 5px rgba(0, 0, 0, 0.2);
        position: relative;
        z-index: 1;
    }

    .sidebar h2 {
        color: white;
        text-align: center;
        margin-bottom: 20px;
    }

    .sidebar ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }

    .sidebar ul li {
        margin: 10px 0;
    }

    .sidebar ul li a {
        color: white;
        text-decoration: none;
        font-size: 16px;
        display: block;
        padding: 10px 20px;
        transition: background-color 0.3s ease;
    }

    .sidebar ul li a:hover {
        background-color: #00bcd4;
        border-radius: 5px;
    }

    main {
        flex: 1;
        padding: 20px;
        background-color: #fff;
        max-width: 1200px;
        margin: 0 auto;
    }

    h1 {
        text-align: center;
        color: #333;
        font-size: 36px;
        margin-bottom: 20px;
    }

    .news-item {
        background-color: white;
        margin-bottom: 20px;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .news-item h2 {
        font-size: 28px;
        color: #333;
    }

    .news-item p {
        font-size: 18px;
        color: #555;
        line-height: 1.6;
    }

    .news-item p.date {
        font-style: italic;
        color: #888;
    }

    .error-message {
        color: red;
        font-weight: bold;
        text-align: center;
        margin: 10px 0;
    }

    footer {
        background-color: #333;
        color: white;
        padding: 10px;
        text-align: center;
        font-size: 14px;
    }

</style>
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
        <a href="/"><h2>Lista de Notícias</h2></a>
        <ul>
            <c:forEach var="noticia" items="${noticias}">
                <li><a href="/noticiaNews/${noticia.getId()}">${noticia.getTitulo()}</a></li>
            </c:forEach>
        </ul>
    </aside>


    <main>

        <c:if test="${not empty msg}">
            <div class="error-message">${msg}</div>
        </c:if>

        <h1>Notícias Diárias</h1>

        <!-- Exibição de uma única notícia -->
        <div class="news-item">
            <h2>${noticia.getTitulo()}</h2>
            <p>${noticia.getLide()}</p>
            <p>${noticia.getCorpo()}</p>
            <p>${noticia.getData()}</p>
        </div>


    </main>
</div>

<footer>
    <p>&copy; 2025 Sistema Notícias. Todos os direitos reservados.</p>
</footer>

</body>
</html>
