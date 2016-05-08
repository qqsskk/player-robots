package player;

import static java.awt.event.KeyEvent.*;

// G H I J K L M O P setas . = / \ 1 3 4 5 6
public class Player2Inputs implements Inputs {
    @Override
    public int shoot1() {
        return VK_I;
    }

    @Override
    public int shoot2() {
        return VK_O;
    }

    @Override
    public int shoot3() {
        return VK_P;
    }

    @Override
    public int moveLeft() {
        return VK_LEFT;
    }

    @Override
    public int moveRight() {
        return VK_RIGHT;
    }

    @Override
    public int moveUp() {
        return VK_W;
    }

    @Override
    public int moveDown() {
        return VK_S;
    }

    @Override
    public int moveUpLeft() {
        return VK_3;
    }

    @Override
    public int moveUpRight() {
        return VK_4;
    }

    @Override
    public int moveDownLeft() {
        return VK_5;
    }

    @Override
    public int moveDownRight() {
        return VK_6;
    }

    @Override
    public int rotateGun0Deg() {
        return VK_G;
    }

    @Override
    public int rotateGun45Deg() {
        return VK_PERIOD;
    }

    @Override
    public int rotateGun90Deg() {
        return VK_H;
    }

    @Override
    public int rotateGun135Deg() {
        return VK_EQUALS;
    }

    @Override
    public int rotateGun180Deg() {
        return VK_J;
    }

    @Override
    public int rotateGun225Deg() {
        return VK_SLASH;
    }

    @Override
    public int rotateGun270Deg() {
        return VK_K;
    }

    @Override
    public int rotateGun315Deg() {
        return VK_BACK_SLASH;
    }

    @Override
    public int changeMoveMode() {
        return VK_M;
    }

    @Override
    public int goBackward() {
        return VK_L;
    }

    @Override
    public int goForward() {
        return VK_P;
    }

    @Override
    public int moveGunWithBody() {
        return VK_1;
    }
}
