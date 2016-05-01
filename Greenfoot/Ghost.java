import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * pl
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    private boolean left;
    private boolean right;
    private int setImage=1;
    private int moveCounter=0;
    public boolean playerDie;
    private boolean eatable;
    private int ID;
    private String image;
    
    private boolean out;
    public boolean dead;
    private int counterExit=0;
    private int redCounter=0;
    private boolean up;
    private boolean down;
    
    public int getID(){
        return ID;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public String getImageString(){
        return image;
    }
    
    public void setImageString(String image){
        this.image = image;
    }
    
    public void setGhostImage(){
       setImage(new GreenfootImage(getImageString()));
    }
    
    public void act() 
    {
        
        if(getWorld().getClass().toString().equals("class MenuWorld")) {
            motionSet();
        } else {
            if(!getWorld().getObjects(Ready.class).isEmpty()) {
                switch(ID) {
                    case 1: setLocation(335,320); setImage(new GreenfootImage("Ghost1.png"));
                    break;
                    case 2: setLocation(395,320); setImage(new GreenfootImage("Ghost2.png"));
                    break;
                    case 3: setLocation(365,350); setImage(new GreenfootImage("Ghost3.png"));
                    break;
                    case 4: setLocation(335,380); setImage(new GreenfootImage("Ghost4.png"));
                    break;
                    case 5: setLocation(395,380); setImage(new GreenfootImage("Ghost5.png"));
                    break;
                }
                playerDie=false; setRotation(0); out=false; dead=false; eatable=false; redCounter=0; counterExit=0; moveCounter=0; setImage=1;
                for( Object obj: getWorld().getObjects(Player.class)){
            Player player = (Player) obj;
            player.setPacManState(player.getAliveState());
            
        }
            }
            
            if(getWorld().getObjects(Menu.class).isEmpty() && getWorld().getObjects(Ready.class).isEmpty()) {
                if(!playerDie) {
                    eatenPill(); dangerCount();
                    if(!counterExit()) {
                        if(!eatable) {
                            begin();
                        }
                        else {
                            dangerSettings();
                        }
                    }
                    else if(!out) {
                        moveOut();
                    }
                    else if(!dead) {
                        moveSet();
                    }
                    else {
                        deadMoveAI(); move();
                    }
                    port(); 
                }
            }
        }
    }
    
    private void eatenPill(){
        for( Object obj: getWorld().getObjects(Food1.class)){
            Food1 food = (Food1) obj;
            if(food.containsPlayer()) {
                eatable = true;
                redCounter = 2;
            }
            
        }
    }
    
    private void motionSet()
    {
        int x=getX(); int y=getY();
        if(y==345) {
            left=true; right=false;
        }
        if(y==475) {
            left=false; right=true;
        }
        if(x==0 && y==345) setLocation(3,475);
        if(x==331 && y==475) setLocation(644, 345);
        motionMove(); motionImage();
    }
    private void motionMove()
    {
        if(left) setLocation(getX()-2,getY());
        else if(right) setLocation(getX()+2,getY());
    }
    private void motionImage()
    {
        int y=getY();
        if(moveCounter==10) {
            if(y==345) {
                if(setImage==1) {
                    setImage(getGhostSubimage("L2")); setImage=2;
                }
                else {
                    setImage(getGhostSubimage("L")); setImage=1;
                }
            }
            if(y==475) {
                if(setImage==1) {
                    setImage(new GreenfootImage("GhostEatable.png")); setImage=2;
                }
                else {
                    setImage(new GreenfootImage("GhostEatable3.png")); setImage=1;
                }
            }
            moveCounter=0;
        }
        else moveCounter=moveCounter+1;
    }
    
    public GreenfootImage getGhostSubimage(String subimage)
    {
        return new GreenfootImage("Ghost"+ID+subimage+".png");
    }
    
    
 
    
    private void dangerCount()
    {
        if(redCounter>0 && redCounter<1800) {
            redCounter=redCounter+2;
        }
    }

    private Food1 getCurrentFood()
    {
        for (Object obj : getWorld().getObjects(Food1.class)) {
            Food1 food = (Food1) obj;
            if (food.containsPlayer()) return food;
        }
        return null;
    }
    private Player getPlayerDeath()
    {
        for (Object obj : getWorld().getObjects(Player.class)) {
            Player p = (Player) obj;
            if (p.playerIsDead) {
                return p;
            }
        }
        return null;
    }
 
    private void begin()
    {
        if(Greenfoot.getRandomNumber(1000)>995) {
            setImage(getGhostSubimage("L"));
        }
        else if(Greenfoot.getRandomNumber(1000)>995) {
            setImage(getGhostSubimage("R"));
        }
        else if(Greenfoot.getRandomNumber(1000)>995) {
            setImage(getGhostSubimage("U"));
        }
        else if(Greenfoot.getRandomNumber(1000)>995) {
            setImage(getGhostSubimage("D"));
        }
        else if(Greenfoot.getRandomNumber(1000)>995) {
            setImage(getGhostSubimage(""));
        }
    }
    private void moveOut()
    {
        int y = getY();
        if(y==260) {
            out=true;
        }
        else {
            left=false; right=false; up=true; down=false;
            if(!eatable) {
                move();
            }
            else {
                eatableMove();
            }
        }
    }
    private void moveSet()
    {
        if(moveCounter==0) {
            if(getObjectsInRange(99, Player.class).isEmpty() ) {
                if(left) {
                    if(canMoveValues(getX(), getY()-23) && canMoveValues(getX()-22, getY()-23) && canMoveValues(getX()+22, getY()-23) && canMoveValues(getX()-6, getY()-23) && canMoveValues(getX()+6, getY()-23) && canMoveValues(getX()-12, getY()-23) && canMoveValues(getX()+12, getY()-23) && Greenfoot.getRandomNumber(1000)>800) {
                        up=true; left=false;
                    }
                    else if(canMoveValues(getX(), getY()+23) && canMoveValues(getX()-22, getY()+23) && canMoveValues(getX()+22, getY()+23) && canMoveValues(getX()-6, getY()+23) && canMoveValues(getX()+6, getY()+23) && canMoveValues(getX()-12, getY()+23) && canMoveValues(getX()+12, getY()+23) && Greenfoot.getRandomNumber(1000)>750) {
                        down=true; left=false;
                    }
                    else if(!canMoveValues(getX()-23,getY()) && Greenfoot.getRandomNumber(1000)>990) {
                        right=true; left=false;
                    }
                }
                else if(right) {
                    if(canMoveValues(getX(), getY()-23) && canMoveValues(getX()-22, getY()-23) && canMoveValues(getX()+22, getY()-23) && canMoveValues(getX()-6, getY()-23) && canMoveValues(getX()+6, getY()-23) && canMoveValues(getX()-12, getY()-23) && canMoveValues(getX()+12, getY()-23) && Greenfoot.getRandomNumber(1000)>800) {
                        up=true; right=false;
                    }
                    else if(canMoveValues(getX(), getY()+23) && canMoveValues(getX()-22, getY()+23) && canMoveValues(getX()+22, getY()+23) && canMoveValues(getX()-6, getY()+23) && canMoveValues(getX()+6, getY()+23) && canMoveValues(getX()-12, getY()+23) && canMoveValues(getX()+12, getY()+23) && Greenfoot.getRandomNumber(1000)>750) {
                        down=true; right=false;
                    }
                    else if(!canMoveValues(getX()+23,getY()) && Greenfoot.getRandomNumber(1000)>990) {
                        left=true; right=false;
                    }
                }
                else if(up) {
                    if(canMoveValues(getX()-23, getY()) && canMoveValues(getX()-23, getY()-22) && canMoveValues(getX()-23, getY()+22) && canMoveValues(getX()-23, getY()-6) && canMoveValues(getX()-23, getY()+6) && canMoveValues(getX()-23, getY()-12) && canMoveValues(getX()-23, getY()+12) && Greenfoot.getRandomNumber(1000)>800) {
                        left=true; up=false;
                    }
                    else if(canMoveValues(getX()+23, getY()) && canMoveValues(getX()+23, getY()-22) && canMoveValues(getX()+23, getY()+22) && canMoveValues(getX()+23, getY()-6) && canMoveValues(getX()+23, getY()+6) && canMoveValues(getX()+23, getY()-12) && canMoveValues(getX()+23, getY()+12) && Greenfoot.getRandomNumber(1000)>750) {
                        right=true; up=false;
                    }
                    else if(!canMoveValues(getX(),getY()-23) && Greenfoot.getRandomNumber(1000)>990) {
                        down=true; up=false;
                    }
                }
                else if(down) {
                    if(canMoveValues(getX()-23, getY()) && canMoveValues(getX()-23, getY()-22) && canMoveValues(getX()-23, getY()+22) && canMoveValues(getX()-23, getY()-6) && canMoveValues(getX()-23, getY()+6) && canMoveValues(getX()-23, getY()-12) && canMoveValues(getX()-23, getY()+12) && Greenfoot.getRandomNumber(1000)>800) {
                        left=true; down=false;
                    }
                    else if(canMoveValues(getX()+23, getY()) && canMoveValues(getX()+23, getY()-22) && canMoveValues(getX()+23, getY()+22) && canMoveValues(getX()+23, getY()-6) && canMoveValues(getX()+23, getY()+6) && canMoveValues(getX()+23, getY()-12) && canMoveValues(getX()+23, getY()+12) && Greenfoot.getRandomNumber(1000)>750) {
                        right=true; down=false;
                    }
                    else if(!canMoveValues(getX(),getY()+23) && Greenfoot.getRandomNumber(1000)>990) {
                        up=true; down=false;
                    }
                }
            }
            else followPlayerAI();
            if(!eatable) {
                move();
            }
            else {
                eatableMove();
            }
        }
        else {
            eatableMove();
        }
        
    }
    private void followPlayerAI()
    {
        int player1X = getPlayerPosition(1, "x"); int player1Y = getPlayerPosition(1, "y");
        
        int posX = getX(); int posY = getY();
        if(left) {
            if((player1X<posX ) && (player1Y==posY ) && (canMoveValues(posX-23, posY) && canMoveValues(posX-23, posY-22) && canMoveValues(posX-23, posY+22) && canMoveValues(posX-23, posY-6) && canMoveValues(posX-23, posY+6) && canMoveValues(posX-23, posY-12) && canMoveValues(posX-23, posY+12))) left=true;
            else if((player1Y<posY ) && (canMoveValues(posX, posY-23) && canMoveValues(posX-22, posY-23) && canMoveValues(posX+22, posY-23) && canMoveValues(posX-6, posY-23) && canMoveValues(posX+6, posY-23) && canMoveValues(posX-12, posY-23) && canMoveValues(posX+12, posY-23))) {
                left=false;
                if(!eatable) up=true;
                else down=true;
            }
            else if((player1Y>posY ) && (canMoveValues(posX, posY+23) && canMoveValues(posX-22, posY+23) && canMoveValues(posX+22, posY+23) && canMoveValues(posX-6, posY+23) && canMoveValues(posX+6, posY+23) && canMoveValues(posX-12, posY+23) && canMoveValues(posX+12, posY+23))) {
                left=false;
                if(!eatable) down=true;
                else up=true;
            }
            else if(!canMoveValues(posX-23, posY) && !canMoveValues(posX, posY-23)) {
                left=false;
                if(!eatable) down=true;
                else up=true;
            }
            else if(!canMoveValues(posX-23, posY) && !canMoveValues(posX, posY+23)) {
                left=false;
                if(!eatable) up=true;
                else down=true;
            }
        }
        else if(right) {
            if((player1X>posX ) && (player1Y==posY ) && (canMoveValues(posX+23, posY) && canMoveValues(posX+23, posY-22) && canMoveValues(posX+23, posY+22) && canMoveValues(posX+23, posY-6) && canMoveValues(posX+23, posY+6) && canMoveValues(posX+23, posY-12) && canMoveValues(posX+23, posY+12))) right=true;
            else if((player1Y<posY ) && (canMoveValues(posX, posY-23) && canMoveValues(posX-22, posY-23) && canMoveValues(posX+22, posY-23) && canMoveValues(posX-6, posY-23) && canMoveValues(posX+6, posY-23) && canMoveValues(posX-12, posY-23) && canMoveValues(posX+12, posY-23))) {
                right=false;
                if(!eatable) up=true;
                else down=true;
            }
            else if((player1Y>posY) && (canMoveValues(posX, posY+23) && canMoveValues(posX-22, posY+23) && canMoveValues(posX+22, posY+23) && canMoveValues(posX-6, posY+23) && canMoveValues(posX+6, posY+23) && canMoveValues(posX-12, posY+23) && canMoveValues(posX+12, posY+23))) {
                right=false;
                if(!eatable) down=true;
                else up=true;
            }
            else if(!canMoveValues(posX+23, posY) && !canMoveValues(posX, posY-23)) {
                right=false;
                if(!eatable) down=true;
                else up=true;
            }
            else if(!canMoveValues(posX+23, posY) && !canMoveValues(posX, posY+23)) {
                left=false;
                if(!eatable) up=true;
                else down=true;
            }
        }
        else if(up) {
            if((player1Y<posY ) && (player1X==posX ) && (canMoveValues(posX, posY-23) && canMoveValues(posX-22, posY-23) && canMoveValues(posX+22, posY-23) && canMoveValues(posX-6, posY-23) && canMoveValues(posX+6, posY-23) && canMoveValues(posX-12, posY-23) && canMoveValues(posX+12, posY-23))) up=true;
            else if((player1X<posX ) && (canMoveValues(posX-23, posY) && canMoveValues(posX-23, posY-22) && canMoveValues(posX-23, posY+22) && canMoveValues(posX-23, posY-6) && canMoveValues(posX-23, posY+6) && canMoveValues(posX-23, posY-12) && canMoveValues(posX-23, posY+12))) {
                up=false;
                if(!eatable) left=true;
                else right=true;
            }
            else if((player1X>posX ) && (canMoveValues(posX+23, posY) && canMoveValues(posX+23, posY-22) && canMoveValues(posX+23, posY+22) && canMoveValues(posX+23, posY-6) && canMoveValues(posX+23, posY+6) && canMoveValues(posX+23, posY-12) && canMoveValues(posX+23, posY+12))) {
                up=false;
                if(!eatable) right=true;
                else left=true;
            }
            else if(!canMoveValues(posX, posY-23) && !canMoveValues(posX-23, posY)) {
                up=false;
                if(!eatable) right=true;
                else left=true;
            }
            else if(!canMoveValues(posX, posY-23) && !canMoveValues(posX+23, posY)) {
                up=false;
                if(!eatable) left=true;
                else right=true;
            }
        }
        else if(down) {
            if((player1Y>posY ) && (player1X==posX ) && (canMoveValues(getX(), getY()+23) && canMoveValues(getX()-22, getY()+23) && canMoveValues(getX()+22, getY()+23) && canMoveValues(getX()-6, getY()+23) && canMoveValues(getX()+6, getY()+23) && canMoveValues(getX()-12, getY()+23) && canMoveValues(getX()+12, getY()+23))) down=true;
            else if((player1X<posX ) && (canMoveValues(posX-23, posY) && canMoveValues(posX-23, posY-22) && canMoveValues(posX-23, posY+22) && canMoveValues(posX-23, posY-6) && canMoveValues(posX-23, posY+6) && canMoveValues(posX-23, posY-12) && canMoveValues(posX-23, posY+12))) {
                down=false;
                if(!eatable) left=true;
                else right=true;
            }
            else if((player1X>posX ) && (canMoveValues(posX+23, posY) && canMoveValues(posX+23, posY-22) && canMoveValues(posX+23, posY+22) && canMoveValues(posX+23, posY-6) && canMoveValues(posX+23, posY+6) && canMoveValues(posX+23, posY-12) && canMoveValues(posX+23, posY+12))) {
                down=false;
                if(!eatable) right=true;
                else left=true;
            }
            else if(!canMoveValues(posX, posY+23) && !canMoveValues(posX-23, posY)) {
                up=false;
                if(!eatable) right=true;
                else left=true;
            }
            else if(!canMoveValues(posX, posY+23) && !canMoveValues(posX+23, posY)) {
                up=false;
                if(!eatable) left=true;
                else right=true;
            }
        }
    }
    private void move()
    {
        if(up && !out) {
            setLocation(getX(),getY()-1); setImage(getGhostSubimage("U")); setRotation(0);
        }
        else if(left && canMoveValues(getX()-23, getY()) && canMoveValues(getX()-23, getY()-12) && canMoveValues(getX()-23, getY()+12)) {
            setLocation(getX()-1,getY());
            if(!dead) {
                setImage(new GreenfootImage(getGhostSubimage("L")));
            }
            else {
                setImage(new GreenfootImage("GhostDead1.png")); setRotation(180);
            }
        }
        else if (right && canMoveValues(getX()+23, getY()) && canMoveValues(getX()+23, getY()-12) && canMoveValues(getX()+23, getY()+12)) {
            setLocation(getX()+1,getY());
            if(!dead) {
                setImage(new GreenfootImage(getGhostSubimage("R")));
            }
            else {
                setImage(new GreenfootImage("GhostDead1.png")); setRotation(0);
            }
        }
        else if(up && canMoveValues(getX(), getY()-23) && canMoveValues(getX()-12, getY()-23) && canMoveValues(getX()+12, getY()-23)) {
            setLocation(getX(),getY()-1);
            if(!dead) {
                setImage(new GreenfootImage(getGhostSubimage("U")));
            }
            else {
                setImage(new GreenfootImage("GhostDead2.png")); setRotation(0);
            }
        }
        else if(down && canMoveValues(getX(), getY()+23) && canMoveValues(getX()-12, getY()+23) && canMoveValues(getX()+12, getY()+23)) {
            setLocation(getX(),getY()+1);
            if(!dead) {
                setImage(new GreenfootImage(getGhostSubimage("D")));
            }
            else {
                setImage(new GreenfootImage("GhostDead2.png")); setRotation(180);
            }
        }
        else if(down && dead && !canMoveValues(getX(),getY()+23)) {
            setLocation(getX(),getY()+1); setImage(new GreenfootImage("GhostDead2.png")); setRotation(180);
        }
    }
    private void eatableMove()
    {
        if(moveCounter==1) {
            if(up && !out) {
                setLocation(getX(),getY()-1);
            }
            else if(left && canMoveValues(getX()-23, getY()) && canMoveValues(getX()-23, getY()-12) && canMoveValues(getX()-23, getY()+12)) {
                setLocation(getX()-1,getY());
            }
            else if (right && canMoveValues(getX()+23, getY()) && canMoveValues(getX()+23, getY()-12) && canMoveValues(getX()+23, getY()+12)) {
                setLocation(getX()+1,getY());
            }
            else if(up && canMoveValues(getX(), getY()-23) && canMoveValues(getX()-12, getY()-23) && canMoveValues(getX()+12, getY()-23)) {
                setLocation(getX(),getY()-1);
            }
            else if(down && canMoveValues(getX(), getY()+23) && canMoveValues(getX()-12, getY()+23) && canMoveValues(getX()+12, getY()+23)) {
                setLocation(getX(),getY()+1);
            }
            moveCounter=0;
        }
        else {
            moveCounter=1;
        }
        dangerSettings();
    }
    private void dangerSettings()
    {
        if(redCounter<1300) {
            setImage(new GreenfootImage("GhostEatable.png"));
        }
        if(redCounter==1300 || redCounter==1500 || redCounter==1700) {
            setImage(new GreenfootImage("GhostEatable2.png"));
           
        }
        else if(redCounter==1400 || redCounter==1600 || redCounter==1800) {
            setImage(new GreenfootImage("GhostEatable.png"));
           
        }
        if(redCounter==1800) {
            redCounter=0; eatable=false;
            for( Object obj: getWorld().getObjects(Player.class)){
            Player player = (Player) obj;
            player.setPacManState(player.getAliveState());
            
        }
        }
        if(dead) {
            redCounter=0;
             
        }
    }
    private void deadMoveAI()
    {
        int x=getX(); int y=getY();
        if((x==650 && (y==200 || y==500)) || (x==575 && (y==290 || y==410)) || (x==515 && (y==200 || y==260 || y==440 || y==500)) || (x==470 && (y==260 || y==440)) || (x==455 && y==260) || (x==425 && (y==170 || y==530)) || (x==245 && (y==140 || y==560)) || (y==260 && (x<=515 && x>365))) {
            left=true; right=false; up=false; down=false;
        }
        else if((x==80 && (y==200 || y==500)) || (x==155 && (y==290 || y==410)) || (x==215 && (y==200 || y==260 || y==440 || y==500)) || (x==260 && (y==260 || y==440)) || (y==260 && x==275) || (x==305 && (y==170 || y==530)) || (x==365 && y==440) || (x==485 && (y==140 || y==560)) || (y==260 && (x>=215 && x<365))) {
            left=false; right=true; up=false; down=false;
        }
        else if ((y==620 && (x==80 || x==155 || x==245 || x==305 || x==425 || x==485 || x==575 || x==650)) || (y==560 && (x==80 || x==155 || x==215 || x==305 || x==425 || x==515 || x==575 || x==650)) || (y==530 && x==365) || (y==500 && (x==155 || x==260 || x==470 || x==575)) || (y==440 && (x==275 || x==455)) || (y==350 && (x==455 || x==275)) || (y==290 && (x==215 || x==515))) {
            left=false; right=false; up=true; down=false;
        }
        else if((y==80 && (x==80 || x==155 || x==245 || x==305 || x==425 || x==485 || x==575 || x== 650)) || (y==140 && (x==80 || x==155 || x==215 || x==305 || x==425 || x==515 || x==575 || x==650)) || (y==170 && x==365) || (y==200 && (x==155 || x==260 || x==470 || x==575)) || (y==260 && x==365) || (y==410 && (x==215 || x==515)) || (y==425 && x==80)) {
            left=false; right=false; up=false; down=true;
        }
        if(x==365 && y==350) {
            up=true; down=false; out=false; eatable=false; dead=false; redCounter=0; moveCounter=0; setImage=1; setImage(new GreenfootImage("Ghost1.png"));
            for( Object obj: getWorld().getObjects(Player.class)){
            Player player = (Player) obj;
            player.setPacManState(player.getAliveState());
            
        }
        }
    }
    private void port()
    {
        int x=getX(); int y=getY();
        if(x==680 && y==350) {
            setLocation(51,350); left=false; right=true;
        }
        if(x==50 && y==350) {
            setLocation(679,350); left=true; right=false;
        }
    }

    private boolean counterExit()
    {
        if(counterExit==(ID-1)*250) return true;
        counterExit=counterExit+1; return false;
    }
    private boolean canMoveValues(int X, int Y)
    {
        if(getWorld().getObjectsAt(X,Y, Wall.class).isEmpty()) return true;
        return false;
    }
    private int getPlayerPosition(int player, String axs)
    {
        int position=0;
        if(player==1) {
            for (Object obj : getWorld().getObjects(Player.class)) {
                Player a = (Player) obj;
                position = a.getPositionValues(axs);
            }
        }

        return position;
    }

}
