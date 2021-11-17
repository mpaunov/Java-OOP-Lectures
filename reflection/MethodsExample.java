package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class MethodsExample {
    private static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            boolean firstIsGetter = f.getName().startsWith("get");
            boolean secondIsGetter = s.getName().startsWith("get");

            if (firstIsGetter && secondIsGetter) {
                return f.getName().compareTo(s.getName());
            }

            boolean firstIsSetter = f.getName().startsWith("set");
            boolean secondIsSetter = s.getName().startsWith("set");

            if (firstIsSetter && secondIsSetter) {
                return f.getName().compareTo(s.getName());
            }

            return Boolean.compare(secondIsGetter, firstIsGetter);
        }
    }


    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        Method[] allMethods = clazz.getDeclaredMethods();

        Arrays.stream(allMethods)
                .filter(m -> !m.getName().equals("toString"))
                .sorted(new MethodComparator())
                .forEach(MethodsExample::printMethodInfo);
    }

    private static void printMethodInfo(Method m) {
        System.out.println(m.getName().startsWith("get")
                ? String.format("%s will return class %s", m.getName(),
                    m.getReturnType().getSimpleName())
                : String.format("%s and will set field of class %s", m.getName(),
                    m.getParameterTypes()[0].getSimpleName()));
    }
}
