/*    */ package States;
/*    */ 
/*    */ import Main.Handler;
/*    */ import Sounds.Sound;
/*    */ import gfx.Assets;
/*    */ import gfx.ImageLoader;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class MenuState
/*    */   extends State
/*    */ {
/*    */   BufferedImage menuImage;
/*    */   boolean playBox;
/*    */   boolean info;
/*    */   private Sound select;
/*    */   
/*    */   public MenuState(Handler handler) {
/* 19 */     super(handler);
/* 20 */     this.menuImage = ImageLoader.load("/bounceMenu.png");
/* 21 */     this.select = new Sound("/Sounds/select.wav");
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 26 */     if (this.handler.getGame().getMouseManager().getX() >= 256 && this.handler.getGame().getMouseManager().getX() <= 384 && this.handler.getGame().getMouseManager().getY() >= 128 && this.handler.getGame().getMouseManager().getY() <= 192) {
/*    */       
/* 28 */       this.playBox = true;
/*    */     } else {
/*    */       
/* 31 */       this.playBox = false;
/* 32 */     }  if (this.playBox && (this.handler.getGame().getMouseManager()).clicking) {
/*    */       
/* 34 */       setState((this.handler.getGame()).gamestate);
/* 35 */       this.select.clip.start();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 41 */     g.drawImage(this.menuImage, 0, 0, null);
/* 42 */     if (!this.playBox) {
/* 43 */       g.drawImage(Assets.playBox, 256, 128, 128, 64, null);
/*    */     } else {
/* 45 */       g.drawImage(Assets.playBox2, 256, 128, 128, 64, null);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\States\MenuState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */