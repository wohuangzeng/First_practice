package selectclass.bus;

import dao.busdao.Busdao;
import entity.bus.Bus;
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

@WebServlet("/Updatebus")
public class Updatebus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext context = this.getServletContext();
        String id = (String)context.getAttribute("id");
        int i = Integer.parseInt(id);
        Map<String,String[]> map = request.getParameterMap();
        Bus bus = new Bus();
        try {
            BeanUtils.populate(bus,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Busdao busdao = new Busdao(bus);
        if(busdao.updatebus(i)){
            response.sendRedirect("/tourist_project_war_exploded/background/right3.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
