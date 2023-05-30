package towersproject;

public record Disc(DiscColor color, int size) {
    @Override
    public String toString() {
        return switch (color){
            case RED -> " ".repeat((Tower.SIZE - size)) + "r".repeat(size * 2);
            case BLUE -> " ".repeat((Tower.SIZE - size)) + "b".repeat(size * 2);
        };
    }
}
