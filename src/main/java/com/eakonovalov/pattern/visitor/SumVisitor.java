package com.eakonovalov.pattern.visitor;

import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Created by Waine on 28.02.2017.
 */
public class SumVisitor implements ReflectiveVisitor {

    private int result;

    public void visitCollection(Collection c) {
        c.forEach(this::visit);
    }

    public void visitString(String s) {
        result += Integer.valueOf(s);
    }

    public void visitNumber(Number n) {
        result += n.intValue();
    }

    public void visitObject(Object o) {
    }

    @Override
    public void visit(Object o) {
        try {
            Method method = getMethod(o.getClass());
            method.invoke(this, o);
        } catch (Exception ignored) {
        }
    }

    private Method getMethod(Class c) {
        Class temp = c;
        while (temp != Object.class) {
            String method = temp.getName();
            method = "visit" + method.substring(method.lastIndexOf('.') + 1);
            try {
                return getClass().getMethod(method, temp);
            } catch (NoSuchMethodException e) {
                Class[] interfaces = temp.getInterfaces();
                for (Class i : interfaces) {
                    method = i.getName();
                    method = "visit" + method.substring(method.lastIndexOf('.') + 1);
                    try {
                        return getClass().getMethod(method, i);
                    } catch (NoSuchMethodException ignored) {
                    }
                }
                temp = temp.getSuperclass();
            }
        }
        try {
            return getClass().getMethod("visitObject", Object.class);
        } catch (Exception ignored) {
        }

        return null;
    }

    public int getResult() {
        return result;
    }

}
