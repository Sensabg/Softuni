package ObjectsAndClassesMoreExercise.projects;

import java.util.*;
import java.util.stream.Collectors;

//not finished
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int teamsAmount = Integer.parseInt(scanner.nextLine());

        List<Users> usersInfo = new ArrayList<>();
        List<String> users = new ArrayList<>();
        List<String> teamNames = new ArrayList<>();

        for (int i = 0; i < teamsAmount; i++) {
            String input = scanner.nextLine();
            String username = input.split("-")[0];
            String teamName = input.split("-")[1];

            if (!users.contains(username) && !teamNames.contains(teamName)) {
                users.add(username);
                teamNames.add(teamName);
                Users newUser = new Users(username, teamName);
                usersInfo.add(newUser);
                System.out.println("Team " + teamName + " has been created by " + username + "!");
            } else if (teamNames.contains(teamName)) {
                System.out.println("Team " + teamName + " was already created!");
            } else if (users.contains(username)) {
                System.out.println(username + " cannot create another team!");
            }
        }

        String joinTeam = scanner.nextLine();
        while (!joinTeam.equals("end of assignment")) {
            String[] input = joinTeam.split("->");
            String username = input[0];
            String teamName = input[1];

            if (!users.contains(username) && teamNames.contains(teamName)) {
                Users newUser = new Users(username, teamName);
                usersInfo.add(newUser);
                users.add(username);
            }  else if (!teamNames.contains(teamName)) {
                System.out.println("Team " + teamName + " does not exist!");
            } else if (users.contains(username)) {
                System.out.println("Member " + username + " cannot join team " + teamName + "!");
            }

            joinTeam = scanner.nextLine();
        }
        Map<String, List<Users>> teamsMap = usersInfo.stream()
                .collect(Collectors.groupingBy(Users::getTeamName));

        List<String> teamsToDisband = teamsMap.entrySet().stream()
                .filter(entry -> entry.getValue().size() == 1)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        teamsMap.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .sorted(Comparator.<Map.Entry<String, List<Users>>>comparingInt(entry -> entry.getValue().size()).reversed()
                        .thenComparing(Map.Entry::getKey))
                .flatMap(entry -> {
                    List<String> teamInfo = new ArrayList<>();
                    teamInfo.add(entry.getKey());
                    int userCount = 0;
                    for (Users user : entry.getValue()) {
                        teamInfo.add((userCount == 0 ? "- " : "-- ") + user.getUsername());
                        userCount++;
                    }
                    return teamInfo.stream();
                })
                .forEach(System.out::println);

        System.out.println("Teams to disband:");
        teamsToDisband.forEach(System.out::println);
    }
}
//        Map<String, List<Users>> departmentMap = new HashMap<>();
//
//        for (Users currentUsers : usersInfo) {
//            String department = currentUsers.getTeamName();
//            departmentMap.computeIfAbsent(department, k -> new ArrayList<>()).add(currentUsers);
//        }
//        List<String> sortedDepartments = new ArrayList<>(departmentMap.keySet());
//
//        for (String department : sortedDepartments) {
//            List<Users> sortedMembers = new ArrayList<>(departmentMap.get(department));
//
//            if (sortedMembers.size() > 1) {
//                System.out.println(department);
//                int counter = 0;
//                for (Users team : sortedMembers) {
//                    counter++;
//                    String user = team.getUsername();
//                    if (counter == 1) {
//                        System.out.println("- " + user);
//                    } else {
//                        System.out.println("-- " + user);
//                    }
//                }
//            }
//        }
//        System.out.println("Teams to disband:");
//        sortedDepartments.stream()
//                .filter(department -> departmentMap.get(department).size() == 1)
//                .forEach(System.out::println);
//    }