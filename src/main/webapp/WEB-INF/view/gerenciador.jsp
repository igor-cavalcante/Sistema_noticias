<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gerenciador</title>
    <link rel="stylesheet" href="estiloGerenciador.css"></link>
</head>
<body>

<!-- Exibir a mensagem de erro se houver -->
<c:if test="${not empty msg}">
    <div style="color: red; font-weight: bold;">
            ${msg}
    </div>
</c:if>
<%
    // Recupera os cookies enviados pelo navegador
    Cookie[] cookies = request.getCookies();
    String nomeUsuario = "Visitante"; // Nome padrão caso não encontre o cookie

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("sessionName".equals(cookie.getName())) {
                // Supondo que o valor do cookie seja o nome do usuário
                nomeUsuario = cookie.getValue(); // Aqui você pode adicionar lógica para buscar o nome no banco ou outra fonte
            }
        }
    }
%>

<!-- Exibir a mensagem de erro se houver -->
<c:if test="${not empty msg}">
    <div class="error-message">${msg}</div>
</c:if>

<header>
    <nav class="top-nav">
        <ul>
            <li>
                <a href="/cadastrarNoticiaView" >Cadastrar notícia</a>
            </li>
            <li>
                <a href="/" >Ver todas as notícias</a>
            </li>
        </ul>
    </nav>
</header>

<main>
    <!-- Exibe o nome do usuário ou "Visitante" caso o cookie não exista -->
    <h1>Bem-vindo, <%= nomeUsuario %>!</h1>

    <h2>Suas notícias</h2>

    <!-- Exibição das notícias -->
    <c:forEach var="noticia" items="${noticias}">
        <div class="news-item">
            <h3>${noticia.getTitulo()}</h3>
            <p class="lide">${noticia.getLide()}</p>
            <p class="corpo">${noticia.getCorpo()}</p>
            <p class="date">Data: ${noticia.getData()}</p>
            <p class="date">Reporter: ${noticia.getReporter().getName()}</p>

            <!-- Botões Editar e Excluir -->
            <div class="action-buttons">
                <a href="/editarNoticia/${noticia.getId()}" class="btn edit-btn">Editar</a>
                <a href="/excluirNoticia/${noticia.getId()}" class="btn delete-btn" onclick="return confirm('Tem certeza que deseja excluir esta notícia?')">Excluir</a>
            </div>
        </div>
    </c:forEach>

</main>

</body>
</html>
