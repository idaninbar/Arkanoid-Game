/**
 * 208765982 Idan Inbar.
 */
public class Counter {
    private int count;

    /**
     * the function is a constructor for counter.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * add number to current count.
     * @param number is number we add.
     */
    void increase(int number) {
        this.count = this.count + number;
    }
    /**
     * subtract number from current count.
     * @param number is the number we decrease.
     */
    void decrease(int number) {
        this.count = this.count - number;
    }
    /**
     * get current count.
     * @return the current value.
     */
    int getValue() {
        return this.count;
    }
}