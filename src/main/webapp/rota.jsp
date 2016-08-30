<%-- 
    Document   : rota
    Created on : 30/08/2016, 13:11:14
    Author     : touti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Rota</title>
    </head>
    <body>
        <form action="relatorioRota" method="POST">

            Digite o id do Tecnico: <input type="text" name="idSky"/><br/>

            <input type="submit" value="Gera PDF"/>
        </form>
    </body>
</html>

