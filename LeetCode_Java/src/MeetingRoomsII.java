import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * (si < ei), find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 * 
 * Tags: Heap, Greedy, Sort
 * @author wendi
 *
 */
public class MeetingRoomsII {

	/**
	 * Method3: Greedy
	 * @param Interval[] intervals
	 * @return int
	 * Time: O(2nlog(n))
	 * Space: O(2n)
	 */
	public int meetingRoomsIIII(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		int result = 0;
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int endIndex = 0;
		for (int i = 0; i < start.length; i++) {
			if (start[i] < end[endIndex]) {
				result++;
			}
			else {
				endIndex++;
			}
		}
		return result;
	}
	
	/**
	 * Method2: Sort + heap
	 * The priority queue will always be the minimum number of rooms required so far. If the next 
	 * meeting occurs after the next meeting's end time, then replace that meeting with the current 
	 * meeting. If the next meeting occurs before the next meeting's end time, then throw it on the 
	 * queue. When the loop is finished the priority queue represents the numbers of rooms 
	 * booked/rebooked across all meetings.
	 * @param Interval[] intervals
	 * @return int
	 * Time: O(nlog(n) + nlog(n))
	 * Space: O(n)
	 */
	public int meetingRoomsIII(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		// 1 sort intervals using Comparator<>()
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				if (a.start != b.start) return a.start - b.start;
				return a.end - b.end;
			}
		});
		// 2 use heap to record the sorted end time of each room, and then compare new inte.start 
		// with the heap.peek() to check whether it's an empty room. If it's not, no empty room 
		// right now, otherwise, poll the old inte from heap.
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (Interval inte: intervals) {
			if (!heap.isEmpty() && inte.start >= heap.peek()) {
				heap.poll();
			}
			heap.offer(inte.end);
		}		
		return heap.size();
	}
	
	/**
	 * Method1: Sort + list
	 * @param Interval[] intervals
	 * @return int
	 * Time: O(nlog(n) + n^2)
	 * Space: O(n)
	 */
	public int meetingRoomsII(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		// 1 sort intervals using Comparator<>()
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		// 2 use list to record the end time of a room, and compare new interval.start one by one 
		// to check whether there is an empty room
		List<Integer> endTime = new ArrayList<>();
		for (Interval inte: intervals) {
			if (endTime.isEmpty()) {
				endTime.add(inte.end);
				continue;
			}
			boolean can = false;
			for (int i = 0; i < endTime.size(); i++) {
				if (inte.start >= endTime.get(i)) {
					endTime.set(i, inte.end);
					can = true;
					break;
				}
			}
			if (!can) {
				endTime.add(inte.end);
			}
		}
		return endTime.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetingRoomsII result = new MeetingRoomsII();
		System.out.println(result.meetingRoomsII(new Interval[] {new Interval(5, 10), new Interval(0, 5), new Interval(8, 9)}));
		System.out.println(result.meetingRoomsIII(new Interval[] {new Interval(5, 10), new Interval(0, 5), new Interval(8, 9)}));
		System.out.println(result.meetingRoomsIIII(new Interval[] {new Interval(5, 10), new Interval(0, 5), new Interval(8, 9)}));
	}

}
