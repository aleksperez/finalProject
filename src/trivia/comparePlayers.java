package trivia;

import java.util.Comparator;

public class comparePlayers implements Comparator<player> {

    @Override
    public int compare(player player1, player player2) {
        return -(player1.getPoint() - player2.getPoint());
    }
}

