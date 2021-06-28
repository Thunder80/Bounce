/*    */ package gfx.Tiles;
/*    */ 
/*    */ import gfx.Assets;
/*    */ 
/*    */ public class SpikeTile
/*    */   extends Tile {
/*    */   public SpikeTile(int id) {
/*  8 */     super(Assets.spike, id);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSolid() {
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\gfx\Tiles\SpikeTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */