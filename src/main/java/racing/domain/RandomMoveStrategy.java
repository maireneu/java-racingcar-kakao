package racing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int STOP_VALUE = 4;
    private static final int MAX_VALUE = 10;
    private static Random random;

    static {
        random = new Random();
    }

    @Override
    public boolean movable() {
        return random.nextInt(MAX_VALUE) >= STOP_VALUE;
    }
}
