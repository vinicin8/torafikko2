/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torafikko2;

import jplay.*;

/**
 *
 * @author alexandre henrique
 */
public class Controle {
    
    public boolean colisao(GameObject obj, TileInfo tile){
        if((tile.id>=8 && tile.id!=16)&& obj.collided(tile)){
            return true;
        }
        return false;
    }
}
