/*     */ package Entities;
/*     */ 
/*     */ import Main.Handler;
/*     */ import gfx.Assets;
/*     */ import java.awt.Graphics;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class MovingPlatform
/*     */   extends Creature {
/*     */   float cx;
/*     */   float cy;
/*  12 */   float px = this.handler.getPlayer().getX(); float py = this.handler.getPlayer().getY();
/*     */   
/*     */   boolean movevertical;
/*     */   
/*     */   ArrayList<Rock> rocks;
/*     */   
/*     */   public MovingPlatform(Handler handler, float x, float y, boolean movevertical, ArrayList<Rock> rocks) {
/*  19 */     super(handler, x, y, 32, 32);
/*     */     
/*  21 */     this.movevertical = movevertical;
/*  22 */     this.rocks = rocks;
/*  23 */     this.cx = x;
/*  24 */     this.cy = y;
/*  25 */     this.speed = 3.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/*  30 */     float px = this.handler.getPlayer().getX(), py = this.handler.getPlayer().getY();
/*  31 */     if (this.movevertical) {
/*  32 */       moveVertical();
/*     */     } else {
/*  34 */       moveHorizontal();
/*  35 */     }  if (this.handler.getPlayer().isCollided(this))
/*     */     {
/*  37 */       if (py + (this.handler.getPlayer()).height >= this.y) {
/*     */ 
/*     */         
/*  40 */         (this.handler.getPlayer()).yMove = 0.0F;
/*  41 */         (this.handler.getPlayer()).falling = false;
/*  42 */         (this.handler.getPlayer()).jumping = false;
/*  43 */         this.handler.getPlayer().setY(this.y - (this.handler.getPlayer()).bounds.height + 4.0F);
/*     */       
/*     */       }
/*  46 */       else if (px < this.x) {
/*     */         
/*  48 */         this.handler.getPlayer().setX(this.x - (this.handler.getPlayer()).bounds.width);
/*     */       }
/*  50 */       else if (px > this.x) {
/*     */         
/*  52 */         this.handler.getPlayer().setX(this.x + this.bounds.width);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  57 */     for (Rock r : this.rocks) {
/*     */       
/*  59 */       if (r.isCollided(this)) {
/*     */         
/*  61 */         if (r.getY() + r.bounds.height >= this.y) {
/*     */ 
/*     */           
/*  64 */           r.yMove = 0.0F;
/*  65 */           r.setY(this.y - r.height + 4.0F);
/*     */           break;
/*     */         } 
/*  68 */         if (r.getX() < this.x) {
/*     */           
/*  70 */           r.setX(this.x - (this.handler.getPlayer()).bounds.width); break;
/*     */         } 
/*  72 */         if (r.getX() > this.x)
/*     */         {
/*  74 */           r.setX(this.x + this.bounds.width);
/*     */         }
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Graphics g) {
/*  83 */     g.drawImage(Assets.platform, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), 32, 32, null);
/*     */   }
/*     */   
/*     */   public void moveHorizontal() {
/*  87 */     this.x += this.speed;
/*  88 */     if (this.x > this.cx + 96.0F) {
/*  89 */       this.speed = -this.speed;
/*  90 */     } else if (this.x < this.cx - 96.0F) {
/*  91 */       this.speed = -this.speed;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void moveVertical() {
/*  96 */     this.y += this.speed;
/*  97 */     if (this.y > this.cy + 96.0F) {
/*  98 */       this.speed = -this.speed;
/*  99 */     } else if (this.y < this.cy - 96.0F) {
/* 100 */       this.speed = -this.speed;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\MovingPlatform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */