/*    */ package Entities;
/*    */ 
/*    */ import Main.Handler;
/*    */ import Sounds.Sound;
/*    */ import gfx.Assets;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ public class Orb
/*    */   extends StaticCreature
/*    */ {
/*    */   private Sound orbs;
/*    */   
/*    */   public Orb(Handler handler, float x, float y) {
/* 15 */     super(handler, x, y);
/* 16 */     this.orbs = new Sound("/Sounds/orbs.wav");
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 21 */     if (this.handler.getPlayer().isCollided(this)) {
/*    */       
/* 23 */       if (!this.isActivated) {
/*    */         
/* 25 */         Player.orbsCollected++;
/* 26 */         this.orbs.clip.start();
/* 27 */         this.orbs.clip.setFramePosition(0);
/*    */       } 
/* 29 */       this.isActivated = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 36 */     if (!this.isActivated) {
/*    */       
/* 38 */       g.drawImage(Assets.orbr, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), 32, 32, null);
/*    */     }
/*    */     else {
/*    */       
/* 42 */       g.drawImage(Assets.orbg, (int)(this.x - (this.handler.getGame().getGamecamera()).xOffset), (int)(this.y - (this.handler.getGame().getGamecamera()).yOffset), 32, 32, null);
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean getisActivated() {
/* 47 */     return this.isActivated;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\Orb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */