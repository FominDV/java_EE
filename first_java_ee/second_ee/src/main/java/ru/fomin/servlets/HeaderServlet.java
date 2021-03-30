package ru.fomin.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

    private String contextPath;
    private List<String[]> pathList;

    @Override
    public void init() throws ServletException {
        contextPath = getServletContext().getContextPath();
        pathList = Collections.synchronizedList(new ArrayList<>());
        pathList.add(new String[]{"cart", "cart"});
        pathList.add(new String[]{"catalog", "catalog"});
        pathList.add(new String[]{"main", "main"});
        pathList.add(new String[]{"order", "order"});
        pathList.add(new String[]{"product", "product"});
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String header = (String) req.getAttribute("header");
        resp.getWriter().printf("<div class='header'><ul>%s</ul><h1 class='main_tittle'>%s<h1></div>", getAllItemLists(),header);
    }

    private String getItemList(String relativePath, String title) {
        return String.format("<li><a href='%s/%s'>%s</a></li>", contextPath, relativePath, title);
    }

    private synchronized String getAllItemLists() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String[] path : pathList) {
            stringBuffer.append(getItemList(path[0], path[1]));
        }
        return stringBuffer.toString();
    }

}
