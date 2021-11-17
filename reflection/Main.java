package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        Method[] declaredMethods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> !m.getName().equals("toString"))
                .toArray(Method[]::new);

        Arrays.stream(declaredMethods)
                .filter(m -> m.getReturnType() != void.class)
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " have to be public!"));

        Arrays.stream(declaredMethods)
                .filter(m -> m.getReturnType() == void.class)
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " have to be private!"));

        List<Author> annotated = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getAnnotation(Author.class) != null)
                .map(m -> m.getAnnotation(Author.class))
                .collect(Collectors.toList());

        annotated.forEach(a -> System.out.println("Method author is " + a.name()));


        Point2D point2D = new Point2D(13, 42, "info");

        int x = point2D.x();

        int y = point2D.y();

        String info = point2D.info();

    }
}
