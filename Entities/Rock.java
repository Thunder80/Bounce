/*     */ package Entities;
/*     */ 
/*     */ import Main.Handler;
/*     */ import gfx.Assets;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ 
/*     */ public class Rock
/*     */   extends Creature
/*     */ {
/*  11 */   public float friction = 0.5F; public float xMove; public float gravity = 0.07F; public float yMove;
/*     */   public static boolean hit;
/*     */   public static boolean moving;
/*     */   
/*     */   public Rock(Handler handler, float x, float y) {
/*  16 */     super(handler, x, y, 32, 32);
/*  17 */     this.speed = 9.0F;
/*     */   }
/*     */   public static boolean ontop; public static boolean adjust; public static long timer;
/*     */   
/*     */   public void tick() {
/*  22 */     if (this.handler.getPlayer().isCollided(this)) {
/*     */       
/*  24 */       if (this.handler.getPlayer().getY() + (this.handler.getPlayer()).bounds.getHeight() >= this.y && this.handler.getPlayer().getY() < this.y) {
/*     */         
/*  26 */         if (!ontop) {
/*     */           
/*  28 */           (this.handler.getPlayer()).yMove = 0.0F;
/*  29 */           ontop = true;
/*     */         } 
/*  31 */         this.handler.getPlayer().setY(this.y - (this.handler.getPlayer()).bounds.height + 1.0F);
/*  32 */         (this.handler.getPlayer()).falling = false;
/*  33 */         (this.handler.getPlayer()).jumping = false;
/*     */       }
/*  35 */       else if (!(this.handler.getPlayer()).left) {
/*  36 */         this.handler.getPlayer().setX(this.x - (this.handler.getPlayer()).bounds.width);
/*  37 */       } else if ((this.handler.getPlayer()).left) {
/*  38 */         this.handler.getPlayer().setX(this.x + this.bounds.width);
/*     */       } 
/*     */     } else {
/*  41 */       ontop = false;
/*  42 */     }  setInput();
/*  43 */     moveX();
/*  44 */     moveY();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Graphics g) {
/*  49 */     g.drawImage(Assets.rock, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), 32, 32, null);
/*     */   }
/*     */   
/*     */   public void setInput() {
/*  53 */     if ((this.handler.getPlayer()).bullet.isCollided(this) && !hit) {
/*     */       
/*  55 */       if ((this.handler.getPlayer()).fired) {
/*  56 */         this.xMove = -this.speed;
/*     */       } else {
/*  58 */         this.xMove = this.speed;
/*  59 */       }  hit = true;
/*  60 */       moving = true;
/*  61 */       timer = System.currentTimeMillis();
/*     */     } 
/*  63 */     if (moving)
/*     */     {
/*  65 */       if (this.xMove > 0.0F) {
/*  66 */         this.xMove -= this.friction;
/*  67 */       } else if (this.xMove < 0.0F) {
/*  68 */         this.xMove += this.friction;
/*     */       } else {
/*  70 */         this.xMove = 0.0F;
/*     */       }  } 
/*  72 */     if (System.currentTimeMillis() - timer >= 1000L)
/*  73 */       hit = false; 
/*     */   }
/*     */   
/*     */   public void moveX() {
/*  77 */     if (this.xMove > 0.0F) {
/*     */       
/*  79 */       int tx = (int)(this.x + this.bounds.x + this.bounds.width) / 32;
/*  80 */       if (!this.handler.getPlayer().collisionWithTile(tx, (int)((this.y + this.bounds.y) / 32.0F)) && !this.handler.getPlayer().collisionWithTile(tx, (int)(this.y + this.bounds.y + this.bounds.height - 1.0F) / 32)) {
/*     */         
/*  82 */         this.x += this.xMove;
/*     */       }
/*     */       else {
/*     */         
/*  86 */         this.xMove = 0.0F;
/*  87 */         this.x = (tx * 32 - this.bounds.width);
/*  88 */         moving = false;
/*     */       } 
/*     */     } 
/*  91 */     if (this.xMove < 0.0F) {
/*     */       
/*  93 */       int tx = (int)(this.x + this.bounds.x) / 32;
/*  94 */       if (!this.handler.getPlayer().collisionWithTile(tx, (int)((this.y + this.bounds.y) / 32.0F)) && !this.handler.getPlayer().collisionWithTile(tx, (int)(this.y + this.bounds.y + this.bounds.height - 1.0F) / 32)) {
/*     */         
/*  96 */         this.x += this.xMove;
/*     */       }
/*     */       else {
/*     */         
/* 100 */         this.xMove = 0.0F;
/* 101 */         this.x = (tx * 32 + 32);
/* 102 */         moving = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveY() {
/* 109 */     int ty = (int)(this.y + this.bounds.y + this.bounds.height) / 32;
/* 110 */     if (!this.handler.getPlayer().collisionWithTile((int)(this.x + this.bounds.x) / 32, ty) && !this.handler.getPlayer().collisionWithTile((int)(this.x + this.bounds.x + this.bounds.width) / 32, ty)) {
/*     */       
/* 112 */       this.yMove += this.gravity;
/* 113 */       this.y += this.yMove;
/*     */     }
/*     */     else {
/*     */       
/* 117 */       this.yMove = 0.0F;
/* 118 */       this.y = (ty * 32 - this.bounds.height);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCollided(Entity e) {
/* 124 */     if ((this.x > e.x || this.x + this.bounds.width > e.x) && (this.x < e.x + 32.0F || this.x + this.bounds.width < e.x + 32.0F) && (this.y > e.y || this.y + this.bounds.height > e.y) && (this.y < e.y + 32.0F || this.y + this.bounds.height < e.y + 32.0F)) {
/* 125 */       return true;
/*     */     }
/* 127 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\Rock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */