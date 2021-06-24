
package torafikko2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.*;
import jplay.*;
public class Cenario1 {

    private Window janela;
    private Scene cena;
    private Jogador jogador, jogador2, jogador3, jogador4,jogador5;
    private Keyboard teclado;
    private Npc npc[], npc2[], npc3[], npc4[];
    private Person p1;
    
    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("scene.scn"));
        teclado = janela.getKeyboard();
        jogador = new Jogador(798, 343);
        jogador2 = new Jogador(-54, 224);
        jogador3 = new Jogador(328, 593);
        jogador4 = new Jogador(432, -42);
        jogador5 = new Jogador(798, 299);
        p1 = new Person(175,313);
        npc2 = new Npc[14];
        npc3 = new Npc[4];
        npc4 = new Npc[4];
        run();
    }

    
     
    private void run() {
        ArrayList<Npc> npc = new ArrayList<>();
        int prioridade1 = 1;
        int prioridade2 = 3;


        for (int i = 0; i < 14; i++) {
            if (i == 0 && i!=prioridade1 && i!=prioridade2) {
                npc.add(0, new Npc(-200, 343));
            } else if(i!=prioridade1&& i!=prioridade2) {
                npc.add(i, new Npc(-210 * (i + 2), 343));
            } else{
            npc.add(i, new Npc(-210 * (i + 2), 299));
            }
             
        }
        
        for (int i = 0; i < npc2.length; i++) {
            if (i == 0) {
                npc2[0] = new Npc(780, 224);
            } else {
                npc2[i] = new Npc(850 * (i/3), 224);
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
                npc4[0] = new Npc(426, -180);
            } else {
                npc4[i] = new Npc(426, -45 * (i + 4));
            } 
        }

  teclado.addKey(KeyEvent.VK_R);
  teclado.addKey(KeyEvent.VK_A);
  teclado.addKey(KeyEvent.VK_E);
  teclado.addKey(KeyEvent.VK_P);
  teclado.addKey(KeyEvent.VK_D);
  teclado.addKey(KeyEvent.VK_Q);
  boolean auto = false;
  
  boolean sair = false;
  boolean feito = false;
  boolean apertou = false;
  boolean colidiu= false;
  boolean dead = false;
  boolean parar = false;
  boolean ir = false;
          
  
        while (true) {
          if(teclado.keyDown(KeyEvent.VK_R)){new Cenario1(janela);}
          
            GameImage fim = new GameImage("src\\recursos\\fundos\\fim.png");
            GameImage fim2 = new GameImage("src\\recursos\\fundos\\fim2.png");
            Animation fdead = new Animation("src\\recursos\\fundos\\dead.png"); 
            
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
            Animation poste6 = new Animation("src\\recursos\\tiles\\semaf.png");poste6.x= 295;poste6.y=300;
            Animation poste7 = new Animation("src\\recursos\\tiles\\post.png");poste7.x= 295;poste7.y=-10;
            Animation poste8 = new Animation("src\\recursos\\tiles\\post.png");poste8.x= 52;poste8.y=310;
            Animation poste9 = new Animation("src\\recursos\\tiles\\post.png");poste9.x= 230;poste9.y=310;
            Animation poste10 = new Animation("src\\recursos\\tiles\\post.png");poste10.x= 595;poste10.y=310;
            Animation poste11 = new Animation("src\\recursos\\tiles\\post.png");poste11.x= 740;poste11.y=310;
            Animation poste12 = new Animation("src\\recursos\\tiles\\post.png");poste12.x= 296;poste12.y=470;
            Animation poste13 = new Animation("src\\recursos\\tiles\\post.png");poste13.x= 472;poste13.y=510;
            Animation poste14 = new Animation("src\\recursos\\tiles\\semaf1.png");poste14.x= 475;poste14.y=120;
            
            Animation hot = new Animation("src\\recursos\\tiles\\hot.png");hot.x=595;hot.y=125;
            Animation correio = new Animation("src\\recursos\\tiles\\correio.png");correio.x=680;correio.y=185;
            Animation banco = new Animation("src\\recursos\\tiles\\banco1.png");banco.x=703;banco.y=-3;
            
            Animation fut = new Animation("src\\recursos\\tiles\\fut3.png");fut.x=7;fut.y=453;
            Animation grade = new Animation("src\\recursos\\tiles\\grade.png");grade.x=-6;grade.y=388;
            
            Animation barreira = new Animation("src\\recursos\\tiles\\park1.png");barreira.x=54;barreira.y=326;
            Animation barreira2 = new Animation("src\\recursos\\tiles\\park.png");barreira2.x=708;barreira2.y=228;
            
            Animation barreira3 = new Animation("src\\recursos\\tiles\\street.png");barreira3.x=440;barreira3.y=348;
            Animation barreira4 = new Animation("src\\recursos\\tiles\\street.png");barreira4.x=340;barreira4.y=352;
            Animation barreira5 = new Animation("src\\recursos\\tiles\\street.png");barreira5.x=340;barreira5.y=325;
            Animation barreira6 = new Animation("src\\recursos\\tiles\\street.png");barreira6.x=432;barreira6.y=220;
            Animation barreira7 = new Animation("src\\recursos\\tiles\\street.png");barreira7.x=340;barreira7.y=352;
            Animation barreira8 = new Animation("src\\recursos\\tiles\\street.png");barreira8.x=412;barreira8.y=220;
            Animation barreira9 = new Animation("src\\recursos\\tiles\\street.png");barreira9.x=412;barreira9.y=140;
            Animation barreira10 = new Animation("src\\recursos\\tiles\\street.png");barreira10.x=325;barreira10.y=220;
           // Animation barreira11 = new Animation("src\\recursos\\tiles\\barreira.png");barreira11.x=412;barreira11.y=240;                       
            Animation siga = new Animation("src\\recursos\\tiles\\siga.png");siga.x=250;siga.y=305;
            Animation pare = new Animation("src\\recursos\\tiles\\pare.png");pare.x=250;pare.y=305;
            Animation siga1 = new Animation("src\\recursos\\tiles\\siga.png");siga1.x=500;siga1.y=126;
            Animation pare1 = new Animation("src\\recursos\\tiles\\pare.png");pare1.x=500;pare1.y=126;
           // Animation obs = new Animation("src\\recursos\\tiles\\rock.png");obs.x=212;obs.y=343;
            
             if(teclado.keyDown(KeyEvent.VK_E)){System.exit(0);}
                
            //p1.controle(janela, teclado);
            //cena.moveScene(p1);
            //p1.x += cena.getXOffset();
            //p1.y += cena.getYOffset();
            cena.moveScene(jogador2);
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset(); 
            //jogador.controle(janela, teclado);
            if(npc.get(npc.size()-1).x>5){
                 cena.changeTile(10, 0, 77);
                 cena.changeTile(11, 0, 77);
                }
        barreira.draw();barreira2.draw();barreira3.draw();barreira4.draw();barreira5.draw();barreira6.draw();
        barreira7.draw();barreira8.draw();barreira9.draw();barreira10.draw();
          
            for (int i = 0; i < npc.size(); i++) {  
                npc.get(i).x += cena.getXOffset();
                npc.get(i).y += cena.getYOffset();
                npc.get(i).caminho(cena);
                npc.get(i).draw();
               // System.out.println("npc1["+i+"]: "+npc.get(i).x);
               npc.get(i).velocidade=2.3;
                if(i==prioridade1||i==prioridade2){
                    npc.get(i).perseguir1(jogador5.x, jogador5.y);
                    jogador5.rota(npc.get(i));
                }else{
                    jogador.rota(npc.get(i));
                    npc.get(i).perseguir(jogador.x, jogador.y);
                }
                                            
                npc.get(i).morrer();
                
                if(dead==true){
                 if(npc.get(i).collided(barreira3)){
                    if(barreira3.x > npc.get(i).x + barreira3.width - 4 ){
                   npc.get(i).x = barreira3.x - npc.get(i).width;
               } else if(barreira3.x + barreira3.width - 4 < npc.get(i).x ) {
                    npc.get(i).x = barreira3.x + barreira3.width ;
                }
                 }   //  npc4[i].y = barreira6.y + npc4[i].height;
                cena.changeTile(11, 9, 04);
                cena.changeTile(10, 9, 04);
                    }

                if(sair==false){
/*
                 if(npc.get(i).collided(obs)){
                    janela.drawText("|||Remova a Pedra|||",(int) obs.x-45,(int) obs.y+25, Color.red, new Font("Arial", Font.PLAIN,12));
                    cena.changeTile(11, 0, 77);
                    cena.changeTile(10, 0, 77);
                    npc.get(i).x= obs.x - npc.get(i).width;
                   
                    p1.draw();
                    if(p1.collided(obs)&&teclado.keyDown(KeyEvent.VK_P)){
                         
                    obs.hide();
                    feito=true;
                    apertou=true;
                    for(int z =0;z<npc.size();z++){
                            npc.get(z).velocidade=2.8;
                            }
                    }
                    if(p1.collided(npc.get(i))&&feito==true){
                       p1.hide();
                       obs.x=1000;
                       cena.changeTile(10, 0, 1);
                       cena.changeTile(11, 0, 1);
                        sair=true;  
                    }
                 }*/
            }
                              
                if (i > 0 ) {
                   
                    if (npc.get(i - 1).collided(npc.get(i))) {
                        npc.get(i).x = npc.get(i - 1).x - npc.get(i).width;
                    } 
                    
                     if(npc.get(i).collided(barreira)&&npc.get(i-1).collided(barreira)&&npc.get(3).x>212){
                         colidiu=true;
                                                               
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
                     if(colidiu==true){
                          fim.draw();fdead.hide();
                          cena.changeTile(7, 9, 20);
                          cena.changeTile(8, 9, 20);
                          
                    barreira.hide();barreira2.hide();barreira3.hide();barreira4.hide();barreira5.hide();barreira6.hide();
                    barreira7.hide();barreira8.hide();barreira9.hide();porta.hide();porta1.hide();
                    teto.hide();tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();porta3.hide();
                    hort.hide();hort1.hide();chair.hide();car.hide();car1.hide();car2.hide();car3.hide();
                    tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                    poste.hide();poste1.hide();poste2.hide();poste3.hide();
                    hot.hide();correio.hide();banco.hide();poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                    poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                    fut.hide();grade.hide();pare.hide();siga.hide();pare1.hide();siga1.hide();luz.hide();n1.hide();
                          
                      }
                }
                
                if(npc.get(prioridade2).collided(npc.get(prioridade1))){
                npc.get(prioridade2).x = npc.get(prioridade1).x - npc.get(prioridade2).width;
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
                    if(npc.get(i).x>54 && i!=prioridade1&& i!=prioridade2){
                  
                     janela.drawText("id:"+(id*i+3), (int)npc.get(i).x,(int) npc.get(i).y+5, Color.ORANGE);
                       
                    } else if(npc.get(i).x>54&& (i==prioridade1 || i==prioridade2)){
                    janela.drawText("id:"+(id*i+3), (int)npc.get(i).x,(int) npc.get(i).y+5, Color.MAGENTA);
                    }

            }

            for (int i = 0; i < npc2.length; i++) {
                npc2[i].x += cena.getXOffset();
                npc2[i].y += cena.getYOffset();
                npc2[i].caminho(cena);
                npc2[i].velocidade=2.3;
                npc2[i].draw();
                npc2[i].perseguir(jogador2.x, jogador2.y);
                //npc2[i].morrer();
                if(npc2[npc2.length-1].x<800){
                 cena.changeTile(7, 24, 77);
                 cena.changeTile(8, 24, 77);
                }
                jogador2.rota(npc2[i]);
          
                if(dead==true){
                 if(npc2[i].collided(barreira10)){
                    if(barreira10.x > npc2[i].x + barreira10.width - 4 ){
                   npc2[i].x = barreira10.x - npc2[i].width;
               } else if(barreira10.x + barreira10.width - 4 < npc2[i].x ) {
                    npc2[i].x = barreira10.x + barreira10.width ;
                }
                 }   //  npc4[i].y = barreira6.y + npc4[i].height;
                cena.changeTile(7, 15, 04);
                 cena.changeTile(8, 15, 04);
                    }
              
                if (i > 0) {
                    
                    if (npc2[i - 1].collided(npc2[i])) {
                        npc2[i].x = npc2[i - 1].x + npc2[i].width;
                    }
                    if(npc2[i].collided(barreira2)&&npc2[i-1].collided(barreira2)&&npc2[i].x<667){
                    
                      fim.draw();fdead.hide();
                      cena.changeTile(11, 15, 20);
                      cena.changeTile(10, 15, 20);
                    barreira.hide();barreira2.hide();barreira3.hide();barreira4.hide();barreira5.hide();barreira6.hide();
                    barreira7.hide();barreira8.hide();barreira9.hide();porta.hide();porta1.hide();
                    teto.hide();tenda.hide();tendaa.hide();tenda1.hide();tenda2.hide();porta3.hide();
                    hort.hide();hort1.hide();chair.hide();car.hide();car1.hide();car2.hide();car3.hide();
                    tree.hide();tree1.hide();tree2.hide();tree3.hide();tree4.hide();tree5.hide();tree6.hide();tree7.hide();
                    poste.hide();poste1.hide();poste2.hide();poste3.hide();
                    hot.hide();correio.hide();banco.hide();poste4.hide(); poste5.hide(); poste6.hide(); poste7.hide(); poste8.hide(); poste9.hide(); poste10.hide();
                    poste11.hide(); poste12.hide(); poste13.hide(); poste14.hide();
                    fut.hide();grade.hide();pare.hide();siga.hide();pare1.hide();siga1.hide();n2.hide();
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
                if (i > 1 ) {
                   
                    if (npc2[i - 2].collided(npc2[i])) {
                        npc2[i].x = npc2[i - 2].x + npc2[i].width;
                    }}
                               
                 if (i > 2 ) {
                    if (npc2[i - 3].collided(npc2[i])) {
                        npc2[i].x = npc2[i - 3].x + npc2[i].width;
                    }}
                int id = 23;
                    if(npc2[i].x<708){
                  
                     janela.drawText("id:"+(id*i+5), (int)npc2[i].x,(int) npc2[i].y+5, Color.CYAN);
                       
                    }
            }
            
            for (int i = 0; i < npc3.length; i++) {
                npc3[i].x += cena.getXOffset();
                npc3[i].y += cena.getYOffset();
                npc3[i].caminho(cena);
                npc3[0].velocidade=1.5;
                npc3[i].draw();
                npc3[i].perseguir(jogador3.x, jogador3.y);
                npc3[i].morrerVert1();
                jogador3.rota2(npc3[i]);
            
                    if(npc3[i].collided(barreira4) && dead==true){
                         if(barreira4.y + barreira4.height - 4 < npc3[i].y){
                   npc3[i].y = barreira4.y + barreira4.height;
               } else if(barreira4.y > npc3[i].y + barreira4.height - 4 ){
                   npc3[i].y = barreira4.y - barreira4.height;
               }
                    //  npc4[i].y = barreira6.y + npc4[i].height;
                 //cena.changeTile(6, 10, 80);
                 //cena.changeTile(6, 11, 80);
                    }
                
                
                if (i > 0) {
                    if (npc3[i - 1].collided(npc3[i])) {
                        npc3[i].y = npc3[i-1].y - npc3[i].height;
                    }

                }
                if (i > 1) {
                    if (npc3[i - 2].collided(npc3[i])) {
                        npc3[i].y = npc3[i-2].y - npc3[i].height;
                    }

                }
                if (i > 2) {
                    if (npc3[i - 3].collided(npc3[i])) {
                        npc3[i].y = npc3[i-3].y - npc3[i].height;
                    }

                }            
                   //teclado.keyDown(KeyEvent.VK_A)
                if(1==1){auto=true;}
                 if(ir==true){
                 cena.changeTile(7, 15, 04);
                 cena.changeTile(8, 15, 04);
                 cena.changeTile(11, 9, 04);
                 cena.changeTile(10, 9, 04);
                 pare.hide();
                 pare1.hide();
                 siga.draw();
                 siga1.draw();
                 }else if(parar==true){
                 cena.changeTile(7, 15, 20);
                 cena.changeTile(8, 15, 20);
                 cena.changeTile(11, 9, 20);
                 cena.changeTile(10, 9, 20);
                 pare.draw();
                 pare1.draw();
                 siga.hide();
                 siga1.hide();
                 }
                 
                 if(npc4[2].collided(barreira9)&&
                         npc3[i].collided(barreira5)){
                    if(auto==true){
                     parar=true;
                     ir=false; 
                    }
                }else if(npc4[2].collided(barreira9)&&
                         npc3[2].collided(barreira5)){
                    if(auto==true){
                     parar=true;
                     ir=false; 
                    }
                }else if(npc4[2].collided(barreira9)&&
                         npc3[3].collided(barreira5)){
                    if(auto==true){
                     parar=true;
                     ir=false; 
                    }
                }else if(npc4[3].collided(barreira8)){
                    if(auto==true){
                     parar=true;
                     ir=false; 
                    }
                }else if(npc3[3].collided(barreira7)){
                    if(auto==true){
                     ir=true;
                     parar=false;
                    }
                }else if(npc4[3].collided(barreira9)||npc4[2].collided(barreira9)){
                    if(auto==true){
                     ir=true;
                     parar=false;
                    }
                }else{
                 parar=true;
                 ir=false;
                }
             
             /*  */
            }

            for (int i = 0; i < npc4.length; i++) {
                npc4[i].x += cena.getXOffset();
                npc4[i].y += cena.getYOffset();
                npc4[i].caminho(cena);

                npc4[i].draw();
                
                npc4[i].perseguir(jogador4.x, jogador4.y);
                npc4[i].morrerVert2();
                jogador4.rota3(npc4[i]);
                
                
               
                if(dead==true){
                    if(npc4[i].collided(barreira6)){
                         if(barreira6.y + barreira6.height - 4 < npc4[i].y){
                   npc4[i].y = barreira6.y + barreira6.height;
               } else if(barreira6.y > npc4[i].y + barreira6.height - 4 ){
                   npc4[i].y = barreira6.y - barreira6.height;
               }
                    //  npc4[i].y = barreira6.y + npc4[i].height;
                   // cena.changeTile(12, 14, 80);
                   // cena.changeTile(12, 13, 80);
                    }
                }
                    
                
                if (i > 0) {
                    if (npc4[i - 1].collided(npc4[i])) {
                        npc4[i].y = npc4[i-1].y + npc4[i].height;
                    }
                       
                }

                if (i > 1) {
                    if (npc4[i - 2].collided(npc4[i])) {
                        npc4[i].y = npc4[i-2].y + npc4[i].height;
                    }
                       
                }
                
                if (i > 2) {
                    if (npc4[i - 3].collided(npc4[i])) {
                        npc4[i].y = npc4[i-3].y + npc4[i].height;
                    }
                       
                }
               
            }
           if(npc.get(npc.size()-1).x>700&&npc2[npc2.length-1].x>700){
                fim2.draw();
                      
                    barreira.hide();barreira2.hide();barreira3.hide();barreira4.hide();barreira5.hide();barreira6.hide();
                    barreira7.hide();barreira8.hide();barreira9.hide();porta.hide();porta1.hide();
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
            jogador5.draw();
            
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
             if(npc.get(prioridade2).x>400&&npc2[6].x<251){
                    if(teclado.keyDown(KeyEvent.VK_D)){
                    dead=true;}
                  fdead.draw();
                }          
                 
   
  
    /*     if(teclado.keyDown(KeyEvent.VK_D) ){
     cena.changeTile(7, 11, 77);
     cena.changeTile(8, 11, 77);
     cena.changeTile(11, 13, 77);
     cena.changeTile(10, 13, 77);
    dead=true;
     }
    if(dead==true){fdead.draw();}
    */
            janela.delay(8);
            janela.update();
           
        }
    
    }

}
