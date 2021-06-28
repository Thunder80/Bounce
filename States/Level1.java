/*    */ package States;
/*    */ 
/*    */ import Entities.Cannon;
/*    */ import Entities.ExitDoor;
/*    */ import Entities.Orb;
/*    */ import Entities.Player;
/*    */ import Main.Handler;
/*    */ import Worlds.World;
/*    */ import gfx.Assets;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Level1
/*    */   extends State
/*    */ {
/*    */   public World world;
/*    */   public Player player;
/*    */   public Orb orbs;
/*    */   public ExitDoor exitdoor;
/*    */   public Cannon cannon;
/*    */   
/*    */   public Level1(Handler handler) {
/* 28 */     super(handler);
/* 29 */     this.world = new World("/Levels/Level1", handler);
/* 30 */     handler.setWorld(this.world);
/* 31 */     this.player = new Player(handler, this.world.spawnx, this.world.spawny);
/* 32 */     handler.setPlayer(this.player);
/* 33 */     this.exitdoor = new ExitDoor(handler, 416.0F, 256.0F);
/* 34 */     this.orbs = new Orb(handler, 768.0F, 256.0F);
/* 35 */     this.cannon = new Cannon(handler, 64.0F, 128.0F);
/* 36 */     this.exitdoor.isActivated = false;
/* 37 */     this.orbs.isActivated = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 42 */     this.world.tick();
/* 43 */     this.exitdoor.tick();
/* 44 */     this.player.tick();
/* 45 */     this.orbs.tick();
/* 46 */     this.cannon.tick();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 51 */     int xo = (int)(this.handler.getGame().getGamecamera()).xOffset;
/* 52 */     int yo = (int)(this.handler.getGame().getGamecamera()).yOffset;
/* 53 */     this.world.render(g);
/* 54 */     this.exitdoor.render(g);
/* 55 */     this.orbs.render(g);
/* 56 */     this.cannon.render(g);
/* 57 */     g.drawImage(Assets.tutorial, (int)(64.0F - (this.handler.getGame().getGamecamera()).xOffset), (int)(192.0F - (this.handler.getGame().getGamecamera()).yOffset), 96, 32, null);
/* 58 */     g.setColor(new Color(238, 36, 27));
/* 59 */     g.setFont(new Font("Arial Black", 30, 30));
/* 60 */     g.drawString("Controls", 64 - xo, 140 - yo);
/* 61 */     g.drawString("D W A", 64 - xo, 180 - yo);
/*    */ 
/*    */     
/* 64 */     g.drawImage(Assets.arrow, 416 - xo - 16, 192 - yo, 32, 32, null);
/* 65 */     g.setFont(new Font("Arial Black", 10, 10));
/* 66 */     if (!this.orbs.getisActivated()) {
/* 67 */       g.drawString("This is a closed door u hav to collect orbs to open it", 320 - xo, 192 - yo);
/*    */     } else {
/* 69 */       g.drawString("Now the door is open and u can go to the next level through this", 320 - xo, 192 - yo);
/*    */     } 
/* 71 */     g.drawImage(Assets.arrow, 768 - xo, 224 - yo, 32, 32, null);
/* 72 */     g.drawString("This is an orb come here to activate it", 704 - xo, 224 - yo);
/* 73 */     g.drawString("You can shoot a bullet with spacebar to move the rocks you will face in future levels.Remember this.", 256 - xo, 64 - yo);
/* 74 */     g.drawString("And you cannot shoot another bullet till one bullet hits a wall.", 352 - xo, 96 - yo);
/* 75 */     this.player.render(g);
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\States\Level1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */