package towersproject;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Tower {
    public static final int SIZE = 8;
    private final LinkedList<Disc> discs = new LinkedList<>();
    private Tower(List<Disc> other){discs.addAll(other);}
    public static Tower empty(){return new Tower();}
    public static Tower full(DiscColor baseColor){
        var tower = new Tower();
        var curColor = baseColor;
        for (int i = 0; i < SIZE; i++) {
                tower.discs.add(new Disc(curColor,SIZE-i));
                curColor = switch (curColor){
                    case RED -> DiscColor.BLUE;
                    case BLUE -> DiscColor.RED;
                };
        }
        return tower;
    }

    public LinkedList<Disc> getDiscs() {
        return discs;
    }
    public boolean canAdd(Disc disc){
        return discs.isEmpty() || discs.get(discs.size()-1).size() >= disc.size();
    }
    public void add(Disc disc){
        if (!canAdd(disc)) throw new IllegalStateException("cant add disc ("+disc+") to top ("+discs.get(discs.size()-1).toString()+")");
        discs.add(disc);
    }
    public Disc getTop() {
        return discs.isEmpty() ? null : discs.get(discs.size() - 1);
    }
    public Disc removeTop() {
        return discs.remove(discs.size() - 1);
    }
    public boolean isComplete() {
        if (discs.isEmpty()) return false;
        int redCount = 0;
        int blueCount = 0;
        for (var d : discs) {
            if (d.color() == DiscColor.RED)
                redCount++;
            else if (d.color() == DiscColor.BLUE)
                blueCount++;
        }
        return redCount == SIZE || blueCount == SIZE;
    }
}
