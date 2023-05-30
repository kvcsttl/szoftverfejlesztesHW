package towersproject.search;

import towersproject.Tower;

import java.util.ArrayList;
import java.util.List;

public record Move(int from, int to){
    public static List<Move> ALL_MOVES = List.of(
            new Move(0,1),
            new Move(0,2),
            new Move(1,0),
            new Move(1,2),
            new Move(2,0),
            new Move(2,1)
    );

    public boolean isValid(List<Tower> towers) {
        var top = towers.get(from).getTop();
        return top != null && towers.get(to).canAdd(top);
    }

    public void make(List<Tower> towers){
        towers.get(to).add(towers.get(from).removeTop());
    }
}
