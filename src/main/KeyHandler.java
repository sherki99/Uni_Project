package main;

import java.awt.event.KeyListener; // the listener interface for receiving keyboard events(keystrokes)
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode(); // returns the integer keycode associated with the key in this event

        if(code == KeyEvent.VK_W) // if user press w key
        {
            upPressed = true;
        }
        if(code == KeyEvent.VK_S) // if user press s key
        {
            downPressed = true;
        }
        if(code == KeyEvent.VK_A) // if user press a key
        {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D) // if user press d key
        {
            rightPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode(); // returns the integer keycode associated with the key in this event

        if(code == KeyEvent.VK_W)
        {
            upPressed = false;
        }
        if(code == KeyEvent.VK_S)
        {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }

    }
}
