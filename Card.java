import java.awt.Graphics;

public class Card {
    private String image;
    private int roll, x, y, width, height;

    public Card(int x, int y, int width, int height){
        this.x = x;
        this.y =y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics pen) {
        pen.fillRect(x,y,width,height);
    }
}
