class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] requestsHandled = new int[k];

        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int maxRequests = 0;

        for (int i = 0; i < arrival.length; i++) {
            int arrTime = arrival[i];
            int loadTime = load[i];

            while (!busy.isEmpty() && busy.peek()[0] <= arrTime) {
                available.add(busy.poll()[1]);
            }

            if (available.isEmpty()) {
                continue; 
            }

            Integer target = available.ceiling(i % k);
            if (target == null) {
                target = available.first(); 
            }

            available.remove(target);
            busy.offer(new int[]{arrTime + loadTime, target});
            requestsHandled[target]++;

            maxRequests = Math.max(maxRequests, requestsHandled[target]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestsHandled[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}