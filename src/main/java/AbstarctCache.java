import jdk.nashorn.internal.ir.BaseNode;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public abstract class AbstarctCache<K,V,N extends BaseNode> implements Cache<V, K> {

    private final int cacheSize;

    protected Map<K, N> mapStorage;

    public AbstarctCache(final int cacheSize){
        this.cacheSize = cacheSize;
        if (cacheSize <= 0){
            throw new IllegalArgumentException(String.format("Cache size cannot be 0 or less. You'r size is: %s", cacheSize));
        }
    }

    protected int getCacheSize() {
        return cacheSize;
    }

    protected void checkStorage() {
        Objects.requireNonNull(mapStorage, "Storage cannot be null");
    }

    @Override
    public Optional<K> get(V key) {
        return Optional.empty();
    }

    @Override
    public void put(V key, K value) {

    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public boolean isEmpty() {
        return mapStorage.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("Cache type: %s\nCache size: %s", this.getClass().getSimpleName(), cacheSize);
    }
}
