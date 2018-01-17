<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
			<form:form servletRelativeAction="${url }" method="POST" commandName="produto" enctype="multipart/form-data">
				<fieldset class="uk-fieldset">
		
					<legend class="uk-legend">Novo Produto</legend>
		
					<div class="uk-margin">
						<label for="title">Título</label>
						<form:input path="title" id="title" cssClass="uk-input"/>
						<form:errors path="title" />
					</div>
		
					<div class="uk-margin">
						<label for="description">Descrição</label>
						<form:textarea path="description" id="description" rows="5" cssClass="uk-textarea"/>
						<form:errors path="description" />
					</div>
					
					<div class="uk-margin">
						<label for="numberOfPages">Número de páginas</label>
						<form:input path="numberOfPages" id="numberOfPages" cssClass="uk-input"/>
						<form:errors path="numberOfPages" />						
					</div>

					<div class="uk-margin">
						<label for="releaseDate">Data de lançamento</label>
						<form:input path="releaseDate" id="releaseDate" type="date"/>
						<form:errors path="releaseDate" />						
					</div>
		
					<c:forEach items="${tipos }" var="tipo" varStatus="status">
						<label>${tipo } :</label>
						<input type="text" name="precos[${status.index }].valor" />
						<input type="hidden" name="precos[${status.index }].tipo" value="${tipo }">
						<br/>
					</c:forEach>

					<div class="uk-margin">
						<label for="summary">Sumario do livro</label>
						<input type="file" id="summary" name="summary">
						<form:errors path="summaryPath" />						
					</div>

					<div>
						<input class="uk-button uk-button-default" type="submit" value="Salvar" />
					</div>
				</fieldset>
			</form:form>
		</section>
	</div>
</body>
</html>