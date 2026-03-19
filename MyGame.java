import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class MyGame extends Game  {
    
        public static final String TITLE = "Card Game";
        public static final int SCREEN_WIDTH = 1200;
        public static final int SCREEN_HEIGHT = 800;

        int cardX, cardY, cardWidth, cardHeight;
        Card card;
		
	public MyGame() {
                cardX = 100;
                cardY = 100;
                cardWidth = 100;
                cardHeight = 100;
                card = new Card(cardX, cardY, cardWidth, cardHeight);
        }
        

	public void update() {

        }
	
	public void draw(Graphics pen) {    
                pen.setFont(new Font("Arial",1,20));
                pen.setColor(Color.BLACK);
                pen.drawString(TITLE, (SCREEN_WIDTH / 2) - (pen.getFontMetrics().stringWidth(TITLE) / 2), 50);
                card.draw(pen);
        }
        
    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {}

    @Override
    public void mouseClicked(MouseEvent ke) { }

    @Override
    public void mousePressed(MouseEvent me) {}
    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}

    @Override
    public void mouseDragged(MouseEvent arg0) {}


    @Override
    public void mouseMoved(MouseEvent arg0) {}
        
        
    //Launches the Game
    public static void main(String[] args) { new MyGame().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT); }
}