import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Game implements KeyListener, MouseListener, MouseMotionListener
{
    private JFrame frame;
    private GamePanel gamePanel;
    private boolean running;
    private MyGame game;  
    private long startTime, previousTime;
    protected long elapsedTime;
    protected double deltaTime;  

    protected void start(String title, int width, int height)
    {
    	this.game = (MyGame)this;
    	running = true;
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
        startTime = System.currentTimeMillis(); 
        previousTime = System.nanoTime(); 
        run();
    }


    class GamePanel extends JPanel
    {
        private static final long serialVersionUID = 1L;
        @Override
        public void paintComponent(Graphics g) { 
            super.paintComponent(g);
            game.draw(g); 
        }
    }

    private void run()
    {
        
        Thread gameThread = new Thread(() -> {
            while (running) {
                elapsedTime = System.currentTimeMillis() - startTime;
                long currentTime = System.nanoTime();
                deltaTime = (currentTime - previousTime) / 1_000_000_000.0;
                previousTime = currentTime;

                game.update();

                gamePanel.repaint(); // repaint the panel, not the frame


            }
        });
        gameThread.start();
    }
}