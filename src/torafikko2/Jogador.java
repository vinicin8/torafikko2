/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torafikko2;

import java.awt.Point;
import java.util.Vector;
import jplay.*;

/**
 *
 * @author 20191148060007
 */
public class Jogador extends Sprite {
    
    private double velocidade = 1.0;
    private int direcao = 3;
    private boolean movendo = false;
    
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
    Controle controle = new Controle();
    /*
    *  Controle de caminhos percorríveis.
    *
    */
   public void caminho(Scene cena) {
       Point min = new Point((int)this.x,(int)this.y);
       Point max = new Point((int)this.x + this.width,(int)this.y + this.height);
       
       Vector<?> tiles = cena.getTilesFromPosition(min, max);
       
       for (int i = 0; i < tiles.size(); i++) {
           TileInfo tile = (TileInfo) tiles.elementAt(i);
           
           if(controle.colisao(this,tile) == true){
               if(colisaoVertical(this,tile)){
               if(tile.y + tile.height - 2 < this.y){
                   this.y = tile.y + tile.height;
               } else if(tile.y > this.y + tile.height - 2 ){
                   this.y = tile.y - this.height;
               }
           }
               if(colisaoHorizontal(this,tile)){
                if(tile.x > this.x + tile.width - 2 ){
                   this.x = tile.x - this.width;
               } else {
                    this.x = tile.x + tile.width;
                }
           }
       }
    }
   }
   private boolean colisaoVertical(GameObject obj, GameObject obj2 ){
    if(obj2.x + obj2.width <= obj.x)
        return false;
    if(obj.x + obj.width <= obj2.x)
        return false;
    return true;
   }
   
   private boolean colisaoHorizontal(GameObject obj, GameObject obj2 ){
    if(obj2.y + obj2.height <= obj.y)
        return false;
    if(obj.y + obj.height <= obj2.y)
        return false;
    return true;
   }    
        
   
       
        
    }

