package structural.composite;

import java.awt.Color;

public class Demo {
    public static final Color DARK_GREEN = new Color(2, 113, 72);

    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, DARK_GREEN),
                        new Dot(240, 240, DARK_GREEN),
                        new Dot(240, 360, DARK_GREEN),
                        new Dot(360, 360, DARK_GREEN),
                        new Dot(360, 240, DARK_GREEN)
                )
        );
    }
}
