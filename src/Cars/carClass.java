package Cars;


import main.DataPanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.*;

public class carClass extends  Entity {


    // import keyandler and dataPanel
    DataPanel dt;
    KeyHandler keyH;


    public carClass(DataPanel dt, KeyHandler keyH) {
       // connectToServer();
        this.dt = dt;
        this.keyH = keyH;


        //collision area for the cars
        solidArea = new Rectangle(); // instaniate solid area, which is need for the collision detection
        solidArea.x = 5; // solid area  start 5 from the image of the car
        solidArea.width = 45; // shape of the solid area
        solidArea.height = 45; // shape of the solid area


        setDefaultValues();
        getCarImage();
    }

    //public
    public void setDefaultValues() // inside I set the car default values
    {
        x = 150;
        y = 200;
        speed = 0; // default speed
        direction = 1;
    }

    public void getCarImage() {

        try {

            up_1 = ImageIO.read(new FileInputStream("res/ferrari/1.png"));
            up_2 = ImageIO.read(new FileInputStream("res/ferrari/2.png"));
            up_3 = ImageIO.read(new FileInputStream("res/ferrari/3.png"));
            up_4 = ImageIO.read(new FileInputStream("res/ferrari/4.png"));
            up_5 = ImageIO.read(new FileInputStream("res/ferrari/5.png"));
            up_6 = ImageIO.read(new FileInputStream("res/ferrari/6.png"));
            up_7 = ImageIO.read(new FileInputStream("res/ferrari/7.png"));

            up_8 = ImageIO.read(new FileInputStream("res/ferrari/8.png"));


            up_9 = ImageIO.read(new FileInputStream("res/ferrari/9.png"));
            up_10 = ImageIO.read(new FileInputStream("res/ferrari/10.png"));
            up_11 = ImageIO.read(new FileInputStream("res/ferrari/11.png"));
            up_12 = ImageIO.read(new FileInputStream("res/ferrari/12.png"));
            up_13 = ImageIO.read(new FileInputStream("res/ferrari/13.png"));
            up_14 = ImageIO.read(new FileInputStream("res/ferrari/14.png"));
            up_15 = ImageIO.read(new FileInputStream("res/ferrari/15.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void update() {


        // check collision
        collisionOn = false;
        dt.cChecker.checkTile(this);


        if (collisionOn == true) {

            //System.out.println("you hit");
            setDefaultValues();
           // direction = 1;

        } else {

            if (keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed == true) {
                //now the spritecounter increase only when  we press on of this key
                // remember in java the upder left corner is x:0 y:0
                // x values increase to the right, y values increases as they go down
                if (keyH.upPressed == true)  // if upPressed is true the car is going diritto  // the key input is cathced by keyHandler
                {

                    if (speed <= 10) {
                        speed += 1;
                    }

                } else if (keyH.downPressed == true) {

                    if (speed >= 1) {
                        speed -= 1;
                    }

                    //  y += speed;
                } else if (keyH.rightPressed == true) {

                    direction += 1;
                } else if (keyH.leftPressed == true) {
                    direction -= 1;
                }

            }

        }

        collisionOn = false;



        spriteNum++;  // every frame this get called and increase the counter by 1 and if hits 10 the sprite changes one to 1 or two to 1 // cosi che posso avere
        // leffeto del personaggio che cammina nel video gioco del video su yuotube // pesno che questo non centra con la rotazine

        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {

                spriteNum = 1;
            }

        }
    }


    public void draw(Graphics2D g2)
    {

        BufferedImage image = null;



        switch (direction) // check the direction
        {
            case 1: // default value
                image = up_1;
                y =  y - 1 * speed;

                break;
            case 2:
                image = up_2;
                x  = x + 1 * speed;
                y = y - 1 * speed;

                break;
            case 3:
                image = up_3;
                x = x + 1 * speed;
                break;
            case 4:
                image = up_4;
                x = x + 1 * speed;
                break;
            case 5:
                image = up_5;
                x  = x + 1 * speed;
              //  y = y - 1 * speed;
                break;
            case 6:
                image = up_6;
                y = y + 1 * speed;
                break;
            case 7:
                image = up_7;
                y = y + 1 * speed;
                break;
            case 8:
                image = up_8;
                y = y - 1 * speed;
                break;
            case 9:
                y  = y + 1 * speed;
                image = up_9;
                break;

            case 15:
                y  = y + 1 * speed;
                image = up_15;
                break;
            case 14:
                y = y - 1 * speed;
                image = up_14;
                break;
            case 13:
                x  = x - 1 * speed;
                image = up_13;
                break;
            case 12:
                x  = x - 1 * speed;
                image = up_12;
                break;
            case 11:
                x  = x - 1 * speed;
                image = up_11;
                break;
            case 10:
                x  = x - 1 * speed;
                image = up_10;
                break;

            case 16:
                image = up_1;
                direction = 1;

                break;
            case 0:
                direction = 15;
                image = up_15;
                break;


                // throw new IllegalStateException("Unexpected value: " + direction);
        }

        g2.drawImage(image, x, y, dt.tileSize, dt.tileSize, null); // draw an image on the screen; tilesize is weight and hidth // x,y szie of image

    }

    public int[] getPosition() {

        int[] Position = {x, y, speed, direction};
        return Position;

    }
}


