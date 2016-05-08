package player;

import static java.awt.event.KeyEvent.*;

// A B C D E F N Q R S T U V W Y X Z , 2 7 8 9 0
public class Player1Inputs implements Inputs {
    @Override
    public int shoot1() {
        return VK_T;
    }

    @Override
    public int shoot2() {
        return VK_Y;
    }

    @Override
    public int shoot3() {
        return VK_U;
    }

    @Override
    public int moveLeft() {
        return VK_A;
    }

    @Override
    public int moveRight() {
        return VK_D;
    }

    @Override
    public int moveUp() {
        return VK_UP;
    }

    @Override
    public int moveDown() {
        return VK_DOWN;
    }

    @Override
    public int moveUpLeft() {
        return VK_7;
    }

    @Override
    public int moveUpRight() {
        return VK_8;
    }

    @Override
    public int moveDownLeft() {
        return VK_9;
    }

    @Override
    public int moveDownRight() {
        return VK_0;
    }

    @Override
    public int rotateGun0Deg() {
        return VK_Z;
    }

    @Override
    public int rotateGun45Deg() {
        return VK_E;
    }

    @Override
    public int rotateGun90Deg() {
        return VK_X;
    }

    @Override
    public int rotateGun135Deg() {
        return VK_F;
    }

    @Override
    public int rotateGun180Deg() {
        return VK_C;
    }

    @Override
    public int rotateGun225Deg() {
        return VK_R;
    }

    @Override
    public int rotateGun270Deg() {
        return VK_V;
    }

    @Override
    public int rotateGun315Deg() {
        return VK_COMMA;
    }

    @Override
    public int changeMoveMode() {
        return VK_Q;
    }

    @Override
    public int goBackward() {
        return VK_B;
    }

    @Override
    public int goForward() {
        return VK_N;
    }

    @Override
    public int moveGunWithBody() {
        return VK_2;
    }
}
