/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.fromGui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class Frame extends JFrame{
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem1, menuItem2;
    
    public Frame(JPanel panelMatrix, JPanel panelInfo){
        menuBar = new JMenuBar();
        menu = new JMenu("Options");
        menuItem1 = new JMenuItem("Restart");
        menuItem1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                refreshFrame();
            }
        });
        menuItem2 = new JMenuItem("Help");
        menuItem2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                 // Set dialog properties
                
  JDialog jd = new JDialog();
  jd.setTitle("Help Me!");
  jd.setSize(400, 400);
  jd.setLayout(new FlowLayout());
  JTextArea message = new JTextArea("This is an implementation of DeathLock detector"
           + "\n1.)you need to click and select the nodes and the arrows"
           + "\n2.)Then type the coordinates of the initial node"
           + "\nlike: 0,1 or 0,2 (row,column)"
           + "\n3 At the end chosee calc DeadLock ");
    Font font = new Font("Courier New", Font.PLAIN, 16);
    message.setFont(font);
    message.setOpaque(false);
    message.setEditable(false);
  jd.add(message);
  jd.setLocationRelativeTo(null);
  jd.pack();
  jd.setVisible(true);
            }
        });
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        
        this.setLayout(new BorderLayout());
        this.setSize(1000, 700);
        this.add(panelMatrix, BorderLayout.CENTER);
        this.add(panelInfo, BorderLayout.SOUTH);
        this.setTitle("DeadLock Detector v 0.0.1");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }
    public void refreshFrame(){
        this.removeAll();
        setVisible(false);
        dispose();
        fromGui fr = new fromGui();
        PanelMatrix panelMatrix = new PanelMatrix(fr);
        PanelInfo panelInfo = new PanelInfo(fr, panelMatrix);
        new Frame(panelMatrix, panelInfo);       
    }
}
