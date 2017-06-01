/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ChildrenDaoLocal;
import Dao.ChildrensDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Childrens;

/**
 *
 * @author arK
 */
/*pendiente verificar si se agreaga linea webservlet*/
//@WebServlet(name="ChildrensServlet", urlPatterns = "/myKinderGarten")
public class ChildrensServlet extends HttpServlet {

    @EJB
    private ChildrenDaoLocal childrensDao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action=request.getParameter("action");
       String childrenIdStr= request.getParameter("id"); //childrenId
      int childrenId=0;
      if(childrenIdStr!=null && !childrenIdStr.equals(""))
          childrenId=Integer.parseInt(childrenIdStr);

       String name=request.getParameter("name");
       String padre=request.getParameter("padre");
       String madre=request.getParameter("madre");
       String edadStr=request.getParameter("edad");
       int edad=0;
      if(edadStr!=null && !edadStr.equals(""))
          edad=Integer.parseInt(edadStr);
       
   Childrens children=new Childrens(childrenId,name,edad,padre,madre);
        //ChildrensDao childrendao= new ChildrensDao(); //pilas aqui toco crear un objeto de la clase CHILDRENSDAO PARA PODER LLAMAR LOS METODOS
       if("Add".equalsIgnoreCase(action)){
       childrensDao.addChildren(children);
       
   }  else  if("Edit".equalsIgnoreCase(action)){
           childrensDao.editChildren(children);
           
   }else   if("Delete".equalsIgnoreCase(action)){
           childrensDao.deleteChildren(childrenId);
   
    }else  if("Search".equalsIgnoreCase(action)){
           children=childrensDao.getChildren(childrenId);
    }
       
  request.setAttribute("children",children);
  request.setAttribute("allChildrens",childrensDao.getAllChildren());
  request.getRequestDispatcher("index.jsp").forward(request, response);

        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChildrensServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChildrensServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
