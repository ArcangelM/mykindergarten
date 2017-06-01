/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import javax.ejb.Local;
import modelo.Childrens;

/**
 *
 * @author arK
 */
@Local
public interface ChildrenDaoLocal {

    void addChildren(Childrens children);

    void editChildren(Childrens children);

    void deleteChildren(int childrenId);

    Childrens getChildren(int childrenId);

    List<Childrens> getAllChildren();
    
}
