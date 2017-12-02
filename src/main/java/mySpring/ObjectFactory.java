package mySpring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.*;

/**
 * Created by olexandra on 11/6/17.
 */
public class ObjectFactory {

    List<ObjectConfigurator> objectConfigurators = new ArrayList<>();
    private static Map<Class<?>, Object> map;

    static {
        map = new HashMap<>();
//        map.put(Speaker.class, new ConsoleSpeaker());
//        map.put(ICleaner.class, new CleanerImpl());
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
        if (map.containsKey(clazz)) {
            //object was created
            return (T) map.get(clazz);
        } else {
            //object will be new
            if (!clazz.isInterface()) {
                //is class
                newObject = clazz.newInstance();
                map.put(clazz, newObject);
            } else {
                //is interface
                Set<Class<? extends T>> classes = scaner.getSubTypesOf(clazz);
                if (classes.size() != 1) {
                    throw new IllegalStateException("one implementaion should be");
                }
                newObject = classes.iterator().next().newInstance();
            }
            map.put(clazz, newObject);
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
