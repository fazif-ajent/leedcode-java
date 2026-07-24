import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    Map<Integer, CheckIn> checkInMap;
    Map<String, int[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn data = checkInMap.get(id);

        String key = data.station + "-" + stationName;

        int[] value = travelMap.getOrDefault(key, new int[2]);

        value[0] += (t - data.time); // Total travel time
        value[1]++;                  // Number of trips

        travelMap.put(key, value);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;

        int[] value = travelMap.get(key);

        return (double) value[0] / value[1];
    }
}