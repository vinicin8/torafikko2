/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torafikko2;

import java.awt.Point;
import java.util.Vector;
import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

/**
 *
 * @author alexandre henrique
 */
public class Ator extends Sprite{
        Controle controle = new Controle();
    double velocidade = 0.5;
    int direcao = 3;
    boolean movendo = false;
    static double energia = 500;
    
    public Ator(String fileName, int numFrames) {
        super(fileName, numFrames);
    }
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
