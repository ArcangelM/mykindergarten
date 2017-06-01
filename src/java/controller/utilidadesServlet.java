/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.UtilidadesDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Childrens;
import modelo.GestionArchivo;

/**
 *
 * @author arK
 */
public class utilidadesServlet extends HttpServlet {

    @EJB
    private UtilidadesDao child;
     //private GestionArchivo childrenArreg;
        
     private GestionArchivo childrenArreg = new GestionArchivo();
        
        
        
        
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
      //  ArrayList<Childrens>childrensArregl= new ArrayList();
//        childrensArregl = childrenArreg.deArchivoAarreglo();
          
          String ruta= request.getParameter("file");
          System.out.println("ruta: "+ruta);
         
         List<Childrens>childrensArregl= child.listarArray(ruta);
        childrensArregl.forEach((chi) -> {
            System.out.println(chi.getId()+" "+chi.getName()+" "+chi.getPadre()+" "+chi.getEdad()+" "+chi.getMadre());
         
        });
        String action=request.getParameter("action");
        
//        for (Childrens chi:childrenArreg.deArchivoAarreglo()){
//               System.out.println(chi.getId()+" "+chi.getName()+" "+chi.getPadre()+" "+chi.getEdad()+" "+chi.getMadre());
//             }
        //ChildrensDao childrendao= new ChildrensDao(); //pilas aqui toco crear un objeto de la clase CHILDRENSDAO PARA PODER LLAMAR LOS METODOS
        if("listar".equalsIgnoreCase(action)){
//       System.out.println("Estoy dentro del if LISTAR"+"  ARREGLO: "+childrensArregl);
//             for (Childrens chi:childrensArregl ){
//               System.out.println(chi.getId()+" "+chi.getName()+" "+chi.getPadre()+" "+chi.getEdad()+" "+chi.getMadre());
//             }
       
        request.setAttribute("childrensArreglo",childrensArregl);
        request.getRequestDispatcher("utilidades.jsp").forward(request, response);
        
       }    
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet utilidadesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet utilidadesServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        System.out.println("Entre al doPOST");
        System.out.println("Numero desde clase: "+childrenArreg.numero());
        
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
