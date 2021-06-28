/*    */ package gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ public class Assets
/*    */ {
/*    */   static Spritesheet sheet;
/*  9 */   private static int width = 16;
/*    */   
/* 11 */   private static int height = 16;
/*    */   
/*    */   private static final int tileHeight = 16;
/*    */   private static final int tileWidth = 16;
/*    */   public static BufferedImage stone;
/*    */   public static BufferedImage bullet_right;
/*    */   public static BufferedImage bullet_left;
/*    */   public static BufferedImage cannon;
/*    */   
/*    */   public static void init() {
/* 21 */     sheet = new Spritesheet(ImageLoader.load("/bounceTiles.png"));
/* 22 */     brick = sheet.crop(width * 0, height * 0, 16, 16);
/* 23 */     sky = sheet.crop(width * 1, height * 0, 16, 16);
/* 24 */     player = sheet.crop(width * 2, height * 0, 16, 16);
/* 25 */     spike = sheet.crop(width * 3, height * 0, 16, 16);
/* 26 */     guard = sheet.crop(width * 4, height * 0, 16, 16);
/* 27 */     orbr = sheet.crop(width * 5, height * 0, 16, 16);
/* 28 */     orbg = sheet.crop(width * 6, height * 0, 16, 16);
/* 29 */     doorClosed = sheet.crop(width * 7, height * 0, 16, 16);
/* 30 */     doorOpened = sheet.crop(width * 0, height * 1, 16, 16);
/* 31 */     playBox = sheet.crop(width * 0, height * 2, 64, 48);
/* 32 */     playBox2 = sheet.crop(width * 4, height * 2, 64, 48);
/* 33 */     tutorial = sheet.crop(width, height, 48, 16);
/* 34 */     arrow = sheet.crop(width * 4, height, 16, 16);
/* 35 */     stone = sheet.crop(width * 5, height, 16, 16);
/* 36 */     bullet_left = sheet.crop(width * 7, height, 16, 16);
/* 37 */     bullet_right = sheet.crop(width * 6, height, 16, 16);
/* 38 */     cannon = sheet.crop(width * 0, height * 5, 16, 16);
/* 39 */     gateOpened = sheet.crop(width * 0, height * 5, 16, 16);
/* 40 */     gateClosed = sheet.crop(width * 3, height * 5, 16, 16);
/* 41 */     rock = sheet.crop(width * 1, height * 5, 16, 16);
/* 42 */     switchnp = sheet.crop(width * 2, height * 5, 16, 16);
/* 43 */     switchPressed = sheet.crop(width * 4, height * 5, 16, 16);
/* 44 */     platform = sheet.crop(width * 5, height * 5, 16, 16);
/*    */   }
/*    */   
/*    */   public static BufferedImage gateClosed;
/*    */   public static BufferedImage gateOpened;
/*    */   public static BufferedImage rock;
/*    */   public static BufferedImage switchnp;
/*    */   public static BufferedImage switchPressed;
/*    */   public static BufferedImage platform;
/*    */   public static BufferedImage brick;
/*    */   public static BufferedImage sky;
/*    */   public static BufferedImage player;
/*    */   public static BufferedImage spike;
/*    */   public static BufferedImage guard;
/*    */   public static BufferedImage orbr;
/*    */   public static BufferedImage orbg;
/*    */   public static BufferedImage doorClosed;
/*    */   public static BufferedImage doorOpened;
/*    */   public static BufferedImage playBox;
/*    */   public static BufferedImage playBox2;
/*    */   public static BufferedImage tutorial;
/*    */   public static BufferedImage arrow;
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\gfx\Assets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */