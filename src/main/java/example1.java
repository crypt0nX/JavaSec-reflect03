import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

public class example1 {
    public static void main(String[] args) throws Exception {
        execute3();
    }

    public static void execute1() throws Exception{
        Class<?> clazz = Class.forName("java.lang.ProcessBuilder");
        ((ProcessBuilder) clazz.getConstructor(List.class).newInstance(Arrays.asList("/System/Applications/Calculator.app/Contents/MacOS/Calculator"))).start();
    }

    public static void execute2() throws Exception{
        Class<?> clazz = Class.forName("java.lang.ProcessBuilder");
        ((ProcessBuilder) clazz.getConstructor(String[].class).newInstance(new String[][]{{"/System/Applications/Calculator.app/Contents/MacOS/Calculator"}})).start();
    }

    public static void execute3() throws Exception{
        ProcessBuilder result = null;
        Method startMethod = null;
        Class<?> clazz = Class.forName("java.lang.ProcessBuilder");
        startMethod = clazz.getMethod("start");
        Constructor<?> clazzConstructor = clazz.getConstructor(String[].class);
        result =  (ProcessBuilder)clazzConstructor.newInstance(new String[][]{{"/System/Applications/Calculator.app/Contents/MacOS/Calculator"}});
        startMethod.invoke(result);
    }
}
