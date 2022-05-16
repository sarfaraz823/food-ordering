
package mvit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Menu extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
           String name=request.getParameter("name");
            String pass=request.getParameter("pass");
            Calendar cal=new GregorianCalendar();
            int hour=cal.get(Calendar.HOUR);
            int minute=cal.get(Calendar.MINUTE);
            String am_pm="";
             int row=0;
             int i=0;
            
            
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
      
        try{
            st=con.createStatement();
            rs=st.executeQuery("select count(*) from registeruser");
            while(rs.next()){
            row=rs.getInt(1);
           // out.println(row);
            }  
        pst=con.prepareStatement("select * from registeruser");
        rs=pst.executeQuery();
       
       // st=con.createStatement();
        //rs=st.executeQuery("select * from registeruser");
        
        } 
        catch(SQLException e){}
       
         
         //request.getParameter("name")
         //request.getParameter("pass")
        /*  try{
           pst=con.prepareStatement("insert into registeruser values(?,?)");
           pst.setString(1,name);
           pst.setString(2,pass);
           pst.executeUpdate();
       //st=con.createStatement();
*/       
      //st.executeUpdate("insert into registeruser values('sarfara','howee')");
       /*rs=st.executeQuery("select * from ALAM123");
       boolean b=rs.next();
       if(!b){
       System.out.println("no data found");
       }
       else{
       System.out.println("usn\tname");
       do{
       System.out.println(rs.getString(1)+"\t"+rs.getString(2));
       }while(rs.next());
       }
       *//*}
       catch(SQLException e){
       System.out.println(e);
       }*/
         
         
         
         
         
         
         
         
         
         
         
     
         
         
         
         
       
       
    try{ 
        
      
       
       while(rs.next()){
       i=i+1;
         
           try { if (name.equals(rs.getString(1))&&pass.equals(rs.getString(2))){
               
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Servlet Menu</title>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h1>Hi "+ name+"</h1>");
                            out.println("</body>");
                            out.println("</html>");
               
                    try{
                    if(cal.get(Calendar.AM_PM)==0){
                         if (name.equals(rs.getString(1))&&pass.equals(rs.getString(2)))
                    {
                        am_pm="AM";
                       
                        
                        out.println("<h1>Hi "+ name+"</h1>");
                        out.println("<h1>Its Time for BREAKFAST..</h1>");
                        out.println("<h1>current time is: "+hour+":"+minute+am_pm+"</h1>");
                        out.println("<h1><a href=breakfast.html>Click here to se the list of menu for breakfast</a></h1>");
                        out.println("</div>");
                        
                        out.println("</body>");
                        out.println("</html>");
                        break;
                    }
                    
                    }
                    else if(0<=hour && hour<6){
                        if (name.equals(rs.getString(1))&&pass.equals(rs.getString(2))){
                            
                            am_pm="PM";
                            out.println("<h1>current time is: "+hour+":"+minute+am_pm+"</h1>");
                            out.println("<h1><a href=lunch.html>Click here to se the list of menu for lunch</a></h1>");
                           break;
                        }}
                    else{
                        if (name.equals(rs.getString(1))&&pass.equals(rs.getString(2))){
                            
                            am_pm="PM";
                            out.println("<h1>ITs TIME FOR DINNER</h1>");
                            out.println("<h1>Current Time is: "+hour+":"+minute+am_pm+"</h1>");
                            out.println("<h1><a href=dinner.html>Click here to se the list of menu for dinner</a></h1>");
                            boolean b=rs.next();
                           // out.println(b);
                            // out.println(rs.last());
                            break;
                        }
                    }}catch(SQLException e){}
          }     else{
                       if (row==i){
                          
                          out.println("please enter correct user name and password"); 
                        out.println("<h1><a href='index.html'>click here to login again </a></h1>");
                        }
                          
                        
                            
                        }
             } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
       }
    }catch(Exception e) {}
       
      
    
    
     
    }
}
     
          
       
      
                   
            


   
    
 
        
         
       

   

