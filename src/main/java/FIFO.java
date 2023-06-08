import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FIFO extends ReplacementAlgorithm {
    private Queue<Integer> pageFramesQueue;

    public FIFO(int pageFrameCount) {
        super(pageFrameCount);
        pageFramesQueue = new LinkedList<>();
    }

    @Override
    public void insert(int pageNumber) {
        if (!pageFramesQueue.contains(pageNumber)) {
            if (pageFramesQueue.size() >= pageFrameCount) {
                pageFramesQueue.poll();
            }
            pageFramesQueue.offer(pageNumber);
            pageFaultCount++;
        }
    }

    @Override
    public List<Integer> getPageFrames() {
        return new ArrayList<>(pageFramesQueue);
    }
}
