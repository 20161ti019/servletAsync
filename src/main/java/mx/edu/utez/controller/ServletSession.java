package mx.edu.utez.controller;

import mx.edu.utez.model.user.BeanUser;
import mx.edu.utez.model.user.DaoUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletSession", urlPatterns = {"/login","/logout"})
public class ServletSession extends HttpServlet {
    /**
     * Cierra la sesion de la aplicacion
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //obtiene la sesion
        HttpSession session = request.getSession();
        //mata la sesion
        session.setAttribute("session",null);
        session.invalidate();
        //redirige al loggin o Home
        request.getRequestDispatcher("/").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BeanUser beanUser = new BeanUser();
        beanUser.setEmail(request.getParameter("email"));
        beanUser.setPassword(request.getParameter("password"));
        DaoUser daoUser = new DaoUser();
        boolean res = daoUser.createSession(
                beanUser.getEmail(),
                beanUser.getPassword()
        );
        if (res){
            session.setAttribute("session",beanUser);
            request.getRequestDispatcher("views/inicio.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/").forward(request,response);
        }
    }
}
