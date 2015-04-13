/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JButton;

/**
 *
 * @author Felipe
 */
public class Button extends JButton{

    int f, c;

    Button(int f, int c) {
      this.f = f;
      this.c = c;
    }
    public int getRow(){
        return f;
    }
    public int getColumn(){
        return c;
    }    
}
