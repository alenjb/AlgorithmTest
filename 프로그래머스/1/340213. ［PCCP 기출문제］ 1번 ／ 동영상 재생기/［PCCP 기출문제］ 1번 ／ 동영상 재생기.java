class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        for (String command : commands) {
            int posInt = timeToInt(pos);
            int opStart = timeToInt(op_start);
            int opEnd = timeToInt(op_end);

            if (posInt >= opStart && posInt <= opEnd) {
                pos = op_end;
            }

            pos = calTime(pos, command, "00:00", video_len);
            
            posInt = timeToInt(pos);
    if (posInt >= opStart && posInt <= opEnd) {
        pos = op_end;
    }
        }
        return pos;
    }

    static int timeToInt(String s) {
        String[] parts = s.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    static String calTime(String time, String command, String start_limit, String end_limit) {
        int min = timeToInt(start_limit);
        int max = timeToInt(end_limit);
        int now = timeToInt(time);

        if (command.equals("next")) {
            now = Math.min(now + 10, max);
        } else { // prev
            now = Math.max(now - 10, min);
        }

        int minutes = now / 60;
        int seconds = now % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
