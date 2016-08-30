
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Sugestão de Material</title>
    </head>
    <body>
        <form action="relatorioSugestao" method="POST">
            
            Digite o id do Tecnico: <input type="text" name="idSky"/><br/>
            
            <input type="submit" value="Gera PDF"/>
        </form>
    </body>
</html>