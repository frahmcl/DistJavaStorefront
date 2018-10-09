<%--
  Created by IntelliJ IDEA.
  User: tech
  Date: 9/23/2018
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="us.mattgreen.model.Product" %>
<%@ page import="us.mattgreen.model.ProductService" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Fake storefront">
    <meta name="keywords" content="distrubted java">
    <meta name="author" content="Chris Frahm">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Storefront | Pricing</title>
    <link rel="stylesheet" href="./css/styles.css">
</head>

<body>

<header>
    <div class="container">
        <div id="branding">
            <h1><span class="highlight">Frahm</span>Stores</h1>
        </div>
        <nav>
            <ul>
                <li >
                    <a href="index.jsp">Home</a>
                </li>
                <li>
                    <a href="about.html">About</a>
                </li>
                <li class="current">
                    <a href="pricing.jsp">Pricing</a>
                </li>
                <li>
                    <a href="cart.jsp">Cart</a>
                </li>
            </ul>
        </nav>
    </div>
</header>
<section id="newsletter">
    <div class="container">
        <h1>Subscribe to our newsletter</h1>
        <form>
            <input type="email" placeholder="Enter email...">
            <button type="submit" class="button_1">Subscribe</button>
        </form>
    </div>
</section>

<section id="main">
    <div class="container">
        <article id="main-col">
            <h1 class="page-title">Products</h1>
        </article>
    </div>
</section>
<table border="1">
    <%

        List<Product> productList = (List)request.getAttribute("productList");
        for (Product product : productList){
    %>
    <tr>
        <td class="foodImage">
            <img src="img/<%=product.getProductName().replaceAll("[^a-zA-Z]+", "").toLowerCase()%>.jpg" height="150" width="150">
        </td>
        <td><a href="?id=<%= product.getId() %>"><%= product.getProductName() %></a></td>
        <td> <%= product.getPrice() %> </td>
        <td>
            <form method="GET" action="cart.jsp">
                <input type="checkbox" name="productId" value="<%=product.getId()%>" hidden>
                <button type="submit"  value="productController">
                    Add to Cart
                </button>
            </form>

        </td>
    </tr>
    <%
        }
    %>
</table>


<footer>
    <p>Frahm Stores, Copyright &copy; 2018</p>
</footer>
</body>

</html>