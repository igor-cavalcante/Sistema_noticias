<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gerenciador</title>
</head>

<style>
    /* Estilos gerais do corpo */
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Estilo para a mensagem de erro */
    .error-message {
        color: red;
        font-weight: bold;
        margin-bottom: 20px;
        font-size: 14px;
    }

    /* Estilos para o título principal */
    h1 {
        font-size: 24px;
        color: #333;
        margin-bottom: 20px;
    }

    /* Estilos gerais de formulários */
    form {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 600px;
        box-sizing: border-box;
    }

    /* Estilo para os rótulos dos campos */
    label {
        font-size: 14px;
        color: #555;
        margin-bottom: 8px;
        display: block;
    }

    /* Estilos para os campos de texto e área de texto */
    input[type="text"],
    textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 14px;
    }

    textarea {
        height: 150px;
        resize: vertical;
    }

    /* Estilo para o botão de envio */
    button[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 10px 15px;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
        font-size: 16px;
    }

    /* Efeito de hover nos botões */
    button[type="submit"]:hover {
        background-color: #0056b3;
    }

    /* Estilo para tornar o formulário responsivo */
    @media (max-width: 768px) {
        form {
            max-width: 100%;
            padding: 15px;
        }
        h1 {
            font-size: 20px;
        }
    }

</style>
<body>

<!-- Exibir a mensagem de erro se houver -->
<c:if test="${not empty msg}">
    <div class="error-message">
            ${msg}
    </div>
</c:if>

<h1>Formulário para edição da notícia</h1>
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