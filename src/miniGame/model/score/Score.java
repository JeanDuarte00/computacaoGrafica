package miniGame.model.score;

public class Score implements Comparable<Score>{
    private String player;
    private int score;

    public Score() {

    }
    public Score(String gamer, int score) {
        this.player = gamer;
        this.score = score;
    }

    public String getGamer() {
        return player;
    }

    public void setGamer(String gamer) {
        this.player = gamer;
    }

    public float getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Score anotherPlayer) {
        if (this.score > anotherPlayer.getScore()) {
            return -1;
        }
        if (this.score < anotherPlayer.getScore()) {
            return 1;
        }
        return 0;
    }
}
