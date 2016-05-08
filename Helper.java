package player;

import static robocode.util.Utils.*;

public class Helper {
    public enum Direction { UP, DOWN, LEFT, RIGHT, LEFT_UP, RIGHT_UP, LEFT_DOWN, RIGHT_DOWN }
    
    private AbstractSimpleGunJoystick robot;

    public Helper(AbstractSimpleGunJoystick robot) {
        this.robot = robot;
    }
    
    // Returns the distance to move
    public double distanceToMove() {
        // If no keys are pressed, we should not move at all
        if (robot.getDirections().isEmpty()) return 0;

        // If the robot has more than 45 degrees to turn, move only 5 pixel
        if (Math.abs(angleToTurnInDegrees()) > 45) return 5;

        // Otherwise, move at full speed
        return Double.POSITIVE_INFINITY;
    }

    // Returns the angle to turn, which is the delta between the desired
    // direction and the current heading of the robot
    public double angleToTurnInDegrees() {
        if (robot.getDirections().isEmpty()) return 0;
        return robocode.util.Utils.normalRelativeAngleDegrees(desiredDirection() - robot.getHeading());
    }

    // Return the desired direction depending on the pending move getDirections().
    // With one arrow key pressed, the move to N, E, S, W.
    // With two keys pressed, the robot also move to NE, NW, SE, SW.
    public double desiredDirection() {
        if (robot.getDirections().contains(Direction.LEFT_UP))
            return 315;
        if (robot.getDirections().contains(Direction.RIGHT_UP))
            return 45;
        if (robot.getDirections().contains(Direction.RIGHT_DOWN))
            return 135;
        if (robot.getDirections().contains(Direction.LEFT_DOWN))
            return 225;

        if (robot.getDirections().contains(Direction.UP)) {
            if (robot.getDirections().contains(Direction.RIGHT)) return 45;
            if (robot.getDirections().contains(Direction.LEFT)) return 315;
            return 0;
        }
        if (robot.getDirections().contains(Direction.DOWN)) {
            if (robot.getDirections().contains(Direction.RIGHT)) return 135;
            if (robot.getDirections().contains(Direction.LEFT)) return 225;
            return 180;
        }
        if (robot.getDirections().contains(Direction.RIGHT)) return 90;
        if (robot.getDirections().contains(Direction.LEFT)) return 270;
        return 0;
    }

    public boolean equals(double v1, double v2) {
        return Math.abs(v1 - v2) <= 0.000001;
    }

    public double getAngleToRotateGun(double directionX, double directionY) {
        double angle = normalAbsoluteAngle(Math.atan2(directionY, directionX));
        return normalRelativeAngle(angle - robot.getGunHeadingRadians());
    }
}