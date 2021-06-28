/*     */ package States;
/*     */ 
/*     */ import Entities.ExitDoor;
/*     */ import Entities.Guard;
/*     */ import Entities.Orb;
/*     */ import Entities.Player;
/*     */ import Main.Handler;
/*     */ import Worlds.World;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Level4
/*     */   extends State
/*     */ {
/*     */   public World world;
/*     */   public Player player;
/*  22 */   public ArrayList<Guard> guards = new ArrayList<>();
/*     */   
/*  24 */   public ArrayList<Orb> orbs = new ArrayList<>();
/*     */   
/*     */   public ExitDoor exitdoor;
/*     */   
/*     */   public boolean init;
/*     */ 
/*     */   
/*     */   public Level4(Handler handler) {
/*  32 */     super(handler);
/*  33 */     this.world = new World("/Levels/Level4", handler);
/*  34 */     this.player = new Player(handler, this.world.spawnx, this.world.spawny);
/*     */     
/*  36 */     this.guards.add(new Guard(handler, 64.0F, 128.0F, true));
/*  37 */     this.guards.add(new Guard(handler, 1632.0F, 32.0F, false));
/*  38 */     this.guards.add(new Guard(handler, 576.0F, 544.0F, false));
/*  39 */     this.guards.add(new Guard(handler, 704.0F, 128.0F, true));
/*  40 */     this.guards.add(new Guard(handler, 768.0F, 128.0F, true));
/*  41 */     this.guards.add(new Guard(handler, 960.0F, 224.0F, true));
/*  42 */     this.guards.add(new Guard(handler, 992.0F, 192.0F, false));
/*     */     
/*  44 */     this.orbs.add(new Orb(handler, 32.0F, 128.0F));
/*  45 */     this.orbs.add(new Orb(handler, 576.0F, 576.0F));
/*  46 */     this.orbs.add(new Orb(handler, 736.0F, 32.0F));
/*  47 */     this.orbs.add(new Orb(handler, 992.0F, 224.0F));
/*  48 */     this.orbs.add(new Orb(handler, 1248.0F, 512.0F));
/*  49 */     this.orbs.add(new Orb(handler, 1664.0F, 32.0F));
/*     */ 
/*     */     
/*  52 */     this.exitdoor = new ExitDoor(handler, 1760.0F, 576.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/*  57 */     if (!World.gameOver) {
/*     */       
/*  59 */       this.world.tick();
/*  60 */       for (Orb o : this.orbs)
/*     */       {
/*  62 */         o.tick();
/*     */       }
/*  64 */       for (Guard gd : this.guards)
/*     */       {
/*  66 */         gd.tick();
/*     */       }
/*  68 */       this.exitdoor.tick();
/*  69 */       this.player.tick();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Graphics g) {
/*  75 */     this.world.render(g);
/*  76 */     for (Orb o : this.orbs)
/*     */     {
/*  78 */       o.render(g);
/*     */     }
/*  80 */     for (Guard gd : this.guards)
/*     */     {
/*  82 */       gd.render(g);
/*     */     }
/*  84 */     this.exitdoor.render(g);
/*  85 */     this.player.render(g);
/*  86 */     g.setColor(Color.yellow);
/*  87 */     g.setFont(new Font("Arial Black", 15, 15));
/*  88 */     g.drawString("Life - " + Player.life, 570, 25);
/*  89 */     g.drawString("Orbs needed - " + (this.world.orbsPresent - Player.orbsCollected), 10, 25);
/*  90 */     if (World.gameOver) {
/*     */       
/*  92 */       g.setFont(new Font("Algerian", 30, 30));
/*  93 */       g.setColor(Color.white);
/*  94 */       g.drawString("GAME OVER!", 250, 135);
/*     */     } 
/*  96 */     g.setColor(Color.red);
/*  97 */     g.drawString("Oh i forgot to tell one thing you could restart a level", (int)(1344.0F - (this.handler.getGame().getGamecamera()).xOffset), (int)(416.0F - (this.handler.getGame().getGamecamera()).yOffset));
/*  98 */     g.drawString("by pressing backspace on your keyboard", (int)(1408.0F - (this.handler.getGame().getGamecamera()).xOffset), (int)(448.0F - (this.handler.getGame().getGamecamera()).yOffset));
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/* 103 */     this.handler.setWorld(this.world);
/* 104 */     this.handler.setPlayer(this.player);
/*     */   }
/*     */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\States\Level4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */