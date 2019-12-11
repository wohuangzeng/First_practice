package selectclass.hotel;

import dao.hoteldao.Hoteldao;
import entity.hotel.Hotel;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/Updatehotel")
public class Updatehotel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext context = this.getServletContext();
        String id = (String)context.getAttribute("id");
        int i=Integer.parseInt(id);
        Map<String,String[]> map = request.getParameterMap();
        Hotel hotel = new Hotel();
        try {
            BeanUtils.populate(hotel,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Hoteldao hoteldao =new Hoteldao(hotel);
        if(hoteldao.updatehotel(i)){
            response.sendRedirect("/tourist_project_war_exploded/background/right1.jsp");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
