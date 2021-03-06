
package torafikko2;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;
import jplay.*;

public class Jogador extends Ator {
    
   static double energia = 1000;
     private double ataque = 1;
  
    public Jogador(int x,int y) {
       super(URL.sprite("carro.png"),12);
       this.x = x;
       this.y = y;
       this.setTotalDuration(2000);
    }
    
    public void controle(Window janela, Keyboard teclado){
        if (teclado.keyDown(Keyboard.LEFT_KEY)) {
            if (this.x > 0) {
                this.x -= velocidade;
            }

            if (direcao != 1) {
                setSequence(2,3);
                direcao = 1;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
            if (this.x < janela.getWidth() - 60) {
                this.x += velocidade;
            }
            if (direcao != 2) {
                setSequence(4, 6);
                direcao = 2;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.UP_KEY)) {
            if (this.y > 0) {
                this.y -= velocidade;
            }
            if (direcao != 4) {
                setSequence(7, 8);
                direcao = 4;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
            if (this.y < janela.getHeight() - 60) {
                this.y += velocidade;
            }
            if (direcao != 5) {
                setSequence(11, 12);
                direcao = 5;
            }
            movendo = true;
        }
        if (movendo) {
            update();
            movendo = false;
        }
    }
    
 
    
    public boolean rota(Npc npc) {
        if (this.collided(npc)) {
           npc.x = 10_000;
           npc.velocidade=0.0; 
           npc.movendo=false;
           npc.direcao=0;
           
      
           return true;
        }
    return false;
    }

    public void rota2(Npc npc) {
        if (this.collided(npc)) {
           npc.x = 328;
           npc.y =  0;
//-550;
           
        }

    }
    
     public void rota3(Npc npc) {
        if (this.collided(npc)) {
           npc.x = 432;
           npc.y = 600;
        }

    }
}
   

