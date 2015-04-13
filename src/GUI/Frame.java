/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Felipe
 */
public class Frame extends JFrame{
    
    public Frame(JPanel panelMatrix, JPanel panelInfo){
        this.setLayout(new BorderLayout());
        this.setSize(1000, 700);
        this.add(panelMatrix, BorderLayout.CENTER);
        this.add(panelInfo, BorderLayout.SOUTH);
        this.setTitle("DeadLock Detector v 0.0.1");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
