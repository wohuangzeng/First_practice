package selectclass.question;

import dao.questiondao.Questiondao;
import entity.question.Question;
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

@WebServlet("/Updatequestion")
public class Updatequestion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map = request.getParameterMap();
        ServletContext context = this.getServletContext();
        String id = (String)context.getAttribute("id");
        int i =Integer.parseInt(id);
        Question question = new Question();
        try {
            BeanUtils.populate(question,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Questiondao dao =new Questiondao(question);
        if(dao.updatequestion(i)){
            response.sendRedirect("/tourist_project_war_exploded/background/right4.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
