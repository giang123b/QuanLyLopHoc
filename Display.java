import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    static ArrayList<Person> list = new ArrayList<Person>();

    public static void menuTeacher() {
        System.out.println("===============================================");
        System.out.println("1. Add a list member");
        System.out.println("2. Show list member");
        System.out.println("3. Add a member");
        System.out.println("4. Delete a member");
        System.out.println("5. Edit a member");
        System.out.println("6. Delete list member");
        System.out.println("7. Show list team");
        System.out.println("8. Show list member of team");
        System.out.println("9. Show daily meeting");
        System.out.println("0. Exit");
        int selection;
        System.out.println("Enter your selection: ");
        selection = new Scanner(System.in).nextInt();

        switch (selection) {
            case 1:
                addList();
                break;
            case 2:
                showList();
                break;
            case 3:
                addMember();
                break;
            case 4:
                deleteMember();
                break;
            case 5:
                editMember();
                break;
            case 6:
                deleteList();
                break;
            case 7:
                showListTeam();
                break;
            case 8:
                showListMemberTeam();
                break;
            case 9:
                showDailyMeeting();
                break;
            case 0:
                System.out.println("===============================================");
                System.out.println("Many thanks! See you again!");
                System.exit(0);

        }
    }

    private static void showListTeam() {
        System.out.println("===============================================");
        System.out.println("List team: ");
        for (int i = 1; i < list.size(); i++){
            int count = 0;
            for (int j = i + 1; j <= list.size(); j++)
                if (list.get(j).getTeam() == i) count++;
            if (count != 0) System.out.println("Team " + list.get(i).getTeam());
        }
    }

    private static void deleteList() {
        System.out.println("===============================================");
        list.clear();
        if (list.size() == 0) System.out.println("List member is empty!");
        else System.out.println("List member is not empty!");
    }

    private static void editMember() {
        System.out.println("===============================================");

        showList();

        System.out.println("What numerical order of member do you want to edit?");
        int selection;
        do {
            System.out.println("Enter your selection: ");
            selection = new Scanner(System.in).nextInt() - 1;
        } while (selection > list.size() - 1 && selection < 0);

        list.remove(selection);
        addMember();
    }

    private static void deleteMember() {
        System.out.println("===============================================");

        showList();

        System.out.println("What numerical order of member do you want to delete?");
        int selection;
        do {
            System.out.println("Enter your selection: ");
            selection = new Scanner(System.in).nextInt() - 1;
        } while (selection > list.size() - 1 && selection < 0);

        list.remove(selection);
    }

    private static void addMember() {
        System.out.println("===============================================");

        Person member = new Person();

        System.out.println("Enter the member name:");
        String name = new Scanner(System.in).nextLine();
        member.setName(name);

        System.out.println("Enter the member's telephone number:");
        String phoneNumber = new Scanner(System.in).nextLine();
        member.setPhoneNumber(phoneNumber);

        System.out.println("Enter the team:");
        int team = new Scanner(System.in).nextInt();
        member.setTeam(team);

        list.add(member);
    }

    private static void showList() {
        System.out.println("===============================================");
        System.out.printf("%-5s%-30s%-20s%-15s\n", "No", "Name", "Phone number", "Team");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-5s", (i + 1));
            list.get(i).showMember();
        }
    }

    private static void addList() {
        System.out.println("===============================================");
        System.out.println("How many members are there in your class?");
        int size = new Scanner(System.in).nextInt();
        for (int i = 1; i <= size; i++) {
            System.out.println("Member " + i + ":");
            Person member = new Person();

            System.out.println("Enter the member name:");
            String name = new Scanner(System.in).nextLine();
            member.setName(name);

            System.out.println("Enter the member's telephone number:");
            String phoneNumber = new Scanner(System.in).nextLine();
            member.setPhoneNumber(phoneNumber);

            System.out.println("Enter the team:");
            int team = new Scanner(System.in).nextInt();
            member.setTeam(team);

            list.add(member);
        }
    }


    //    **********************************************************************
    public static void menuTeamLeader() {
        System.out.println("===============================================");
        System.out.println("1. Add a member to team");
        System.out.println("2. Show list member team");
        System.out.println("3. Create daily meeting");
        System.out.println("4. Show daily meeting");
        System.out.println("5. Comment on a member");
        System.out.println("6. Show comment");
        System.out.println("0. Exit");
        int selection;
        System.out.println("Enter your selection: ");
        selection = new Scanner(System.in).nextInt();

        switch (selection) {
            case 1:
                addAMemberToTeam();
                break;
            case 2:
                showListMemberTeam();
                break;
            case 3:
                createDailyMeeting();
                break;
            case 4:
                showDailyMeeting();
                break;
            case 5:
                commentAMember();
                break;
            case 6:
                showComment();
                break;
            case 0:
                System.out.println("===============================================");
                System.out.println("Many thanks! See you again!");
                System.exit(0);

        }
    }

    private static void showComment() {
        System.out.println("===============================================");

        System.out.println("1. Comment of a member");
        System.out.println("2. Comment of all member");
        int selection1;
        do {
            System.out.println("Enter your selection: ");
            selection1 = new Scanner(System.in).nextInt();
        } while (selection1 > 2 && selection1 < 1);


        if (selection1 == 1) {
            showList();

            System.out.println("What numerical order of member do you want to show comment?");
            int selection;
            do {
                System.out.println("Enter your selection: ");
                selection = new Scanner(System.in).nextInt() - 1;
            } while (selection > list.size() - 1 && selection < 0);

            System.out.println("\nMember " + list.get(selection).getName() + ":");
            System.out.println(list.get(selection).getComment());
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("\nMember " + list.get(i).getName() + ":");
                System.out.println(list.get(i).getComment());
                System.out.printf("\n");
            }
        }
    }

    private static void commentAMember() {
        showList();

        System.out.println("What numerical order of member do you want to comment?");
        int selection;
        do {
            System.out.println("Enter your selection: ");
            selection = new Scanner(System.in).nextInt() - 1;
        } while (selection > list.size() - 1 && selection < 0);

        System.out.println("Enter the comment: ");
        String comment = new Scanner(System.in).nextLine();
        list.get(selection).setComment(comment);

    }

    private static void showDailyMeeting() {
        showList();

        System.out.println("What numerical order of member do you want to show daily meeting?");
        int selection;
        do {
            System.out.println("Enter your selection: ");
            selection = new Scanner(System.in).nextInt() - 1;
        } while (selection > list.size() - 1 && selection < 0);

        System.out.println(list.get(selection).getName());
        System.out.println(list.get(selection).getDailyMeeting());
    }

    private static void createDailyMeeting() {
        showList();

        System.out.println("What numerical order of member do you want to create daily meeting?");
        int selection;
        do {
            System.out.println("Enter your selection: ");
            selection = new Scanner(System.in).nextInt() - 1;
        } while (selection > list.size() - 1 && selection < 0);

        System.out.println("Enter the daily meeting: ");
        String daiyMeeting = new Scanner(System.in).nextLine();
        list.get(selection).setDailyMeeting(daiyMeeting);
    }

    private static void showListMemberTeam() {
        System.out.println("===============================================");
        System.out.println("What team are you in?");
        System.out.println("Enter your team: ");
        int selection = new Scanner(System.in).nextInt();

        System.out.printf("%-5s%-30s%-20s%-15s\n", "No", "Name", "Phone number", "Team");
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTeam() == selection) {
                System.out.printf("%-5s", count);
                list.get(i).showMember();
                count++;
            }
        }

    }

    private static void addAMemberToTeam() {
        System.out.println("===============================================");

        showList();

        System.out.println("What numerical order of member do you want to add?");
        int selection;
        do {
            System.out.println("Enter your selection: ");
            selection = new Scanner(System.in).nextInt() - 1;
        } while (selection > list.size() - 1 && selection < 0);

        System.out.println("Enter the team: ");
        int team = new Scanner(System.in).nextInt();

        list.get(selection).setTeam(team);
    }


    public static void main(String[] args) {
        while (true) {
            System.out.println("===============================================");
            System.out.println("Are you teacher or team leader?");
            System.out.println("1.Teacher\n2.Team leader\n0.Exit");
            int selection;

            do {
                System.out.println("Enter your selection: ");
                selection = new Scanner(System.in).nextInt();
            } while (selection > 2 && selection < 0);

            if (selection == 1) menuTeacher();
            else if (selection == 2) menuTeamLeader();
            else {
                System.out.println("===============================================");
                System.out.println("Many thanks! See you again!");
                System.exit(0);
            }
        }
    }
}
