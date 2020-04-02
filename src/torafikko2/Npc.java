/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torafikko2;
import java.awt.Color;
import jplay.*;
/**
 *
 * @author alexandre henrique
 */
public class Npc extends Ator{
     private double ataque = 1;
    public Npc(int x, int y) {
        super(URL.sprite("infinity.png"), 12);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
        this.velocidade= 0.6;
    }
    
    public void perseguir(double x, double y){
        if (this.x > x && this.y <= y + 50 && this.y >= y - 50) {
            moveTo(x, y, velocidade);
            if (direcao != 1) {
                setSequence(2, 3);
                direcao = 1;
            }
            movendo = true;
        } else if (this.x < x && this.y <= y + 50 && this.y >= - 50) {
            moveTo(x, y, velocidade);
            if (direcao != 2) {
                setSequence(4, 6);
            }
            movendo = true;
        } else if (this.y > y) {
            moveTo(x, y, velocidade);
            if (direcao != 4) {
                setSequence(7, 8);
                direcao = 4;
            }
            movendo = true;
        } else if (this.y < y) {
            moveTo(x, y, velocidade);
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
    public boolean morrer() {
        if (Npc.energia <= 0) {
            this.velocidade = 0;
            this.ataque = 0;
            this.direcao = 0;
            this.movendo = false;
            this.x = 1_000_000;
            return true;
        }
        return false;
    }
    
     public boolean morrerVert1() {
        if (Npc.energia <= 0) {
            this.velocidade = 0;
            this.ataque = 0;
            this.direcao = 0;
            this.movendo = false;
            this.x = 328;
            this.y = -10;
            return true;
        }
        return false;
    }
     
    public boolean morrerVert2() {
        if (Npc.energia <= 0) {
            this.velocidade = 0;
            this.ataque = 0;
            this.direcao = 0;
            this.movendo = false;
            this.x = 412;
            this.y = -10;
            return true;
        }
        return false;
    } 
}
    

