package selectclass.user;

import dao.userdao.Userdao;
import entity.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user =new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        if(!user.getUsername().equals("")) {
            Cookie cookie = new Cookie("username", user.getUsername());
            response.addCookie(cookie);
        }
        Userdao userdao = new Userdao(user);
        if(userdao.login()){
            response.sendRedirect("/tourist_project_war_exploded/StaticHtmlPage-master/kecheng/zhuye.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
