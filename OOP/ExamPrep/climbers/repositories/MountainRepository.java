package climbers.repositories;

import climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MountainRepository implements Repository<Mountain> {

    private final Map<String, Mountain> mountains;
    public MountainRepository() {
        this.mountains = new LinkedHashMap<>();
    }

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(this.mountains.values());
    }

    @Override
    public void add(Mountain entity) {
        mountains.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Mountain entity) {
        return mountains.remove(entity.getName()) != null;
    }

    @Override
    public Mountain byName(String name) {
        return mountains.get(name);
    }
}
