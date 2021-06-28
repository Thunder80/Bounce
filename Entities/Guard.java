/*    */ package Entities;
/*    */ 
/*    */ import Main.Handler;
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class Guard
/*    */   extends Creature
/*    */ {
/*    */   public float cy;
/*    */   public float cx;
/*    */   public boolean vertical;
/*    */   
/*    */   public Guard(Handler handler, float x, float y, boolean vertical) {
/* 15 */     super(handler, x, y, 32, 32);
/* 16 */     this.vertical = vertical;
/* 17 */     this.cy = y;
/* 18 */     this.cx = x;
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 23 */     if (this.vertical) {
/* 24 */       moveVertical();
/*    */     } else {
/* 26 */       moveHorizontal();
/* 27 */     }  if (this.handler.getPlayer().isCollided(this)) {
/*    */       
/* 29 */       Player.life--;
/* 30 */       (this.handler.getPlayer()).x = (this.handler.getWorld()).spawnx;
/* 31 */       (this.handler.getPlayer()).y = (this.handler.getWorld()).spawny;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 37 */     g.drawImage(Assets.guard, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), 32, 32, null);
/*    */   }
/*    */   
/*    */   public void moveVertical() {
/* 41 */     this.y += this.speed;
/* 42 */     if (this.y > this.cy + 96.0F)
/* 43 */       this.speed = -3.0F; 
/* 44 */     if (this.y < this.cy - 96.0F)
/* 45 */       this.speed = 3.0F; 
/*    */   }
/*    */   
/*    */   public void moveHorizontal() {
/* 49 */     this.x += this.speed;
/* 50 */     if (this.x > this.cx + 96.0F)
/* 51 */       this.speed = -3.0F; 
/* 52 */     if (this.x < this.cx - 96.0F)
/* 53 */       this.speed = 3.0F; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\Guard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */