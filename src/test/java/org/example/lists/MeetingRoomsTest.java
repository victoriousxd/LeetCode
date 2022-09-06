package org.example.lists;

import org.junit.jupiter.api.Test;

class MeetingRoomsTest {
    @Test
    public void testTwoSumTest() {
        int[][] meetings = new int[3][2];
        meetings[2][0] = 1;
        meetings[2][1] = 3;
        meetings[1][0] = 2;
        meetings[1][1] = 3;
        meetings[0][0] = 3;
        meetings[0][1] = 4;

        MeetingRooms twoSum = new MeetingRooms();

        int result = twoSum.minMeetingRooms(meetings);
        System.out.println(result);

    }

    @Test
    public void testTwoSumTest2() {
        int[][] meetings = new int[4][2];
        meetings[2][0] = 1;
        meetings[2][1] = 3;
        meetings[1][0] = 2;
        meetings[1][1] = 3;
        meetings[0][0] = 3;
        meetings[0][1] = 6;
        meetings[3][0] = 3;
        meetings[3][1] = 5;
        MeetingRooms twoSum = new MeetingRooms();

        int result = twoSum.minMeetingRooms(meetings);
        System.out.println(result);

    }
}