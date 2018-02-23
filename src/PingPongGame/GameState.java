package PingPongGame;

public class GameState {

    private int timeout = 2000;
    private volatile String lastHit;
    public volatile boolean isActive = true;

    public synchronized void hit(String player) {
        long t = System.currentTimeMillis();
        while (this.lastHit == player) {
            try {
                wait(timeout);

                if (System.currentTimeMillis() - t >= timeout){
                    this.isActive = false;
                    System.out.println("You loose!");
                    break;
                }
            } catch (InterruptedException e) {
            }

        }

        this.lastHit = player;
        notify();
    }

}
