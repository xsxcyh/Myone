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
import java.util.List;

@WebServlet("/comment/list")
public class CommentList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<comment> myrws = new commentdao().getallrw();
            String json = new Gson().toJson(myrws);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
