package com.bergaz.intermediate.the_core_platform.section_09;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WorkDispatchSystem {
    public void startWork(String workerTypeName, Object workerTarget) {
        try {
            Class<?> workerType = Class.forName(workerTypeName);
            Class<?> targetType = workerTarget.getClass();
            Constructor constructor = workerType.getConstructor(targetType);
            Object worker = constructor.newInstance(workerTarget);
            Method doWork = workerType.getMethod("doWork");
            doWork.invoke(worker);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
