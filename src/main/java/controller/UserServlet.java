package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import po.User;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static javax.swing.UIManager.put;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String privateSecret = request.getParameter("privateSecret");
        response.setContentType("application/json;charset=utf-8");
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(email, privateSecret);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        if(user!=null && Objects.equals(user.getPrivateSecret(), privateSecret)){
            stringObjectHashMap.put("loginSuccess",true);
            stringObjectHashMap.put("name",user.getName());
        }else{
            stringObjectHashMap.put("loginSuccess",false);
        }
        mapper.writeValue(response.getWriter(),stringObjectHashMap);
    }

    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
