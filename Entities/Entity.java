/*    */ package Entities;
/*    */ 
/*    */ import Main.Handler;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public abstract class Entity {
/*    */   protected int width;
/*    */   protected int height;
/*    */   protected Rectangle bounds;
/*    */   protected float x;
/*    */   protected float y;
/*    */   protected Handler handler;
/*    */   
/*    */   public int getWidth() {
/* 16 */     return this.width;
/*    */   }
/*    */   
/*    */   public void setWidth(int width) {
/* 20 */     this.width = width;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 24 */     return this.height;
/*    */   }
/*    */   
/*    */   public void setHeight(int height) {
/* 28 */     this.height = height;
/*    */   }
/*    */   
/*    */   public float getX() {
/* 32 */     return this.x;
/*    */   }
/*    */   
/*    */   public void setX(float x) {
/* 36 */     this.x = x;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 40 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setY(float y) {
/* 44 */     this.y = y;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Entity(Handler handler, float x, float y, int width, int height) {
/* 53 */     this.x = x;
/* 54 */     this.y = y;
/* 55 */     this.width = width;
/* 56 */     this.height = height;
/* 57 */     this.handler = handler;
/* 58 */     this.bounds = new Rectangle(0, 0, width, height);
/*    */   }
/*    */   
/*    */   public abstract void tick();
/*    */   
/*    */   public abstract void render(Graphics paramGraphics);
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Entities\Entity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */