package towersproject.search;

import towersproject.Tower;

import java.util.ArrayList;
import java.util.List;

public record Move(int from, int to){

    public boolean isValid(List<Tower> towers) {
        var top = towers.get(from).getTop();
        return top != null && towers.get(to).canAdd(top);
    }

    public void make(List<Tower> towers){
        towers.get(to).add(towers.get(from).removeTop());
    }
}
