package pl.envelo.akademia.tictactoe;

public class Player {
    private String name;
    private int wins;

    public Player(String name) {
        this.name = name;
    }

    public void incrementWins(){
        ++wins;
    }

        public String getName() {
            return name;
        }

        public int getWins() {
        return wins;
    }
}
