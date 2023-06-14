public class CrystalBalls {
    public int distance(boolean[] breaks) {
        int jam = (int) Math.floor(Math.sqrt(breaks.length));

        int i = jam;
        for (; i < breaks.length; i += jam) {
            if (breaks[i]) {
                break;
            }
        }

        i = -jam;

        for(int j = 0; j < jam && i < breaks.length; j++, i++) {
            if (breaks[i]) {
                return i;
            }
        }


        return -1;
    }
}
