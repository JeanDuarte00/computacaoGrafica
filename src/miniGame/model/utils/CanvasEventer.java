package miniGame.model.utils;

import miniGame.controller.MenuRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CanvasEventer {


    public void canvasMouseMoved(MenuRenderer renderer, Canvas canvas) {

        canvas.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Point p= e.getPoint();

                p.y=(p.y-700)*-1;

                if(p.x<150&&p.x>50){
                    if(p.y<650&&p.y>550){
                        //rotate0
                        renderer.setRotate(0);
                    }else{
                        renderer.disableRotate(0);
                    }
                    if(p.y<150&&p.y>50){
                        renderer.setRotate(3);
                    }else{
                        renderer.disableRotate(3);
                    }
                }else{
                    renderer.disableRotate(0);
                    renderer.disableRotate(3);
                }
                if(p.x<750&&p.x>650){
                    if(p.y<650&&p.y>550){
                        renderer.setRotate(2);
                    }else{
                        renderer.disableRotate(2);
                    }
                    if(p.y<150&&p.y>50){
                        renderer.setRotate(1);
                    }else{
                        renderer.disableRotate(1);
                    }
                }else{
                    renderer.disableRotate(1);
                    renderer.disableRotate(2);
                }

                if(p.x<650&&p.x>150){
                    if(p.y<500&&p.y>400){
                        renderer.focusMenu(0);
                    }else{
                        renderer.notFocus(0);
                    }

                    if(p.y<350&&p.y>250){
                        renderer.focusMenu(1);
                    }else{
                        renderer.notFocus(1);
                    }

                    if(p.y<200&&p.y>100){
                        renderer.focusMenu(2);
                    }else{
                        renderer.notFocus(2);
                    }
                }else{
                    renderer.notFocus(0);
                    renderer.notFocus(1);
                    renderer.notFocus(2);
                }


            }
        });

    }

}
