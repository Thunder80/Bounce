/*    */ package Worlds;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ 
/*    */ public class LevelUtils
/*    */ {
/*    */   public static String loadFileAsString(String path) {
/* 10 */     StringBuilder builder = new StringBuilder();
/*    */     
/*    */     try {
/* 13 */       BufferedReader br = new BufferedReader(new InputStreamReader(LevelUtils.class.getResourceAsStream(path)));
/*    */       String line;
/* 15 */       while ((line = br.readLine()) != null) {
/* 16 */         builder.append(String.valueOf(line) + "\n");
/*    */       }
/* 18 */       br.close();
/* 19 */     } catch (IOException e) {
/* 20 */       e.printStackTrace();
/*    */     } 
/* 22 */     return builder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public static int parseInt(String num) {
/*    */     try {
/* 28 */       return Integer.parseInt(num);
/* 29 */     } catch (NumberFormatException e) {
/*    */       
/* 31 */       e.printStackTrace();
/* 32 */       return 0;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Worlds\LevelUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */