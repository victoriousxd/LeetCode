package org.example.lists;

import org.example.utility.Utility;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/meeting-rooms-ii/">...</a>
 */

public class MeetingRooms {
    List<Room> meetingRooms = new LinkedList<>();
    int count = 0;

    private static int compareIntervals(int[] interval1, int[] interval2) {
        if (interval1[0] < interval2[0]) {
            return -1;
        } else if (interval1[0] > interval2[0]) {
            return 1;
        } else {
            if (interval1[1] < interval2[1]) {
                return -1;
            } else if (interval1[1] > interval2[1]) {
                return 1;
            }
            return 0;
        }
    }

    public void findMeetingRoom(int[] meeting) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meeting[0] >= meetingRooms.get(i).ending) {
                System.out.printf("Adding meeting: %d - %d to room %d%n", meeting[0], meeting[1], i);
                meetingRooms.get(i).addMeeting(meeting);
                return;
            }
        }

        meetingRooms.add(new Room(meeting));
    }

    public int naiveMeetingRooms(int[][] intervals) {
        int[][] sorted = mergeSortIntervals(intervals);
        Queue<Integer> ends = new PriorityQueue<>();
        Utility.print2dMatrix(sorted);
        for (int i = 0; i < sorted.length; i++) {
            findMeetingRoom(intervals[i]);
        }
        return count;
    }

    public int minMeetingRooms(int[][] intervals) {
        int[][] sorted = Arrays.stream(intervals).sorted(MeetingRooms::compareIntervals).toArray(int[][]::new);
        Queue<Integer> ends = new PriorityQueue<>();
        Utility.print2dMatrix(sorted);
        for (int[] ints : sorted) {

            if (ends.isEmpty() == false && ints[0] >= ends.peek()) {
                ends.remove();
            }
            ends.add(ints[1]);
        }
        return ends.size();
    }

    private int[][] mergeSortIntervals(int[][] intervals) {
        if (intervals.length == 2) {
            if (compareIntervals(intervals[0], intervals[1]) == 1) {
                int[] larger = intervals[0];
                intervals[0] = intervals[1];
                intervals[1] = larger;
            }
        } else if (intervals.length > 2) {
            int leftSize = intervals.length / 2;
            int[][] left = mergeSortIntervals(
                    copyTo(
                            intervals,
                            new int[leftSize][2],
                            0,
                            leftSize));
            int[][] right = mergeSortIntervals(
                    copyTo(
                            intervals,
                            new int[intervals.length - leftSize][2],
                            leftSize,
                            intervals.length));

            int l = 0, r = 0, index = 0;
            while (index < intervals.length) {
                if (l >= left.length) {
                    intervals[index] = right[r++];
                } else if (r >= right.length) {
                    intervals[index] = left[l++];
                } else {
                    if (compareIntervals(left[l], right[r]) == 1) {
                        intervals[index] = right[r++];
                    } else {
                        intervals[index] = left[l++];
                    }
                }
                index++;

            }
        }
        return intervals;
    }

    private int[][] copyTo(int[][] source, int[][] destination, int start, int end) {
        int index = 0;
        while (start < end) {
            destination[index++] = source[start++];
        }
        return destination;
    }

    public class Room {
        public int ending;
        public int id;

        public Room(int[] meeting) {
            System.out.printf("Creating room %d for meeting: %d - %d%n", id, meeting[0], meeting[1]);
            id = ++count;
            addMeeting(meeting);
        }

        public void addMeeting(int[] meeting) {
            ending = meeting[1];
        }


    }
}
