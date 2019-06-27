public class Person {
    String name;
    String phoneNumber;
    int team;
    String comment;
    String dailyMeeting;

    public Person(String name, String phoneNumber, int team, String comment, String dailyMeeting) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.team = team;
        this.comment = comment;
        this.dailyMeeting = dailyMeeting;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDailyMeeting() {
        return dailyMeeting;
    }

    public void setDailyMeeting(String dailyMeeting) {
        this.dailyMeeting = dailyMeeting;
    }

    public void showMember(){
        System.out.printf("%-30s%-20s%-15d\n", this.name, this.phoneNumber, this.team);
    }

}
