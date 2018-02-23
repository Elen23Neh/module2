package PingPongGame;

public class NPCPlayer extends BasePlayer {
    public NPCPlayer(GameState state) {
        super("npc", state);
    }

    @Override
    public void run() {
        while (this.state.isActive){
            System.out.println("Bamm");
            this.state.hit(this.playerName);
        }
    }
}
