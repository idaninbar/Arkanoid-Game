/**
 * 208765982 Idan Inbar.
 */
public interface HitNotifier {
    /**
     * the funciton adds a listener to hit event.
     * @param hl is the listener we want to add.
     */
    void addHitListener(HitListener hl);
    /**
     * the fucntion removes a listener to hit event.
     * @param hl is the listener we want to remove.
     */
    void removeHitListener(HitListener hl);
}
