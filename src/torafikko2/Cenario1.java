/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torafikko2;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import jplay.*;

public class Cenario1 {

    private Window janela;
    private Scene cena;
    private Jogador jogador, jogador2, jogador3, jogador4;
    private Keyboard teclado;
    private Npc npc[], npc2[], npc3[], npc4[];

    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("scene.scn"));
        teclado = janela.getKeyboard();
        jogador = new Jogador(798, 229);
        jogador2 = new Jogador(-54, 324);
        jogador3 = new Jogador(328, 593);
        jogador4 = new Jogador(412, -42);

        //npc = new Npc[14];
        npc2 = new Npc[17];
        npc3 = new Npc[7];
        npc4 = new Npc[5];

        
       
        run();
    }

    private void run() {
        ArrayList<Npc> npc = new ArrayList <>();
        
        for (int i = 0; i < 14; i++) {
            if (i == 0) {
                npc.add(0, new Npc(-200, 229));
            }else{
           npc.add(i, new Npc(-210 * (i + i), 229));}
        }
        /*
         x: <0 y:324
         
         */
        for (int i = 0; i < npc2.length; i++) {
            if (i == 0) {
                npc2[0] = new Npc(800, 324);
            } else {
                npc2[i] = new Npc(800 + (i * 100), 324);
            }
        }

        for (int i = 0; i < npc3.length; i++) {
            if (i == 0) {
                npc3[0] = new Npc(328, -20);
            } else if (i % 2 == 0) {
                npc3[i] = new Npc(328, -30 * (i + 5));
            } else if (i % 2 != 0) {
                npc3[i] = new Npc(328, -50 * (i + 9));
            }
        }

        for (int i = 0; i < npc4.length; i++) {
            if (i == 0) {
                npc4[0] = new Npc(412, 600);
            } else if (i % 2 == 0) {
                npc4[i] = new Npc(412, -30 * (i + 4));
            } else if (i % 2 != 0) {
                npc4[i] = new Npc(412, -50 * (i + 3));
            }
        }
        
        
   
        int prioridade1 =(int) (Math.random() * (npc.size()-1));
             System.out.println(prioridade1);
        
        while (true) {
            GameImage fim = new GameImage("src\\recursos\\fundos\\fim.png");
            
            if (teclado.keyDown(Keyboard.S_KEY)) {
                cena.changeTile(7, 9, 20);

            } else if (teclado.keyDown(Keyboard.SPACE_KEY)) {
                cena.changeTile(7, 9, 04);
            }
            if (teclado.keyDown(Keyboard.D_KEY)) {
                cena.changeTile(11, 15, 20);

            } else if (teclado.keyDown(Keyboard.M_KEY)) {
                cena.changeTile(11, 15, 04);
            }
            jogador.controle(janela, teclado);
            // jogador.caminho(cena); 
            //cena.draw();
            
            cena.moveScene(jogador);

            //jogador2.draw();
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();
              
             
            for (int i = 0; i < npc.size(); i++) {
                 
                
                npc.get(i).x += cena.getXOffset();
                npc.get(i).y += cena.getYOffset();
               npc.get(i).caminho(cena);

                npc.get(i).draw();

                npc.get(i).perseguir(jogador.x, jogador.y);
               npc.get(i).morrer();
                jogador.rota(npc.get(i));
               
                
                boolean colidiu = false;
                for (int j = 0; j < npc3.length; j++){
                    
                            
                       /* if(colidiu == false){ 
                    if(npc.get(prioridade1).collided(npc3[j])){
                       colidiu = true;
                             
                     }
                    }else{fim.draw(); }*/
                             
                    if (npc.get(i).collided(npc3[j]) && i!=0) {
                          
                           npc.get(i).x=10_000;
                            npc.get(i).velocidade=0.0;
                           npc.get(i).movendo=false;
                            npc.get(i).direcao=0;
                            
                            npc3[j].x=328;
                            npc3[j].y= -50;
                  
                    }else if (npc.get(0).collided(npc3[j])){
                        npc.get(0).x=10_000;
                        npc.get(i).velocidade=0.0;
                           npc.get(i).movendo=false;
                            npc.get(i).direcao=0;
                            
                        npc3[j].x=10_000;
                        npc3[j].velocidade=0.0;
                        npc3[j].movendo=false;
                        npc3[j].direcao=0;
                        if( npc.get(0).x == npc3[j].x)
                            fim.draw();
                        System.out.println(npc.get(0).x + "-" + npc3[j].x ); 
                            
                        
                    }
                        
                         
                }
                    for (int k = 0; k < npc4.length; k++) {
                        if (npc.get(i).collided(npc4[k])) {
                         
// System.exit(0);           if(npc[npc.length-(npc.length-6)].collided(npc4[k]))
                            
                            npc.get(i).x=10_000;
                           npc.get(i).velocidade=0.0;
                           npc.get(i).movendo=false;
                            npc.get(i).direcao=0;
                            
                            npc4[k].x=412;
                            npc4[k].y=600;
                            
                           
                        }
                        
                    }
                    
                 
                    if (i > 0) {
                        if (npc.get(i-1).collided(npc.get(i))) {
                           npc.get(i).x = npc.get(i-1).x - npc.get(i).width;
                        }

                    }

                    janela.drawText("id: " + i, (int)npc.get(i).x + 5, (int) npc.get(i).y + 3, Color.yellow);

            }
            
            for (int i = 0; i < npc2.length; i++) {
                npc2[i].x += cena.getXOffset();
                npc2[i].y += cena.getYOffset();
                npc2[i].caminho(cena);

                npc2[i].draw();
                npc2[i].perseguir(jogador2.x, jogador2.y);
                npc2[i].morrer();
                jogador2.rota(npc2[i]);
                for (int j = 0; j < npc3.length; j++) {
                  
                    if (npc2[i].collided(npc3[j])) {
                            npc2[i].x=10_000;
                           npc2[i].velocidade=0.0;
                            npc2[i].movendo=false;
                            npc2[i].direcao=0;
                            
                            npc3[j].x=328;
                            npc3[j].y= -50;
                    }}
                for (int k = 0; k < npc4.length; k++) {
                     
                    if (npc2[i].collided(npc4[k])) {
                            npc2[i].x=10_000;
                           npc2[i].velocidade=0.0;
                            npc2[i].movendo=false;
                            npc2[i].direcao=0;
                            
                            npc4[k].x=412;
                            npc4[k].y=600;
                            
                    }}
                
                if (i > 0) {
                    if (npc2[i - 1].collided(npc2[i])) {
                        npc2[i].x = npc2[i - 1].x + npc2[i].width;
                    }

                }
                 janela.drawText("id: " + (npc.size()+1+i), (int) npc2[i].x + 5, (int) npc2[i].y + 3, Color.yellow);
            }
            for (int i = 0; i < npc3.length; i++) {
                npc3[i].x += cena.getXOffset();
                npc3[i].y += cena.getYOffset();
                npc3[i].caminho(cena);

                npc3[i].draw();

                npc3[i].perseguir(jogador3.x, jogador3.y);
                npc3[i].morrerVert1();
                jogador3.rota2(npc3[i]);

                if (i > 0) {
                    if (npc3[i - 1].collided(npc3[i])) {
                        npc3[i].y = npc3[i - 1].y - npc3[i].height;
                    }

                }

                janela.drawText("id: " + (npc2.length+npc.size()+1+i), (int) npc3[i].x + 5, (int) npc3[i].y + 3, Color.yellow);
            }

            for (int i = 0; i < npc4.length; i++) {
                npc4[i].x += cena.getXOffset();
                npc4[i].y += cena.getYOffset();
                npc4[i].caminho(cena);

                npc4[i].draw();

                npc4[i].perseguir(jogador4.x, jogador4.y);
                npc4[i].morrerVert2();
                jogador4.rota3(npc4[i]);

                if (i > 0) {
                    if (npc4[i - 1].collided(npc4[i])) {
                        npc4[i].y = npc4[i - 1].y + npc4[i].height;
                    }

                }

                janela.drawText("id: " + (npc3.length+npc2.length+npc.size()+1+i), (int) npc4[i].x + 5, (int) npc4[i].y + 3, Color.yellow);
            }


            jogador.draw();
            jogador2.draw();
            jogador3.draw();
            jogador4.draw();
            //npc.vida(janela);
            janela.drawText("Prioridade I: " + prioridade1 , 2, 12, Color.WHITE, new Font("arial",Font.BOLD,12));            
            janela.update();
            //System.out.println("X: " +jogador.getX() + " Y: " + jogador.getY());

            //jogador.moveTo(754.0, 229.0, 1.0);
        } 
    }
    
   
}
