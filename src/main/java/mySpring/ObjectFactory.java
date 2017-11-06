package mySpring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by olexandra on 11/6/17.
 */
public class ObjectFactory {

    static Map<Class<?>, Object> map;

    static {
        map = new HashMap<>();
        map.put(Speaker.class, new ConsoleSpeaker());
        map.put(ICleaner.class, new CleanerImpl());
    }

    private Reflections scaner = new Reflections("mySpring");

    public static void main(String[] args) {
        ObjectFactory factory = new ObjectFactory();
        Speaker consoleSpeaker = factory.createObject(Speaker.class);
        consoleSpeaker.speak("I Strart");
        IRobot robot = factory.createObject(IRobot.class);
        robot.cleanRoom();
    }

    @SneakyThrows
    private <T> T createObject(Class<T> clazz) {
//        String simpleName = clazz.getSimpleName();
        T newObject;
        //is interface
        if (!clazz.isInterface()) {
            newObject = clazz.newInstance();
        } else {
            //is class
            Set<Class<? extends T>> classes = scaner.getSubTypesOf(clazz);
            if (classes.size() != 1) {
                throw new IllegalStateException("one implementaion should be");
            }
            newObject = classes.iterator().next().newInstance();
        }
        return newObject;
    }
/*
    @SneakyThrows
    private <T> T createObject(Class<T> clazz) {
//        String simpleName = clazz.getSimpleName();
        T newObject;
        //is interface
        if (map.containsKey(clazz)) {
            newObject = (T) map.get(clazz);
        } else {
            //is class
            Set<Class<? extends T>> classes = scaner.getSubTypesOf(clazz);
            if (classes.size() != 1){
                throw new IllegalStateException("one implementaion should be");
            }
            newObject = (T) classes.iterator().next();
//            newObject = clazz.newInstance();
        }
        return newObject;
    }
*/
}
