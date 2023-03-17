package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

public class KeyHandler implements KeyListener {
    public boolean upPressed, leftPressed, rightPressed,victory;
    public boolean jumpLock = false;
    public boolean gravity;
    public int count = 0;
    public Date date = new Date();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W && !jumpLock) {
            Date date1 = new Date();
            long mss = date1.getTime() - date.getTime();
            date = date1;
            if (mss > 240) {
                count++;
                upPressed = true;

                if (count > 1) {
                    jumpLock = true;
                    gravity = true;
                }
            }
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
            upPressed = false;
            rightPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
            leftPressed = false;
            upPressed = false;
        }

        if (code == KeyEvent.VK_Q) {
            victory = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
            jumpLock = false;
            count = 0;
            gravity = true;


        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}