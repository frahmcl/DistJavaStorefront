
<%@ page import="java.util.List" %>
<%@ page import="us.mattgreen.model.*" %>
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
                <li class="current">
                    <a href="pricing.jsp">Pricing</a>
                </li>
                <li>
                    <a href="cart.go">Cart</a>
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
            <h1 class="page-title">About Us</h1>
        </article>
    </div>
</section>
<%--

    <table>
        <%
            List products = (List) request.getAttribute("listOfProducts");
            Iterator it = products.iterator();
            while(it.hasNext()){
                Product product = (Product) it.next();
                out.print("<tr><td><img src=img/"
                        + product.getProductName().replaceAll("[^a-zA-Z]+", "").toLowerCase()
                        + ".jpg height='100' width='150'> </td> <td>"
                        + product.getProductName()
                        + "</td> <td>"
                        +  product.getPrice() + "</td></tr>");
            }
        %>
    </table>
    <input type="submit" value="Purchase">
    </form>--%>
<form action="cartplace.go">
<table border="1">
    <%
        ProductService productService = new ProductService();
        List<Product> productList = productService.getAllProducts();
        for (Product product : productList){
    %>
    <tr>
        <td class="foodImage">
            <img src="img/<%=product.getProductName().replaceAll("[^a-zA-Z]+", "").toLowerCase()%>.jpg" height="150" width="150">
        </td>
        <td><%= product.getProductName() %></td>
        <td>
           <%= product.getPrice() %>
        </td>
        <td><input type='checkbox' name='cartItem' value='<%= product.getId() %>'></td></tr>
    </td>
    </tr>
    <%
        }
    %>
</table>
   <input type="submit" value="Purchase">
</form>
<footer>
    <p>Frahm Stores, Copyright &copy; 2018</p>
</footer>
</body>

</html>