import java.awt.event.KeyEvent;

public class KeyHandler implements java.awt.event.KeyListener {
    Player player;
    public KeyHandler(Player player) {
        this.player = player;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: player.moveLeft(); break;
            case KeyEvent.VK_RIGHT: player.moveRight(); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
