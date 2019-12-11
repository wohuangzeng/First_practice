package selectclass.hotel;

import dao.Dao;
import dao.hoteldao.Hoteldao;
import entity.hotel.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Deletehotel")
public class Deletehotel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String hotelname = request.getParameter("id");
        System.out.println(hotelname);
        Dao dao = new Dao();
        if(dao.other("delete from hotel where id="+hotelname)){
            response.sendRedirect("/tourist_project_war_exploded/background/right1.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
