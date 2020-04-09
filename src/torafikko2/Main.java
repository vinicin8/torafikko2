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
        Keyboard teclado = janela.getKeyboard();
        GameImage inicio = new GameImage("src\\recursos\\fundos\\main.png");
        while (true) {            
            inicio.draw();
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                  new Cenario1(janela);
            }
            janela.update();
        }
    }
    
}
