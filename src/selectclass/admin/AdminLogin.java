package selectclass.admin;

import dao.admindao.Admindao;
import dao.userdao.Userdao;
import entity.admin.Admin;
import entity.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Admin admin = new Admin();
        admin.setUsername(request.getParameter("edtUserName"));
        admin.setPassword(request.getParameter("edtPassWord"));
        Admindao admindao = new Admindao(admin);
        System.out.println(admin);
        if(admindao.login()){
            response.sendRedirect("/tourist_project_war_exploded/background/xianshi.jsp");
        }
        else {
            PrintWriter out = response.getWriter();
            out.write("用户名或密码错误！！！");
            response.sendRedirect("/tourist_project_war_exploded/StaticHtmlPage-master/kecheng/UTF8/index.html");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
