<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
  <title>welcome页面</title>
  <link rel="stylesheet" type="text/css" href="./css/main.css">
  <link rel="stylesheet" type="text/css" href="./css/layer.css">
  <script type="text/javascript" src="./js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="./js/hi.js"></script>
  <script type="text/javascript" src="./js/layui/layer.js"></script>
</head>

<body>
<%--<!-- 输出普通字符 -->--%>
<%--${msg } <br/>--%>
<%--<!-- 输出List -->--%>
<%--<p>书籍列表</p>--%>
<%--<div>--%>
  <%--<ul>--%>
<%--<c:forEach items="${bookList}" var="node">--%>
    <%--<li class="main-content">${node}</li>--%>
<%--</c:forEach>--%>
  <%--</ul>--%>
<%--</div>--%>
<%--<br/>--%>
<%--<br/>--%>

<%--<!-- 输出Map -->--%>
<%--<c:forEach items="${map}" var="node">--%>
  <%--姓名：<c:out value="${node.key}"></c:out>--%>
  <%--住址：<c:out value="${node.value}"></c:out>--%>
  <%--<br/>--%>
<%--</c:forEach>--%>


<ul class="box">
  <c:forEach items="${picList}" var="pic">
    <div class="pic-content">
    <li value="${pic}" style="background: url('./images/${pic}');background-size: 100% 100%;"></li>
    <span>${pic}</span>
    </div>
  </c:forEach>
</ul>


</body>
</html>