package controller;

import com.alibaba.fastjson.JSON;
import model.IncomeAndExpenses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestController {
    public RestController() {
    }

    @RequestMapping(value = "/querydata", method = RequestMethod.GET)
    public void myMethod(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<IncomeAndExpenses> list = new ArrayList<>();
        list = queryAll();
        //System.out.println(list);
        String data = "[";
        for (int x=0;x<list.size()-1;++x) {
            data+= "{\"year\":"+list.get(x).getYear() + ",\"income\":" + list.get(x).getIncome() + ",\"expenses\":" + list.get(x).getExpenses() + "},";
        }
        data+= "{\"year\":"+list.get(list.size()-1).getYear() + ",\"income\":" + list.get(list.size()-1).getIncome() + ",\"expenses\":" + list.get(list.size()-1).getExpenses() + "}]";
        //System.out.println(data);
//        String jsonData = JSON.toJSONString(list);
        OutputStream out = response.getOutputStream();
        out.write(data.getBytes("UTF-8"));
        out.flush();
    }

    private List<IncomeAndExpenses> queryAll() {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<IncomeAndExpenses> datas = new ArrayList<>();
        //String hql = "from IncomeAndExpenses";
        Query query = session.createQuery("from IncomeAndExpenses");
        datas = query.list();
        session.close();
        sessionFactory.close();
        return datas;
    }

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("./hello.html");
    }
}
