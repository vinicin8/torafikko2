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
    private Jogador jogador, jogador2, jogador3, jogador4,jogador5;
    private Keyboard teclado;
    private Npc npc[], npc2[], npc3[], npc4[];

    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("scene.scn"));
        teclado = janela.getKeyboard();
        jogador = new Jogador(798, 229);
        jogador2 = new Jogador(-54, 337);
        jogador3 = new Jogador(328, 593);
        jogador4 = new Jogador(412, -42);
//jogador5 = new Jogador(798, 264);
        //npc = new Npc[14];
        npc2 = new Npc[10];
        npc3 = new Npc[4];
        npc4 = new Npc[4];

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
                npc2[0] = new Npc(780, 337);
            } else {
                npc2[i] = new Npc(850 * (i), 337);
            }
        }

        for (int i = 0; i < npc3.length; i++) {
            if (i == 0) {
                npc3[0] = new Npc(328, -160);
            } else {
                npc3[i] = new Npc(328, -40 * (i +4));
            }
        }

        for (int i = 0; i < npc4.length; i++) {
            if (i == 0) {
                npc4[0] = new Npc(412, -180);
            } else {
                npc4[i] = new Npc(412, -45 * (i + 4));
            } 
        }

        int prioridade1 = 3;
                //(int) (Math.random() * (npc.size() - 1));
        int prioridade2 = 0;
                //(int) (Math.random() * (npc2.length - 1));
 Time tempo = new Time(710, 580, true);
 teclado.addKey(KeyEvent.VK_R);
  
        while (true) {
          if(teclado.keyDown(KeyEvent.VK_R)){new Cenario1(janela);}
            
            GameImage fim = new GameImage("src\\recursos\\fundos\\fim.png");
            GameImage fim2 = new GameImage("src\\recursos\\fundos\\fim2.png");
            Animation noite = new Animation("src\\recursos\\fundos\\gg.png"); 
            
            Animation n1 = new Animation("src\\recursos\\fundos\\1.png");   
            Animation n2 = new Animation("src\\recursos\\fundos\\2.png");   
            Animation n3 = new Animation("src\\recursos\\fundos\\3.png");   
            Animation luz = new Animation("src\\recursos\\fundos\\luz.png");   
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
            Animation poste14 = new Animation("src\\recursos\\tiles\\semaf1.png");poste14.x= 475;poste14.y=300;
            
            Animation hot = new Animation("src\\recursos\\tiles\\hot.png");hot.x=595;hot.y=125;
            Animation correio = new Animation("src\\recursos\\tiles\\correio.png");correio.x=680;correio.y=185;
            Animation banco = new Animation("src\\recursos\\tiles\\banco1.png");banco.x=703;banco.y=-3;
            
            Animation fut = new Animation("src\\recursos\\tiles\\fut3.png");fut.x=7;fut.y=453;
            Animation grade = new Animation("src\\recursos\\tiles\\grade.png");grade.x=-6;grade.y=388;
            
            Animation barreira = new Animation("src\\recursos\\tiles\\park1.png");barreira.x=54;barreira.y=228;
            Animation barreira2 = new Animation("src\\recursos\\tiles\\park.png");barreira2.x=708;barreira2.y=326;
            
            Animation barreira3 = new Animation("src\\recursos\\tiles\\street.png");barreira3.x=340;barreira3.y=-30;
             Animation barreira4 = new Animation("src\\recursos\\tiles\\street.png");barreira4.x=340;barreira4.y=150;
             Animation barreira5 = new Animation("src\\recursos\\tiles\\street.png");barreira5.x=340;barreira5.y=320;
            Animation barreira6 = new Animation("src\\recursos\\tiles\\street.png");barreira6.x=412;barreira6.y=532;
            Animation barreira7 = new Animation("src\\recursos\\tiles\\street.png");barreira7.x=412;barreira7.y=434;
            Animation barreira8 = new Animation("src\\recursos\\tiles\\street.png");barreira8.x=412;barreira8.y=260;
             Animation barreira9 = new Animation("src\\recursos\\tiles\\street.png");barreira9.x=412;barreira9.y=140;
             Animation barreira10 = new Animation("src\\recursos\\tiles\\street.png");barreira10.x=340;barreira10.y=-420;
                                    
                Animation siga = new Animation("src\\recursos\\tiles\\siga.png");siga.x=250;siga.y=126;
                Animation pare = new Animation("src\\recursos\\tiles\\pare.png");pare.x=250;pare.y=126;
                 Animation siga1 = new Animation("src\\recursos\\tiles\\siga.png");siga1.x=500;siga1.y=305;
                Animation pare1 = new Animation("src\\recursos\\tiles\\pare.png");pare1.x=500;pare1.y=305;
           if (teclado.keyDown(Keyboard.LEFT_KEY)) {
                cena.changeTile(7, 9, 20);
                cena.changeTile(8, 9, 20);
            } else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
                cena.changeTile(7, 9, 04);
                cena.changeTile(8, 9, 04);
            }
            if (teclado.keyDown(Keyboard.UP_KEY)) {
                cena.changeTile(11, 15, 20);
                cena.changeTile(10, 15, 20);
            } else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
                cena.changeTile(11, 15, 04);
                cena.changeTile(10, 15, 04);
            }
            
            
             if(teclado.keyDown(Keyboard.SPACE_KEY)){System.exit(0);}
            //jogador.controle(janela, teclado);
            
                
                
               
            cena.moveScene(jogador);

            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();

        barreira.draw();barreira2.draw();barreira3.draw();barreira4.draw();barreira5.draw();barreira6.draw();
            barreira7.draw();barreira8.draw();barreira9.draw();barreira10.draw();
          
    
            for (int i = 0; i < npc.size(); i++) {
            
              

                npc.get(i).x += cena.getXOffset();
                npc.get(i).y += cena.getYOffset();
                npc.get(i).caminho(cena);

                npc.get(i).draw();
                
                
               npc.get(i).perseguir(jogador.x, jogador.y);
              
                npc.get(i).morrer();
                
                jogador.rota(npc.get(i));
                
               
                if (i > 0 ) {
                   
                    if (npc.get(i - 1).collided(npc.get(i))) {
                        npc.get(i).x = npc.get(i - 1).x - npc.get(i).width;
                    } 
                    
                     if(npc.get(i).collided(barreira)&&npc.get(i-1).collided(barreira)){
                      fim.draw();
                      
                      barreira.hide();barreira2.hide();barreira3.hide();barreira4.hide();barreira5.hide();barreira6.hide();
                    barreira7.hide();barreira8.hide();barreira9.hide();barreira10.hide();porta.hide();porta1.hide();
                    teto.hide();tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();porta3.hide();
                    hort.hide();hort1.hide();chair.hide();car.hide();car1.hide();car2.hide();car3.hide();
                    tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                    poste.hide();poste1.hide();poste2.hide();poste3.hide();
                    hot.hide();correio.hide();banco.hide();poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                    poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                    fut.hide();grade.hide();pare.hide();siga.hide();pare1.hide();siga1.hide();luz.hide();n1.hide();
                            for (int l = 0; l < npc.size(); l++) {
                            npc.get(l).hide();
                            npc.get(l).velocidade = 0.0;
                            npc.get(l).movendo = false;
                            npc.get(l).direcao = 0;
                        }
                        for (int x = 0; x < npc2.length; x++) {
                           npc2[x].hide();
                           npc2[x].x=8_000;
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
                
                
               
                 if (i > 1 ) {
                   
                    if (npc.get(i - 2).collided(npc.get(i))) {
                        npc.get(i).x = npc.get(i - 2).x - npc.get(i).width;
                    } }
                
                
                 if (i > 2 ) {
                   
                    if (npc.get(i - 3).collided(npc.get(i))) {
                        npc.get(i).x = npc.get(i - 3).x - npc.get(i).width;
                    } }
                 
                 
                     int id = 54;
                    if(npc.get(i).x>54){
                  
                     janela.drawText("id:"+(id*i+3), (int)npc.get(i).x,(int) npc.get(i).y+5, Color.ORANGE);
                       
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
          
              
                if (i > 0) {
                    
                    if (npc2[i - 1].collided(npc2[i])) {
                        npc2[i].x = npc2[i - 1].x + npc2[i].width;
                    }
                    if(npc2[i].collided(barreira2)&&npc2[i-1].collided(barreira2)){
                    fim.draw();
                      cena.changeTile(11, 15, 20);
                      cena.changeTile(10, 15, 20);
                    barreira.hide();barreira2.hide();barreira3.hide();barreira4.hide();barreira5.hide();barreira6.hide();
                    barreira7.hide();barreira8.hide();barreira9.hide();barreira10.hide();porta.hide();porta1.hide();
                    teto.hide();tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();porta3.hide();
                    hort.hide();hort1.hide();chair.hide();car.hide();car1.hide();car2.hide();car3.hide();
                    tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                    poste.hide();poste1.hide();poste2.hide();poste3.hide();
                    hot.hide();correio.hide();banco.hide();poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                    poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                    fut.hide();grade.hide();pare.hide();siga.hide();pare1.hide();siga1.hide();noite.hide();luz.hide();n2.hide();
                            for (int l = 0; l < npc.size(); l++) {
                            npc.get(l).hide();
                            npc.get(l).velocidade = 0.0;
                            npc.get(l).movendo = false;
                            npc.get(l).direcao = 0;
                        }
                        for (int x = 0; x < npc2.length; x++) {
                           npc2[x].hide();
                           npc2[x].velocidade = 0.6;
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
                int id = 23;
                    if(npc2[i].x<708){
                  
                     janela.drawText("id:"+(id*i+5), (int)npc2[i].x,(int) npc2[i].y+5, Color.CYAN);
                       
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
                        npc3[i].y = npc3[i-1].y - npc3[i].height;
                    }

                }
                
                if(npc3[i].collided(barreira3)||npc3[i].collided(barreira5)||npc3[i].collided(barreira4)){
                    pare.draw();
                     siga.hide();
                     pare1.draw();
                     siga1.hide();
                } else if(npc4[i].collided(barreira6)||npc4[i].collided(barreira7)||npc4[i].collided(barreira8)){
                pare.draw();
                siga.hide();
                pare1.draw();
                     siga1.hide();
              }else if(npc4[2].collided(barreira9)&&npc3[3].collided(barreira3)) {
                pare.draw();
                siga.hide();
                pare1.draw();
                     siga1.hide();
                }else if(npc4[2].collided(barreira9)&&npc3[1].collided(barreira3)) {
                pare.draw();
                siga.hide();
                pare1.draw();
                     siga1.hide();
                }else if(npc4[2].collided(barreira9)&&npc3[2].collided(barreira3)) {
                pare.draw();
                siga.hide();
                pare1.draw();
                     siga1.hide();
                }else if(npc4[1].collided(barreira9)&&npc3[3].collided(barreira4)) {
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[2].collided(barreira9)&&npc3[2].collided(barreira4)){
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[3].collided(barreira9)&&npc3[2].collided(barreira4)){
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[3].collided(barreira9)&&npc3[1].collided(barreira4)){
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[3].collided(barreira9)&&npc3[2].collided(barreira4)){
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[2].collided(barreira9)&&npc3[1].collided(barreira4)){
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[2].collided(barreira9)&&npc3[3].collided(barreira4)){
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[2].collided(barreira9)&&npc3[0].collided(barreira4)){
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[3].collided(barreira9)&&npc3[0].collided(barreira4)){
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[3].collided(barreira9)&&npc3[3].collided(barreira4)){
                pare.draw();
                siga.hide();
                pare1.draw();
                siga1.hide();
                }else if(npc4[2].collided(barreira9)){
                siga.draw();
                pare.hide();
                siga1.draw();
                pare1.hide();
                }
             
              /*  janela.drawText("barreira", (int) barreira.x,(int) barreira.y, Color.yellow);
                janela.drawText("barreira2", (int) barreira2.x,(int) barreira2.y, Color.yellow);
                janela.drawText("barreira3", (int) barreira3.x,(int) barreira3.y, Color.yellow);
                janela.drawText("barreira4", (int) barreira4.x,(int) barreira4.y, Color.yellow);
                janela.drawText("barreira5", (int) barreira5.x,(int) barreira5.y, Color.yellow); 
                janela.drawText("barreira6", (int) barreira6.x,(int) barreira6.y, Color.yellow); 
                janela.drawText("barreira7", (int) barreira7.x,(int) barreira7.y, Color.yellow); 
                janela.drawText("barreira8", (int) barreira8.x,(int) barreira8.y, Color.yellow); 
                janela.drawText("barreira9", (int) barreira9.x,(int) barreira9.y, Color.yellow); 
                janela.drawText("barreira10", (int) barreira10.x,(int) barreira10.y, Color.yellow); 
              */  
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
                        npc4[i-1].y = npc4[i].y - npc4[i].height;
                    }
                    
                        
                }

            }
           if(npc.get(npc.size()-1).x>9_000&&npc2[npc2.length-1].x>9_000){
                fim2.draw();
                      
                    barreira.hide();barreira2.hide();barreira3.hide();barreira4.hide();barreira5.hide();barreira6.hide();
                    barreira7.hide();barreira8.hide();barreira9.hide();barreira10.hide();porta.hide();porta1.hide();
                    teto.hide();tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();porta3.hide();
                    hort.hide();hort1.hide();chair.hide();car.hide();car1.hide();car2.hide();car3.hide();
                    tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                    poste.hide();poste1.hide();poste2.hide();poste3.hide();
                    hot.hide();correio.hide();banco.hide();poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                    poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                    fut.hide();grade.hide();pare.hide();siga.hide();pare1.hide();siga1.hide();luz.hide();n2.hide();
           }
             
            jogador.draw();
            jogador2.draw();
            jogador3.draw();
            jogador4.draw();
            //jogador5.draw();
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
             tempo.draw();
             
            /*if(tempo.getSecond()>10&&tempo.getSecond()<=15){
            n3.draw();
            }else if(tempo.getSecond()>15&&tempo.getSecond()<=20){
            n3.hide();
            n2.draw();
            }else if(tempo.getSecond()>20){
            n2.draw();
            //n1.draw();
            luz.draw();
            }*/
             
            janela.update();
             
            
            
           
        }
    
    }

}
