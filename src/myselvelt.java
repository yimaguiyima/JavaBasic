import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

//@WebServlet(name = "myselvelt")
public class myselvelt extends HttpServlet {
    private String[] strings = new String[1000];

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("-----------------------------");
        Timer timer = new Timer();
        timer.schedule(new mytime(), 1000);
    }
    class OOMObject {
    }
    class mytime extends TimerTask {
        @Override
        public void run() {
            System.out.println("-------------mytime----------------");
            Map<String,Object> m = new HashMap<String,Object>();
            int i = 0;
            do{
                OOMObject test = new OOMObject();
                m.put(String.valueOf(i), test);
                i++;
            }while(true);
        }
    }

    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,java.io.IOException
    {
        resp.getWriter().println("I am httpServlet doGet()");
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,java.io.IOException
    {
        resp.getWriter().println("I am httpServlet doPost()");
    }
    public void destory(ServletConfig config){

    }
}
