/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torafikko2;

import jplay.*;

public class Main {

 
    public static void main(String[] args) {
        Window janela = new Window(800, 600);
        
        while (true) {            
            
            janela.update();
            new Cenario1(janela);
        }
    }
    
}
