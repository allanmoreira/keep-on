package br.com.moreirallan.keepon;

import java.awt.*;
import java.time.LocalTime;

public class KeepOn {

    public static void moveMouse(int minutes, int seconds) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        int delay = minutes*60000 + seconds*1000;
        int radius = 100;
        PointerInfo pointerA = MouseInfo.getPointerInfo();
        Point a = pointerA.getLocation();
        System.out.println("Start at " + LocalTime.now());
        while(true){
            Thread.sleep(delay);
            System.out.println("Moving at " + LocalTime.now());
            for (double i = 0; i < (2 * Math.PI) + Math.PI / 6; i = i + Math.PI / 6) {
                int yStart = (int) a.getY();
                int xStart = (int) a.getX();
                robot.mouseMove((int) ((xStart) + (radius * Math.cos(i))), (int) ((yStart) + (radius * Math.sin(i))));
                robot.delay(100);
            }
        }
    }

    public static void mouseInfo(){
        Point pObj = MouseInfo.getPointerInfo().getLocation();
        System.out.println(pObj.toString() + "x: " + pObj.x + " y: " + pObj.y);
    }
}
