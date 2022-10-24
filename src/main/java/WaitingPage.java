public class WaitingPage {
    /**
     * Ожидание для отладки
     */
    public void waiting(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
