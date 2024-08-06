package handball.core;

import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;

import java.util.*;
import java.util.stream.Collectors;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private EquipmentRepository equipment;
    private Map<String, Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new HashMap<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay currentGameplay = switch (gameplayType) {
            case "Outdoor" -> new Outdoor(gameplayName);
            case "Indoor" -> new Indoor(gameplayName);
            default -> throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        };

        this.gameplays.put(gameplayName, currentGameplay);
        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment currentEquipment = switch (equipmentType) {
            case "Kneepad" -> new Kneepad();
            case "ElbowPad" -> new ElbowPad();
            default -> throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        };

        this.equipment.add(currentEquipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment newEquipmentByType = Optional.ofNullable(this.equipment.findByType(equipmentType))
                .orElseThrow(() ->  new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType)));

        this.equipment.remove(newEquipmentByType);
        this.gameplays.get(gameplayName).addEquipment(newEquipmentByType);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team currentTeam = switch (teamType) {
            case "Bulgaria" -> new Bulgaria(teamName, country, advantage);
            case "Germany" -> new Germany(teamName, country, advantage);
            default -> throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        };

        Gameplay gameplay = gameplays.get(gameplayName);

        boolean isValidLocation = switch (teamType) {
            case "Bulgaria" -> "Outdoor".equals(gameplay.getClass().getSimpleName());
            case "Germany" -> "Indoor".equals(gameplay.getClass().getSimpleName());
            default -> false;
        };

        if (!isValidLocation) {
            return GAMEPLAY_NOT_SUITABLE;
        }

        this.gameplays.get(gameplayName).addTeam(currentTeam);
        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = this.gameplays.get(gameplayName);
        gameplay.teamsInGameplay();

        return String.format(TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        int calculateAdvantage = this.gameplays.get(gameplayName).getTeam()
                .stream().mapToInt(Team::getAdvantage).sum();

        return String.format(ADVANTAGE_GAMEPLAY,gameplayName,calculateAdvantage);
    }

    @Override
    public String getStatistics() {
        return this.gameplays.values().stream()
                .map(Gameplay::toString)
                .collect(Collectors.joining(System.lineSeparator())).trim();
    }
}
                                 //// GET STATISTICS Alternatives
// ------------------------------------------------------------------------------------------------------ //
//
//        StringBuilder output = new StringBuilder();
//        this.gameplays.values().forEach(output::append);
//        return output.toString().trim();
//}
// ------------------------------------------------------------------------------------------------------ //
//@Override
//public String getStatistics() {
//    return gameplays.values().stream()
//            .map(Gameplay::toString)
//            .reduce((a, b) -> a + System.lineSeparator() + b)
//            .orElse("")
//            .trim();
//}
// ------------------------------------------------------------------------------------------------------ //
//@Override
//public String getStatistics() {
//    return gameplays.values().stream()
//            .map(Gameplay::toString)
//            .collect(Collectors.collectingAndThen(
//                    Collectors.joining(System.lineSeparator()),
//                    String::trim));
//}
// ------------------------------------------------------------------------------------------------------ //
//@Override
//public String getStatistics() {
//    return String.join(System.lineSeparator(),
//            gameplays.values().stream()
//                    .map(Gameplay::toString)
//                    .collect(Collectors.toList())).trim();
//}
// ------------------------------------------------------------------------------------------------------ //
//@Override
//public String getStatistics() {
//    return gameplays.values().stream()
//            .collect(Collector.of(
//                    StringBuilder::new,
//                    (sb, gameplay) -> sb.append(gameplay.toString()).append(System.lineSeparator()),
//                    StringBuilder::append,
//                    sb -> sb.toString().trim()));
//}
// ------------------------------------------------------------------------------------------------------ //
