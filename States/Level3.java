/*    */ package States;
/*    */ 
/*    */ import Entities.ExitDoor;
/*    */ import Entities.Guard;
/*    */ import Entities.Orb;
/*    */ import Entities.Player;
/*    */ import Main.Handler;
/*    */ import Worlds.World;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Level3
/*    */   extends State
/*    */ {
/*    */   private Player player;
/*    */   private World world;
/*    */   public ExitDoor exitdoor;
/* 24 */   public ArrayList<Orb> orbs = new ArrayList<>();
/*    */   
/* 26 */   public ArrayList<Guard> guards = new ArrayList<>();
/*    */   
/*    */   boolean init;
/*    */   
/*    */   public Level3(Handler handler) {
/* 31 */     super(handler);
/*    */     
/* 33 */     this.world = new World("/Levels/Level3", handler);
/* 34 */     this.player = new Player(handler, this.world.spawnx, this.world.spawny);
/* 35 */     this.exitdoor = new ExitDoor(handler, 1152.0F, 416.0F);
/*    */     
/* 37 */     this.guards.add(new Guard(handler, 224.0F, 384.0F, false));
/* 38 */     this.guards.add(new Guard(handler, 544.0F, 32.0F, false));
/* 39 */     this.guards.add(new Guard(handler, 1088.0F, 128.0F, true));
/*    */     
/* 41 */     this.orbs.add(new Orb(handler, 224.0F, 416.0F));
/* 42 */     this.orbs.add(new Orb(handler, 576.0F, 32.0F));
/* 43 */     this.orbs.add(new Orb(handler, 1120.0F, 64.0F));
/* 44 */     this.orbs.add(new Orb(handler, 1216.0F, 416.0F));
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 49 */     if (!World.gameOver) {
/*    */       
/* 51 */       this.world.tick();
/* 52 */       this.player.tick();
/* 53 */       this.exitdoor.tick();
/* 54 */       for (Orb o : this.orbs)
/*    */       {
/* 56 */         o.tick();
/*    */       }
/* 58 */       for (Guard gd : this.guards)
/*    */       {
/* 60 */         gd.tick();
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 67 */     this.world.render(g);
/* 68 */     this.exitdoor.render(g);
/* 69 */     this.player.render(g);
/* 70 */     for (Guard gd : this.guards)
/*    */     {
/* 72 */       gd.render(g);
/*    */     }
/* 74 */     for (Orb o : this.orbs)
/*    */     {
/* 76 */       o.render(g);
/*    */     }
/* 78 */     g.setColor(Color.yellow);
/* 79 */     g.setFont(new Font("Arial Black", 15, 15));
/* 80 */     g.drawString("Life - " + Player.life, 570, 25);
/* 81 */     g.drawString("Orbs needed - " + (this.world.orbsPresent - Player.orbsCollected), 10, 25);
/* 82 */     if (World.gameOver) {
/*    */       
/* 84 */       g.setFont(new Font("Algerian", 30, 30));
/* 85 */       g.setColor(Color.white);
/* 86 */       g.drawString("GAME OVER!", 250, 135);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void init() {
/* 91 */     this.handler.setWorld(this.world);
/* 92 */     this.handler.setPlayer(this.player);
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\States\Level3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */