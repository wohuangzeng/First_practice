package selectclass.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ExitSelvelt")
public class ExitSelvelt extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookie=request.getCookies();
        for(Cookie c:cookie){
            Cookie cook =new Cookie(c.getName(),c.getValue());
            cook.setMaxAge(0);
            response.addCookie(cook);
        }
        response.sendRedirect("/tourist_project_war_exploded/StaticHtmlPage-master/kecheng/zhuye.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
