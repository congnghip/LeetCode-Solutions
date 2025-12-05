import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> leftMax;
    private PriorityQueue<Integer> rightMin;
    public MedianFinder() {
        leftMax = new PriorityQueue<>(Collections.reverseOrder());
        rightMin = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //bỏ vào bên trái trước
        leftMax.add(num);
        //sau đó bỏ số lớn nhất vào bên phải (vì giá trị đi ra luôn là MAX)
        rightMin.add(leftMax.poll());
        //đảm bảo cân bằng kiểm đảm bảo left luôn hơn hoặc bằng right một giá trị
        //vì số lượng add vào có thể chẳn hoặc lẽ từ đó mình sử lý
        if(leftMax.size() < rightMin.size())
        {
            //bỏ một giá trị min của right vào lại max
            leftMax.add(rightMin.poll());
        }
    }
    
    public double findMedian() {
        //xử lý nếu số lượng số đưa vào là lẽ
        if (leftMax.size() > rightMin.size())
        {
            return leftMax.peek();
        }
        //xử lý nếu chẳng
        return (leftMax.peek() + rightMin.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */