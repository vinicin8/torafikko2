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

        int prioridade1 = 1;
                //(int) (Math.random() * (npc.size() - 1));
        int prioridade2 = 0;
                //(int) (Math.random() * (npc2.length - 1));

        while (true) {
          
            
            GameImage fim = new GameImage("src\\recursos\\fundos\\fim.png");
            GameImage fim2 = new GameImage("src\\recursos\\fundos\\fim2.png");
           
            Animation porta = new Animation("src\\recursos\\tiles\\porta.png"); porta.x= 192;porta.y= 128;
            Animation porta1 = new Animation("src\\recursos\\tiles\\porta1.png"); porta1.x= 192;porta1.y= 160;
            Animation teto = new Animation("src\\recursos\\tiles\\teto.png"); teto.x= 68;teto.y= -1;
            Animation tenda2 = new Animation("src\\recursos\\tiles\\tenda2.png"); tenda2.x=92;tenda2.y=79;
            Animation tenda = new Animation("src\\recursos\\tiles\\tenda.png"); tenda.x=60;tenda.y=79;
            Animation tendaa = new Animation("src\\recursos\\tiles\\tenda.png"); tendaa.x=28;tendaa.y=79;
            Animation tenda1 = new Animation("src\\recursos\\tiles\\tenda1.png"); tenda1.x=-4;tenda1.y=79;
            Animation porta3 = new Animation("src\\recursos\\tiles\\door.png"); porta3.x=55;porta3.y=129; 
            Animation hort = new Animation("src\\recursos\\tiles\\hort.png"); hort.x=90;hort.y=135; 
            Animation hort1 = new Animation("src\\recursos\\tiles\\hort1.png"); hort1.x=10;hort1.y=135;
            Animation chair = new Animation("src\\recursos\\tiles\\chair.png"); chair.x=108;chair.y=155;
            
            Animation car = new Animation("src\\recursos\\tiles\\car.png");car.x=545;car.y=32;
            Animation car1= new Animation("src\\recursos\\tiles\\car1.png");car1.x=676;car1.y=124;
            Animation car2= new Animation("src\\recursos\\tiles\\car2.png");car2.x=705;car2.y=32;
            Animation car3= new Animation("src\\recursos\\tiles\\car3.png");car3.x=577;car3.y=32;
            
            Animation tree = new Animation("src\\recursos\\tiles\\tree.png");tree.x=545;tree.y=-5;
            Animation tree1 = new Animation("src\\recursos\\tiles\\tree.png");tree1.x=609;tree1.y=-5;
            Animation tree2 = new Animation("src\\recursos\\tiles\\tree.png");tree2.x=673;tree2.y=-5;
            Animation tree3 = new Animation("src\\recursos\\tiles\\tree.png");tree3.x=737;tree3.y=-5;
            
            Animation tree4 = new Animation("src\\recursos\\tiles\\tree1.png");tree4.x=578;tree4.y=155;
            Animation tree5 = new Animation("src\\recursos\\tiles\\tree1.png");tree5.x=642;tree5.y=155;
            Animation tree6 = new Animation("src\\recursos\\tiles\\tree1.png");tree6.x=706;tree6.y=155;
            Animation tree7 = new Animation("src\\recursos\\tiles\\tree1.png");tree7.x=770;tree7.y=155;
            
            Animation poste = new Animation("src\\recursos\\tiles\\post.png");poste.x= 500;poste.y=-35;
            Animation poste1 = new Animation("src\\recursos\\tiles\\post.png");poste1.x= 500;poste1.y=45;
            Animation poste2 = new Animation("src\\recursos\\tiles\\post.png");poste2.x= 520;poste2.y=92;
            Animation poste3 = new Animation("src\\recursos\\tiles\\post.png");poste3.x= 730;poste3.y=92;
            Animation poste4 = new Animation("src\\recursos\\tiles\\post.png");poste4.x= 0;poste4.y=120;
            Animation poste5 = new Animation("src\\recursos\\tiles\\post.png");poste5.x= 160;poste5.y=120;
            Animation poste6 = new Animation("src\\recursos\\tiles\\semaf.png");poste6.x= 295;poste6.y=120;
            Animation poste7 = new Animation("src\\recursos\\tiles\\post.png");poste7.x= 295;poste7.y=-10;
            Animation poste8 = new Animation("src\\recursos\\tiles\\post.png");poste8.x= 52;poste8.y=310;
            Animation poste9 = new Animation("src\\recursos\\tiles\\post.png");poste9.x= 230;poste9.y=310;
            Animation poste10 = new Animation("src\\recursos\\tiles\\post.png");poste10.x= 595;poste10.y=310;
            Animation poste11 = new Animation("src\\recursos\\tiles\\post.png");poste11.x= 740;poste11.y=310;
            Animation poste12 = new Animation("src\\recursos\\tiles\\post.png");poste12.x= 296;poste12.y=470;
            Animation poste13 = new Animation("src\\recursos\\tiles\\post.png");poste13.x= 472;poste13.y=510;
            Animation poste14 = new Animation("src\\recursos\\tiles\\semaf1.png");poste14.x= 475;poste14.y=310;
            
            Animation hot = new Animation("src\\recursos\\tiles\\hot.png");hot.x=595;hot.y=125;
            Animation correio = new Animation("src\\recursos\\tiles\\correio.png");correio.x=680;correio.y=185;
            Animation banco = new Animation("src\\recursos\\tiles\\banco1.png");banco.x=703;banco.y=-3;
            
            Animation fut = new Animation("src\\recursos\\tiles\\fut3.png");fut.x=7;fut.y=453;
            Animation grade = new Animation("src\\recursos\\tiles\\grade.png");grade.x=-6;grade.y=388;
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
                if(i!=prioridade1){
                jogador.rota(npc.get(i));
                }
                boolean colidiu = false;
                for (int j = 0; j < npc3.length; j++) {

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
                        // janela.drawText("id: " + i, (int) npc.get(i).x + 5, (int) npc.get(i).y + 3, Color.yellow);
                         
                        if (npc.get(prioridade1).x == npc3[j].x) {
                            fim.draw();

                          
                            colidiu = true;
                           
                        }
                    } else if(colidiu == true ) {
                        if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                            new Cenario1(janela);
                        }
                        porta.hide();porta1.hide();
                        teto.hide();
                        tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();
                        porta3.hide();
                        hort.hide();hort1.hide();
                        chair.hide();
                        car.hide();car1.hide();car2.hide();car3.hide();
                        tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                        poste.hide();poste1.hide();poste2.hide();poste3.hide();
                        hot.hide();correio.hide();banco.hide();
                         poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                         poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                          fut.hide();
                           grade.hide();
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
                      // janela.drawText("id: " + (npc.size() + 1 + i), (int) npc2[i].x + 5, (int) npc2[i].y + 3, Color.yellow);
                        if (npc.get(prioridade1).x == npc4[k].x) {
                            fim.draw();
                            colidiu2 = true;
                        }
                    } else {
                        if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                            new Cenario1(janela);
                        } 
                         porta.hide();porta1.hide();
                         teto.hide();
                         tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();
                         porta3.hide();
                         hort.hide();hort1.hide();
                         chair.hide();
                         car.hide();car1.hide();car2.hide();car3.hide();
                         tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                        poste.hide();poste1.hide();poste2.hide();poste3.hide();
                        hot.hide();correio.hide();banco.hide();
                         poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                         poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                         fut.hide();
                        grade.hide();
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
                         porta.hide();porta1.hide();
                         teto.hide();
                         tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();
                         porta3.hide();
                         hort.hide();hort1.hide();
                         chair.hide();
                         car.hide();car1.hide();car2.hide();car3.hide();
                         tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                        poste.hide();poste1.hide();poste2.hide();poste3.hide();
                        hot.hide();correio.hide();banco.hide();
                         poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                             poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                         fut.hide();
                          grade.hide();
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
                if(i!=prioridade2){
                jogador2.rota(npc2[i]);
                }
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
                         porta.hide();porta1.hide();
                         teto.hide();
                         tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();
                         porta3.hide();
                         hort.hide();hort1.hide();
                         chair.hide();
                         car.hide();car1.hide();car2.hide();car3.hide();
                         tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                        poste.hide();poste1.hide();poste2.hide();poste3.hide();
                          hot.hide();correio.hide();banco.hide();
                         poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                         poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                          fut.hide();
                         grade.hide();
                        hot.hide();correio.hide();banco.hide();
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
                         porta.hide();porta1.hide();
                         teto.hide();
                         tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();
                         porta3.hide();
                         hort.hide();hort1.hide();
                         chair.hide();
                         car.hide();car1.hide();car2.hide();car3.hide();
                         tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                        poste.hide();poste1.hide();poste2.hide();poste3.hide();
                        hot.hide();correio.hide();banco.hide();
                         poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                         poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                              fut.hide();
                         grade.hide();
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

             
            }

            jogador.draw();
            jogador2.draw();
            jogador3.draw();
            jogador4.draw();
            
             porta.draw();porta1.draw();
             teto.draw();
             tenda.draw();tendaa.draw();tenda1.draw();tenda2.draw();
             porta3.draw();
             hort.draw();hort1.draw();
             chair.draw();
             car.draw();car1.draw();car2.draw();car3.draw();
             tree.draw();tree1.draw();tree2.draw();tree3.draw();tree4.draw();tree5.draw();tree6.draw();tree7.draw();
             poste.draw();poste1.draw();poste2.draw();poste3.draw();
             poste4.draw();poste5.draw();poste6.draw();poste7.draw();poste8.draw();poste9.draw();poste10.draw();
             poste11.draw();poste12.draw();poste13.draw();poste14.draw();
             hot.draw();
             correio.draw();
             banco.draw();
             fut.draw();
            
             grade.draw();
            
            //janela.drawText("Prioridade I: " + prioridade1, 2, 12, Color.WHITE, new Font("arial", Font.BOLD, 12));
            //janela.drawText("Prioridade II: " + (prioridade2+npc.size()), 2, 20, Color.WHITE, new Font("arial", Font.BOLD, 12));
            janela.update();
            
            
            
            //System.out.println("X: " +jogador.getX() + " Y: " + jogador.getY());
        }
    }

}
