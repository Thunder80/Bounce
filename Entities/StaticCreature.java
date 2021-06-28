/*    */ package Entities;
/*    */ 
/*    */ import Main.Handler;
/*    */ 
/*    */ public abstract class StaticCreature
/*    */   extends Entity {
/*    */   protected static final int DEFAULTWIDTH = 32;
/*    */   protected static final int DEFAULTHEIGHT = 32;
/*    */   public boolean isActivated = false;
/*    */   
/*    */   public StaticCreature(Handler handler, float x, float y) {
/* 12 */     super(handler, x, y, 32, 32);
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\StaticCreature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */