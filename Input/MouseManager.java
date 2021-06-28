/*    */ package Input;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import java.awt.event.MouseMotionListener;
/*    */ 
/*    */ public class MouseManager
/*    */   implements MouseListener, MouseMotionListener
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   public boolean clicking;
/*    */   
/*    */   public int getX() {
/* 15 */     return this.x;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getY() {
/* 20 */     return this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {
/* 25 */     this.clicking = true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mousePressed(MouseEvent e) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {
/* 45 */     this.clicking = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseDragged(MouseEvent e) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseMoved(MouseEvent e) {
/* 55 */     this.x = e.getX();
/* 56 */     this.y = e.getY();
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Input\MouseManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */