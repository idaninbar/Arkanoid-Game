import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * 208765982 Idan Inbar.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;

    /**
     * the function is the constructor of the class.
     * @param sensor is the keyboard we get.
     * @param key is the key we get.
     * @param animation is the animation we get.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboard.isPressed(key)) {
            this.isAlreadyPressed = false;
        }
        if (!this.keyboard.isPressed(key) && !this.isAlreadyPressed) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
