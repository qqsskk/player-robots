package player;

import robocode.AdvancedRobot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractSimpleGunJoystick extends AdvancedRobot {
    private Helper helper;
    private int firePower;
    private double angle;
    private Inputs inputs;

    private boolean movementMode = false;
    private boolean goBackward = false;
    private boolean goForward = false;
    private boolean moveGunWithBody = false;
    private final Set<Helper.Direction> directions = new HashSet<>();

    //Second mode
    // Move direction: 1 = move forward, 0 = stand still, -1 = move backward
    int moveDirection;
    // Turn direction: 1 = turn right, 0 = no turning, -1 = turn left
    int turnDirection;
    // Amount of pixels/units to move
    double moveAmount;

    public AbstractSimpleGunJoystick(Inputs inputs) {
        this.inputs = inputs;
    }

    private boolean testKeyEquals(int k1, int k2) {
        return k1 == k2;
    }

    boolean ignoreInputUntilReleaseChangeMode = false;
    public void onKeyPressed(KeyEvent e) {
        int current = e.getKeyCode();

        if(!movementMode) {
            if (testKeyEquals(current, inputs.moveUp()))
                directions.add(Helper.Direction.UP);
            else if (testKeyEquals(current, inputs.moveDown()))
                directions.add(Helper.Direction.DOWN);
            else if (testKeyEquals(current, inputs.moveLeft()))
                directions.add(Helper.Direction.LEFT);
            else if (testKeyEquals(current, inputs.moveRight()))
                directions.add(Helper.Direction.RIGHT);
            else if (testKeyEquals(current, inputs.moveUpLeft()))
                directions.add(Helper.Direction.LEFT_UP);
            else if (testKeyEquals(current, inputs.moveUpRight()))
                directions.add(Helper.Direction.RIGHT_UP);
            else if (testKeyEquals(current, inputs.moveDownLeft()))
                directions.add(Helper.Direction.LEFT_DOWN);
            else if (testKeyEquals(current, inputs.moveDownRight()))
                directions.add(Helper.Direction.RIGHT_DOWN);
        } else {
            if (testKeyEquals(current, inputs.moveUp())) {
                moveDirection = 1;
                moveAmount = Double.POSITIVE_INFINITY;
            } else if (testKeyEquals(current, inputs.moveDown())) {
                moveDirection = -1;
                moveAmount = Double.POSITIVE_INFINITY;
            } else if (testKeyEquals(current, inputs.moveLeft()))
                turnDirection = -1;
            else if (testKeyEquals(current, inputs.moveRight()))
                turnDirection = 1;
        }

        if(testKeyEquals(current, inputs.shoot1()))
            firePower = 1;
        else if(testKeyEquals(current, inputs.shoot2()))
            firePower = 2;
        else if(testKeyEquals(current, inputs.shoot3()))
            firePower = 3;

        if(testKeyEquals(current, inputs.changeMoveMode()) && !ignoreInputUntilReleaseChangeMode) {
            movementMode = !movementMode;
            ignoreInputUntilReleaseChangeMode = true;
        }

        if(testKeyEquals(current, inputs.goBackward()))
            goBackward = true;
        if(testKeyEquals(current, inputs.goForward()))
            goForward = true;

        double dirX, dirY;
        if(testKeyEquals(current, inputs.rotateGun0Deg())) {
            dirX = Math.cos(0);
            dirY = Math.sin(0);
            setTurnGunRightRadians(helper.getAngleToRotateGun(dirX, dirY));
            moveGunWithBody = true;
        } else if(testKeyEquals(current, inputs.rotateGun90Deg())) {
            dirX = Math.cos(Math.PI / 2);
            dirY = Math.sin(Math.PI / 2);
            setTurnGunRightRadians(helper.getAngleToRotateGun(dirX, dirY));
            moveGunWithBody = true;
        } else if(testKeyEquals(current, inputs.rotateGun180Deg())) {
            dirX = Math.cos(Math.PI);
            dirY = Math.sin(Math.PI);
            setTurnGunRightRadians(helper.getAngleToRotateGun(dirX, dirY));
            moveGunWithBody = true;
        } else if(testKeyEquals(current, inputs.rotateGun270Deg())) {
            dirX = Math.cos(Math.PI + Math.PI / 2);
            dirY = Math.sin(Math.PI + Math.PI / 2);
            setTurnGunRightRadians(helper.getAngleToRotateGun(dirX, dirY));
            moveGunWithBody = true;
        } else if(testKeyEquals(current, inputs.rotateGun45Deg())) {
            dirX = Math.cos(Math.PI / 4);
            dirY = Math.sin(Math.PI / 4);
            setTurnGunRightRadians(helper.getAngleToRotateGun(dirX, dirY));
            moveGunWithBody = true;
        } else if(testKeyEquals(current, inputs.rotateGun135Deg())) {
            dirX = Math.cos(Math.PI / 2 + Math.PI / 4);
            dirY = Math.sin(Math.PI / 2 + Math.PI / 4);
            setTurnGunRightRadians(helper.getAngleToRotateGun(dirX, dirY));
            moveGunWithBody = true;
        } else if(testKeyEquals(current, inputs.rotateGun225Deg())) {
            dirX = Math.cos(Math.PI + Math.PI / 4);
            dirY = Math.sin(Math.PI + Math.PI / 4);
            setTurnGunRightRadians(helper.getAngleToRotateGun(dirX, dirY));
            moveGunWithBody = true;
        } else if(testKeyEquals(current, inputs.rotateGun315Deg()) || (testKeyEquals(current, inputs.rotateGun0Deg()) && testKeyEquals(current, inputs.rotateGun270Deg()))) {
            dirX = Math.cos(Math.PI + Math.PI / 2 + Math.PI / 4);
            dirY = Math.sin(Math.PI + Math.PI / 2 + Math.PI / 4);
            setTurnGunRightRadians(helper.getAngleToRotateGun(dirX, dirY));
            moveGunWithBody = true;
        }

        if(testKeyEquals(current, inputs.moveGunWithBody()))
            moveGunWithBody = false;

        // todo: habilitar movimentação fixa ou livre da mira
    }

    //turnGunLeft(angle - (angle != 0 ? getGunHeading() : 0));

    public void onKeyReleased(KeyEvent e) {
        int current = e.getKeyCode();

        if(!movementMode) {
            if (testKeyEquals(current, inputs.moveUp()))
                directions.remove(Helper.Direction.UP);
            else if (testKeyEquals(current, inputs.moveDown()))
                directions.remove(Helper.Direction.DOWN);
            else if (testKeyEquals(current, inputs.moveLeft()))
                directions.remove(Helper.Direction.LEFT);
            else if (testKeyEquals(current, inputs.moveRight()))
                directions.remove(Helper.Direction.RIGHT);
            else if (testKeyEquals(current, inputs.moveUpLeft()))
                directions.remove(Helper.Direction.LEFT_UP);
            else if (testKeyEquals(current, inputs.moveUpRight()))
                directions.remove(Helper.Direction.RIGHT_UP);
            else if (testKeyEquals(current, inputs.moveDownLeft()))
                directions.remove(Helper.Direction.LEFT_DOWN);
            else if (testKeyEquals(current, inputs.moveDownRight()))
                directions.remove(Helper.Direction.RIGHT_DOWN);
        } else {
            if (testKeyEquals(current, inputs.moveUp()) || testKeyEquals(current, inputs.moveDown())) {
                moveDirection = 0;
                moveAmount = 0;
            } else if (testKeyEquals(current, inputs.moveLeft()) || testKeyEquals(current, inputs.moveRight())) {
                turnDirection = 0;
            }
        }

        if(testKeyEquals(current, inputs.changeMoveMode()))
            ignoreInputUntilReleaseChangeMode = false;

        if(testKeyEquals(current, inputs.goBackward()))
            goBackward = false;
        if(testKeyEquals(current, inputs.goForward()))
            goForward = false;

        if(testKeyEquals(current, inputs.shoot1()) ||
                testKeyEquals(current, inputs.shoot2()) ||
                testKeyEquals(current, inputs.shoot3()))
            firePower = 0;
    }

    public void run() {
        this.helper = new Helper(this);

        // body = black, gun = white, radar = red
        setColors(Color.BLACK, Color.WHITE, Color.RED);

        while(true) {
            setAdjustGunForRobotTurn(moveGunWithBody);

            if(!movementMode) {
                setAhead(helper.distanceToMove());
                setTurnRight(helper.angleToTurnInDegrees());
            } else {
                setAhead(moveAmount * moveDirection);
                moveAmount = Math.max(0, moveAmount - 1);
                setTurnRight(45 * turnDirection);
            }
            if(goForward) setAhead(Double.POSITIVE_INFINITY);
            if(goBackward) setBack(Double.POSITIVE_INFINITY);

            if (firePower > 0) setFire(firePower);
            execute();
        }
    }

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Inputs getInputs() {
        return inputs;
    }

    public void setInputs(Inputs inputs) {
        this.inputs = inputs;
    }

    public Set<Helper.Direction> getDirections() {
        return directions;
    }
}