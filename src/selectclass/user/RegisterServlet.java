package selectclass.user;

import dao.userdao.Userdao;
import entity.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user =new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("userPassword"));
        user.setPhone(request.getParameter("userPhone"));
        user.setEmail(request.getParameter("userEmail"));
        if(request.getParameter("userGender").equals("0")){
            user.setSex("男");
        }
        else {
            user.setSex("女");
        }
        Userdao userdao = new Userdao(user);
        if(userdao.register()){
            response.sendRedirect("/tourist_project_war_exploded/StaticHtmlPage-master/kecheng/zhuye.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
