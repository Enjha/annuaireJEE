<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url var="bootstrap_css"
       value="/webjars/bootstrap/4.6.0-1/css/bootstrap.min.css"/>
<c:url var="bootstrap_js"
       value="/webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"/>
<c:url var="jquery_js" value="/webjars/jquery/3.5.1/jquery.min.js"/>
<c:url var="cssFiles" value="../css/general.css"/>

<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <%@ page pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>AnnuaireJEE</title>
    <style>
        <%@include file="../css/general.css" %>
        <%@include file="../css/footer.css"%>
        <%@include file="../css/connectionButton.css"%>
        <%@include file="../css/accessAnnuaire.css"%>
    </style>
    <link rel="stylesheet" href="${bootstrap_css}">
    <script src="${jquery_js}"></script>
    <script src="${bootstrap_js}"></script>
</head>