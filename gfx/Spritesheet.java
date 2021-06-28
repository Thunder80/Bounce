/*    */ package gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ public class Spritesheet
/*    */ {
/*    */   private BufferedImage image;
/*    */   
/*    */   public Spritesheet(BufferedImage image) {
/* 11 */     this.image = image;
/*    */   }
/*    */ 
/*    */   
/*    */   public BufferedImage crop(int x, int y, int width, int height) {
/* 16 */     return this.image.getSubimage(x, y, width, height);
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\gfx\Spritesheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */