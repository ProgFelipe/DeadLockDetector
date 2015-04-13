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
public class Matrix {
    Node [][] matriz;
    int filas;
    int columnas;
    public Matrix(int fil, int col){
        this.filas = fil;
        this.columnas = col;
        matriz  = new Node[filas][columnas];
    }
    public void SetNode(int fil, int col){
        matriz[fil][col] = new Node("A",fil,col);
    }
    public void removeNode(int fil, int col){
        matriz[fil][col] = null;
    }
    
    public Node getNode(int fil, int col){
        return matriz[fil][col];
    }
    public int getRows(){
        return filas;
    }
    public int getColumns(){
        return columnas;
    }
    public void printMatrix(){
        for(int f = 0; f<filas; f++){
            for(int c = 0; c< columnas; c++){
                if(matriz[f][c] != null){
                System.out.println(f+","+c+" : "+matriz[f][c].getName());
                System.out.println(f+","+c+" : down : "+matriz[f][c].getDown()+", left "+matriz[f][c].getLeft()+
                        ", right "+matriz[f][c].getRight()+", up "+matriz[f][c].getUp());
                }
            }
        }
    }
}
