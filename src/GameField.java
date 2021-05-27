import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320;
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 441;
    private Image dot;
    private Image apple;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;


    public GameField() {
        setBackground(Color.white);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 0;
            y[i] = 0;
        }
        timer = new Timer(100, this);
        timer.start();
        createApple();
    }

    public void createApple() {
        appleX = new Random().nextInt(20) * DOT_SIZE;
        appleY = new Random().nextInt(20) * DOT_SIZE;
    }

    public void loadImages() {
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot, x[i], y[i], this);
            }
        } else {
            String str = "Game Over. Your score: " + dots;
            g.setColor(Color.BLACK);
            g.drawString(str, 95, SIZE / 2);
        }
    }

    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left) {
            x[0] -= DOT_SIZE;
        }
        if (right) {
            x[0] += DOT_SIZE;
        }
        if (up) {
            y[0] -= DOT_SIZE;
        }
        if (down) {
            y[0] += DOT_SIZE;
        }
    }

    public void linearMove() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (x[0] < appleX && x[0] != appleX && x[0] + DOT_SIZE != x[1]) {
            x[0] += DOT_SIZE;
        } else if (x[0] > appleX && x[0] != appleX) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == appleX) {
            if (y[0] < appleY && y[0] + DOT_SIZE != y[1]) {
                y[0] += DOT_SIZE;
            } else if (y[0] > appleY) {
                y[0] -= DOT_SIZE;
            } else x[0] += DOT_SIZE;
        } else if (x[0] - DOT_SIZE != x[1]) {
            y[0] += DOT_SIZE;
        }
    }

    public void hamiltonCycleMove() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (x[0] > DOT_SIZE * 0 && y[0] == DOT_SIZE * 0 && x[0] <= DOT_SIZE * 4) {    //влево 288:16
            x[0] -= DOT_SIZE;
        } else if (x[0] == 0 && y[0] < SIZE) {
            y[0] += DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 20) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 20) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE && y[0] == DOT_SIZE * 19) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE && y[0] > DOT_SIZE) {
            y[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE && y[0] == DOT_SIZE) {
            x[0] += DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 2 && y[0] < DOT_SIZE * 18) {
            y[0] += DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 18) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 18) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 3 && y[0] == DOT_SIZE * 17) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 3 && y[0] == DOT_SIZE * 17) {
            y[0] -= DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 16) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 16) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 3 && y[0] == DOT_SIZE * 15) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 3 && y[0] == DOT_SIZE * 15) {
            y[0] -= DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 14) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 14) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 3 && y[0] == DOT_SIZE * 13) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 3 && y[0] == DOT_SIZE * 13) {
            y[0] -= DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 12) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 12) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 3 && y[0] == DOT_SIZE * 11) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 3 && y[0] == DOT_SIZE * 11) {
            y[0] -= DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 10) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 10) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 3 && y[0] == DOT_SIZE * 9) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 3 && y[0] == DOT_SIZE * 9) {
            y[0] -= DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 8) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 8) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 3 && y[0] == DOT_SIZE * 7) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 3 && y[0] == DOT_SIZE * 7) {
            y[0] -= DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 6) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 6) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 3 && y[0] == DOT_SIZE * 5) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 3 && y[0] == DOT_SIZE * 5) {
            y[0] -= DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 4) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 4) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 3 && y[0] == DOT_SIZE * 3) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 3 && y[0] == DOT_SIZE * 3) {
            y[0] -= DOT_SIZE;
        } else if (x[0] < SIZE && y[0] == DOT_SIZE * 2) {
            x[0] += DOT_SIZE;
        } else if (x[0] == SIZE && y[0] == DOT_SIZE * 2) {
            y[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 20 && y[0] > DOT_SIZE * 0) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 19 && y[0] == DOT_SIZE * 0) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 19 && y[0] == DOT_SIZE * 0) {
            y[0] += DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 19 && y[0] == DOT_SIZE * 1) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 18 && y[0] == DOT_SIZE * 1) {
            y[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 18 && y[0] == DOT_SIZE * 0) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 17 && y[0] == DOT_SIZE * 0) {
            y[0] += DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 17 && y[0] == DOT_SIZE * 1) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 16 && y[0] == DOT_SIZE * 1) {
            y[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 16 && y[0] == DOT_SIZE * 0) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 15 && y[0] == DOT_SIZE * 0) {
            y[0] += DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 15 && y[0] == DOT_SIZE * 1) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 14 && y[0] == DOT_SIZE * 1) {
            y[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 14 && y[0] == DOT_SIZE * 0) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 13 && y[0] == DOT_SIZE * 0) {
            y[0] += DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 13 && y[0] == DOT_SIZE * 1) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 12 && y[0] == DOT_SIZE * 1) {
            y[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 12 && y[0] == DOT_SIZE * 0) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 11 && y[0] == DOT_SIZE * 0) {
            y[0] += DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 11 && y[0] == DOT_SIZE * 1) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 10 && y[0] == DOT_SIZE * 1) {
            y[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 10 && y[0] == DOT_SIZE * 0) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 9 && y[0] == DOT_SIZE * 0) {
            y[0] += DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 9 && y[0] == DOT_SIZE * 1) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 8 && y[0] == DOT_SIZE * 1) {
            y[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 8 && y[0] == DOT_SIZE * 0) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 7 && y[0] == DOT_SIZE * 0) {
            y[0] += DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 7 && y[0] == DOT_SIZE * 1) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 6 && y[0] == DOT_SIZE * 1) {
            y[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 6 && y[0] == DOT_SIZE * 0) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 5 && y[0] == DOT_SIZE * 0) {
            y[0] += DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 5 && y[0] == DOT_SIZE * 1) {
            x[0] -= DOT_SIZE;
        } else if (x[0] == DOT_SIZE * 4 && y[0] == DOT_SIZE * 1) {
            y[0] -= DOT_SIZE;
        } else if (x[0] > DOT_SIZE * 0 && y[0] == DOT_SIZE * 0) {
            x[0] -= DOT_SIZE;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            dots++;
            createApple();
        }
    }

    public void checkCollisions() {
        for (int i = dots; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }
        }

        if (x[0] > SIZE) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }
        if (y[0] > SIZE) {
            inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollisions();
            linearMove();
        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
            }

            if (key == KeyEvent.VK_UP && !down) {
                right = false;
                up = true;
                left = false;
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                right = false;
                down = true;
                left = false;
            }
        }


    }
}
