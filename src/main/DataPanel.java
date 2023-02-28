package main;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Cars.carClass;
import Track.TrackManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


// implements ActionListener
public class DataPanel extends JPanel implements Runnable {
    //class inherits JPanel implements ActionListener


    // screen setting
    final int originalTileSize = 16;
    final int scale = 3;
    final public int tileSize = 48;  // 32 x 3  96x96

    public final int maxScreenCol =  20;
    public final int maxScreenRow = 13;
    public final int screenWidth = 960;  //how many tiles can be displayed on a single screen hor and vert? this will decide the screen size  // tilesize x maxscreencoll(20)
    public  final int screenHeight = 624; // tilesize x  maxscreenrow  48 x 13    if 12 is 576



    int FPS = 10;    // FPS, I choose 60 because I think is it enough


    KeyHandler keyH = new KeyHandler(); // initialize  keyHandler

    //info// for me :  fps(frame per second) 60 means it updated the screen 60 times per second and creates an animation so I need to create time to start this game clock // we will class trhed
    // if fps 30 the program does this(Update and draw) 30 times per second
    Thread gameThread; // keeps runs until we stop the game
    // set default car position
    public carClass ferrari = new carClass(this, keyH); // instantiate carOne called ferrari // needs to be public
    public carClass mercedes = new carClass(this, keyH); // second car
    TrackManager track = new TrackManager(this);

    public Collision cChecker = new Collision(this);




    public DataPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);// so this DataPanel can recognize key input and also we add one more line
        this.setFocusable(true); // with this,this datapanel can be focused to receive key input.
    }

    public void update()  // updates method updated the car coordinates
    {
        ferrari.update();
    }


    public void arena_image(Graphics g){




        // paint the track it was copied from the assignment slide
        Color c1 = Color.yellow;
        g.setColor( c1 );
        g.fillRect( 150, 200, 550, 300 ); // grass

        Color c2 = Color.black;
        g.setColor( c2 );
        g.drawRect( 50, 100, 750, 500 );  // outer edge
        g.drawRect( 150, 200, 550, 300 ); // inner edge

        Color c3 = Color.yellow;
        g.setColor( c3 );
        g.drawRect( 100, 150, 650, 400 ); // mid-lane marker

        Color c4 = Color.white;
        g.setColor( c4 );
        g.drawLine( 425, 500, 425, 600 ); // start line


    }
    public void paintComponent(Graphics g) {  // standard method used to draw things on Jpanel // graphics a class thath has many functions
        // to draw objects on the screen.

        super.paintComponent(g);

        Graphics2D  g2 =  (Graphics2D)g; // convert graphics to graphics2d, they are kind of similar, but has a bit more function.
//
        track.draw(g2);
        ferrari.draw(g2);
        mercedes.draw(g2);

        g2.dispose();  // save memory...

       // arena_image(g);


    } // pain component

    public void startGameThread()
    {
        gameThread = new Thread(this); // instanciate the thread  // this refer to this class
        gameThread.run(); // is gonna automaticaly call the run method
    }

    @Override
    public void run() {  // when I start this gameThread it autmaticlly call this run method


        double drawInterval = 1000000000/FPS; //0.016 seconde
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int DrawCount  = 0;


        while(gameThread != null)   //
        {

            currentTime = System.nanoTime(); // a the beginning of the loop we check the currentTime
            delta += (currentTime - lastTime) / drawInterval; // mean how much time has passed
            timer += (currentTime - lastTime); // we add the past time to this timer
            lastTime = currentTime;  // the lasttime became the current time

            if(delta >= 1)
            {
                // update: update information such as car position
                update();
                // draw : draw the screen with update information
                repaint();
                // if fps 30 the program does this(Update and draw) 30 times per second
                // to this update and draw I need two methods update and paintComponent
                delta--;
                DrawCount++;

            }

            if(timer >= 1000000000)
            {

                System.out.println("FPS" + DrawCount);
                DrawCount = 0;
                timer = 0;


            }


        }
    }
}

