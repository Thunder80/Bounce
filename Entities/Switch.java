/*    */ package Entities;
/*    */ 
/*    */ import Main.Handler;
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Switch
/*    */   extends StaticCreature
/*    */ {
/*    */   private ArrayList<Rock> rocks;
/*    */   private boolean rocksPresent;
/*    */   
/*    */   public Switch(Handler handler, float x, float y, boolean rocksPresent, ArrayList<Rock> rocks) {
/* 17 */     super(handler, x, y);
/* 18 */     this.rocks = rocks;
/* 19 */     this.rocksPresent = rocksPresent;
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 24 */     if (this.handler.getPlayer().isCollided(this)) {
/*    */       
/* 26 */       this.isActivated = true;
/*    */     }
/*    */     else {
/*    */       
/* 30 */       this.isActivated = false;
/*    */     } 
/*    */ 
/*    */     
/* 34 */     if (this.rocksPresent && !this.isActivated)
/*    */     {
/* 36 */       for (Rock r : this.rocks) {
/*    */         
/* 38 */         if (r.isCollided(this)) {
/*    */           
/* 40 */           this.isActivated = true;
/*    */           
/*    */           break;
/*    */         } 
/* 44 */         this.isActivated = false;
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 51 */     if (!this.isActivated) {
/* 52 */       g.drawImage(Assets.switchnp, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), 32, 32, null);
/*    */     } else {
/* 54 */       g.drawImage(Assets.switchPressed, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), 32, 32, null);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\Switch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */