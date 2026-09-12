/*
 * Maximum Meetings in One Room | Practice | GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Greedy > Medium
 * Time complexity: O(NlogN)+O(2N)
 * Space complexity: O(3*N + N)
 * Solved: 2026-09-12
 * URL: https://www.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Think greedily for the meetings which are ending earlier should be allotted and then save time for further meetings.
Some mistakes are also there like regarding custom class array and its object creation
 */

}
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        int n = s.length;
        Meeting[] meetings = new Meeting[n];
        for(int i=0;i<n;i++){
            meetings[i] = new Meeting(s[i],f[i],i+1);
            //Mistake-- > meetings[i].start = s[i];
            // meetings[i].end = f[i];
            // meetings[i].pos = i+1;
        }
        //2nd mistake - Import java utiln arrays , and not directly do meetings.sort rather do call Arrays.sort
        Arrays.sort(meetings,((a,b)->Integer.compare(a.end,b.end)));
        ArrayList<Integer> result = new ArrayList<>();
        int freeTime = -1;
        for(Meeting meet:meetings){
            int start = meet.start;
            int end = meet.end;
            int pos = meet.pos;
            if(start>freeTime){
                freeTime = end;
                result.add(pos);
            }
        }
        //This was also a mistake returning directly collections.sort which returns void so first sort the list then return it in differet line
        Collections.sort(result);
        return result ;
    }
