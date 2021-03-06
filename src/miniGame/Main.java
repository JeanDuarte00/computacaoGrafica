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

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.text.DecimalFormat;


public class Main extends Application {
    private static DecimalFormat df = new DecimalFormat("0.00");
    private int choosen =  (int)(Math.random() * 4) + 1;
    private static int objects[] = new int[4];
    public static String playerName;
    private MenuRenderer menuRender = new MenuRenderer();
    private RendererScore scoreRender = new RendererScore();
    private GameRenderer gameRender = new GameRenderer();
    private static Player player;


    public static void main(String[] args) {

        player = new Player("C:\\Users\\jean_\\IdeaProjects\\computacaoGrafica\\src\\miniGame\\music\\menu.wav");
        player.play();

        Application.launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        System.out.println("Started");
        gameRender.createListAndPosition();
        WindowEvent windowEvent = new WindowEvent();


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

        final FPSAnimator animatorGame = new FPSAnimator(gameCanvas, 400, true);
        final FPSAnimator animator = new FPSAnimator(menuCanvas, 400, true);


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
        gameCanvas.addMouseListener(new MouseListener() {
            @Override

            public void mouseClicked(MouseEvent e) {


                int selected = -1;
                System.out.println("GAME X--Y: " + e.getX() + "--" + e.getY());

                if (e.getX() > 86 && e.getX() < 235) {
                    if (e.getY() > 429 && e.getY() < 561) {
                        System.out.println("OPTION1:");
                        selected = 0;
                    }
                }

                if (e.getX() > 245 && e.getX() < 491) {
                    if (e.getY() > 429 && e.getY() < 561) {
                        System.out.println("OPTION2:");
                        selected = 1;
                    }
                }

                if (e.getX() > 405 && e.getX() < 554) {
                    if (e.getY() > 429 && e.getY() < 561) {
                        System.out.println("OPTION3:");
                        selected = 2;
                    }
                }

                if (e.getX() > 565 && e.getX() < 714) {
                    if (e.getY() > 429 && e.getY() < 561) {
                        System.out.println("OPTION4:");
                        selected = 3;
                    }
                }
                if (selected == gameRender.getResultPosition() || selected != gameRender.getResultPosition()) {
                    if (GameRenderer.getTimer() > 1 || GameRenderer.getLife() == 0 ) {
                        animatorGame.stop();
                        ScoreData score = new ScoreData();
                        JFrame input = new JFrame("Entre seu nome para salvar!");
                        input.setSize(250, 100);
                        input.setLocation(new Point(20, 20));
                        input.getContentPane().setLayout(new FlowLayout());
                        JTextField extfield = new JTextField("", 30);

                        JButton btnSalvar = new JButton("Salvar e Fechar");
                        JButton btnRecomecar = new JButton("Salvar e Jogar Novamente");

                        btnSalvar.setBounds(100, 200, 140, 40);
                        btnRecomecar.setBounds(200, 200, 140, 40);

                        btnSalvar.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                Main.playerName = extfield.getText();
                                extfield.setText("Enviado com sucesso!");
                                score.saveScore(new Score(Main.playerName, GameRenderer.getScore()));
                                System.exit(0);
                            }


                        });
                        btnRecomecar.addActionListener((ActionEvent event) -> {

                            Main.playerName = extfield.getText();
                            score.saveScore(new Score(Main.playerName, GameRenderer.getScore()));

                            menuCanvas.setFocusable(false);
                            menuFrame.setVisible(false);
                            gameFrame.setVisible(true);
                            animatorGame.start();
                            gameRender.setScore(0);
                            gameRender.setTimer(0);
                            gameRender.resetLife();
                            gameRender.resetFrames();
                        });

                        input.getContentPane().add(extfield);
                        input.getContentPane().add(btnSalvar);
                        input.getContentPane().add(btnRecomecar);

                        input.pack();
                        input.setVisible(true);

                    } else if (selected == gameRender.getResultPosition()) {
                        GameRenderer.setFrames(GameRenderer.getFrames() - 15);
                        gameRender.upScore(GameRenderer.getScore() * (1 - GameRenderer.getTimer()));
                        if (GameRenderer.getScore() == 0) {
                            gameRender.upScore(1);
                        }
                        GameRenderer.setTimer(0);
                        new Effects("C:\\Users\\jean_\\IdeaProjects\\computacaoGrafica\\src\\miniGame\\music\\gainScore.wav");
                        gameRender.createListAndPosition();

                    } else if (selected != gameRender.getResultPosition()) {
                        gameRender.downlife();
                        GameRenderer.setTimer(0);
                        new Effects("C:\\Users\\jean_\\IdeaProjects\\computacaoGrafica\\src\\miniGame\\music\\loseScore.wav");
                        gameRender.createListAndPosition();
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

        animator.start();
        animatorGame.start();

        menuCanvas.addGLEventListener(menuRender);
        scoreCanvas.addGLEventListener(scoreRender);
        gameCanvas.addGLEventListener(gameRender);


    }




}