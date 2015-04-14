/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.Frame;
import GUI.PanelMatrix;
import Model.Matrix;
import Model.Node;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Felipe
 */
public class fromGui {
    Frame frame;
    Matrix matrix;
    ArrayList l ;
    String outPutText;
    boolean existence;
    boolean notbacktrack;
    public fromGui(){
        existence = false;
        notbacktrack = true;
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
        deadLock(initialNode, jt);
        if(!existence){
            jt.setText(outPutText+"\nNo DeadLock found!");
        }
        refreshAll();
    }
    
    public void deadLock(Node n, JTextArea jt){
        jt.setText(outPutText);
        if(checkExistence(n)){
            outPutText += "\n ¡¡¡¡DeadLock!!!!";
            jt.setText(outPutText);
        }else{
        if(notbacktrack){l.add(n);}
        if(n.getLeft() == 1){
            //Outgoing Arc Marked
            n.setLeft(2);
            //New node
            int column = n.getColumn()-1;
            outPutText += "\nLEFT ["+n.getRow()+", "+ column+"]";
            jt.setText(outPutText);
            Node node = matrix.getNode(n.getRow(), column);
            notbacktrack = true;
            deadLock(node, jt);
        }else
        if(n.getRight() == 1){
            //Outgoing Arc Marked
            n.setRight(2);
            //New node
            int column = n.getColumn()+1;
            outPutText += "\nRIGHT ["+n.getRow()+", "+ column+"]";
            Node node = matrix.getNode(n.getRow(), column);
            notbacktrack = true;
            deadLock(node, jt);
        }else
        if(n.getDown() == 1){
            //Outgoing Arc Marked
            n.setDown(2);
            //New node
            int row = n.getRow()+1;
            outPutText += "\nDOWN ["+row+", "+ n.getColumn()+"]";
            Node node = matrix.getNode(row, n.getColumn());
            notbacktrack = true;
            deadLock(node, jt);
        }else
        if(n.getUp() == 1){
            //Outgoing Arc Marked
            n.setUp(2);
            //New node
            int row = n.getRow()-1;
            outPutText += "\nUP ["+row+", "+ n.getColumn()+"]";
            Node node = matrix.getNode(row, n.getColumn());
            notbacktrack = true;
            deadLock(node, jt);
        }else
            if(l.size() > 1){
            //BackTrack
            Node node = (Node)l.get(l.size()-2);
            outPutText += "\n**<-BackTrack ["+node.getRow()+", "+node.getColumn()+"]";
            notbacktrack = false;
            l.remove(l.size()-2);
            deadLock(node, jt);
            }
        }
            
    }
    public boolean checkExistence(Node n){
        existence = false;
        for(int c = 0; c<l.size(); c++){
            if(l.get(c).equals(n)){
                existence = true;
            }
        }
        return existence;
    }
    public void refreshAll(){
        existence = false;
        notbacktrack = true;
        outPutText = "";
        l = new ArrayList();
        matrix.refreshMatrix();
    }
}
