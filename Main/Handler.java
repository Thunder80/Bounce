/*    */ package Main;
/*    */ 
/*    */ import Entities.Player;
/*    */ import Worlds.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Handler
/*    */ {
/*    */   private Game game;
/*    */   private World world;
/*    */   private Player player;
/*    */   
/*    */   public Handler(Game game) {
/* 16 */     this.game = game;
/*    */   }
/*    */ 
/*    */   
/*    */   public Game getGame() {
/* 21 */     return this.game;
/*    */   }
/*    */   
/*    */   public World getWorld() {
/* 25 */     return this.world;
/*    */   }
/*    */   
/*    */   public void setWorld(World world) {
/* 29 */     this.world = world;
/*    */   }
/*    */ 
/*    */   
/*    */   public Player getPlayer() {
/* 34 */     return this.player;
/*    */   }
/*    */   
/*    */   public void setPlayer(Player player) {
/* 38 */     this.player = player;
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Main\Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */