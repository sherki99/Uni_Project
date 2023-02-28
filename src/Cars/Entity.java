package Cars;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.Socket;
import java.nio.Buffer;

public class Entity { // this stores varibles that will be used in carClas, monedd.. ,..


    public int x, y;
 //   int carX  = 100; // variables need for changing position of the car
   // int carY  = 100;
//    int carSpeed = 4; // the car is speed is 4, this is means 4 pixels increase about 4 pixel

    public int speed;

    public BufferedImage cur_image, up_1, up_2, up_3, up_4, up_5 , up_6, up_7, up_8, up_9, up_10 , up_11, up_12, up_13, up_14, up_15;
//bufferimage ift describe an image with an accessibile buffer of image data(I use this to store my image files)


    public int spriteCounter = 0;
    public int spriteNum = 1;

    public int direction;
    public Rectangle solidArea; // with this class can create an invesible or abstract rectangle, we can store day such as x,y width and height
    public boolean collisionOn = false;

   // private ClientSideConnection csc;

    public Socket socket;

    public int playerID;
}
