/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.fromGui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Felipe
 */
public class PanelMatrix extends JPanel{
    int fila = 0,columna =0;
    fromGui fr;
    public PanelMatrix(fromGui frgui){
        int d = 0;
        fr = frgui;
        for(int c = 0; c<64; c++){
            //JButton boton = new JButton();
            if(columna > 7){columna = 0;}
            Button b = new Button(fila,columna);
            columna++;
            node(b);
            //node(boton);
            this.add(b);
            d++;
            if(d == 8 && c <= 56){
                fila++;
                d = 0;
                for(int e = 0; e<8; e++){
                    //button = new JButton();
                    //ArrowButtonUpDown(button);
                    Button btn = new Button(fila,e);
                    ArrowButtonUpDown(btn);
                    this.add(btn);
                    if(e<7){
                        JButton nulo = new JButton();
                        nulo.setBackground(Color.red);
                        nulo.setPreferredSize(new Dimension(60, 30));
                    this.add(nulo);}
                }
            }else{
                if(c < 63){
                    Button button = new Button(fila, columna);
                ArrowButtonLeftRight(button);
            this.add(button);}}
        }
    }
    public void ArrowButtonLeftRight(JButton button){
    try {
                Image img = ImageIO.read(getClass().getResource("resources/none.bmp"));
                button.setBackground(Color.WHITE);
                button.setPreferredSize(new Dimension(60, 30));
                button.setIcon(new ImageIcon(img.getScaledInstance(20, 20, 0)));
                button.setName("none");
                button.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Image img = null;
                        try {
                                /*                               
                                Get The position of the node
                                other posibility
                                   JButton b = (JButton)e.getSource();
                                Rectangle r = b.getBounds();
                                Point p = b.getLocation();
                                int row = p.y / r.height;
                                int col = p.x / r.width;
                                System.out.printf("At cell %d,%d\n", row, col);
                                */
                                Button b = (Button)e.getSource();
                                System.out.println("fil "+ b.getRow()+ " col "+b.getColumn());
                            if(button.getName().equalsIgnoreCase("left")){img = ImageIO.read(getClass().getResource("resources/right.bmp"));button.setName("right");}else
                            if(button.getName().equalsIgnoreCase("right")){img = ImageIO.read(getClass().getResource("resources/none.bmp"));button.setName("none");}else
                            if(button.getName().equalsIgnoreCase("none")){img = ImageIO.read(getClass().getResource("resources/left.bmp"));button.setName("left");}
                            button.setIcon(new ImageIcon(img.getScaledInstance(20, 20, 0)));
                            fr.SetLeftRightArrows(b.getRow(), b.getColumn(), button.getName());
                        } catch (IOException ex) { System.err.println("Error: "+ex);}                        
                    }
                });
              } catch (IOException ex) { System.err.println("Error: "+ex);}
    }
    public void ArrowButtonUpDown(Button button){
    try {
                Image img = ImageIO.read(getClass().getResource("resources/none.bmp"));
                button.setBackground(Color.WHITE);
                button.setPreferredSize(new Dimension(60, 30));
                button.setIcon(new ImageIcon(img.getScaledInstance(20, 20, 0)));
                button.setName("none");
                button.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Image img = null;
                        try {
                                                            /*                               
                                Get The position of the node
                                */
                                Button b = (Button)e.getSource();
                                System.out.println("fil "+ b.getRow()+ " col "+b.getColumn());
                            if(button.getName().equalsIgnoreCase("down")){img = ImageIO.read(getClass().getResource("resources/up.bmp"));button.setName("up");}else
                            if(button.getName().equalsIgnoreCase("up")){img = ImageIO.read(getClass().getResource("resources/none.bmp"));button.setName("none");}else
                            if(button.getName().equalsIgnoreCase("none")){img = ImageIO.read(getClass().getResource("resources/down.bmp"));button.setName("down");}
                            fr.SetUpDownArrow(b.getRow(), b.getColumn(), button.getName());
                            button.setIcon(new ImageIcon(img.getScaledInstance(20, 20, 0)));
                        } catch (IOException ex) { System.err.println("Error: "+ex);}                        
                    }
                });
              } catch (IOException ex) { System.err.println("Error: "+ex);}
    }
    public void node(Button button){
        try {
                Image img = ImageIO.read(getClass().getResource("resources/none.bmp"));
                button.setBackground(Color.DARK_GRAY);
                button.setPreferredSize(new Dimension(60, 30));
                button.setIcon(new ImageIcon(img.getScaledInstance(20, 20, 0)));
                button.setName("none");
                button.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Image img = null;
                        try {
                            if(button.getName().equalsIgnoreCase("node")){img = ImageIO.read(getClass().getResource("resources/none.bmp"));button.setName("");
                                /*                               
                                Get The position of the node
                                */
                                Button b = (Button)e.getSource();
                                fr.removeNode(b.getRow(), b.getColumn());
                            }else{
                                img = ImageIO.read(getClass().getResource("resources/node.bmp"));button.setName("node");
                                /*                               
                                Get The position of the node
                                */
                                Button b = (Button)e.getSource();
                                System.out.println("fil "+ b.getRow()+ " col "+b.getColumn());
                                fr.SetNode(b.getRow(), b.getColumn());
                            }
                            button.setIcon(new ImageIcon(img.getScaledInstance(20, 20, 0)));
                        } catch (IOException ex) { System.err.println("Error: "+ex);}                        
                    }
                });
              } catch (IOException ex) { System.err.println("Error: "+ex);}
    }
    public void refreshMatrix(){
      
    }
    
}
