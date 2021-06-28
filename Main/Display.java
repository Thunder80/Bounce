/*    */ package Main;
/*    */ 
/*    */ import java.awt.Canvas;
/*    */ import java.awt.Component;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Display
/*    */ {
/*    */   JFrame frame;
/*    */   Canvas canvas;
/*    */   String title;
/*    */   int width;
/*    */   int height;
/*    */   
/*    */   public Display(String title, int width, int height) {
/* 19 */     this.title = title;
/* 20 */     this.width = width;
/* 21 */     this.height = height;
/* 22 */     createDisplay();
/*    */   }
/*    */ 
/*    */   
/*    */   private void createDisplay() {
/* 27 */     this.frame = new JFrame(this.title);
/* 28 */     this.frame.setSize(new Dimension(this.width, this.height));
/* 29 */     this.frame.setLocationRelativeTo((Component)null);
/* 30 */     this.frame.setResizable(false);
/* 31 */     this.frame.setFocusable(true);
/* 32 */     this.frame.setVisible(true);
/* 33 */     this.frame.setDefaultCloseOperation(3);
/*    */     
/* 35 */     this.canvas = new Canvas();
/* 36 */     this.canvas.setMinimumSize(new Dimension(this.width, this.height));
/* 37 */     this.canvas.setMaximumSize(new Dimension(this.width, this.height));
/* 38 */     this.canvas.setPreferredSize(new Dimension(this.width, this.height));
/* 39 */     this.canvas.setFocusable(false);
/*    */     
/* 41 */     this.frame.add(this.canvas);
/* 42 */     this.frame.pack();
/*    */   }
/*    */ 
/*    */   
/*    */   public JFrame getJFrame() {
/* 47 */     return this.frame;
/*    */   }
/*    */   
/*    */   public Canvas getCanvas() {
/* 51 */     return this.canvas;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Main\Display.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */