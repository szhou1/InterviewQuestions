/**
 * @param {number[][]} intervals
 * @return {number}
 */
var minMeetingRooms = function(intervals) {
    // sort by starting time
    // minRooms = 1
    // localRooms = 1
    // prev = interval[0]
    /**
     * for each interval
     *      if prev.end < curr.start
     *          localRooms++
     *          minRooms = MIN(minRooms, localRooms)
     *      else 
     *          localRooms = 1
     */
};