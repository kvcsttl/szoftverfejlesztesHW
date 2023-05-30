package towersproject.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Node <T>{
    private final T node;
    private Node<T> parent;

    @Override
    public String toString() {
        return node.toString();
    }

    public static <T> List<T> backtrace(Node<T> endNode) {
        List<T> route = new ArrayList<>();
        route.add(endNode.getNode());
        while (endNode.getParent() != null) {
            endNode = endNode.getParent();
            route.add(endNode.getNode());
        }
        Collections.reverse(route);
        return route;
    }
}
