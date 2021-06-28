/*    */ package Worlds;
/*    */ 
/*    */ import Entities.Player;
/*    */ import Main.Handler;
/*    */ import gfx.Tiles.Tile;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ public class World
/*    */ {
/*    */   public int[][] map;
/*    */   public int height;
/*    */   public int width;
/*    */   private Handler handler;
/*    */   public int orbsPresent;
/*    */   public static boolean gameOver = false;
/*    */   public static boolean victory;
/*    */   public int spawnx;
/*    */   public int spawny;
/*    */   
/*    */   public World(String path, Handler handler) {
/* 22 */     loadWorld(path);
/* 23 */     this.handler = handler;
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 28 */     if (Player.life < 1) {
/* 29 */       gameOver = true;
/*    */     }
/* 31 */     int xStart = (int)Math.max(0.0F, (this.handler.getGame().getGamecamera()).xOffset / 32.0F);
/* 32 */     int xEnd = (int)Math.min(this.width, ((this.handler.getGame().getGamecamera()).xOffset + this.handler.getGame().getWidth()) / 32.0F + 1.0F);
/* 33 */     int yStart = (int)Math.max(0.0F, (this.handler.getGame().getGamecamera()).yOffset / 32.0F);
/* 34 */     int yEnd = (int)Math.min(this.height, ((this.handler.getGame().getGamecamera()).yOffset + this.handler.getGame().getHeight()) / 32.0F + 1.0F);
/* 35 */     for (int y = yStart; y < yEnd; y++) {
/*    */       
/* 37 */       for (int x = xStart; x < xEnd; x++)
/*    */       {
/* 39 */         getTile(x, y).tick();
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Graphics g) {
/* 46 */     int xStart = (int)Math.max(0.0F, (this.handler.getGame().getGamecamera()).xOffset / 32.0F);
/* 47 */     int xEnd = (int)Math.min(this.width, ((this.handler.getGame().getGamecamera()).xOffset + this.handler.getGame().getWidth()) / 32.0F + 1.0F);
/* 48 */     int yStart = (int)Math.max(0.0F, (this.handler.getGame().getGamecamera()).yOffset / 32.0F);
/* 49 */     int yEnd = (int)Math.min(this.height, ((this.handler.getGame().getGamecamera()).yOffset + this.handler.getGame().getHeight()) / 32.0F + 1.0F);
/* 50 */     for (int y = yStart; y < yEnd; y++) {
/*    */       
/* 52 */       for (int x = xStart; x < xEnd; x++)
/*    */       {
/* 54 */         getTile(x, y).render(g, (int)((x * 32) - (this.handler.getGame().getGamecamera()).xOffset), (int)((y * 32) - (this.handler.getGame().getGamecamera()).yOffset));
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Tile getTile(int x, int y) {
/* 61 */     Tile t = Tile.tiles[this.map[x][y]];
/* 62 */     if (t == null)
/* 63 */       return Tile.skytile; 
/* 64 */     return t;
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadWorld(String path) {
/* 69 */     String file = LevelUtils.loadFileAsString(path);
/* 70 */     String[] tokens = file.split("\\s+");
/* 71 */     int lenght = tokens.length;
/* 72 */     this.width = LevelUtils.parseInt(tokens[lenght - 2]);
/* 73 */     this.height = LevelUtils.parseInt(tokens[lenght - 1]);
/* 74 */     this.spawnx = LevelUtils.parseInt(tokens[lenght - 4]);
/* 75 */     this.spawny = LevelUtils.parseInt(tokens[lenght - 3]);
/* 76 */     this.orbsPresent = LevelUtils.parseInt(tokens[lenght - 5]);
/* 77 */     this.map = new int[this.width][this.height];
/* 78 */     for (int y = 0; y < this.height; y++) {
/*    */       
/* 80 */       for (int x = 0; x < this.width; x++)
/*    */       {
/* 82 */         this.map[x][y] = LevelUtils.parseInt(tokens[x + this.width * y]);
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Worlds\World.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */