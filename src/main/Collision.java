package main;


import Cars.Entity;
import Track.TrackManager;

public class Collision {  // class used to check the collision


    DataPanel dt;  //

    TrackManager track;
    public Collision(DataPanel dt)
    {
        this.dt = dt;
    }

    public void  checkTile(Entity entity)  // check if the player is hitting solid tile or not
    {
        // get x and y of the car solid area
        //left x and right x, top y and bottom y
        //coordinates
      //  int entityLeftX = entity.x + entity.solidArea.x;
       // int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
       // int entityTopX =  entity.y  + entity.solidArea.y;
       // int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;

        // then base on these coordinates, we will fin out theri column and row numbers
        int entityX = entity.x;
        int entityY = entity.y;

        int r1x = 96;
        int r2x = 864; // 960 - 96(2 x 48)
        int r1y = 48;
        int r2y = 576; //  624- 48 = 576
        //int r2y =
   //     System.out.println(r1x);


        if(entityX <= r1x ||entityX >= r2x && entityY>= r2y || entityY <= r1y)
        {
            entity.collisionOn = true;
        }



        r1x = 800;
        r2x = 864;

        if(entityX >= r1x || entityY >= r2y){
            entity.collisionOn = true;
        }

        r1x = 200;
        r2x = 750;
        r1y = 150;
        r2y = 450;


        if(entityX >= r1x && entityX <= r2x && entityY >= r1y && entityY <= r2y){
            //System.out.println("sei dentro");
            entity.collisionOn = true;

        }






    }


}
