/*    */ package gfx.Tiles;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Tile
/*    */ {
/*    */   public BufferedImage texture;
/*    */   public final int id;
/* 12 */   public static Tile[] tiles = new Tile[16];
/*    */ 
/*    */   
/*    */   public static final int TILEHEIGHT = 32;
/*    */   
/*    */   public static final int TILEWIDTH = 32;
/*    */   
/* 19 */   public static Tile bricktile = new BrickTile(0);
/* 20 */   public static Tile skytile = new SkyTile(1);
/* 21 */   public static Tile spiketile = new SpikeTile(2);
/*    */ 
/*    */ 
/*    */   
/*    */   public Tile(BufferedImage texture, int id) {
/* 26 */     this.id = id;
/* 27 */     this.texture = texture;
/*    */     
/* 29 */     tiles[id] = this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void tick() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Graphics g, int x, int y) {
/* 39 */     g.drawImage(this.texture, x, y, 32, 32, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSolid() {
/* 44 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\gfx\Tiles\Tile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */