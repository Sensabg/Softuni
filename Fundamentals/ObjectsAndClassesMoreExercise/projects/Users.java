package ObjectsAndClassesMoreExercise.projects;

public class Users {

    private String username;
    private String teamName;

    public Users(String username, String teamName) {
        this.username = username;
        this.teamName = teamName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}