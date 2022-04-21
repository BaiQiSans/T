package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import po.User;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");//设置编码
        try {
            String methodName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')+1);//从前端获取目标方法
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (NoSuchMethodException ex)
        {
            response.getWriter().write("方法未找到");
        } catch (InvocationTargetException | IllegalAccessException ignore) { }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
