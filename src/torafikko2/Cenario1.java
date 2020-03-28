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
    private Jogador jogador,jogador2;
    private Keyboard teclado;
    
    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("scene.scn"));
        jogador = new Jogador(798,229);
        jogador2 = new Jogador(1,229);
        teclado = janela.getKeyboard();
        
        run();
    }
    
    private void run(){
         Npc npc = new Npc(1,229);
         
        
        
        
        while (true) {        
           
           if(teclado.keyDown(Keyboard.S_KEY)){
                cena.changeTile(7, 9, 20);
                
           } else if(teclado.keyDown(Keyboard.SPACE_KEY)){
               cena.changeTile(7, 9, 04);
           }
           jogador.controle(janela, teclado);
           jogador.caminho(cena); 
           //cena.draw();
           cena.moveScene(jogador);
          
            //jogador2.draw();
            npc.caminho(cena);
            
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();
            
            npc.x += cena.getXOffset();
            npc.y += cena.getYOffset();
            
            jogador.draw();
            npc.draw();
            
            jogador.vida(janela);
            npc.vida(janela);
            
            npc.perseguir(jogador.x, jogador.y);
            npc.atacar(jogador);
            npc.morrer();
            janela.update();
            //System.out.println("X: " +jogador.getX() + " Y: " + jogador.getY());
            //jogador.moveTo(754.0, 229.0, 1.0);
           
            
            
            
        }
    }
}
