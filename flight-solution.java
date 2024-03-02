public class Solution {
    public static void main(String[] args) throws Exception {
        // Test case 1
        int[][] flights1 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println("Actual: " + findCheapestPrice(4, flights1, 0, 3, 1) + ", Expected: 700");

        // Test case 2
        int[][] flights2 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println("Actual: " + findCheapestPrice(4, flights2, 0, 3, 0) + ", Expected: -1");

        // Test case 3
        int[][] flights3 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println("Actual: " + findCheapestPrice(3, flights3, 0, 2, 0) + ", Expected: 500");
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int size = flights.length;
        int index = 0;
        int tempPrice = 0;
        int stopCount = 0;
        int travelPrice = 0;
        while(index != size) {
            int tempStopCount = 0;
            if (flights[index][0] == src) {
                if (flights[index][1] == dst) {
                     if(k == 0) {
                         
                         travelPrice = flights[index][2];
                         break;
                     }
                     tempPrice = flights[index][2];
                     
                } else {
                    tempStopCount = 1;
                    int nextSrc = flights[index][1];
                    int nextIndex = index+1;
        //             int[][] flights1 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        // System.out.println("Actual: " + findCheapestPrice(4, flights1, 0, 3, 1) + ", Expected: 700");
                    while (nextIndex != size) {
                        if (flights[nextIndex][0] == nextSrc) {
                            
                            if (flights[nextIndex][1] == dst) {
                                travelPrice += tempPrice;
                                tempStopCount += 1;
                                break;
                            } else {
                                nextSrc = flights[nextIndex][1];
                            }
                        }
                        nextIndex += 1;
                    }
                }
                stopCount = tempStopCount;
                if (stopCount > k) {
                        travelPrice = -1;
                    }
           }
            index += 1;
        }
        
        return travelPrice;
    }
}
