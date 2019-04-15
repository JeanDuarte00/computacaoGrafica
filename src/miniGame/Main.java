package miniGame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import javafx.application.Application;
import javafx.stage.Stage;
import miniGame.controller.GameRenderer;
import miniGame.controller.MenuRenderer;
import miniGame.controller.RendererScore;
import miniGame.model.score.Score;
import miniGame.model.score.ScoreData;
import miniGame.model.utils.*;
import miniGame.model.utils.Dimension;
import miniGame.model.utils.WindowEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends Application {

    private int choosen =  (int)(Math.random() * 4) + 1;
    private static int objects[] = new int[4];
    public static String playerName;
    private MenuRenderer menuRender = new MenuRenderer();
    private RendererScore scoreRender = new RendererScore();
    private GameRenderer gameRender = new GameRenderer();
    private ScoreData scoreData = new ScoreData();
    private static Player player;

    public static void main(String[] args) {

        player = new Player("C://repositorios/cg/computacaoGrafica/src/miniGame/music/menu.wav");
        player.play();



            Application.launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        gameRender.createListAndPosition();
        System.out.println("Chosen: "+choosen);
        WindowEvent windowEvent = new WindowEvent();
        objects[0] = 1;
        objects[1] = 2;
        objects[2] = 3;
        objects[3] = 4;


        // all configuration
        Dimension sceneDimension = new Dimension(800, 800);
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        GLCanvas menuCanvas = new GLCanvas(capabilities);
        GLCanvas scoreCanvas = new GLCanvas(capabilities);
        GLCanvas gameCanvas = new GLCanvas(capabilities);


        menuCanvas.setSize(sceneDimension.getWidth(), sceneDimension.getHeight());
        gameCanvas.setSize(sceneDimension.getWidth(), sceneDimension.getHeight());
        scoreCanvas.setSize(sceneDimension.getWidth(), sceneDimension.getHeight());

        JFrame menuFrame = new JFrame("Mini Game - Menu");
        JFrame gameFrame = new JFrame("Mini Game - ClickFall");
        JFrame scoreFrame = new JFrame("Mini Game - Scores");

        menuCanvas.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Point p= e.getPoint();

                p.y=(p.y-800)*-1;

                if(p.x<150&&p.x>50){
                    if(p.y<650&&p.y>550){
                        //rotate0
                        menuRender.setRotate(0);
                    }else{
                        menuRender.disableRotate(0);
                    }
                    if(p.y<150&&p.y>50){
                        menuRender.setRotate(3);
                    }else{
                        menuRender.disableRotate(3);
                    }
                }else{
                    menuRender.disableRotate(0);
                    menuRender.disableRotate(3);
                }
                if(p.x<750&&p.x>650){
                    if(p.y<650&&p.y>550){
                        menuRender.setRotate(2);
                    }else{
                        menuRender.disableRotate(2);
                    }
                    if(p.y<150&&p.y>50){
                        menuRender.setRotate(1);
                    }else{
                        menuRender.disableRotate(1);
                    }
                }else{
                    menuRender.disableRotate(1);
                    menuRender.disableRotate(2);
                }

                if(p.x<650&&p.x>150){
                    if(p.y<500&&p.y>400){
                        menuRender.focusMenu(0);
                    }else{
                        menuRender.notFocus(0);
                    }

                    if(p.y<350&&p.y>250){
                        menuRender.focusMenu(1);
                    }else{
                        menuRender.notFocus(1);
                    }

                    if(p.y<200&&p.y>100){
                        menuRender.focusMenu(2);
                    }else{
                        menuRender.notFocus(2);
                    }
                }else{
                    menuRender.notFocus(0);
                    menuRender.notFocus(1);
                    menuRender.notFocus(2);
                }


            }
        });
        menuCanvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // exit
                if(e.getX()>200 && e.getX()<600) {
                    if (e.getY()>50 && e.getY()<150) {
                        System.out.println("EXIT: "+e.getX());
                        System.exit(0);
                        // code here
                    }
                }

                // new
                if(e.getX()>200 && e.getX()<600) {
                    if (e.getY()>250 && e.getY()<350) {
                        System.out.println("NEW: "+e.getX());
                        menuCanvas.setFocusable(false);
                        menuFrame.setVisible(false);
                        gameFrame.setVisible(true);
                        // code here
                    }
                }

                // score
                if(e.getX()>200 && e.getX()<600){
                    if(e.getY()>400 && e.getY()<500){
                        System.out.println("SCORE: "+e.getX());
                        menuCanvas.setFocusable(false);
                        menuFrame.setVisible(false);
                        scoreFrame.setVisible(true);
                        // code here
                    }
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        scoreCanvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // exit
                System.out.println("SCORES: "+e.getX()+"--"+e.getY());
                if(e.getX()>300 && e.getX()<500) {
                    if (e.getY()>660 && e.getY()<720) {
                        System.out.println("SCORES-VOLTAR: "+e.getX());
                        menuCanvas.setFocusable(true);
                        menuFrame.setVisible(true);
                        scoreFrame.setVisible(false);
                        // code here
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        final FPSAnimator animatorGame = new FPSAnimator(gameCanvas, 400, true);
        gameCanvas.addMouseListener(new MouseListener() {
            @Override

            public void mouseClicked(MouseEvent e) {
                int selected = -1;
                System.out.println("GAME X--Y: "+e.getX()+"--"+e.getY());

                if(e.getX()>86 && e.getX()<235) {
                    if (e.getY()>429 && e.getY()<561) {
                        System.out.println("OPTION1:");
                       selected = 0;
                    }
                }

                if(e.getX()>245 && e.getX()<491) {
                    if (e.getY()>429 && e.getY()<561) {
                        System.out.println("OPTION2:");
                        selected = 1;
                    }
                }

                if(e.getX()>405 && e.getX()<554) {
                    if (e.getY()>429 && e.getY()<561) {
                        System.out.println("OPTION3:");
                        selected = 2;
                    }
                }

                if(e.getX()>565 && e.getX()<714) {
                    if (e.getY()>429 && e.getY()<561) {
                        System.out.println("OPTION4:");
                        selected = 3;
                    }
                }
                if ( selected == gameRender.getResultPosition() || selected != gameRender.getResultPosition()) {
                    if (GameRenderer.getTimer() > 1) {
                        animatorGame.stop();
                        ScoreData score = new ScoreData();
                        JFrame input = new JFrame("Entre seu nome para salvar!");
                        input.setSize(250, 100);
                        input.setLocation(new Point(20, 20));
                        input.getContentPane().setLayout(new FlowLayout());
                        JTextField extfield = new JTextField("", 30);

                        JButton btn = new JButton("Salvar");
                        btn.setBounds(100, 100, 140, 40);
                        btn.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                Main.playerName = extfield.getText();
                                extfield.setText("Enviado com sucesso!");
                                score.saveScore(new Score(Main.playerName, GameRenderer.getScore()));

                                System.exit(0);
                            }


                        });
                        input.getContentPane().add(extfield);
                        input.getContentPane().add(btn);

                        input.pack();
                        input.setVisible(true);

                    }
                    else if ( selected == gameRender.getResultPosition()){
                        gameRender.upScore(1);
                        GameRenderer.setTimer(0);
                        new Effects("C://repositorios/cg/computacaoGrafica/src/miniGame/music/gainScore.wav");
                        gameRender.createListAndPosition();

                    } else if ( selected != gameRender.getResultPosition() ) {
                        gameRender.downlife();
                        GameRenderer.setTimer(0);
                        new Effects("C://repositorios/cg/computacaoGrafica/src/miniGame/music/loseScore.wav");
                        gameRender.createListAndPosition();
                    }
                }


                if(GameRenderer.getLife()==-1 ){

                    JFrame input = new JFrame("Entre seu nome para salvar!");
                    input.setSize(250, 100);
                    input.setLocation(new Point(20, 20));
                    input.getContentPane().setLayout(new FlowLayout());
                    JTextField extfield = new JTextField("",30);

                    JButton btn=new JButton("Salvar");
                    btn.setBounds(100,100,140, 40);
                    btn.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            playerName = extfield.getText();
                            System.out.println(playerName);
                            extfield.setText("Enviado com sucesso!");
                            scoreData.saveScore(new Score(playerName, GameRenderer.getScore()));
                            System.exit(0);
                        }


                    });
                    input.getContentPane().add(extfield);
                    input.getContentPane().add(btn);

                    input.pack();
                    input.setVisible(true);


                    // System.exit(0);

                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        windowEvent.close( menuFrame );
        windowEvent.close( gameFrame );
        windowEvent.close( scoreFrame );

        scoreFrame.getContentPane().add(scoreCanvas);
        menuFrame.getContentPane().add(menuCanvas);
        gameFrame.getContentPane().add(gameCanvas);

        menuFrame.setSize(menuFrame.getContentPane().getPreferredSize());
        gameFrame.setSize(menuFrame.getContentPane().getPreferredSize());
        scoreFrame.setSize(menuFrame.getContentPane().getPreferredSize());

        menuFrame.setResizable(false);
        gameFrame.setResizable(false);
        scoreFrame.setResizable(false);

        menuFrame.setVisible(true);
        gameFrame.setVisible(false);
        scoreFrame.setVisible(false);

        menuCanvas.setFocusable(true);
        gameCanvas.setFocusable(true);
        scoreCanvas.setFocusable(true);

        menuFrame.setLocation(new Point(20, 20));
        gameFrame.setLocation(new Point(20, 20));
        scoreFrame.setLocation(new Point(20, 20));


        final FPSAnimator animator = new FPSAnimator(menuCanvas, 400, true);
        animator.start();
        animatorGame.start();
        menuCanvas.addGLEventListener(menuRender);
        scoreCanvas.addGLEventListener(scoreRender);
        gameCanvas.addGLEventListener(gameRender);


    }




}