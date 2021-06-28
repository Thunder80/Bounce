/*    */ package Entities;
/*    */ 
/*    */ import Main.Handler;
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class Gate
/*    */   extends StaticCreature
/*    */ {
/*    */   private Switch switch1;
/*    */   private boolean rocksPresent;
/*    */   private ArrayList<Rock> rocks;
/*    */   
/*    */   public Gate(Handler handler, float x, float y, boolean rocksPresent, ArrayList<Rock> rocks) {
/* 17 */     super(handler, x, y);
/* 18 */     this.rocksPresent = rocksPresent;
/* 19 */     this.rocks = rocks;
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 24 */     if (!this.isActivated) {
/*    */       
/* 26 */       if (this.handler.getPlayer().isCollided(this))
/*    */       {
/* 28 */         if ((this.handler.getPlayer()).left) {
/* 29 */           this.handler.getPlayer().setX(this.x + this.bounds.width);
/*    */         } else {
/* 31 */           this.handler.getPlayer().setX(this.x - (this.handler.getPlayer()).bounds.width);
/*    */         } 
/*    */       }
/* 34 */       if (this.rocksPresent)
/*    */       {
/* 36 */         for (Rock r : this.rocks) {
/*    */           
/* 38 */           if (r.isCollided(this)) {
/*    */             
/* 40 */             if (r.getX() > this.x) {
/* 41 */               r.setX(this.x + this.bounds.width); continue;
/*    */             } 
/* 43 */             r.setX(this.x - r.bounds.width);
/*    */           } 
/*    */         } 
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 50 */     if (this.switch1.isActivated) {
/* 51 */       this.isActivated = true;
/*    */     } else {
/* 53 */       this.isActivated = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 58 */     if (this.isActivated) {
/* 59 */       g.drawImage(Assets.gateClosed, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), 32, 32, null);
/*    */     } else {
/* 61 */       g.drawImage(Assets.gateOpened, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), 32, 32, null);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setSwitch(Switch switch1) {
/* 66 */     this.switch1 = switch1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\Gate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */