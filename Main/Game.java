 /*     */ package Main;
/*     */ 
/*     */ import Camera.GameCamera;
/*     */ import Input.KeyManager;
/*     */ import Input.MouseManager;
/*     */ import Sounds.Sound;
/*     */ import States.GameState;
/*     */ import States.MenuState;
/*     */ import States.State;
/*     */ import Worlds.World;
/*     */ import gfx.Assets;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.image.BufferStrategy;
/*     */ 
/*     */ public class Game
/*     */   implements Runnable {
/*  20 */   private int width = 640;
/*     */   
/*  22 */   private int height = 320;
/*     */   
/*     */   private Sound main;
/*     */   
/*     */   Display display;
/*     */   
/*     */   private World world;
/*     */   
/*     */   public State gamestate;
/*     */   
/*     */   public State menustate;
/*     */   
/*     */   private KeyManager keymanager;
/*     */   
/*     */   private MouseManager mousemanager;
/*     */   
/*     */   private Handler handler;
/*     */   
/*     */   private GameCamera gamecamera;
/*     */   
/*     */   boolean running;
/*     */   
/*     */   public Game() {
/*  45 */     this.display = new Display("Bounce", this.width, this.height);
/*     */     
/*  47 */     this.keymanager = new KeyManager();
/*     */     
/*  49 */     this.mousemanager = new MouseManager();
/*     */     
/*  51 */     this.display.getCanvas().addMouseListener((MouseListener)this.mousemanager);
/*  52 */     this.display.getCanvas().addMouseMotionListener((MouseMotionListener)this.mousemanager);
/*  53 */     this.display.getJFrame().addKeyListener((KeyListener)this.keymanager);
/*  54 */     this.main = new Sound("/Sounds/Main.wav");
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*  59 */     Assets.init();
/*     */     
/*  61 */     this.handler = new Handler(this);
/*  62 */     this.gamestate = (State)new GameState(this.handler);
/*  63 */     this.menustate = (State)new MenuState(this.handler);
/*     */     
/*  65 */     setGamecamera(new GameCamera(this.handler, 0, 0));
/*     */     
/*  67 */     State.setState(this.menustate);
/*  68 */     this.main.clip.loop(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void start() {
/*  73 */     this.running = true;
/*  74 */     (new Thread(this)).start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/*  78 */     this.running = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/*  83 */     this.keymanager.tick();
/*     */     
/*  85 */     if (State.getState() != null) {
/*  86 */       State.getState().tick();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render() {
/*  98 */     BufferStrategy bs = this.display.canvas.getBufferStrategy();
/*  99 */     if (bs == null) {
/*     */       
/* 101 */       this.display.canvas.createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 104 */     Graphics g = bs.getDrawGraphics();
/* 105 */     g.clearRect(0, 0, this.display.getJFrame().getWidth(), this.display.getJFrame().getHeight());
/* 106 */     State.getState().render(g);
/* 107 */     bs.show();
/* 108 */     g.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/* 113 */     init();
/* 114 */     long lastTimer = System.currentTimeMillis();
/* 115 */     long lastTime = System.nanoTime();
/*     */     
/* 117 */     double nsPerTick = 1.6666666E7D;
/*     */     
/* 119 */     double delta = 0.0D;
/*     */     
/* 121 */     int ticks = 0, frames = 0;
/*     */     
/* 123 */     while (this.running) {
/*     */       
/* 125 */       long now = System.nanoTime();
/* 126 */       delta += (now - lastTime) / nsPerTick;
/* 127 */       lastTime = now;
/* 128 */       while (delta > 1.0D) {
/*     */         
/* 130 */         tick();
/* 131 */         ticks++;
/* 132 */         delta--;
/*     */       } 
/*     */       try {
/* 135 */         Thread.sleep(2L);
/* 136 */       } catch (Exception e) {
/*     */         
/* 138 */         e.printStackTrace();
/*     */       } 
/* 140 */       render();
/* 141 */       frames++;
/* 142 */       if (System.currentTimeMillis() - lastTimer >= 1000L) {
/*     */         
/* 144 */         System.out.println("Ticks = " + ticks + " Frames = " + frames);
/* 145 */         lastTimer += 1000L;
/* 146 */         ticks = 0;
/* 147 */         frames = 0;
/*     */       } 
/*     */     } 
/* 150 */     stop();
/*     */   }
/*     */   
/*     */   public static void main(String[] agrs) {
/* 154 */     (new Game()).start();
/*     */   }
/*     */   
/*     */   public World getWorld() {
/* 158 */     return this.world;
/*     */   }
/*     */   
/*     */   public KeyManager getKeymanager() {
/* 162 */     return this.keymanager;
/*     */   }
/*     */   public int getWidth() {
/* 165 */     return this.width;
/*     */   }
/*     */   
/*     */   public void setWidth(int width) {
/* 169 */     this.width = width;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 173 */     return this.height;
/*     */   }
/*     */   
/*     */   public void setHeight(int height) {
/* 177 */     this.height = height;
/*     */   }
/*     */   
/*     */   public GameCamera getGamecamera() {
/* 181 */     return this.gamecamera;
/*     */   }
/*     */   
/*     */   public void setGamecamera(GameCamera gamecamera) {
/* 185 */     this.gamecamera = gamecamera;
/*     */   }
/*     */   
/*     */   public MouseManager getMouseManager() {
/* 189 */     return this.mousemanager;
/*     */   }
/*     */ 
/*     */   
/*     */   public Display getDisplay() {
/* 194 */     return this.display;
/*     */   }
/*     */ }


/* Location:              C:\Users\Sayan Bhattacharya\Downloads\Bounce.jar!\Main\Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */