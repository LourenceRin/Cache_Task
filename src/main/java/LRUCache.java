import model.BaseNode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Optional;

public class LRUCache<K, V> extends AbstractCache<K, V, BaseNode<K, V>> {

    LRUCache(final int cacheSize) {
        super(cacheSize);
        this.MapStorage = new LinkedHashMap<>();
    }

    @Override
    public Optional<V> get(final K key) {
        checkStorage();

        BaseNode<K, V> node = MapStorage.get(key);

        if (node == null) {
            return Optional.empty();
        } else {
            put(key, node.getValue());
        }

        return Optional.ofNullable(node.getValue());
    }

    @Override
    public void put(final K key, final V value) {
        checkStorage();

        if (MapStorage.containsKey(key)) {
            MapStorage.remove(key);
        } else if (MapStorage.size() == getCacheSize()) {
            Iterator<K> iterator = MapStorage.keySet().iterator();
            iterator.next();
            iterator.remove();
        }

        MapStorage.put(key, new BaseNode<>(key, value));
    }

}
