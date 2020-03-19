/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torafikko2;

import jplay.*;

public class Cenario1  {
    
    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;
    
    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("scene.scn"));
        jogador = new Jogador(1,229);
        
        run();
    }
    
    private void run(){
        jogador.x=1.0;
        jogador.y=317.0;
        
        
        
        while (true) {            
            cena.draw();
            jogador.draw();
            jogador.mover(janela);
            janela.update();
            //jogador.controle(janela, teclado);
            
    
            System.out.println("X: " +jogador.getX() + " Y: " + jogador.getY());
            
        }
    
        
    }
   
}
