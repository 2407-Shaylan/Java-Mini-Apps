package Snake_Game;

import java.awt.*;
import javax.swing.JPanel;


public class Application extends JPanel
{

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Snake snake = Snake.snake;

        g.setColor(Color.BLACK);                           /*Color and size of the background*/
        g.fillRect(0, 0, 900, 900);   /*Color and size of the background*/
        g.setColor(Color.BLUE);                          /*Color of the snake*/

        for (Point point : snake.snakeParts)
        {
            g.fillRect(point.x * Snake.SCALE, point.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
        }
        g.fillRect(snake.head.x * Snake.SCALE, snake.head.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
        g.setColor(Color.RED); /*Color of the apple*/
        g.fillRect(snake.apple.x * Snake.SCALE, snake.apple.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
        String string = "Your Score: " + snake.score + "  ||  " + "Time Taken: " + snake.time / 20 + "s";
        g.setColor(Color.white); /*Color of text on top*/
        g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);

        string = "Game Over!, Press the space-bar to try again! ";

        if (snake.over)
        {
            g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
        }

        string = "Game Paused!";

        if (snake.paused && !snake.over)
        {
            g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
        }
    }
}