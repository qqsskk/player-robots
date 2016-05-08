package player;


/**
 * Interactive - a sample robot by Flemming N. Larsen.
 * <p/>
 * This is a robot that is controlled using the arrow keys and mouse only.
 * <p/>
 * Keys:
 * - W or arrow up:    Move forward
 * - S or arrow down:  Move backward
 * - A or arrow right: Turn right
 * - D or arrow left:  Turn left
 * Mouse:
 * - Moving:      Moves the aim, which the gun will follow
 * - Wheel up:    Move forward
 * - Wheel down:  Move backward
 * - Button 1:    Fire a bullet with power = 1
 * - Button 2:    Fire a bullet with power = 2
 * - Button 3:    Fire a bullet with power = 3
 * <p/>
 * The bullet color depends on the fire power:
 * - Power = 1:   Yellow
 * - Power = 2:   Orange
 * - Power = 3:   Red
 * <p/>
 * Note that the robot will continue firing as long as the mouse button is
 * pressed down.
 * <p/>
 * By enabling the "Paint" button on the robot console window for this robot,
 * a cross hair will be painted for the robots current aim (controlled by the
 * mouse).
 *
 * @author Flemming N. Larsen (original)
 *
 * @version 1.2
 *
 * @since 1.3.4
 */
public class P1SimpleGunJoystick extends AbstractSimpleGunJoystick {
	public P1SimpleGunJoystick() {
		super(new Player1Inputs());
	}
}
