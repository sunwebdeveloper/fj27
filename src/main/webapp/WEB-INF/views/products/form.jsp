<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/" var="contextPath" />
<link rel="stylesheet" href="${contextPath }resources/css/uikit.min.css" />
<link rel="stylesheet" href="${contextPath }resources/css/uikit-rtl.min.css" />
<script src="${contextPath }resources/js/uikit.min.js"></script>
<script src="${contextPath }resources/js/uikit-icons.min.js"></script>
<title>Novo Livro</title>
</head>
<body>
	<div class="uk-container uk-container-small">
		<section>
			<c:url var="url" value="/products"/>
			<form action="${url }" method="post">
				<fieldset class="uk-fieldset">
		
					<legend class="uk-legend">Novo Produto</legend>
		
					<div class="uk-margin">
						<input class="uk-input" type="text" name="title" placeholder="Titulo"/>
					</div>
		
					<div class="uk-margin">
						<textarea class="uk-textarea" rows="5" name="description" placeholder="Descrição"></textarea>
					</div>
					
					<div class="uk-margin">
						<input class="uk-input" type="text" name="numberOfPages" placeholder="Número de Páginas"/>
					</div>
		
					<div>
						<input class="uk-button uk-button-default" type="submit" value="Salvar" />
					</div>
				</fieldset>
			</form>
		</section>
	</div>
</body>
</html>