/*    */ package Entities;
/*    */ 
/*    */ import Main.Handler;
/*    */ 
/*    */ public abstract class Creature
/*    */   extends Entity
/*    */ {
/*    */   protected static final int DEFAULT_WIDTH = 32;
/*    */   protected static final int DEFAULT_HEIGHT = 32;
/*    */   protected static final float SPEED = 3.0F;
/*    */   protected float speed;
/*    */   
/*    */   public Creature(Handler handler, float x, float y, int width, int height) {
/* 14 */     super(handler, x, y, width, height);
/* 15 */     this.speed = 3.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\Creature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */