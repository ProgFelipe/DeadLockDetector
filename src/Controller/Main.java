/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlockdetector;

import Controller.fromGui;
import GUI.Frame;
import GUI.PanelMatrix;
import GUI.PanelInfo;
import Model.Node;

/**
 *
 * @author Felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fromGui fr = new fromGui();
        PanelMatrix panelMatrix = new PanelMatrix(fr);
        PanelInfo panelInfo = new PanelInfo(fr, panelMatrix);
        new Frame(panelMatrix, panelInfo);
    }                   
}
