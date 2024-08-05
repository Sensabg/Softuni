package climbers.core;

import climbers.common.ConstantMessages;
import climbers.common.ExceptionMessages;
import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;

import java.util.Collection;
import java.util.stream.Collectors;


import static climbers.common.ConstantMessages.*;
import static climbers.common.ExceptionMessages.*;


public class ControllerImpl implements Controller {

    private final Repository<Mountain> mountainRepository;
    private final Repository<Climber> climberRepository;
    private int mountains;

    public ControllerImpl() {

        this.mountainRepository = new MountainRepository();
        this.climberRepository = new ClimberRepository();
    }


    @Override
    public String addClimber(String type, String climberName) {

        Climber climber = switch (type) {
            case "WallClimber" -> new WallClimber(climberName);
            case "RockClimber" -> new RockClimber(climberName);
            default -> throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        };

        this.climberRepository.add(climber);
        return String.format(CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        for (String peak : peaks) {
            mountain.getPeaksList().add(peak);
        }
        this.mountainRepository.add(mountain);
        return String.format(MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = this.climberRepository.byName(climberName);

        if (climber == null) {
            throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
        }

        climberRepository.remove(climber);
        return String.format(CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Collection<Climber> climbers = this.climberRepository.getCollection();

        if (climbers.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }

        Mountain mountain = this.mountainRepository.byName(mountainName);
        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climbers);
        int removed = climbers.stream().filter(c -> c.getStrength() == 0).toArray().length;
        this.mountains++;

        return String.format(PEAK_CLIMBING, mountainName, removed);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format(FINAL_MOUNTAIN_COUNT, this.mountains));
        statistics.append(System.lineSeparator());
        statistics.append(FINAL_CLIMBERS_STATISTICS);

        Collection<Climber> climbers = climberRepository.getCollection();
        for (Climber climber : climbers) {
            statistics.append(System.lineSeparator());
            statistics.append(String.format(FINAL_CLIMBER_NAME, climber.getName()));
            statistics.append(System.lineSeparator());
            statistics.append(String.format(FINAL_CLIMBER_STRENGTH, climber.getStrength()));
            statistics.append(System.lineSeparator());
            String last = climber.getRoster().getPeaks().isEmpty()
                    ? "None"
                    : String.join(FINAL_CLIMBER_FINDINGS_DELIMITER, climber.getRoster().getPeaks());
            statistics.append(String.format(FINAL_CLIMBER_PEAKS, last));
        }
        return statistics.toString();
    }
}