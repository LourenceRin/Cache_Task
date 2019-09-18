import java.util.Objects;

public class CacheManager {
    private static final int DEFAULT_CACHE_SIZE = 4;

    private CacheManager() {
    }

    public static <K, V> Cache<K, V> createCache(TypeCache type) {
        return createCache(type, DEFAULT_CACHE_SIZE);
    }

    public static <K, V> Cache<K, V> createCache(TypeCache type, int cacheSize) {
        switch (Objects.requireNonNull(type, "Cache type cannot be null")) {
            case LRU:
                return new LRUCache<>(cacheSize);
            default:
                throw new IllegalArgumentException(String.format("Can't create cache type '%s'", type.name()));
        }
    }

}
