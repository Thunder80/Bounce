/*    */ package Sounds;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.sound.sampled.AudioInputStream;
/*    */ import javax.sound.sampled.AudioSystem;
/*    */ import javax.sound.sampled.Clip;
/*    */ import javax.sound.sampled.LineUnavailableException;
/*    */ import javax.sound.sampled.UnsupportedAudioFileException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Sound
/*    */ {
/*    */   public Clip clip;
/*    */   
/*    */   public Sound(String path) {
/*    */     try {
/* 19 */       AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResource(path));
/* 20 */       this.clip = AudioSystem.getClip();
/* 21 */       this.clip.open(ais);
/*    */     }
/* 23 */     catch (UnsupportedAudioFileException e) {
/* 24 */       e.printStackTrace();
/* 25 */     } catch (IOException e) {
/* 26 */       e.printStackTrace();
/* 27 */     } catch (LineUnavailableException e) {
/* 28 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Sounds\Sound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */