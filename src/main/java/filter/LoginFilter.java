package filter;

import domain.Person;
import security.PasswordHash;
import security.UserContext;
import util.ApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Person person = ApplicationContext.getPersonService().getByUsername(username);
        PasswordHash passwordHash = new PasswordHash();
        boolean isEqual = false;
        try {
            isEqual = passwordHash.checkEqualityOfHashedPasswords(password, person.getPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        if (username.equals(person.getUserName()) && isEqual) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) res;
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            HttpSession httpSession =  httpServletRequest.getSession();
            httpSession.setAttribute("username", username);
            UserContext.username = username;

            chain.doFilter(req, res);


        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) res;
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
        }
    }
}
