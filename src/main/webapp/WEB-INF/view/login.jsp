<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Form Cadastro</title>
    <link rel="stylesheet" href="formLogin.css">
</head>
<body>
<header>
    <!-- Exibir a mensagem de erro se houver -->
    <c:if test="${not empty msg}">
        <div class="error-message">
                ${msg}
        </div>
    </c:if>
</header>

<h1>Formulário de Login</h1>

<form action="/login" method="post">
    <fieldset>
        <legend>Entre com suas credenciais</legend>
        <label for="login">Login:</label>
        <input type="text" id="login" name="login" required placeholder="Digite seu login"/>

        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required placeholder="Digite sua senha"/>

        <input type="submit" value="Entrar"/>
    </fieldset>
</form>
</body>
</html>
