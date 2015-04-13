/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Felipe
 */
public class Node {
    private String name;
    //This are the outgoings and incoming arrows from the node 
    //if exit arrow then assign the direction to one
    //if incoming arrow then minus one
    private int Left, Right, Up, Down;
    private int Row, Column;
    public Node(String Name,int row, int column){
        this.name = Name;
        this.Row = row;
        this.Column = column;
        
        this.Left = 0;
        this.Right = 0;
        this.Up = 0;
        this.Down = 0;
    }
    public String getName(){
        return name;
    }
    public int getRow(){
        return Row;
    }
    public int getColumn(){
        return Column;
    }
    public int getUp(){return Up;}
    public int getDown(){return Down;}
    public int getLeft(){return Left;}
    public int getRight(){return Right;}
    
    public void setUp(int up){Up = up;}
    public void setDown(int down){Down = down;}
    public void setLeft(int left){Left = left;}
    public void setRight(int right){Right = right;}
}
