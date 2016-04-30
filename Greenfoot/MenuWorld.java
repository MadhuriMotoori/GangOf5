import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{
    GreenfootSound begin = new GreenfootSound("begin-sound.mp3");
    public boolean muteS;
    public boolean musicS;
    private Buttons buttonPlayer1;
    private Buttons buttonPlayer2;
    private Buttons buttonAbout;
    private Buttons buttonHelp;
    
    private PlayCommand playCmd;
    private HelpCommand helpCmd;
    private AboutCommand aboutCommand;
    private normalStrategyCommand nrmlCmd;
    /**
     * Constructor for objects of class Pacman.
     * 
     */
    public MenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(731, 701, 1); 
        setPaintOrder(ButtonsOverlay.class, Menu.class, Buttons.class, Cover.class,Wall.class,Ghost.class,Player.class,Food.class);
        setActOrder(Player.class,Food.class,Ghost.class);
        prepare();
        Greenfoot.setSpeed(50); Greenfoot.start();
    }
    
    public void prepare()
    {
        
        addObject(new Cover(), 365, 350);
        buttonPlayer1 = new Buttons(1);
        playCmd = new PlayCommand();
        addObject(buttonPlayer1, 560, 290); 
        buttonPlayer2 = new Buttons(2);
        addObject(buttonPlayer2, 560, 377); 
        buttonAbout = new Buttons(3);
        addObject(buttonAbout, 528, 455); 
        buttonHelp = new Buttons(4);
        helpCmd = new HelpCommand();
        addObject(buttonHelp, 558, 543);
       
        helpCmd = new HelpCommand();
        aboutCommand = new AboutCommand();
        nrmlCmd = new normalStrategyCommand();
        
        buttonPlayer1.setCommand(playCmd);
        buttonHelp.setCommand(helpCmd);
        buttonAbout.setCommand(aboutCommand);
        buttonPlayer2.setCommand(nrmlCmd);
            
        for (int i=0; i<25; i++){
            Wall w = new Wall();
            w.getImage().scale(20, 20);
            addObject(w,i*15 , 410);
        }
        
        addObject(new Player(), 375, 345); 
        GhostFactory ghostFactory = new GhostFactory();
        
        addObject(ghostFactory.makeGhost(1), 420, 345);
        addObject(ghostFactory.makeGhost(2), 465, 345); 
        addObject(ghostFactory.makeGhost(3), 510, 345);
        addObject(ghostFactory.makeGhost(4), 555, 345); 
        addObject(ghostFactory.makeGhost(5), 600, 345);
        //addObject(
        Buttons mute = new Buttons(6); if(muteS) mute.setImage("mute button 2.png"); else mute.setImage("mute button 1.png"); mute.getImage().scale(30,30);
        Buttons music = new Buttons(5); if(musicS) music.setImage("music button 2.png"); else music.setImage("music button 1.png"); music.getImage().scale(30,30);
        addObject(mute, 465, 620); addObject(music, 510, 620); begin.setVolume(60);
        if(!musicS) begin.play();
        Greenfoot.setSpeed(50);
        setPaintOrder(ButtonsOverlay.class, Menu.class, Buttons.class, Cover.class,Wall.class,Ghost.class,Player.class,Food.class);
        setActOrder(Player.class,Food.class,Ghost.class);
        
        playCmd.setReceiver(
            new Receiver(){
                public void performAction(){
                    if(Greenfoot.mouseClicked(buttonPlayer1)){
                        System.out.println("Player1 starts to play");
                        begin.stop();
                        Greenfoot.stop();
                        Strategy strategy = new EasyStrategy();
                        Greenfoot.setWorld(strategy.getWorld());
                       
                    }
                }
            });
        
        helpCmd.setReceiver(
            new Receiver(){
                public void performAction(){
                    if(Greenfoot.mouseClicked(buttonHelp)){
                        Greenfoot.setWorld(new HelpWorld());
                    }
                   
                }
            });
            

        aboutCommand.setReceiver(
            new Receiver(){
                public void performAction(){
                    if(Greenfoot.mouseClicked(buttonAbout)){
                     Greenfoot.setWorld(new AboutWorld());
                    }
                   
                }
            });
            
            nrmlCmd.setReceiver(
            new Receiver(){
                public void performAction(){
                    if(Greenfoot.mouseClicked(buttonPlayer2)){
                     //Greenfoot.setWorld(new NormalStrategy());
                    Strategy strategy = new NormalStrategy();
                        Greenfoot.setWorld(strategy.getWorld());
                    }
                   
                }
            });



    }
}


