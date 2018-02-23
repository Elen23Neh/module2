package PingPongGame;

public class Game {
    public static void main(String[] args){
        GameState state = new GameState();
        BasePlayer user = new UserPlayer(state);
        BasePlayer npc = new NPCPlayer(state);

        new Thread(npc).start();
        new Thread(user).start();
    }
}
