
import model.BaseNode;

import java.util.Map;
import java.util.Objects;


public abstract class AbstractCache<K, V, N extends BaseNode> implements Cache<K, V> {

    private final int cacheSize;

    Map<K, N> MapStorage;

    AbstractCache(final int cacheSize) {
        if (cacheSize <= 0) {
            throw new IllegalArgumentException(String.format("Cache size cannot be 0 or less. You'r size is: %s", cacheSize));
        }

        this.cacheSize = cacheSize;
    }

    int getCacheSize() {
        return cacheSize;
    }

    void checkStorage() {
        Objects.requireNonNull(MapStorage, "Storage cannot be null");
    }

    @Override
    public void clear() {
        MapStorage.clear();
    }

    @Override
    public boolean isEmpty() {
        return MapStorage.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("Cache type: %s\nCache size: %s", this.getClass().getSimpleName(), cacheSize);
    }
}
