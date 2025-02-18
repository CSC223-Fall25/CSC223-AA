package csc223.aa;
public class FUber {
    
    public static void main(String[] args) {
        System.out.println(euclidean(0,0,6,6));
        System.out.println(manhattan(0,0,6,6));
    }

    public static float euclidean(float x1, float y1, float x2, float y2) {
        float distance;
        // does operation, takes the squart root of ((x2 -x1)^2 + (y2 -y1)^2)
        distance = (float)Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
        return distance;
    }

    public static float manhattan(float x1, float y1, float x2, float y2) {
        float distance;
        //does operation, |x2- x1| + |y2- y1|
        distance = (float)Math.abs(x2 - x1) + Math.abs(y2 - y1);
        return distance;
    }

    
}

