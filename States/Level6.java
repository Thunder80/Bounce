/*     */ package States;
/*     */ 
/*     */ import Entities.ExitDoor;
/*     */ import Entities.Gate;
/*     */ import Entities.Guard;
/*     */ import Entities.MovingPlatform;
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
/*     */ public class Level6
/*     */   extends State
/*     */ {
/*     */   private Player player;
/*     */   public World world;
/*     */   public ExitDoor exitdoor;
/*  28 */   public ArrayList<Rock> rocks = new ArrayList<>();
/*     */   
/*  30 */   public ArrayList<Switch> switch1 = new ArrayList<>();
/*     */   
/*  32 */   public ArrayList<MovingPlatform> platform = new ArrayList<>();
/*     */   
/*  34 */   public ArrayList<Guard> guards = new ArrayList<>();
/*     */   
/*  36 */   public ArrayList<Orb> orbs = new ArrayList<>();
/*     */   
/*  38 */   public ArrayList<Gate> gates = new ArrayList<>();
/*     */   
/*     */   boolean init;
/*     */   
/*     */   public Level6(Handler handler) {
/*  43 */     super(handler);
/*  44 */     this.world = new World("/Levels/Level6", handler);
/*  45 */     this.player = new Player(handler, this.world.spawnx, this.world.spawnx);
/*  46 */     this.exitdoor = new ExitDoor(handler, 64.0F, 1216.0F);
/*     */     
/*  48 */     for (int y = 0; y < this.world.height; y++) {
/*     */       
/*  50 */       for (int x = 0; x < this.world.width; x++) {
/*     */         
/*  52 */         if (this.world.map[x][y] == 3)
/*  53 */           this.orbs.add(new Orb(handler, (32 * x), (32 * y))); 
/*  54 */         if (this.world.map[x][y] == 4)
/*  55 */           this.guards.add(new Guard(handler, (32 * x), (32 * y), false)); 
/*  56 */         if (this.world.map[x][y] == 8)
/*  57 */           this.rocks.add(new Rock(handler, (32 * x), (32 * y))); 
/*  58 */         if (this.world.map[x][y] == 7)
/*  59 */           this.switch1.add(new Switch(handler, (32 * x), (32 * y), true, this.rocks)); 
/*  60 */         if (this.world.map[x][y] == 9)
/*  61 */           this.platform.add(new MovingPlatform(handler, (32 * x), (32 * y), true, this.rocks)); 
/*  62 */         if (this.world.map[x][y] == 6)
/*  63 */           this.gates.add(new Gate(handler, (32 * x), (32 * y), true, this.rocks)); 
/*     */       } 
/*     */     } 
/*  66 */     ((Gate)this.gates.get(0)).setSwitch(this.switch1.get(2));
/*  67 */     ((Gate)this.gates.get(1)).setSwitch(this.switch1.get(0));
/*  68 */     ((Gate)this.gates.get(2)).setSwitch(this.switch1.get(1));
/*  69 */     ((Gate)this.gates.get(3)).setSwitch(this.switch1.get(3));
/*  70 */     ((Gate)this.gates.get(4)).setSwitch(this.switch1.get(4));
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/*  75 */     if (!World.gameOver && !World.victory) {
/*     */       
/*  77 */       this.world.tick();
/*  78 */       this.exitdoor.tick();
/*  79 */       for (MovingPlatform m : this.platform)
/*  80 */         m.tick(); 
/*  81 */       for (Switch s : this.switch1)
/*  82 */         s.tick(); 
/*  83 */       for (Orb o : this.orbs)
/*  84 */         o.tick(); 
/*  85 */       for (Gate ga : this.gates)
/*  86 */         ga.tick(); 
/*  87 */       for (Guard gu : this.guards)
/*  88 */         gu.tick(); 
/*  89 */       for (Rock r : this.rocks)
/*  90 */         r.tick(); 
/*  91 */       this.player.tick();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Graphics g) {
/*  97 */     this.world.render(g);
/*  98 */     this.exitdoor.render(g);
/*  99 */     for (MovingPlatform m : this.platform)
/* 100 */       m.render(g); 
/* 101 */     for (Switch s : this.switch1)
/* 102 */       s.render(g); 
/* 103 */     for (Orb o : this.orbs)
/* 104 */       o.render(g); 
/* 105 */     for (Gate ga : this.gates)
/* 106 */       ga.render(g); 
/* 107 */     for (Guard gu : this.guards)
/* 108 */       gu.render(g); 
/* 109 */     for (Rock r : this.rocks)
/* 110 */       r.render(g); 
/* 111 */     this.player.render(g);
/*     */ 
/*     */     
/* 114 */     g.setColor(Color.yellow);
/* 115 */     g.setFont(new Font("Arial Black", 15, 15));
/* 116 */     g.drawString("Life - " + Player.life, 570, 25);
/* 117 */     g.drawString("Orbs needed - " + (this.world.orbsPresent - Player.orbsCollected), 10, 25);
/* 118 */     if (World.gameOver) {
/*     */       
/* 120 */       g.setFont(new Font("Algerian", 30, 30));
/* 121 */       g.setColor(Color.white);
/* 122 */       g.drawString("GAME OVER!", 250, 135);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/* 128 */     this.handler.setWorld(this.world);
/* 129 */     this.handler.setPlayer(this.player);
/* 130 */     this.init = true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\States\Level6.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */