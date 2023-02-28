package Track;

import Cars.Entity;
import main.DataPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.awt.Rectangle;

public class TrackManager extends Track {

    DataPanel dt; // creation of datapanel
    Track[] tile;  // array of track
    int mapTileNum[][];


    public  TrackManager(DataPanel dt) // constructor
    {
        this.dt = dt; // invocation of datapanel

        tile = new Track[10]; // I am creating 10 component of the track as tile

        mapTileNum = new int[dt.screenWidth][dt.screenHeight]; // variabile needed for storing the value from map01.txt

        //r1 = new Rectangle(0, 0, 960, 48);
      //  r1.setSize(Color.white);
       // r2 = new Rectangle(0,0, 96, 624);
       // r3 = new Rectangle(0,576, 48, 960);
        getTileImage();
        //loadMap();

    }

    public void getTileImage()
    {
        try
        {
            // creation of bufferImage for the track
            tile[0] =  new Track();
            tile[0].image = ImageIO.read(new FileInputStream("res/track/Grass_Tile.png"));
            tile[0].collision =  true;
           // collision = true;

            tile[1] =  new Track();
            tile[1].image = ImageIO.read(new FileInputStream("res/track/Soil_Tile.png"));

            tile[2] =  new Track();
            tile[2].image = ImageIO.read(new FileInputStream("res/track/Water_Tile.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadMap(){ // this is method is important for extract the value from txt(map01.txt) file
        try
        {
            InputStream is = getClass().getResourceAsStream("src/Track/map01.txt"); // inputstream is used to import this text file
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); //  BuffereReader to read the content of this text file

            int col = 0; //
            int row = 0;

            while(col < dt.maxScreenCol && row < dt.maxScreenRow)
            {
                String line = br.readLine(); // read a line of text// single line // get data as string

                while(col < dt.maxScreenCol)
                {
                    String numbers[] =  line.split(" ");
                    int num = Integer.parseInt(numbers[col]) ;// use col a san index for numbers array

                    mapTileNum[col][row] = num; // store all the number from map01.text int maptilenum
                    col++;
                }
                if(col == dt.maxScreenCol)
                {

                    col = 0;
                    row++;

                }
            }
            br.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {

        int x = 0;
        int y = 0;


        while (x <= dt.screenWidth) {


            y = 0;
            while(y <= dt.screenHeight)
            {
                if(y < 48  || y > 528 && y <= dt.screenHeight){
                    g.drawImage(tile[0].image, x, y, dt.tileSize, dt.tileSize, null);
                }
                y += 48;
            }
            g.drawImage(tile[0].image, x, y, dt.tileSize, dt.tileSize, null);
            x += 48;


        }

        y = 0;
        while(y < dt.screenHeight)
        {
            x = 0;
            while(x <= dt.screenWidth)
            {
                if(x < 96 || x > 816 && x <= dt.screenWidth)
                {
                    g.drawImage(tile[0].image, x,y, dt.tileSize,dt.tileSize,null);
                }
                x += 48;
            }
            g.drawImage(tile[0].image, x, y, dt.tileSize, dt.tileSize, null);
            y += 48;

        }






        Color c1 = Color.getHSBColor(139, 81,34 );
        g.setColor( c1 );
        g.fillRect( 200, 150, 550, 300 ); // grass

        Color c2 = Color.black;
        g.setColor( c2 );
     //   g.drawRect( 100, 50, 750, 500 );  // outer edge
       // g.drawRect( 200, 150, 550, 300 ); // inner edge

        Color c3 = Color.darkGray;
        g.setColor( c3 );
        g.drawRect( 150, 100, 650, 400 ); // mid-lane marker

        Color c4 = Color.white;
        g.setColor( c4 );
        g.drawLine( 475, 450, 475, 550 ); // start line



    }
}





