<!--
	Why it is used:

This page shows available training packs / courses / subscription plans.

What it does:
Displays list of courses or packages
Shows price, duration, features
Lets user choose a plan
Why it is needed:

This is the main business page of your system:

It converts users into customers
Helps users decide what to buy/enroll
Simple flow:

User - logs in -views packs - selects a plan
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Skill Packs</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="header">
   <img src="${pageContext.request.contextPath}/images/logo.png">
    <h2>Available Skill Packs</h2>
</div>

<div class="nav-bar" style="text-align: center; margin-bottom: 20px;">
    <c:if test="${not empty sessionScope.user}">
        Welcome, <b>${sessionScope.user.name}</b> | 
        <a href="/subscriptions/${sessionScope.user.id}">My Subscriptions</a> | 
        <a href="/add-pack">Add Skill Pack</a> | 
        <a href="/logout">Logout</a>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <a href="/login">Login</a> | <a href="/register">Register</a>
    </c:if>
</div>

<div class="container">

    <h3>All Courses</h3>

    <c:if test="${not empty editPack}">
        <div class="card" style="border: 2px solid #007bff; padding: 15px; margin-bottom: 20px;">
            <h4>Edit Skill Pack</h4>
            <form action="${pageContext.request.contextPath}/update-pack" method="post">
                <input type="hidden" name="id" value="${editPack.id}">
                <input type="text" name="title" value="${editPack.title}" placeholder="Title" required><br><br>
                <input type="text" name="description" value="${editPack.description}" placeholder="Description"><br><br>
                <input type="number" step="0.01" name="price" value="${editPack.price}" placeholder="Price" required><br><br>
                <button type="submit">Update Pack</button>
                <a href="${pageContext.request.contextPath}/packs" style="margin-left: 10px;">Cancel</a>
            </form>
        </div>
    </c:if>

    <!--  loop skill packs -->
    <c:forEach var="pack" items="${packs}">

        <div class="card">

            <!--  show title -->
            <h4>${pack.title}</h4>

            <!--  show description -->
            <p>${pack.description}</p>

            <!--  show price -->
            <b>₹ ${pack.price}</b>

            <br><br>

            <!-- subscribe action -->
            <a href="${pageContext.request.contextPath}/subscribe?userId=${sessionScope.user.id}&packId=${pack.id}">
                Subscribe
            </a>

            <!-- edit action -->
            <a href="${pageContext.request.contextPath}/edit-pack/${pack.id}" style="margin-left: 10px;">
                Edit
            </a>

            <!-- delete action -->
            <a href="${pageContext.request.contextPath}/delete-pack/${pack.id}" style="margin-left: 10px; color: red;"
               onclick="return confirm('Are you sure you want to delete this pack?');">
                Delete
            </a>

        </div>

    </c:forEach>

</div>

</body>
</html>