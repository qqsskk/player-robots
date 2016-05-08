package player;

public interface Inputs {
    int shoot1();
    int shoot2();
    int shoot3();

    int moveLeft();
    int moveRight();
    int moveUp();
    int moveDown();
    int moveUpLeft();
    int moveUpRight();
    int moveDownLeft();
    int moveDownRight();

    int rotateGun0Deg();
    int rotateGun45Deg();
    int rotateGun90Deg();
    int rotateGun135Deg();
    int rotateGun180Deg();
    int rotateGun225Deg();
    int rotateGun270Deg();
    int rotateGun315Deg();

    int changeMoveMode();
    int goBackward();
    int goForward();
    int moveGunWithBody();
}
