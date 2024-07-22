package dolphinarium;

import dolphinarium.core.Engine;
import dolphinarium.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();

    }
}
