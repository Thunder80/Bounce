/*    */ package gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ImageLoader
/*    */ {
/*    */   public static BufferedImage image;
/*    */   
/*    */   public static BufferedImage load(String path) {
/*    */     try {
/* 15 */       image = ImageIO.read(ImageLoader.class.getResource(path));
/* 16 */     } catch (IOException e) {
/* 17 */       e.printStackTrace();
/*    */     } 
/* 19 */     return image;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\gfx\ImageLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */