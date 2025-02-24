<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Form Cadastro</title>
</head>
<body>
<header>
    <!-- Exibir a mensagem de erro se houver -->
    <c:if test="${not empty msg}">
        <div style="color: red; font-weight: bold;">
                ${msg}
        </div>
    </c:if>
</header>

<h1>Form para login</h1>

<form action="/login" method="post">
    <fieldset>
        <label>Login:</label>
        <input type="text" name="login"/>
        <label>Senha:</label>
        <input type="password" name="senha"/>
        <input type="submit" value="Enviar"/>
    </fieldset>
</form>

</body>
</html>