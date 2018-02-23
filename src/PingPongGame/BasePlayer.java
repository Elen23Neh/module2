package PingPongGame;

public abstract class BasePlayer implements Runnable{
    protected String playerName;
    protected GameState state;

    public BasePlayer(String playerName, GameState state) {
        this.playerName = playerName;
        this.state = state;
    }
}
