package towersproject;

import towersproject.search.Move;
import towersproject.search.Node;
import lombok.Getter;

import java.util.*;

public class Hanoi {
    private final static List<Move> allMoves = List.of(
            new Move(0,1),
            new Move(0,2),
            new Move(1,0),
            new Move(1,2),
            new Move(2,0),
            new Move(2,1)
    );

    private final List<Tower> towers = List.of(Tower.full(DiscColor.BLUE), Tower.full(DiscColor.RED), Tower.empty());

    public List<Move> getPossibleMoves(){
        List<Move> res = new ArrayList<>();
        for (var move:allMoves) {
            if(move.isValid(towers))
                res.add(move);
        }
        return res;
    }

    public List<Move> solve(){
        var rnd = new Random();
        Deque<Node<Move>> queue = new LinkedList<>();
        Node<Move> node = new Node<>(getPossibleMoves().get(rnd.nextInt(getPossibleMoves().size())));
        queue.add(node);
        int count = 0;
        visualize();
        while (!queue.isEmpty() && count < 1_000_000_000) {
            count++;
            node = queue.poll();
            if (isDone(towers)) {
                System.out.println("Végeredmény:");
                visualize();
                var lepesek = Node.backtrace(node);
                System.out.println("Lépések száma: " + lepesek.size());
                return null;
            }

            node.getNode().make(towers);
            queue.removeIf(n -> !n.getNode().isValid(towers));
            var mm = getPossibleMoves();
            Collections.shuffle(mm);
            for (var m : mm) {
                var t = new Node<>(m, node);
                queue.offer(t);
            }

            if (count % 1_000_000 == 0)
                visualize();
        }
        return null;
    }

    public boolean isDone(List<Tower> towers){
        return towers.stream().filter(Tower::isComplete).count() == 2;
    }

    private void visualize() {
        for (int i = Tower.SIZE - 1; i >= 0; i--) {
            String[] asd = new String[towers.size()];
            for (int j = 0; j < towers.size(); j++) {
                if (towers.get(j).getDiscs().size() <= i) {
                    asd[j] = " ".repeat(Tower.SIZE) + "|";
                } else {
                    asd[j] = towers.get(j).getDiscs().get(i).toString();
                }
            }
            System.out.printf("%-18s".repeat(towers.size()) + "\n", (Object[]) asd);
        }
        System.out.println();
    }
}
