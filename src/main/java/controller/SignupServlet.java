package controller;

import command.PersonCommand;
import security.PasswordHash;
import util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phoneNumber=req.getParameter("phoneNumber");
        String nationalCode=req.getParameter("nationalCode");
        String role = req.getParameter("role");

        PasswordHash passwordHash = new PasswordHash();
        String hashedPassword;
        try {
            hashedPassword = passwordHash.createHashedPassword(password);
            PersonCommand personSignupCommand = new PersonCommand();
            personSignupCommand.setFirstName(firstName);
            personSignupCommand.setLastName(lastName);
            personSignupCommand.setUserName(username);
            personSignupCommand.setMobileNumber(phoneNumber);
            personSignupCommand.setNationalCode(nationalCode);
            personSignupCommand.setPassword(hashedPassword);
            ApplicationContext.getPersonService().personSignup(personSignupCommand);

        } catch (Exception e ) {

            throw new RuntimeException(e);

        }
    }
}
