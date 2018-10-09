package us.mattgreen.controller;

import us.mattgreen.model.Product;
import us.mattgreen.model.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/ProductController" )
public class ProductController extends HttpServlet {

    private static final String RESULT_PAGE = "productDetail.jsp";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NameController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NameController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductService productService = new ProductService();
        RequestDispatcher dispatcher = null;
        String search = request.getParameter("search");
        int id = Integer.parseInt(request.getParameter("id"));
        String item = request.getParameter("items");

        if(id >= 0 ){
            Product product = productService.getSingleItem(id);
            request.setAttribute("product", product);
            RequestDispatcher view =
                    request.getRequestDispatcher("productDetail.jsp");
            view.forward(request, response);
        } else if (search != null){
            List<Product> productList = productService.findNames(search);
            request.setAttribute("productList", productList);
            RequestDispatcher view =
                    request.getRequestDispatcher("productList.jsp");
            view.forward(request, response);
        } else {
            List<Product> productList = productService.getAllProducts();
            request.setAttribute("productList", productList);
            RequestDispatcher view =
                    request.getRequestDispatcher("productList.jsp");
            view.forward(request, response);
        }

      /*  if(item != null){
            Cookie items = new Cookie("items", request.getParameter("items"));
            items.setMaxAge(60*60*24);
            RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
            view.forward(request, response);
        }*/

        dispatcher.forward(request, response);
        //String id = request.getParameter("id");
     /*   String search = request.getParameter("search");
            if (search != null) {
            List<Product> productList = productService.findNames(search);
            request.setAttribute("productList", productList);
            dispatcher =
                    request.getRequestDispatcher("/productList.jsp");
                dispatcher.forward(request, response);
        } else {
            List<Product> productList = productService.getAllProducts();
            request.setAttribute("productList", productList);
            dispatcher =
                    request.getRequestDispatcher("/productList.jsp");
        }*/
/*
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
