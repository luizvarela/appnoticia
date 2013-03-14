<%@ include file="/WEB-INF/cabecalho.jsp"%>
<% if(usuario==null){ %>
<form action="AutenticaUsuarioServlet" method="post">
Login: <input type="text" name="login"><br/>
Senha: <input type="password" name="senha"><br/>
<input type="submit" value="Logar" class="btn btn-primary">
</form>
<%} %>
<%@ include file="/WEB-INF/rodape.jsp"%>