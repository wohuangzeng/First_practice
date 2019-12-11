package selectclass.travel;

import dao.traveldao.Traveldao;
import entity.travel.Travel;
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

@WebServlet("/Updatetravel")
public class Updatetravel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext context = this.getServletContext();
        String id = (String)context.getAttribute("id");
        int i=Integer.parseInt(id);
        Map<String,String[]> map = request.getParameterMap();
        Travel travel = new Travel();
        try {
            BeanUtils.populate(travel,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Traveldao traveldao =new Traveldao(travel);
        if(traveldao.updatehotel(i)){
            response.sendRedirect("/tourist_project_war_exploded/background/right2.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
