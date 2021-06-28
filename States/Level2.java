/*    */ package States;
/*    */ 
/*    */ import Entities.ExitDoor;
/*    */ import Entities.Guard;
/*    */ import Entities.Orb;
/*    */ import Entities.Player;
/*    */ import Main.Handler;
/*    */ import Worlds.World;
/*    */ import gfx.Assets;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Level2
/*    */   extends State
/*    */ {
/*    */   public Player player;
/*    */   public World world;
/*    */   public Orb orbs;
/*    */   public Guard guards;
/*    */   public ExitDoor exitdoor;
/*    */   boolean init;
/*    */   
/*    */   public Level2(Handler handler) {
/* 30 */     super(handler);
/* 31 */     this.world = new World("/Levels/Level2", handler);
/* 32 */     this.player = new Player(handler, this.world.spawnx, this.world.spawny);
/* 33 */     this.orbs = new Orb(handler, 352.0F, 128.0F);
/* 34 */     this.guards = new Guard(handler, 320.0F, 128.0F, true);
/* 35 */     this.exitdoor = new ExitDoor(handler, 768.0F, 256.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 40 */     this.world.tick();
/* 41 */     this.exitdoor.tick();
/* 42 */     this.player.tick();
/* 43 */     this.orbs.tick();
/* 44 */     this.guards.tick();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 49 */     int xo = (int)(this.handler.getGame().getGamecamera()).xOffset;
/* 50 */     int yo = (int)(this.handler.getGame().getGamecamera()).yOffset;
/* 51 */     this.world.render(g);
/* 52 */     this.exitdoor.render(g);
/* 53 */     this.player.render(g);
/* 54 */     this.orbs.render(g);
/* 55 */     this.guards.render(g);
/*    */     
/* 57 */     g.setColor(new Color(238, 36, 27));
/* 58 */     g.drawString("This is a guard DONT COLLIDE WITH IT!!!", 256 - xo, 128 - yo);
/*    */     
/* 60 */     g.drawImage(Assets.arrow, 320 - xo, 224 - yo, 32, 32, null);
/* 61 */     g.drawString("These are spikes.Stay away fram this also.", 352 - xo, 256 - yo - 16);
/* 62 */     g.drawString("These are the things u need to know to play the game", 640 - xo - 16, 192 - yo - 16);
/* 63 */     g.drawString("Best of luck!!!", 736 - xo, 224 - yo);
/*    */   }
/*    */   
/*    */   public void init() {
/* 67 */     this.handler.setWorld(this.world);
/* 68 */     this.handler.setPlayer(this.player);
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\States\Level2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */