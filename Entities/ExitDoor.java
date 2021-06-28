/*    */ package Entities;
/*    */ 
/*    */ import Main.Handler;
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ public class ExitDoor
/*    */   extends StaticCreature
/*    */ {
/*    */   public ExitDoor(Handler handler, float x, float y) {
/* 12 */     super(handler, x, y);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void tick() {
/* 18 */     if ((this.handler.getWorld()).orbsPresent == Player.orbsCollected) {
/*    */       
/* 20 */       this.isActivated = true;
/* 21 */       if (this.handler.getPlayer().isCollided(this)) {
/*    */         
/* 23 */         Player.currentLevel++;
/* 24 */         Player.orbsCollected = 0;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 31 */     if (!this.isActivated) {
/* 32 */       g.drawImage(Assets.doorClosed, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset - 32.0F), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset - 32.0F), 64, 64, null);
/*    */     } else {
/* 34 */       g.drawImage(Assets.doorOpened, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset - 32.0F), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset - 32.0F), 64, 64, null);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\ExitDoor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */