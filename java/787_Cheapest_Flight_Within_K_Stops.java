/*
 * Problem: 787. Cheapest Flights Within K Stops
 * 
 * Description:
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei]
 * indicates that there is a flight from city fromi to city toi with cost pricei. You are also given three integers src, dst, and k,
 * return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 * 
 * Requirements:
 * - Find cheapest price from src to dst
 * - At most k stops allowed
 * - Return -1 if no route exists
 * 
 * Example:
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation: The graph is shown above. The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * 
 * Constraints:
 * - 1 <= n <= 100
 * - 0 <= flights.length <= (n * (n - 1) / 2)
 * - flights[i].length == 3
 * - 0 <= fromi, toi < n
 * - fromi != toi
 * - 1 <= pricei <= 10^4
 * - There will not be any multiple flights between two cities
 * - 0 <= src, dst, k < n
 * - src != dst
 */

class Solution {
    //using bellman ford
    
    public void computePrice(int[][]flights, int[] prices, int [] temp){
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            
            if(prices[u] != Integer.MAX_VALUE){
                if(prices[u] + price < temp[v]){
                    temp[v] = prices[u] + price;
                }
            }
        }
    }
    
    public void copyTempToPrice(int[] prices, int[] temp){
        for(int i=0; i<prices.length; i++){
            prices[i] = temp[i];
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        int[] temp = new int[n];
        
        Arrays.fill(prices, Integer.MAX_VALUE);
        Arrays.fill(temp, Integer.MAX_VALUE);
        
        prices[src] = 0;
        temp[src] = 0;
        
        for(int i=0; i<=k; i++){
            computePrice(flights, prices, temp);
            copyTempToPrice(prices, temp);
        }
        
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}