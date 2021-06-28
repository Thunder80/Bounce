/*     */ package Entities;
/*     */ 
/*     */ import Main.Handler;
/*     */ import Sounds.Sound;
/*     */ import gfx.Assets;
/*     */ import gfx.Tiles.Tile;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player extends Creature {
/*     */   public float xMove;
/*     */   public float yMove;
/*  12 */   public float gravity = 0.07F;
/*     */   public boolean jumping = true;
/*     */   public boolean falling = true;
/*  15 */   public static int orbsCollected = 0; private int spawnX; private int spawnY;
/*  16 */   public static int currentLevel = 1; public boolean left; public boolean isFiring;
/*     */   public boolean fired;
/*     */   private Sound jump;
/*     */   private Sound die;
/*     */   private Sound shoot;
/*     */   public Bullet bullet;
/*     */   
/*     */   public int getSpawnX() {
/*  24 */     return this.spawnX;
/*     */   }
/*     */   public void setSpawnX(int spawnX) {
/*  27 */     this.spawnX = spawnX;
/*     */   }
/*     */   public int getSpawnY() {
/*  30 */     return this.spawnY;
/*     */   }
/*     */   public void setSpawnY(int spawnY) {
/*  33 */     this.spawnY = spawnY;
/*     */   }
/*     */   
/*  36 */   public static int life = 5, olife = 5;
/*     */   
/*     */   public Player(Handler handler, float x, float y) {
/*  39 */     super(handler, x, y, 16, 16);
/*  40 */     this.bounds.height--;
/*  41 */     this.bounds.width--;
/*  42 */     this.bullet = new Bullet(handler, x, y, this);
/*  43 */     this.jump = new Sound("/Sounds/jump.wav");
/*  44 */     this.die = new Sound("/Sounds/die.wav");
/*  45 */     this.shoot = new Sound("/Sounds/shoot.wav");
/*     */   }
/*     */   
/*     */   public void tick() {
/*  49 */     getInput();
/*  50 */     moveX();
/*  51 */     moveY();
/*  52 */     this.handler.getGame().getGamecamera().centerOnEntity(this);
/*  53 */     this.bullet.tick();
/*     */ 
/*     */     
/*  56 */     if (life != olife) {
/*     */       
/*  58 */       this.die.clip.start();
/*  59 */       this.die.clip.setFramePosition(0);
/*  60 */       olife = life;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Graphics g) {
/*  66 */     g.drawImage(Assets.player, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), null);
/*  67 */     if ((this.handler.getGame().getKeymanager()).enter && !this.isFiring) {
/*     */       
/*  69 */       this.bullet.x = this.x;
/*  70 */       this.bullet.y = this.y;
/*  71 */       this.isFiring = true;
/*  72 */       this.fired = this.left;
/*  73 */       this.shoot.clip.start();
/*  74 */       this.shoot.clip.setFramePosition(0);
/*     */     } 
/*  76 */     if (this.isFiring) {
/*  77 */       this.bullet.render(g);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean collisionWithTile(int x, int y) {
/*  82 */     return this.handler.getWorld().getTile(x, y).isSolid();
/*     */   }
/*     */ 
/*     */   
/*     */   public void getInput() {
/*  87 */     this.xMove = 0.0F;
/*  88 */     int ty = (int)(this.y + this.bounds.y + this.bounds.height) / 32;
/*  89 */     if (!collisionWithTile((int)(this.x + this.bounds.x + this.bounds.width) / 32, ty) && !collisionWithTile((int)(this.x + this.bounds.x) / 32, ty) && (this.jumping || this.falling) && !Rock.ontop) {
/*     */       
/*  91 */       this.yMove += this.gravity;
/*     */     }
/*     */     else {
/*     */       
/*  95 */       this.yMove = 0.0F;
/*     */     } 
/*  97 */     if ((this.handler.getGame().getKeymanager()).right) {
/*     */       
/*  99 */       this.xMove = this.speed;
/* 100 */       this.left = false;
/*     */     } 
/* 102 */     if ((this.handler.getGame().getKeymanager()).left) {
/*     */       
/* 104 */       this.xMove = -this.speed;
/* 105 */       this.left = true;
/*     */     } 
/* 107 */     if ((this.handler.getGame().getKeymanager()).up && !this.jumping && !this.falling) {
/*     */       
/* 109 */       this.yMove = -this.speed;
/* 110 */       this.jumping = true;
/* 111 */       this.jump.clip.start();
/* 112 */       this.jump.clip.setFramePosition(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveX() {
/* 118 */     if (this.xMove > 0.0F) {
/*     */       
/* 120 */       int tx = (int)(this.x + this.bounds.width + this.bounds.x + this.xMove) / 32;
/* 121 */       if (!collisionWithTile(tx, (int)(this.y + this.bounds.y) / 32) && !collisionWithTile(tx, (int)(this.y + this.bounds.y + this.bounds.height) / 32)) {
/*     */         
/* 123 */         this.x += this.xMove;
/*     */ 
/*     */       
/*     */       }
/* 127 */       else if (getTile(tx, (int)(this.y + this.bounds.y + this.yMove) / 32) == Tile.tiles[2]) {
/*     */         
/* 129 */         life--;
/* 130 */         this.x = (this.handler.getWorld()).spawnx;
/* 131 */         this.y = (this.handler.getWorld()).spawny;
/*     */       } else {
/*     */         
/* 134 */         this.x = (tx * 32 - this.bounds.width - 1);
/*     */       } 
/*     */     } 
/* 137 */     if (this.xMove < 0.0F) {
/*     */       
/* 139 */       int tx = (int)(this.x + this.bounds.x + this.xMove) / 32;
/* 140 */       if (!collisionWithTile(tx, (int)(this.y + this.bounds.y) / 32) && !collisionWithTile(tx, (int)(this.y + this.bounds.y + this.bounds.height) / 32)) {
/*     */         
/* 142 */         this.x += this.xMove;
/*     */ 
/*     */       
/*     */       }
/* 146 */       else if (getTile(tx, (int)(this.y + this.bounds.y + this.yMove) / 32) == Tile.tiles[2]) {
/*     */         
/* 148 */         life--;
/* 149 */         this.x = (this.handler.getWorld()).spawnx;
/* 150 */         this.y = (this.handler.getWorld()).spawny;
/*     */       }
/*     */       else {
/*     */         
/* 154 */         this.x = (tx * 32 + 32);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveY() {
/* 161 */     if (!collisionWithTile((int)(this.x + this.bounds.x) / 32, (int)(this.y + this.bounds.y + this.bounds.height + 1.0F) / 32) && !collisionWithTile((int)(this.x + this.bounds.x + this.bounds.width) / 32, (int)(this.y + this.bounds.y + this.bounds.height + 1.0F) / 32))
/* 162 */       this.falling = true; 
/* 163 */     if (this.yMove > 0.0F) {
/*     */       
/* 165 */       int ty = (int)(this.y + this.bounds.y + this.bounds.height + this.yMove) / 32;
/* 166 */       if (!collisionWithTile((int)((this.x + this.bounds.x) / 32.0F), ty) && !collisionWithTile((int)(this.x + this.bounds.x + this.bounds.width) / 32, ty)) {
/*     */         
/* 168 */         this.y += this.yMove;
/*     */       }
/*     */       else {
/*     */         
/* 172 */         if (getTile((int)(this.x + this.bounds.x + this.bounds.width) / 32, ty) == Tile.tiles[2] || getTile((int)(this.x + this.bounds.x) / 32, ty) == Tile.tiles[2]) {
/*     */           
/* 174 */           life--;
/* 175 */           this.x = (this.handler.getWorld()).spawnx;
/* 176 */           this.y = (this.handler.getWorld()).spawny;
/*     */         }
/*     */         else {
/*     */           
/* 180 */           this.y = (ty * 32 - this.bounds.height - 1);
/*     */         } 
/* 182 */         this.jumping = false;
/* 183 */         this.falling = false;
/*     */       } 
/*     */     } 
/* 186 */     if (this.yMove < 0.0F) {
/*     */       
/* 188 */       int ty = (int)(this.y + this.bounds.y + this.yMove) / 32;
/* 189 */       if (!collisionWithTile((int)(this.x + this.bounds.x + this.bounds.width) / 32, ty) && !collisionWithTile((int)(this.x + this.bounds.x) / 32, ty)) {
/*     */         
/* 191 */         this.y += this.yMove;
/*     */ 
/*     */       
/*     */       }
/* 195 */       else if (getTile((int)(this.x + this.bounds.x + this.bounds.width) / 32, ty) == Tile.tiles[2]) {
/*     */         
/* 197 */         life--;
/* 198 */         this.x = (this.handler.getWorld()).spawnx;
/* 199 */         this.y = (this.handler.getWorld()).spawny;
/*     */       }
/*     */       else {
/*     */         
/* 203 */         this.y = (ty * 32 + 32);
/* 204 */         this.yMove++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCollided(Entity e) {
/* 212 */     if ((this.x > e.x || this.x + this.bounds.width > e.x) && (this.x < e.x + 32.0F || this.x + this.bounds.width < e.x + 32.0F) && (this.y > e.y || this.y + this.bounds.height > e.y) && (this.y < e.y + 32.0F || this.y + this.bounds.height < e.y + 32.0F))
/*     */     {
/* 214 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 218 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Tile getTile(int x, int y) {
/* 224 */     return Tile.tiles[(this.handler.getWorld()).map[x][y]];
/*     */   }
/*     */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */