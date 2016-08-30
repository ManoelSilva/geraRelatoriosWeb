<%-- 
    Document   : estoqueTecnico
    Created on : 26/08/2016, 18:52:44
    Author     : touti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Estoque de Técnico</title>
    </head>
    <body>
        <form action="relatorioEstoqueUnico" method="POST">
            
            Digite o id do Tecnico: <input type="text" name="idSky"/><br/>
            
            <input type="submit" value="Gera PDF"/>
        </form>
    </body>
</html>
