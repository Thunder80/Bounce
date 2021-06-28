/*     */ package States;
/*     */ 
/*     */ import Entities.ExitDoor;
/*     */ import Entities.Gate;
/*     */ import Entities.Guard;
/*     */ import Entities.Orb;
/*     */ import Entities.Player;
/*     */ import Entities.Rock;
/*     */ import Entities.Switch;
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
/*     */ 
/*     */ 
/*     */ public class Level5
/*     */   extends State
/*     */ {
/*     */   Player player;
/*     */   public World world;
/*     */   public ExitDoor exitdoor;
/*  28 */   public ArrayList<Rock> rocks = new ArrayList<>();
/*  29 */   public ArrayList<Gate> gates = new ArrayList<>();
/*  30 */   public ArrayList<Switch> switch1 = new ArrayList<>();
/*  31 */   public ArrayList<Orb> orbs = new ArrayList<>();
/*     */ 
/*     */   
/*     */   boolean init;
/*     */   
/*  36 */   ArrayList<Guard> guards = new ArrayList<>();
/*     */   
/*     */   public Level5(Handler handler) {
/*  39 */     super(handler);
/*  40 */     this.world = new World("/Levels/Level5", handler);
/*  41 */     this.player = new Player(handler, this.world.spawnx, this.world.spawny);
/*  42 */     this.exitdoor = new ExitDoor(handler, 64.0F, 576.0F);
/*     */     
/*  44 */     for (int y = 0; y < this.world.height; y++) {
/*     */       
/*  46 */       for (int x = 0; x < this.world.width; x++) {
/*     */         
/*  48 */         if (this.world.map[x][y] == 3)
/*  49 */           this.orbs.add(new Orb(handler, (32 * x), (32 * y))); 
/*  50 */         if (this.world.map[x][y] == 4)
/*  51 */           this.guards.add(new Guard(handler, (32 * x), (32 * y), false)); 
/*  52 */         if (this.world.map[x][y] == 8)
/*  53 */           this.rocks.add(new Rock(handler, (32 * x), (32 * y))); 
/*  54 */         if (this.world.map[x][y] == 7)
/*  55 */           this.switch1.add(new Switch(handler, (32 * x), (32 * y), true, this.rocks)); 
/*  56 */         if (this.world.map[x][y] == 6) {
/*  57 */           this.gates.add(new Gate(handler, (32 * x), (32 * y), true, this.rocks));
/*     */         }
/*     */       } 
/*     */     } 
/*  61 */     ((Gate)this.gates.get(0)).setSwitch(this.switch1.get(0));
/*  62 */     ((Gate)this.gates.get(1)).setSwitch(this.switch1.get(0));
/*  63 */     ((Gate)this.gates.get(2)).setSwitch(this.switch1.get(4));
/*  64 */     ((Gate)this.gates.get(3)).setSwitch(this.switch1.get(2));
/*  65 */     ((Gate)this.gates.get(4)).setSwitch(this.switch1.get(1));
/*  66 */     ((Gate)this.gates.get(5)).setSwitch(this.switch1.get(3));
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/*  71 */     if (!World.gameOver && !World.victory) {
/*     */       
/*  73 */       this.world.tick();
/*  74 */       this.exitdoor.tick();
/*  75 */       for (Gate ga : this.gates)
/*  76 */         ga.tick(); 
/*  77 */       for (Switch s : this.switch1)
/*  78 */         s.tick(); 
/*  79 */       for (Guard gu : this.guards)
/*  80 */         gu.tick(); 
/*  81 */       for (Orb o : this.orbs)
/*  82 */         o.tick(); 
/*  83 */       this.player.tick();
/*  84 */       for (Rock r : this.rocks) {
/*  85 */         r.tick();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Graphics g) {
/*  92 */     this.world.render(g);
/*  93 */     this.exitdoor.render(g);
/*  94 */     for (Gate ga : this.gates)
/*  95 */       ga.render(g); 
/*  96 */     for (Switch s : this.switch1)
/*  97 */       s.render(g); 
/*  98 */     for (Guard gu : this.guards)
/*  99 */       gu.render(g); 
/* 100 */     for (Orb o : this.orbs)
/* 101 */       o.render(g); 
/* 102 */     this.player.render(g);
/* 103 */     for (Rock r : this.rocks) {
/* 104 */       r.render(g);
/*     */     }
/* 106 */     g.setColor(Color.yellow);
/* 107 */     g.setFont(new Font("Arial Black", 15, 15));
/* 108 */     g.drawString("Life - " + Player.life, 570, 25);
/* 109 */     g.drawString("Orbs needed - " + (this.world.orbsPresent - Player.orbsCollected), 10, 25);
/* 110 */     if (World.gameOver) {
/*     */       
/* 112 */       g.setFont(new Font("Algerian", 30, 30));
/* 113 */       g.setColor(Color.white);
/* 114 */       g.drawString("GAME OVER!", 250, 135);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/* 120 */     this.handler.setWorld(this.world);
/* 121 */     this.handler.setPlayer(this.player);
/* 122 */     this.init = true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\States\Level5.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */