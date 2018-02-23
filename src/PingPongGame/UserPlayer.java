package PingPongGame;

import java.util.Scanner;

public class UserPlayer extends BasePlayer {
    public UserPlayer(GameState state) {
        super("user", state);
    }

    @Override
    public void run() {
        while (this.state.isActive) {
            Scanner scanner = new Scanner(System.in);
            String res = scanner.nextLine();
            this.state.hit(this.playerName);
        }
    }
}
