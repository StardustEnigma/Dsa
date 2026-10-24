class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months={0,0,31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int overlap=0;

        String[] arriveA=arriveAlice.split("-");
        String[] leaveA=leaveAlice.split("-");
        String[] arriveB=arriveBob.split("-");
        String[] leaveB=leaveBob.split("-");

        
        int aliceAriveDay=months[Integer.parseInt(arriveA[0])] + Integer.parseInt(arriveA[1]);
        int aliceLeaveDay=months[Integer.parseInt(leaveA[0])] + Integer.parseInt(leaveA[1]);
        int bobAriveDay=months[Integer.parseInt(arriveB[0])] + Integer.parseInt(arriveB[1]);
        int bobLeaveDay=months[Integer.parseInt(leaveB[0])] + Integer.parseInt(leaveB[1]);

        int start=Math.max(aliceAriveDay,bobAriveDay);
        int end=Math.min(aliceLeaveDay,bobLeaveDay);

        return Math.max(0,end-start+1);
        

    }
}