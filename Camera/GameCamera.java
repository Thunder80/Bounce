/*    */ package Camera;
/*    */ 
/*    */ import Entities.Entity;
/*    */ import Main.Handler;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameCamera
/*    */ {
/*    */   public float xOffset;
/*    */   public float yOffset;
/*    */   private Handler handler;
/*    */   
/*    */   public GameCamera(Handler handler, int xOffset, int yOffset) {
/* 15 */     this.handler = handler;
/* 16 */     this.xOffset = xOffset;
/* 17 */     this.yOffset = yOffset;
/*    */   }
/*    */ 
/*    */   
/*    */   public void checkSpace() {
/* 22 */     if (this.xOffset < 0.0F)
/*    */     {
/* 24 */       this.xOffset = 0.0F;
/*    */     }
/*    */     
/* 27 */     if (this.yOffset < 0.0F)
/*    */     {
/* 29 */       this.yOffset = 0.0F;
/*    */     }
/* 31 */     if (this.xOffset > ((this.handler.getWorld()).width * 32 - this.handler.getGame().getWidth()))
/*    */     {
/* 33 */       this.xOffset = ((this.handler.getWorld()).width * 32 - this.handler.getGame().getWidth());
/*    */     }
/* 35 */     if (this.yOffset < 0.0F)
/*    */     {
/* 37 */       this.yOffset = 0.0F;
/*    */     }
/* 39 */     if (this.yOffset > ((this.handler.getWorld()).height * 32 - this.handler.getGame().getHeight()))
/*    */     {
/* 41 */       this.yOffset = ((this.handler.getWorld()).height * 32 - this.handler.getGame().getHeight());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void centerOnEntity(Entity e) {
/* 47 */     this.xOffset = e.getX() - (this.handler.getGame().getWidth() / 2) + (e.getWidth() / 2);
/* 48 */     this.yOffset = e.getY() - (this.handler.getGame().getHeight() / 2) + (e.getHeight() / 2);
/* 49 */     checkSpace();
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Camera\GameCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */