package servertictactoe;

public class Player {
    private int id;    
    private String name;
    private String email;
    private String password;
    private String playerStatus;
    private int totalScore;
    private int numPlayedGames;

    // name, email, password. Rest have a default value when creating a new player
    public Player(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Empty
    public Player() {
    }
    
    // All
    public Player(int id, String name, String email, String password, String playerStatus, int totalScore, int numPlayedGames) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.playerStatus = playerStatus;
        this.totalScore = totalScore;
        this.numPlayedGames = numPlayedGames;
    }
        
    // All except ID
    public Player(String name, String email, String password, String playerStatus, int totalScore, int numPlayedGames) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.playerStatus = playerStatus;
        this.totalScore = totalScore;
        this.numPlayedGames = numPlayedGames;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String playerStatus) {
        this.playerStatus = playerStatus;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void setNumPlayedGames(int numPlayedGames) {
        this.numPlayedGames = numPlayedGames;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return playerStatus;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getNumPlayedGames() {
        return numPlayedGames;
    }
}
