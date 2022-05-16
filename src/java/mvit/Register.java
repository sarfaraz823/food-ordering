
package mvit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String name=request.getParameter("name");
        String pass=request.getParameter("pass");
        String pass1=request.getParameter("pass1");
            
            
        Connection con=null;
       ResultSet rs=null;
       Statement st=null;
       PreparedStatement pst=null;
       
       
         try{
       Class.forName("com.mysql.jdbc.Driver");
       System.out.println("Driver is loaded");
       con=DriverManager.getConnection("jdbc:mysql://localhost/alam","root","root");
        System.out.println("connection is establish");
        }
       catch(ClassNotFoundException e){
       System.out.println(e);
       }
       catch(SQLException e){
       System.out.println(e);
       }
     
     //try{    
    /* if (name.equals(rs.getString(1))&& pass.equals(rs.getString(2))){ */   
         
         if(pass.equals(pass1)){
        try{
           pst=con.prepareStatement("insert into registeruser values(?,?)");
           pst.setString(1,name);
           pst.setString(2,pass);
           pst.executeUpdate();
           out.println("<h1>Registration is Successfull"  + "</h1>");
          out.println("<a href='index.html'>click here to Login in </a>");
           }
       catch(SQLException e){
       System.out.println(e);
       }}
       else{
      out.println("<h1>Your Registration is not Successfull</h1>");
      out.println("<h1>Enter corrct user name and password</h1>");
      out.println("<a href='sign_in.html'>click here to register again</a>");
     }    
    }
    /* else{
          out.println("<h1>you have already register</h1>");
          out.println("<h1>please enter correct user name and password</h1>");
          out.println("<a href='index.html'>click here to Login in </a>");
     }}*/
     /*catch(SQLException e){
       System.out.println(e);
       }
    }*/
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
        processRequest(request, response);
    }

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
