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
<c:if test="${not empty erro}">
    <div style="color: red; font-weight: bold;">
            ${erro}
    </div>
</c:if>
    </header>


<h1>Form para cadastro do reporterad</h1>

<form method="post" action="/inserirReporter">
    <fieldset>
        <label>Nome:</label>
        <input type="text" name="nome" placeholder="Nome Completo"/>
        <label>Login:</label>
        <input type="text" name="login" placeholder="Login"/>
        <label>Senha:</label>
        <input type="password" name="senha" placeholder="Senha"/>
        <input type="submit" value="Cadastrar"/>
    </fieldset>

</form>



</body>
</html>