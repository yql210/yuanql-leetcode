import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: PACKAGE_NAME
 * @BelongsClassName: LRU
 * @Author: yuanql
 * @CreateTime: 2023-10-08  15:23
 * @Description:
 * @Version: 1.0
 */


public class LRU extends LinkedHashMap {
    private final int cap;

    public LRU(int cap) {
        super(cap, 0.75F, true);
        this.cap = cap;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > cap;
    }
}
