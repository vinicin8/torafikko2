/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torafikko2;

import java.awt.Color;
import java.util.ArrayList;
import jplay.*;

public class Cenario1  {
    
    private Window janela;
    private Scene cena;
    private Jogador jogador,jogador2,jogador3,jogador4;
    private Keyboard teclado;
    private Npc npc[],npc2[],npc3[], npc4[];

    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("scene.scn"));
        teclado = janela.getKeyboard(); 
        jogador = new Jogador(798,229);
        jogador2 = new Jogador(-54,324);
        jogador3 = new Jogador(328,593);
        jogador4 = new Jogador(412,-42);
        
        npc = new Npc[14];
        npc2 = new Npc[17];
        npc3 = new Npc[7];
        npc4 = new Npc[10];

        
        run();
    }
    
    private void run(){
     
         for(int i = 0; i < npc.length; i++){
               if(i==0){npc[0] = new Npc(-200, 229);}    
               npc[i] = new Npc(-200 * (i+1), 229);
           }
        /*
         x: <0 y:324
         
         */
        for(int i = 0; i < npc2.length; i++){
               if(i==0){npc2[0] = new Npc(800, 324);} 
               else{
               npc2[i] = new Npc(800 + (i*100), 324);}
           }
        
        for(int i = 0; i < npc3.length; i++){
               if(i==0){npc3[0] = new Npc(328, -20);} 
               else if(i%2==0){
               npc3[i] = new Npc(328, -30*(i+5));}
               else if(i%2!=0){
               npc3[i] = new Npc(328, -50*(i+5));}
           }
       
        for(int i = 0; i < npc4.length; i++){
               if(i==0){npc4[0] = new Npc(412, 600);} 
               else if(i%2==0){
               npc4[i] = new Npc(412, -30*(i+4));}
               else if(i%2!=0){
               npc4[i] = new Npc(412, -50*(i+3));}
           }
        while (true) {        
          
           if(teclado.keyDown(Keyboard.S_KEY)){
                cena.changeTile(7, 9, 20);
                
           } else if(teclado.keyDown(Keyboard.SPACE_KEY)){
               cena.changeTile(7, 9, 04);
           }
           jogador.controle(janela, teclado);
          // jogador.caminho(cena); 
           //cena.draw();
           cena.moveScene(jogador);
          
            //jogador2.draw();
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();
            
            for (int i = 0; i < npc.length; i++) {
               npc[i].x += cena.getXOffset();
               npc[i].y += cena.getYOffset();
               npc[i].caminho(cena);
               
              //npc[i].draw();
               
               npc[i].perseguir(jogador.x, jogador.y);
               npc[i].morrer(); 
               jogador.rota(npc[i]);
               
               if(i>0){
               if(npc[i-1].collided(npc[i]))
                  npc[i].x = npc[i-1].x - npc[i].width ;
               
              
               }
               
               //janela.drawText("id: " + i, (int) npc[i].x + 5, (int) npc[i].y + 3, Color.yellow);
              
            }
            
            for (int i = 0; i < npc2.length; i++) {
               npc2[i].x += cena.getXOffset();
               npc2[i].y += cena.getYOffset();
               npc2[i].caminho(cena);
               
               //npc2[i].draw();
               
               npc2[i].perseguir(jogador2.x, jogador2.y);
               npc2[i].morrer(); 
               jogador2.rota(npc2[i]);
               
               if(i>0){
               if(npc2[i-1].collided(npc2[i]))
                  npc2[i].x = npc2[i-1].x + npc2[i].width ;
                  
               }
               // janela.drawText("id: " + (npc.length+1+i), (int) npc2[i].x + 5, (int) npc2[i].y + 3, Color.yellow);
            }
            
            for (int i = 0; i < npc3.length; i++) {
               npc3[i].x += cena.getXOffset();
               npc3[i].y += cena.getYOffset();
               npc3[i].caminho(cena);
               
               npc3[i].draw();
               
               npc3[i].perseguir(jogador3.x, jogador3.y);
               npc3[i].morrerVert1(); 
               jogador3.rota2(npc3[i]);
               
               if(i>0){
               if(npc3[i-1].collided(npc3[i]))
                  npc3[i].y = npc3[i-1].y - npc3[i].height ;
               
              
               }
               
               //janela.drawText("id: " + i, (int) npc[i].x + 5, (int) npc[i].y + 3, Color.yellow);
              
            }
            
            for (int i = 0; i < npc4.length; i++) {
               npc4[i].x += cena.getXOffset();
               npc4[i].y += cena.getYOffset();
               npc4[i].caminho(cena);
               
               npc4[i].draw();
               
               npc4[i].perseguir(jogador4.x, jogador4.y);
               npc4[i].morrerVert2(); 
               jogador4.rota3(npc4[i]);
               
               if(i>0){
               if(npc4[i-1].collided(npc4[i]))
                  npc4[i].y = npc4[i-1].y + npc4[i].height ;
               
              
               }
               
               //janela.drawText("id: " + i, (int) npc[i].x + 5, (int) npc[i].y + 3, Color.yellow);
              
            }
            
            jogador.vida(janela);
            jogador.draw();
            jogador2.draw();
            jogador3.draw();
            jogador4.draw();
            //npc.vida(janela);
            
           
            janela.update();
            //System.out.println("X: " +jogador.getX() + " Y: " + jogador.getY());
            janela.delay(2);
            //jogador.moveTo(754.0, 229.0, 1.0);
           
            
            
            
        }
    }
}
