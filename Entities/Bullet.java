/*    */ package Entities;
/*    */ 
/*    */ import Main.Handler;
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ public class Bullet
/*    */   extends Creature
/*    */ {
/*    */   Player player;
/*    */   
/*    */   public Bullet(Handler handler, float x, float y, Player player) {
/* 14 */     super(handler, x, y, 32, 32);
/* 15 */     this.player = player;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void tick() {
/* 22 */     if (this.player.isFiring)
/*    */     {
/* 24 */       if (this.player.fired) {
/*    */         
/* 26 */         this.x -= 3.0F;
/* 27 */         int tx = (int)(this.x + this.bounds.x - 3.0F) / 32;
/* 28 */         if (getTileSolid(tx, (int)(this.y + this.bounds.y + this.bounds.height) / 32 - 1))
/*    */         {
/* 30 */           this.player.isFiring = false;
/* 31 */           this.x = 0.0F;
/* 32 */           this.y = 0.0F;
/*    */         }
/*    */       
/*    */       } else {
/*    */         
/* 37 */         this.x += 3.0F;
/* 38 */         int tx = (int)(this.x + this.bounds.x + this.bounds.width + 3.0F) / 32;
/* 39 */         if (getTileSolid(tx, (int)(this.y + this.bounds.y + this.bounds.height) / 32 - 1)) {
/*    */           
/* 41 */           this.player.isFiring = false;
/* 42 */           this.x = 0.0F;
/* 43 */           this.y = 0.0F;
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 64 */     if (this.player.fired) {
/* 65 */       g.drawImage(Assets.bullet_left, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset - 8.0F - 16.0F), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset - 8.0F), 32, 32, null);
/*    */     } else {
/* 67 */       g.drawImage(Assets.bullet_right, (int)(this.x + (this.handler.getPlayer()).bounds.width - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset - 8.0F), 32, 32, null);
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean getTileSolid(int x, int y) {
/* 72 */     return this.handler.getWorld().getTile(x, y).isSolid();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCollided(Entity e) {
/* 77 */     if ((this.x > e.x || this.x + this.bounds.width > e.x) && (this.x < e.x + 32.0F || this.x + this.bounds.width < e.x + 32.0F) && (this.y > e.y || this.y + this.bounds.height > e.y) && (this.y < e.y + 32.0F || this.y + this.bounds.height < e.y + 32.0F)) {
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\Bullet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */