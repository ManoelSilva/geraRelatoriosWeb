<%-- 
    Document   : multa
    Created on : 13/09/2016, 15:01:08
    Author     : touti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio de Multas</title>
    </head>
    <body>
        <form action="relatorioMulta" method="POST">
            Data Inicial: <input type="text" name="data_ini"/><br/>

            Data Final: <input type="text" name="data_fim"/><br/>

            Clique para gerar relatório: <input type="submit" value="Gera PDF"/>
        </form>
    </body>
</html>
    