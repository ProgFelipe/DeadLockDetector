/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.fromGui;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class PanelInfo extends JPanel{
    JTextArea textArea;
    fromGui fr ;
    PanelMatrix pm;
    public PanelInfo(fromGui frgui, PanelMatrix pMatrix){
        pm = pMatrix;
        new GridLayout(1, 3, 7, 7);//filas, columnas, espacio entre filas, espacio entre columna
        fr = frgui;
        textArea = new JTextArea(4, 50);
        JScrollPane scrollPane = new JScrollPane(textArea); 
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        JTextField textField = new JTextField(10);
        textField.setFont(new Font("Serif", Font.ITALIC, 16));
        
        JButton boton = new JButton("Calc DeadLock");
        
        boton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] a = textField.getText().split(",");
                fr.startDetectionAlgorithm(Integer.parseInt(a[0].trim()), Integer.parseInt(a[1].trim()), textArea);
            }
        });        
        boton.setBackground(Color.ORANGE);
        this.add(scrollPane);
        this.add(textField);
        this.add(boton);
    }
}
