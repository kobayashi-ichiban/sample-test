/*
 * H27年秋
 */
package jp.Fe;

public abstract class Cache {
    public enum Policy {
        FIFO, LRU;
    }

    static Cache createCache(Policy policy) {
        switch (policy) {
            case FIFO:
                return new ListBasedCache.Fifo();
            case LRU:
                return new ListBasedCache.Lru();
        }
        throw new UnsupportedOperationException();
    }

    abstract byte[] getCachedBlockData(int index);

    abstract void cacheBlockData(int index, byte[] blockData);
}
