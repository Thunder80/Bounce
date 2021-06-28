/*    */ package Input;
/*    */ 
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeyManager
/*    */   implements KeyListener
/*    */ {
/* 14 */   public boolean[] keys = new boolean[256]; public boolean up;
/*    */   public boolean right;
/*    */   public boolean left;
/*    */   
/*    */   public void tick() {
/* 19 */     this.up = this.keys[87];
/* 20 */     this.right = this.keys[68];
/* 21 */     this.left = this.keys[65];
/* 22 */     this.enter = this.keys[32];
/* 23 */     this.mainmenu = this.keys[10];
/* 24 */     this.reset = this.keys[8];
/*    */   }
/*    */   public boolean enter; public boolean mainmenu; public boolean reset;
/*    */   
/*    */   public void keyPressed(KeyEvent e) {
/* 29 */     this.keys[e.getKeyCode()] = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 34 */     this.keys[e.getKeyCode()] = false;
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Input\KeyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */