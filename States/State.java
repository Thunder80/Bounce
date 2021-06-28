/*    */ package States;
/*    */ 
/*    */ import Main.Handler;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public abstract class State
/*    */ {
/*  8 */   private static State currentState = null;
/*    */   
/*    */   protected Handler handler;
/*    */   
/*    */   protected boolean menu = true;
/*    */ 
/*    */   
/*    */   public State(Handler handler) {
/* 16 */     this.handler = handler;
/*    */   }
/*    */   
/*    */   public abstract void tick();
/*    */   
/*    */   public abstract void render(Graphics paramGraphics);
/*    */   
/*    */   public static State getState() {
/* 24 */     return currentState;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setState(State state) {
/* 29 */     currentState = state;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\States\State.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */