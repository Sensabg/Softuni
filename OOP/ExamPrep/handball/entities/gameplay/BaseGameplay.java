package handball.entities.gameplay;

import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;

import java.util.Optional;
import java.util.stream.Collectors;

import static handball.common.ExceptionMessages.*;

public abstract class BaseGameplay implements Gameplay {

    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    protected BaseGameplay(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    @Override
    public int allProtection() {
        return equipments.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        this.teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        this.teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipments;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d",
                this.getName(),
                this.getClass().getSimpleName(),
                this.getTeamNames(),
                this.equipments.size(),
                this.allProtection());
    }

    private String getTeamNames() {
        return Optional.of(teams.stream().map(Team::getName)
                .collect(Collectors.joining(" ")))
                .filter(s -> !s.isEmpty())
                .orElse("none");
    }
}
                      //toSTRING + getTeamNames Alternatives
// ------------------------------------------------------------------------------------------------------ //
//           teams.stream()
//                .map(Team::getName)
//                .collect(Collectors.joining(" ", "", teams.isEmpty() ? "none" : ""));
//
// ------------------------------------------------------------------------------------------------------ //
//
//     private String getTeamNames()
//           return teams.stream()
//                   .map(Team::getName)
//                   .collect(Collectors.collectingAndThen(Collectors.joining(" "),
//                           s -> s.isEmpty() ? "none" : s));
//
// ------------------------------------------------------------------------------------------------------ //
//
//       private String getTeamNames()
//          teams.stream()
//               .map(Team::getName)
//               .flatMap(Optional::stream)
//               .collect(Collectors.collectingAndThen( Collectors.joining(" "),
//                        s -> s.isEmpty() ? "none" : s))
//    
// ------------------------------------------------------------------------------------------------------ //
//
//    @Override
//    public String toString() {
//        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d",
//                this.getName(),
//                this.getClass().getSimpleName(),
//                teams.stream()
//                        .collect(Collectors.collectingAndThen(Collectors.mapping(Team::getName,
//                         Collectors.joining(" ")), s -> s.isEmpty() ? "none" : s)),
//                equipments.size(),
//                allProtection());
//     }
// ------------------------------------------------------------------------------------------------------ //
//
//    @Override
//    public String toString() {
//        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d",
//                this.getName(),
//                this.getClass().getSimpleName(),
//                Optional.of(teams.stream()
//                                .map(Team::getName)
//                                .collect(Collectors.joining(" ")))
//                        .filter(s -> !s.isEmpty())
//                        .orElse("none"),
//                equipments.size(),
//                allProtection();
//
// ------------------------------------------------------------------------------------------------------ //
//
//    @Override
//    public String toString() {
//        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d",
//                this.getName(),
//                this.getClass().getSimpleName(),
//                teams.stream()
//                        .map(Team::getName)
//                        .collect(Collectors.collectingAndThen(Collectors.joining(" "),
//                                s -> s.isEmpty() ? "none" : s)), equipments.size(), allProtection());

// ------------------------------------------------------------------------------------------------------ //
//
//      @Override
//      public String toString() {
//        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d",
//            this.getName(),
//            this.getClass().getSimpleName(),
//            teams.stream()
//                 .map(Team::getName)
//                 .flatMap(Optional::stream)
//                 .collect(Collectors.collectingAndThen(
//                     Collectors.joining(" "), s -> s.isEmpty() ? "none" : s)),
//            equipments.size(),
//            allProtection());
//}
// ------------------------------------------------------------------------------------------------------ //
//
//    @Override
//    public String toString() {
//       return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d",
//           this.getName(),
//           this.getClass().getSimpleName(),
//           teams.stream()
//                .map(Team::getName)
//                .collect(Collectors.joining(" ", "", teams.isEmpty() ? "none" : "")),
//           equipments.size(),
//           allProtection();
//    }   
// ------------------------------------------------------------------------------------------------------ //
//
//     @Override
//      public String toString() {
//        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d",
//            this.getName(),
//            this.getClass().getSimpleName(),
//            teams.stream()
//                 .map(Team::getName)
//                 .collect(Collectors.joining(" ", "", teams.isEmpty() ? "none" : "")),
//            equipments.size(),
//            allProtection());
//       }
// ------------------------------------------------------------------------------------------------------ //
//
//     @Override
//      public String toString() {
//        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d",
//            this.getName(),
//            this.getClass().getSimpleName(),
//            getTeamNames(),
//            equipments.size(),
//            allProtection());
//        }
//
//        private String getTeamNames() {
//           return teams.stream()
//                       .map(Team::getName)
//                       .collect(Collectors.collectingAndThen(
//                           Collectors.joining(" "), s -> s.isEmpty() ? "none" : s));
//        }       
// ------------------------------------------------------------------------------------------------------ //
