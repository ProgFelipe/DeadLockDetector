/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Matrix;
import Model.Node;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Felipe
 */
public class fromGui {
    Matrix matrix;
    ArrayList l ;
    public fromGui(){
        matrix = new Matrix(8,8);
        l = new ArrayList();
        }
    public void SetLeftRightArrows(int fil, int col, String arrow){
        Node n = matrix.getNode(fil, col);
        if(n == null){matrix.SetNode(fil, col); n = matrix.getNode(fil, col);}
        Node n2 = matrix.getNode(fil,col-1);
        if(n2 == null){matrix.SetNode(fil, col-1); n2 = matrix.getNode(fil,col-1);}
        if(arrow.equalsIgnoreCase("left")){n.setLeft(1);n2.setRight(-1);}else
        if(arrow.equalsIgnoreCase("right")){n.setLeft(-1);n2.setRight(1);}else
        if(arrow.equalsIgnoreCase("none")){n.setLeft(0);n2.setRight(0);}
        matrix.printMatrix();
    }
    
    public void SetUpDownArrow(int fil, int col, String arrow){
        Node n = matrix.getNode(fil, col);
        if(n == null){matrix.SetNode(fil, col); n = matrix.getNode(fil, col);}
        Node n2 = matrix.getNode(fil-1,col);
        if(n2 == null){matrix.SetNode(fil-1, col); n2 = matrix.getNode(fil-1,col);}
        if(arrow.equalsIgnoreCase("up")){
            n.setUp(1);n2.setDown(-1);
        }else
        if(arrow.equalsIgnoreCase("down")){
            n.setUp(-1);n2.setDown(1);
        }else
        if(arrow.equalsIgnoreCase("none")){
            n.setUp(0);n2.setDown(0);
        }
        matrix.printMatrix();
    }
    
    public void SetNode(int fil, int col){
        matrix.SetNode(fil, col);
        matrix.printMatrix();
    }
    public void removeNode(int fil, int col){
        matrix.removeNode(fil, col);
        matrix.printMatrix();
    }
    
    public void startDetectionAlgorithm(int fil, int col, JTextArea jt){
        //Initial node
        Node initialNode = matrix.getNode(fil, col);
        deadLock(initialNode);
        
        jt.setText("DeathLock detected");
    }
    
    public void deadLock(Node n){
        checkExistence(n);
        l.add(n);
        if(n.getLeft() == 1){
            //Outgoing Arc Marked
            n.setLeft(2);
            //New node
            Node node = matrix.getNode(n.getRow(), n.getColumn());
            deadLock(node);
        }
        if(n.getRight() == 1){
            //Outgoing Arc Marked
            n.setRight(2);
            //New node
            Node node = matrix.getNode(n.getRow(), n.getColumn());
            deadLock(node);
        }
        if(n.getDown() == 1){
            //Outgoing Arc Marked
            n.setDown(2);
            //New node
            Node node = matrix.getNode(n.getRow(), n.getColumn());
            deadLock(node);
        }
        if(n.getUp() == 1){
            //Outgoing Arc Marked
            n.setUp(2);
            //New node
            Node node = matrix.getNode(n.getRow(), n.getColumn());
            deadLock(node);
        }
    }
    public boolean checkExistence(Node n){
        boolean existence = false;
        for(int c = 0; c<l.size(); c++){
            if(l.get(0).equals(n)){
                existence = true;
            }
        }
        return existence;
    }
}
