/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Childrens;

/**
 *
 * @author arK
 */
@Stateless
public class ChildrensDao implements ChildrenDaoLocal {
   // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
        @PersistenceContext
    private EntityManager em;

    @Override
    public void addChildren(Childrens children) {
              em.persist(children);
    }
  

    @Override
    public void editChildren(Childrens children) {
        em.merge(children);
    }

    @Override
    public void deleteChildren(int childrenId) {
        em.remove(getChildren(childrenId));
    }

    @Override
    public Childrens getChildren(int childrenId) {
       return em.find(Childrens.class, childrenId);
    }

    @Override
    public List<Childrens> getAllChildren() {
       return (em.createNamedQuery("allChildrens",Childrens.class)).getResultList();
       
    }

    
}
