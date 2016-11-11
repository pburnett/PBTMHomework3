//©2016 Casey Hayes & Tanner McIntyre. All Rights Reserved.

package chtm.calculator;

import chtm.objects.User;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chayes10
 */
public class Calculate extends HttpServlet {

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    HttpSession session = request.getSession();
      
    String url = "/index.jsp";

    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    request.setAttribute("currentYear", currentYear);

    // get current action
    String action = request.getParameter("action");
    if (action == null) {
      action = "restart";  // default action
    }

    // perform action and set URL to appropriate page
    if (action.equals("restart")) {
      url = "/index.jsp";    // the "join" page
    } else if (action.equals("calculate")) {
        
      float amount = Float.parseFloat(request.getParameter("amount"));
      float rate = Float.parseFloat(request.getParameter("rate"));
      int years = Integer.parseInt(request.getParameter("years"));
      double futureValue = amount * Math.pow((1+(rate/100)),years);
      
      session.setAttribute("amount", amount);
      session.setAttribute("rate", rate);
      
      DecimalFormat rateFormat = new DecimalFormat("#.0");
      
      url = "/calculate.jsp";
      
      String amountStr = request.getParameter("amount");
      String rateStr = rateFormat.format(rate);
      String yearsStr = "" + years;
      String futureValueStr = "" + futureValue;
      
      User user = new User(amountStr, rateStr, yearsStr, futureValueStr);
      
      
      request.setAttribute("user", user);
    }
    getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doPost(request, response);
  }

}