package net.outmoded.fastListenerRegistration;

import com.google.common.reflect.ClassPath;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class ListenerRegister {
    private ListenerRegister() {}

    public static void register(Plugin plugin){
        final ClassLoader loader = plugin.getClass().getClassLoader();
        try {

            ClassPath classpath = ClassPath.from(loader); // scans the class path used by classloader

            for (ClassPath.ClassInfo classInfo : classpath.getAllClasses()) {

                Class<?> aClass = classInfo.load();

                if (!Listener.class.isAssignableFrom(aClass)) {
                    continue;
                }

                EventListener classAnnotation = aClass.getAnnotation(EventListener.class);

                if (classAnnotation == null) {
                    continue;
                }

                Constructor<? extends Listener> constructor = (Constructor<? extends Listener>) aClass.getDeclaredConstructor();
                Listener listener = constructor.newInstance();

                plugin.getServer().getPluginManager().registerEvents(listener, plugin);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
