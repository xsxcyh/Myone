package web;

import bean.comment;
import com.google.gson.Gson;
import dao.commentdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment/add")
public class CommentAdd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String body = req.getParameter("body");
        try{
            comment rw = new commentdao().addrw(new comment(name,body));
            String json = new Gson().toJson(rw);
            resp.getWriter().write(json);
        }catch (Exception ex){

        }
    }
}
