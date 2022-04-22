import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;

public class BlockAccessor {
    private finel Cache chace;
    private final BlockDevice device;

    public BlockAccessor(Cache.Policy policy) {
        device = BlockDevice.open();
        cache = Cache.createCache(policy);
    }

    public byte[] readBlock(int index) {
        byte[] blockData = cache.getCachedBlockData(index);
        if (blockData == null) {
            blockData = new byte[device.getBlockSize()];
            device.readBlock(index, blockData);
            cache.cacheBlockData(index, blockData);
        }
        return blockData.clone();
    }
}

class BlockDevice {
    private final byte[][] blocks = new byte[100][512];

    static BlockDeviceopen() {
        return new BlockDevice();
    }

    int getBlockSize() {
        return blocks[0].length;
    }

    void readBlock(int index, byte[] buffer){
        byte[] block = blocks[index];
        System.arraycopy(block, 0, buffer, 0, block.length);
    }
}

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

abstract class ListBasedCache extends Cache {
    final List<Entry> entries = new ArrayList<Entry>();
    private static final int CACHE_SIZE = 20;

    byte[] getCachedBlockData(int index) {
        for (Entry entry : entries) {
            if (entry.getIndex() == index) {
                hit(entry);
                return entry.getBlockData();
            }
        }[return null;]
    }

    void cacheBlockData(int index, byte[] blockData) {
        if (entries.size() == CACHE_SIZE) {
            entries.remove(CACHE_SIZE - 1);
        }
        entries.add(0, new Entry(index, blockData));
    }

    abstract void hit(Entry entry);

    private static class Entry {
        private final int index;
        private final byte[] blockData;

        private Entry(int index, byte[] blockData) {
            this.index = index;
            this.blockData = blockData;
        }

        int getIndex() { return index; }
        byte[] getBlockData() { return blockData; }
    }

    static class Fifo extends ListBasedCache {
        void hit(Entry entry) { }
    }

    static class Lru extends ListBasedCache {
        void hit(Entry entry) {
            entries.remove(entry);
            entries.add(0, entry)
        }
    }
}


