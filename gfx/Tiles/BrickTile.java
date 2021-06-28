/*    */ package gfx.Tiles;
/*    */ 
/*    */ import gfx.Assets;
/*    */ 
/*    */ public class BrickTile
/*    */   extends Tile
/*    */ {
/*    */   public BrickTile(int id) {
/*  9 */     super(Assets.brick, id);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSolid() {
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\gfx\Tiles\BrickTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */