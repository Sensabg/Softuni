package dolphinarium.core;

import dolphinarium.entities.dolphins.BottleNoseDolphin;
import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.dolphins.SpinnerDolphin;
import dolphinarium.entities.dolphins.SpottedDolphin;
import dolphinarium.entities.foods.Food;
import dolphinarium.entities.foods.Herring;
import dolphinarium.entities.foods.Mackerel;
import dolphinarium.entities.foods.Squid;
import dolphinarium.entities.pools.DeepWaterPool;
import dolphinarium.entities.pools.Pool;
import dolphinarium.entities.pools.ShallowWaterPool;
import dolphinarium.repositories.FoodRepository;
import dolphinarium.repositories.FoodRepositoryImpl;

import java.util.*;
import java.util.stream.Collectors;

import static dolphinarium.common.ConstantMessages.*;
import static dolphinarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Map<String, Pool> pools;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.pools = new LinkedHashMap<>();
    }

    @Override
    public String addPool(String poolType, String poolName) {
        Pool pool = switch (poolType) {
            case "DeepWaterPool" -> new DeepWaterPool(poolName);
            case "ShallowWaterPool" -> new ShallowWaterPool(poolName);
            default -> throw new NullPointerException(INVALID_POOL_TYPE);
        };

        if (pools.containsKey(pool.getName())) {
            throw new NullPointerException(POOL_EXISTS);
        }

        pools.put(pool.getName(), pool);
        return String.format(SUCCESSFULLY_ADDED_POOL_TYPE, poolType, poolName);
    }

    @Override
    public String buyFood(String foodType) {
        Food food = switch (foodType) {
            case "Herring" -> new Herring();
            case "Mackerel" -> new Mackerel();
            case "Squid" -> new Squid();
            default -> throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        };

        foodRepository.add(food);
        return String.format(SUCCESSFULLY_BOUGHT_FOOD_TYPE, foodType);
    }

    @Override
    public String addFoodToPool(String poolName, String foodType) {
        Food food = Optional.ofNullable(foodRepository.findByType(foodType))
                .orElseThrow(() -> new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType)));

        Pool pool = pools.get(poolName);
        pool.addFood(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_POOL, foodType, poolName);
    }

    @Override
    public String addDolphin(String poolName, String dolphinType, String dolphinName, int energy) {
        Dolphin dolphin = switch (dolphinType) {
            case "BottleNoseDolphin" -> new BottleNoseDolphin(dolphinName, energy);
            case "SpottedDolphin" -> new SpottedDolphin(dolphinName, energy);
            case "SpinnerDolphin" -> new SpinnerDolphin(dolphinName, energy);
            default -> throw new IllegalArgumentException(INVALID_DOLPHIN_TYPE);
        };

        pools.values().stream()
                .flatMap(p -> p.getDolphins().stream())
                .filter(d -> d.getName().equals(dolphinName))
                .findAny()
                .ifPresent(d -> { throw new IllegalArgumentException(DOLPHIN_EXISTS); });

        Pool pool = pools.get(poolName);
        String poolType = pool.getClass().getSimpleName();

        boolean canLiveInPool = switch (dolphinType) {
            case "BottleNoseDolphin" -> poolType.equals("DeepWaterPool");
            case "SpinnerDolphin" -> poolType.equals("ShallowWaterPool");
            case "SpottedDolphin" -> true;
            default -> false;
        };

        if (!canLiveInPool) {
            return POOL_NOT_SUITABLE;
        }

        pool.addDolphin(dolphin);
        return String.format(SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL, dolphinType, dolphinName, poolName);
    }

    @Override
    public String feedDolphins(String poolName, String foodType) {
        Pool pool = pools.get(poolName);
        Food food = pool.getFoods().stream()
                .filter(f -> f.getClass().getSimpleName().equals(foodType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_FOOD_OF_TYPE_ADDED_TO_POOL));

        pool.getFoods().remove(food);

        Collection<Dolphin> dolphins = pool.getDolphins();
        dolphins.forEach(d -> d.eat(food));
        return String.format(DOLPHINS_FED, dolphins.size(), poolName);
    }

    @Override
    public String playWithDolphins(String poolName) {
        Pool pool = pools.get(poolName);

        Collection<Dolphin> dolphins = Optional.of(pool.getDolphins())
                .filter(d -> !d.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException(NO_DOLPHINS));

        int exhaustedDolphins = dolphins.stream()
                .peek(Dolphin::jump)
                .filter(d -> d.getEnergy() <= 0).toList().size();

        pool.getDolphins().removeIf(d -> d.getEnergy() <= 0);
        return String.format(DOLPHINS_PLAY, poolName, exhaustedDolphins);
    }

    @Override
    public String getStatistics() {
        return pools.values().stream()
                .map(pool -> String.format(DOLPHINS_FINAL, pool.getName()) + System.lineSeparator() +
                        (pool.getDolphins().isEmpty() ? NONE : pool.getDolphins().stream()
                                .map(d -> d.getName() + " - " + d.getEnergy())
                                .collect(Collectors.joining(DELIMITER))))
                                .collect(Collectors.joining(System.lineSeparator()));
    }
}



                          // GET STATISTICS Alternatives

// ------------------------------------------------------------------------------------------------------ //

//       pools.values().stream()
//            .map(pool -> String.format(DOLPHINS_FINAL, pool.getName()) + System.lineSeparator() +
//                    pool.getDolphins().stream()
//                        .map(d -> d.getName() + " - " + d.getEnergy())
//                        .reduce((d1, d2) -> d1 + DELIMITER + d2)
//                        .orElse(NONE))
//                        .collect(Collectors.joining(System.lineSeparator()));

// ------------------------------------------------------------------------------------------------------ //

//   pools.values().stream()
//                 .map(pool -> String.format(DOLPHINS_FINAL, pool.getName())
//                        + System.lineSeparator() +
//                      pool.getDolphins().stream()
//                           .map(d -> d.getName() + " - " + d.getEnergy())
//                                      .collect(Collectors.joining(DELIMITER, "",
//                      pool.getDolphins().isEmpty() ? NONE : "")))
//                                      .collect(Collectors.joining(System.lineSeparator()));

// ------------------------------------------------------------------------------------------------------ //

//   return pools.values().stream()
//            .map(pool -> String.format(DOLPHINS_FINAL, pool.getName()) + System.lineSeparator() +
//                    pool.getDolphins().stream()
//                        .map(d -> d.getName() + " - " + d.getEnergy())
//                        .collect(Collectors.collectingAndThen(
//                                Collectors.joining(DELIMITER),
//                                s -> s.isEmpty() ? NONE : s)))
//                        .collect(Collectors.joining(System.lineSeparator()));

// ------------------------------------------------------------------------------------------------------ //

//   return pools.values()
//                .stream()
//                .map(this::formatPoolStatistics)
//                .collect(Collectors.joining(System.lineSeparator()));
//
//    private String formatPoolStatistics(Pool pool) {
//        String dolphinInfo = pool.getDolphins().stream()
//                .map(d -> d.getName() + " - " + d.getEnergy())
//                .collect(Collectors.joining(DELIMITER));
//
//        dolphinInfo = dolphinInfo.isEmpty() ? NONE : dolphinInfo;
//
//        return String.format(DOLPHINS_FINAL, pool.getName()) + System.lineSeparator() + dolphinInfo;
