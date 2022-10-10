package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Account;
import models.AccountService;

/**
 *
 * @author Xyrille
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessions = request.getSession();
        
        Account user = (Account)sessions.getAttribute("username");
        
        String logout = request.getParameter("logout");
        
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessions = request.getSession();
        
        String username = request.getParameter("username");
        
        String password = request.getParameter("password");
        
        if (username == null || password == null || username.equals("") || password.equals("")) {
            
            request.setAttribute("invalidMessage", "Invalid login");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        }
        
        AccountService ob = new AccountService();
        
        Account user = ob.login(username, password);
        
        sessions = request.getSession();
        if (user != null) {
            sessions.setAttribute("user", user);
            
            response.sendRedirect("home");
        }
        
        else {
            request.setAttribute("username", username);
            
            request.setAttribute("password", password);
            
            request.setAttribute("invalidMessage", "Invalid login");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        }
    }
}
