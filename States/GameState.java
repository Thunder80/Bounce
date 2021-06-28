/*     */ package States;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameState
/*     */   extends State
/*     */ {
/*     */   Level1 level1;
/*     */   Level2 level2;
/*     */   Level3 level3;
/*     */   Level4 level4;
/*     */   Level5 level5;
/*     */   Level6 level6;
/*     */   
/*     */   public GameState(Handler handler) {
/*  34 */     super(handler);
/*  35 */     this.level1 = new Level1(handler);
/*  36 */     this.level2 = new Level2(handler);
/*  37 */     this.level3 = new Level3(handler);
/*  38 */     this.level4 = new Level4(handler);
/*  39 */     this.level5 = new Level5(handler);
/*  40 */     this.level6 = new Level6(handler);
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/*  45 */     if (Player.currentLevel == 1) {
/*  46 */       this.level1.tick();
/*  47 */     } else if (Player.currentLevel == 2) {
/*     */       
/*  49 */       if (!this.level2.init) {
/*     */         
/*  51 */         this.level2.init();
/*  52 */         this.level2.init = true;
/*  53 */         this.handler.getPlayer().setX((this.handler.getWorld()).spawnx);
/*  54 */         this.handler.getPlayer().setY((this.handler.getWorld()).spawny);
/*     */       } 
/*  56 */       this.level2.tick();
/*     */     }
/*  58 */     else if (Player.currentLevel == 3) {
/*     */       
/*  60 */       if (!this.level3.init) {
/*     */         
/*  62 */         this.level3.init();
/*  63 */         this.level3.init = true;
/*  64 */         this.handler.getPlayer().setX((this.handler.getWorld()).spawnx);
/*  65 */         this.handler.getPlayer().setY((this.handler.getWorld()).spawny);
/*     */       } 
/*  67 */       this.level3.tick();
/*     */     }
/*  69 */     else if (Player.currentLevel == 4) {
/*     */       
/*  71 */       if (!this.level4.init) {
/*     */         
/*  73 */         this.level4.init();
/*  74 */         this.level4.init = true;
/*  75 */         this.handler.getPlayer().setX((this.handler.getWorld()).spawnx);
/*  76 */         this.handler.getPlayer().setY((this.handler.getWorld()).spawny);
/*     */       } 
/*  78 */       this.level4.tick();
/*     */     }
/*  80 */     else if (Player.currentLevel == 5) {
/*     */       
/*  82 */       if (!this.level5.init) {
/*     */         
/*  84 */         this.level5.init();
/*  85 */         this.level5.init = true;
/*  86 */         this.handler.getPlayer().setX((this.handler.getWorld()).spawnx);
/*  87 */         this.handler.getPlayer().setY((this.handler.getWorld()).spawny);
/*     */       } 
/*  89 */       this.level5.tick();
/*     */     }
/*  91 */     else if (Player.currentLevel == 6) {
/*     */       
/*  93 */       if (!this.level6.init) {
/*     */         
/*  95 */         this.level6.init();
/*  96 */         this.level6.init = true;
/*  97 */         this.handler.getPlayer().setX((this.handler.getWorld()).spawnx);
/*  98 */         this.handler.getPlayer().setY((this.handler.getWorld()).spawny);
/*     */       } 
/* 100 */       this.level6.tick();
/*     */     }
/* 102 */     else if (Player.currentLevel == 7) {
/*     */       
/* 104 */       World.victory = true;
/*     */     } 
/* 106 */     if ((this.handler.getGame().getKeymanager()).reset) {
/*     */       
/* 108 */       this.handler.getPlayer();
/* 109 */       if (Player.currentLevel == 5) {
/*     */         
/* 111 */         reset5();
/* 112 */         this.handler.getPlayer().setX(this.level5.world.spawnx);
/* 113 */         this.handler.getPlayer().setY(this.level5.world.spawny);
/*     */       } 
/* 115 */       if (Player.currentLevel == 6) {
/*     */         
/* 117 */         reset6();
/* 118 */         this.handler.getPlayer().setX(this.level6.world.spawnx);
/* 119 */         this.handler.getPlayer().setY(this.level6.world.spawny);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Graphics g) {
/* 126 */     if (Player.currentLevel == 1) {
/* 127 */       this.level1.render(g);
/* 128 */     } else if (Player.currentLevel == 2) {
/* 129 */       this.level2.render(g);
/* 130 */     } else if (Player.currentLevel == 3) {
/* 131 */       this.level3.render(g);
/* 132 */     } else if (Player.currentLevel == 4) {
/* 133 */       this.level4.render(g);
/* 134 */     } else if (Player.currentLevel == 5) {
/* 135 */       this.level5.render(g);
/* 136 */     } else if (Player.currentLevel == 6) {
/* 137 */       this.level6.render(g);
/* 138 */     } else if (Player.currentLevel == 7) {
/*     */       
/* 140 */       this.level6.render(g);
/* 141 */       g.setFont(new Font("Algerian", 30, 30));
/* 142 */       g.setColor(Color.white);
/* 143 */       g.drawString("You win", 250, 135);
/* 144 */       g.drawString("Press enter to return to main menu", 50, 200);
/* 145 */       if ((this.handler.getGame().getKeymanager()).mainmenu)
/*     */       {
/* 147 */         restart();
/*     */       }
/*     */     } 
/* 150 */     if (Player.life < 1) {
/*     */       
/* 152 */       g.drawString("Press enter to return to main menu", 50, 200);
/* 153 */       if ((this.handler.getGame().getKeymanager()).mainmenu)
/*     */       {
/* 155 */         restart();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset5() {
/* 162 */     this.level5.orbs.clear();
/* 163 */     this.level5.rocks.clear();
/* 164 */     this.level5.switch1.clear();
/* 165 */     this.level5.gates.clear();
/* 166 */     this.level5.guards.clear();
/*     */ 
/*     */     
/* 169 */     for (int y = 0; y < this.level5.world.height; y++) {
/*     */       
/* 171 */       for (int x = 0; x < this.level5.world.width; x++) {
/*     */         
/* 173 */         if (this.level5.world.map[x][y] == 3)
/* 174 */           this.level5.orbs.add(new Orb(this.handler, (32 * x), (32 * y))); 
/* 175 */         if (this.level5.world.map[x][y] == 4)
/* 176 */           this.level5.guards.add(new Guard(this.handler, (32 * x), (32 * y), false)); 
/* 177 */         if (this.level5.world.map[x][y] == 8)
/* 178 */           this.level5.rocks.add(new Rock(this.handler, (32 * x), (32 * y))); 
/* 179 */         if (this.level5.world.map[x][y] == 7)
/* 180 */           this.level5.switch1.add(new Switch(this.handler, (32 * x), (32 * y), true, this.level5.rocks)); 
/* 181 */         if (this.level5.world.map[x][y] == 6) {
/* 182 */           this.level5.gates.add(new Gate(this.handler, (32 * x), (32 * y), true, this.level5.rocks));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     ((Gate)this.level5.gates.get(0)).setSwitch(this.level5.switch1.get(0));
/* 188 */     ((Gate)this.level5.gates.get(1)).setSwitch(this.level5.switch1.get(0));
/* 189 */     ((Gate)this.level5.gates.get(2)).setSwitch(this.level5.switch1.get(4));
/* 190 */     ((Gate)this.level5.gates.get(3)).setSwitch(this.level5.switch1.get(2));
/* 191 */     ((Gate)this.level5.gates.get(4)).setSwitch(this.level5.switch1.get(1));
/* 192 */     ((Gate)this.level5.gates.get(5)).setSwitch(this.level5.switch1.get(3));
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset6() {
/* 197 */     this.level6.orbs.clear();
/* 198 */     this.level6.rocks.clear();
/* 199 */     this.level6.switch1.clear();
/* 200 */     this.level6.gates.clear();
/* 201 */     this.level6.guards.clear();
/* 202 */     this.level6.platform.clear();
/*     */     
/* 204 */     for (int y = 0; y < this.level6.world.height; y++) {
/*     */       
/* 206 */       for (int x = 0; x < this.level6.world.width; x++) {
/*     */         
/* 208 */         if (this.level6.world.map[x][y] == 3)
/* 209 */           this.level6.orbs.add(new Orb(this.handler, (32 * x), (32 * y))); 
/* 210 */         if (this.level6.world.map[x][y] == 4)
/* 211 */           this.level6.guards.add(new Guard(this.handler, (32 * x), (32 * y), false)); 
/* 212 */         if (this.level6.world.map[x][y] == 8)
/* 213 */           this.level6.rocks.add(new Rock(this.handler, (32 * x), (32 * y))); 
/* 214 */         if (this.level6.world.map[x][y] == 7)
/* 215 */           this.level6.switch1.add(new Switch(this.handler, (32 * x), (32 * y), true, this.level6.rocks)); 
/* 216 */         if (this.level6.world.map[x][y] == 9)
/* 217 */           this.level6.platform.add(new MovingPlatform(this.handler, (32 * x), (32 * y), true, this.level6.rocks)); 
/* 218 */         if (this.level6.world.map[x][y] == 6) {
/* 219 */           this.level6.gates.add(new Gate(this.handler, (32 * x), (32 * y), true, this.level6.rocks));
/*     */         }
/*     */       } 
/*     */     } 
/* 223 */     ((Gate)this.level6.gates.get(0)).setSwitch(this.level6.switch1.get(2));
/* 224 */     ((Gate)this.level6.gates.get(1)).setSwitch(this.level6.switch1.get(0));
/* 225 */     ((Gate)this.level6.gates.get(2)).setSwitch(this.level6.switch1.get(1));
/* 226 */     ((Gate)this.level6.gates.get(3)).setSwitch(this.level6.switch1.get(3));
/* 227 */     ((Gate)this.level6.gates.get(4)).setSwitch(this.level6.switch1.get(4));
/*     */   }
/*     */ 
/*     */   
/*     */   public void restart() {
/* 232 */     State.setState((this.handler.getGame()).menustate);
/* 233 */     Player.life = 5;
/* 234 */     Player.currentLevel = 1;
/* 235 */     (this.handler.getGame().getMouseManager()).clicking = false;
/* 236 */     this.level2.init = false;
/* 237 */     this.level3.init = false;
/* 238 */     this.level4.init = false;
/* 239 */     this.level5.init = false;
/* 240 */     this.level6.init = false;
/* 241 */     this.level1.exitdoor.isActivated = false;
/* 242 */     this.level2.exitdoor.isActivated = false;
/* 243 */     this.level3.exitdoor.isActivated = false;
/* 244 */     this.level4.exitdoor.isActivated = false;
/* 245 */     this.level5.exitdoor.isActivated = false;
/* 246 */     this.level6.exitdoor.isActivated = false;
/*     */     
/* 248 */     this.level1.orbs.isActivated = false;
/*     */     
/* 250 */     this.level2.orbs.isActivated = false;
/*     */     int i;
/* 252 */     for (i = 0; i < this.level3.orbs.size(); i++)
/* 253 */       ((Orb)this.level3.orbs.get(i)).isActivated = false; 
/* 254 */     for (i = 0; i < this.level4.orbs.size(); i++)
/* 255 */       ((Orb)this.level4.orbs.get(i)).isActivated = false; 
/* 256 */     for (i = 0; i < this.level5.orbs.size(); i++)
/* 257 */       ((Orb)this.level5.orbs.get(i)).isActivated = false; 
/* 258 */     for (i = 0; i < this.level6.orbs.size(); i++) {
/* 259 */       ((Orb)this.level6.orbs.get(i)).isActivated = false;
/*     */     }
/* 261 */     this.handler.setWorld(this.level1.world);
/* 262 */     this.handler.setPlayer(this.level1.player);
/* 263 */     this.handler.getPlayer().setX((this.handler.getWorld()).spawnx);
/* 264 */     this.handler.getPlayer().setY((this.handler.getWorld()).spawny);
/*     */     
/* 266 */     reset5();
/*     */     
/* 268 */     reset6();
/*     */     
/* 270 */     Player.orbsCollected = 0;
/* 271 */     World.gameOver = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\States\GameState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */