import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCache {
    private Cache<String, Object> cache;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initCache() {
        cache = CacheManager.createCache(TypeCache.LRU);
    }

    @Test
    public void toStringTest(){
        cache = CacheManager.createCache(TypeCache.LRU);
    }

    @Test
    public void getFromEmptyCache(){
        assertTrue(cache.isEmpty());
        assertFalse(cache.get("1").isPresent());
    }

    @Test
    public void getFromNotFullCache() {
        cache.put("1", 12);
        cache.put("2", "string");
        cache.put("3", false);

        Optional<Object> fromCache = cache.get("2");
        assertFalse(cache.isEmpty());
        assertTrue(fromCache.isPresent());
        assertEquals("string", fromCache.get());
    }


    @Test
    public void cacheSizeIsFullOldValueRemove() {
        cache.put("1", 11);
        cache.put("2", "string");
        cache.put("3", false);
        cache.put("4", new Object());
        cache.put("5", 55);

        Optional<Object> fromCache = cache.get("1");
        assertFalse(fromCache.isPresent());
    }

    @Test
    public void createCacheThisIllegalParameters() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cache size cannot be 0 or less. You'r size is: 0");
        cache = new LRUCache<>(0);
    }
}

