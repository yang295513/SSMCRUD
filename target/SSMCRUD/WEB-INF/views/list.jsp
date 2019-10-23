<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 10/20/2019
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-success">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <div class="row">

    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="item">
                <tr>
                    <th>${item.empId}</th>
                    <th>${item.empName}</th>
                    <th>${item.gender=="M"?"男":"女"}</th>
                    <th>${item.email}</th>
                    <th>${item.department.deptName}</th>
                    <th>
                        <button class="btn btn-warning btn-sm"><span class="glyphicon glyphicon-pencil"></span>编辑</button>
                        <button class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-remove"></span>删除</button>
                    </th>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">当前是第${pageInfo.pageNum},页一共有${pageInfo.pages}页,共有${pageInfo.total}条数据</div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <c:if test="${pageInfo.pageNum!=1}">
                        <li>
                            <a href="${pageContext.request.contextPath}/?pn=${pageInfo.prePage}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <li class="${pageInfo.pageNum==1?"disabled":""}"><a href="${pageContext.request.contextPath}/?pn=${pageInfo.firstPage}">首页</a></li>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                        <li class="${pageInfo.pageNum==pageNum?"disabled":""}"><a href="${pageContext.request.contextPath}/?pn=${pageNum}">${pageNum}</a></li>
                    </c:forEach>

                    <li class="${pageInfo.pageNum==pageInfo.pages?"disabled":""}"><a href="${pageContext.request.contextPath}/?pn=${pageInfo.lastPage}">末页</a></li>

                    <c:if test="${pageInfo.pageNum!=pageInfo.navigateLastPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/?pn=${pageInfo.nextPage}#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>