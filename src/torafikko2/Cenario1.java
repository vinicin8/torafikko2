/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torafikko2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
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
        npc2 = new Npc[14];
        npc3 = new Npc[7];
        npc4 = new Npc[5];

        run();
    }

    private void run() {
        ArrayList<Npc> npc = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            if (i == 0) {
                npc.add(0, new Npc(-200, 229));
            } else {
                npc.add(i, new Npc(-210 * (i + i), 229));
            }
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
                npc3[i] = new Npc(328, -40 * (i + 8));
            } else if (i % 2 != 0) {
                npc3[i] = new Npc(328, -40 * (i + 5));
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

        int prioridade1 = 0;
                //(int) (Math.random() * (npc.size() - 1));
        int prioridade2 = 0;
                //(int) (Math.random() * (npc2.length - 1));
        System.out.println(prioridade2);

        while (true) {
            GameImage fim = new GameImage("src\\recursos\\fundos\\fim.png");
            GameImage fim2 = new GameImage("src\\recursos\\fundos\\fim2.png");
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
            
            
             if(teclado.keyDown(Keyboard.A_KEY)){System.exit(0);}
            jogador.controle(janela, teclado);
            // jogador.caminho(cena); 
            //cena.draw();

            cena.moveScene(jogador);

            //jogador2.draw();
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();

        
            // System.out.println(jogador.rota(npc.get(prioridade1))+ " ___ " + jogador2.rota(npc2[prioridade2]) );
           boolean victory = false;
            for (int i = 0; i < npc.size(); i++) {
               
                

                npc.get(i).x += cena.getXOffset();
                npc.get(i).y += cena.getYOffset();
                npc.get(i).caminho(cena);

                npc.get(i).draw();

                npc.get(i).perseguir(jogador.x, jogador.y);
                npc.get(i).morrer();
                //jogador.rota(npc.get(i));
                
                boolean colidiu = false;
                for (int j = 0; j < npc3.length; j++) {

                    /* if(colidiu == false){ 
                    if(npc.get(prioridade1).collided(npc3[j])){
                       colidiu = true;
                             
                     }
                    }else{fim.draw(); }*/
                    if (npc.get(i).collided(npc3[j]) && i != prioridade1) {

                        npc.get(i).x = 10_000;
                        npc.get(i).velocidade = 0.0;
                        npc.get(i).movendo = false;
                        npc.get(i).direcao = 0;

                        npc3[j].x = 328;
                        npc3[j].y = -600;

                    } else if (npc.get(prioridade1).collided(npc3[j])) {
                        npc.get(prioridade1).x = 9_000;
                        npc.get(prioridade1).velocidade = 0.0;
                        npc.get(prioridade1).movendo = false;
                        npc.get(prioridade1).direcao = 0;

                        npc3[j].x = 9_000;
                        npc3[j].velocidade = 0.0;
                        npc3[j].movendo = false;
                        npc3[j].direcao = 0;

                    }
                    if (colidiu == false && victory==false) {
                         janela.drawText("id: " + i, (int) npc.get(i).x + 5, (int) npc.get(i).y + 3, Color.yellow);
                         
                        if (npc.get(prioridade1).x == npc3[j].x) {
                            fim.draw();

                          
                            colidiu = true;
                           
                        }
                    } else if(colidiu == true ) {
                        if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                            new Cenario1(janela);
                        }
                        
                        for (int l = 0; l < npc.size(); l++) {
                            npc.get(l).hide();
                            npc.get(l).velocidade = 0.0;
                            npc.get(l).movendo = false;
                            npc.get(l).direcao = 0;
                        }
                        for (int x = 0; x < npc2.length; x++) {
                           npc2[x].hide();
                           npc2[x].velocidade = 0.0;
                           npc2[x].movendo = false;
                           npc2[x].direcao = 0;
                        }
                        for (int k = 0; k < npc3.length; k++) {
                            npc3[k].hide();
                            npc3[k].velocidade = 0.0;
                            npc3[k].movendo = false;
                            npc3[k].direcao = 0;
                        }
                        for (int y = 0; y < npc4.length; y++) {
                            npc4[y].hide();
                            npc4[y].velocidade = 0.0;
                            npc4[y].movendo = false;
                            npc4[y].direcao = 0;
                        }
                    }

                }
                
                 boolean colidiu2 = false;
                for (int k = 0; k < npc4.length; k++) {
                    if (npc.get(i).collided(npc4[k]) && i!=prioridade1) {
                        npc.get(i).x = 10_000;
                        npc.get(i).velocidade = 0.0;
                        npc.get(i).movendo = false;
                        npc.get(i).direcao = 0;

                        npc4[k].x = 412;
                        npc4[k].y = 600;

                    }else if (npc.get(prioridade1).collided(npc4[k])) {
                        npc.get(prioridade1).x = 7_000;
                        npc.get(prioridade1).velocidade = 0.0;
                        npc.get(prioridade1).movendo = false;
                        npc.get(prioridade1).direcao = 0;

                        npc4[k].x = 7_000;
                        npc4[k].velocidade = 0.0;
                        npc4[k].movendo = false;
                        npc4[k].direcao = 0;

                    }
                    if (colidiu2 == false && victory == false) {
                       janela.drawText("id: " + (npc.size() + 1 + i), (int) npc2[i].x + 5, (int) npc2[i].y + 3, Color.yellow);
                        if (npc.get(prioridade1).x == npc4[k].x) {
                            fim.draw();
                            colidiu2 = true;
                        }
                    } else {
                        if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                            new Cenario1(janela);
                        } 
                        for (int l = 0; l < npc.size(); l++) {
                            npc.get(l).hide();
                            npc.get(l).velocidade = 0.0;
                            npc.get(l).movendo = false;
                            npc.get(l).direcao = 0;
                        }
                        for (int x = 0; x < npc2.length; x++) {
                           npc2[x].hide();
                           npc2[x].velocidade = 0.0;
                           npc2[x].movendo = false;
                           npc2[x].direcao = 0;
                        }
                        for (int y = 0; y < npc3.length; y++) {
                            npc3[y].hide();
                            npc3[y].velocidade = 0.0;
                            npc3[y].movendo = false;
                            npc3[y].direcao = 0;
                        }
                        
                        for (int m = 0; m < npc4.length; m++) {
                            npc4[m].hide();
                            npc4[m].velocidade = 0.0;
                            npc4[m].movendo = false;
                            npc4[m].direcao = 0;
                        }
                       
                    }

                }

                if (i > 0) {
                    if (npc.get(i - 1).collided(npc.get(i))) {
                        npc.get(i).x = npc.get(i - 1).x - npc.get(i).width;
                    }

                }
                if(jogador.rota(npc.get(prioridade1))){
                        npc.get(prioridade1).x = 9_000;
                        npc.get(prioridade1).velocidade = 0.0;
                        npc.get(prioridade1).movendo = false;
                        npc.get(prioridade1).direcao = 0;

                        jogador.x = 9_000;
                        jogador.velocidade = 0.0;
                        jogador.movendo = false;
                        jogador.direcao = 0;
                    
                     }    if (victory == false) {
                      
                        if (npc.get(prioridade1).x == jogador.x) {
                            fim2.draw();
                            victory = true;
                            
                        }
                    } else {
                        if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                            new Cenario1(janela);
                        } 
                        
                        for (int l = 0; l < npc.size(); l++) {
                            npc.get(l).hide();
                            npc.get(l).velocidade = 0.0;
                            npc.get(l).movendo = false;
                            npc.get(l).direcao = 0;
                        }
                        for (int x = 0; x < npc2.length; x++) {
                           npc2[x].hide();
                           npc2[x].velocidade = 0.0;
                           npc2[x].movendo = false;
                           npc2[x].direcao = 0;
                        }
                        for (int y = 0; y < npc3.length; y++) {
                            npc3[y].hide();
                            npc3[y].velocidade = 0.0;
                            npc3[y].movendo = false;
                            npc3[y].direcao = 0;
                        }
                        
                        for (int m = 0; m < npc4.length; m++) {
                            npc4[m].hide();
                            npc4[m].velocidade = 0.0;
                            npc4[m].movendo = false;
                            npc4[m].direcao = 0;
                        }
                       
                    }

            }

           
            for (int i = 0; i < npc2.length; i++) {
                npc2[i].x += cena.getXOffset();
                npc2[i].y += cena.getYOffset();
                npc2[i].caminho(cena);

                npc2[i].draw();
                npc2[i].perseguir(jogador2.x, jogador2.y);
                npc2[i].morrer();
                jogador2.rota(npc2[i]);
                
                 boolean colidiu3 = false;
                for (int j = 0; j < npc3.length; j++) {

                    if (npc2[i].collided(npc3[j]) && i!=prioridade2) {
                        npc2[i].x = 10_000;
                        npc2[i].velocidade = 0.0;
                        npc2[i].movendo = false;
                        npc2[i].direcao = 0;

                        npc3[j].x = 328;
                        npc3[j].y = -600;
                    }else if (npc2[prioridade2].collided(npc3[j])) {
                       npc2[prioridade2].x = 5_000;
                        npc2[prioridade2].velocidade = 0.0;
                        npc2[prioridade2].movendo = false;
                       npc2[prioridade2].direcao = 0;

                        npc3[j].x = 5_000;
                        npc3[j].velocidade = 0.0;
                        npc3[j].movendo = false;
                        npc3[j].direcao = 0;

                    }
                    if (colidiu3 == false) {
                        if (npc2[prioridade2].x == npc3[j].x) {
                            fim.draw();
                            colidiu3 = true;
                        }
                    } else {
                        if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                            new Cenario1(janela);
                        } 
                        for (int l = 0; l < npc.size(); l++) {
                            npc.get(l).hide();
                            npc.get(l).velocidade = 0.0;
                            npc.get(l).movendo = false;
                            npc.get(l).direcao = 0;
                        }
                        for (int x = 0; x < npc2.length; x++) {
                           npc2[x].hide();
                           npc2[x].velocidade = 0.0;
                           npc2[x].movendo = false;
                           npc2[x].direcao = 0;
                        }
                        for (int y = 0; y < npc3.length; y++) {
                            npc3[y].hide();
                            npc3[y].velocidade = 0.0;
                            npc3[y].movendo = false;
                            npc3[y].direcao = 0;
                        }
                        
                        for (int m = 0; m < npc4.length; m++) {
                            npc4[m].hide();
                            npc4[m].velocidade = 0.0;
                            npc4[m].movendo = false;
                            npc4[m].direcao = 0;
                        }
                       
                    }
                }
                
                 boolean colidiu4 = false;
                for (int k = 0; k < npc4.length; k++) {

                    if (npc2[i].collided(npc4[k]) && i!=prioridade2) {
                        npc2[i].x = 10_000;
                        npc2[i].velocidade = 0.0;
                        npc2[i].movendo = false;
                        npc2[i].direcao = 0;

                        npc4[k].x = 412;
                        npc4[k].y = 600;

                    }else if (npc2[prioridade2].collided(npc4[k])) {
                       npc2[prioridade2].x = 5_000;
                        npc2[prioridade2].velocidade = 0.0;
                        npc2[prioridade2].movendo = false;
                       npc2[prioridade2].direcao = 0;

                        npc4[k].x = 5_000;
                        npc4[k].velocidade = 0.0;
                        npc4[k].movendo = false;
                        npc4[k].direcao = 0;

                    }
                    if (colidiu4 == false) {
                        if (npc2[prioridade2].x == npc4[k].x) {
                            fim.draw();
                            colidiu4 = true;
                        }
                    } else {
                        if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                            new Cenario1(janela);
                        } 
                        for (int l = 0; l < npc.size(); l++) {
                            npc.get(l).hide();
                            npc.get(l).velocidade = 0.0;
                            npc.get(l).movendo = false;
                            npc.get(l).direcao = 0;
                        }
                        for (int x = 0; x < npc2.length; x++) {
                           npc2[x].hide();
                           npc2[x].velocidade = 0.0;
                           npc2[x].movendo = false;
                           npc2[x].direcao = 0;
                        }
                        for (int y = 0; y < npc3.length; y++) {
                            npc3[y].hide();
                            npc3[y].velocidade = 0.0;
                            npc3[y].movendo = false;
                            npc3[y].direcao = 0;
                        }
                        
                        for (int m = 0; m < npc4.length; m++) {
                            npc4[m].hide();
                            npc4[m].velocidade = 0.0;
                            npc4[m].movendo = false;
                            npc4[m].direcao = 0;
                        }
                       
                    }

                if (i > 0) {
                    if (npc2[i - 1].collided(npc2[i])) {
                        npc2[i].x = npc2[i - 1].x + npc2[i].width;
                    }

                }
               
            }
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
                        npc3[i].y = npc3[i].y - npc3[i].height - 4;
                    }

                }

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

              //  janela.drawText("id: " + (npc3.length + npc2.length + npc.size() + 1 + i), (int) npc4[i].x + 5, (int) npc4[i].y + 3, Color.yellow);
            }

            jogador.draw();
            jogador2.draw();
            jogador3.draw();
            jogador4.draw();
            //npc.vida(janela);
            janela.drawText("Prioridade I: " + prioridade1, 2, 12, Color.WHITE, new Font("arial", Font.BOLD, 12));
            janela.drawText("Prioridade II: " + (prioridade2+npc.size()), 2, 20, Color.WHITE, new Font("arial", Font.BOLD, 12));
            janela.update();
            //System.out.println("X: " +jogador.getX() + " Y: " + jogador.getY());

            //jogador.moveTo(754.0, 229.0, 1.0);
        }
    }

}
