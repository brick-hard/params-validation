package utils;

import annotations.And;
import annotations.IntricateAnd;
import annotations.IntricateOr;
import annotations.Or;
import exceptions.*;

import java.lang.reflect.Field;

/**
 * desc:
 *
 * @author ljf
 * date: 2021/7/26
 */
public class ValidationUtils {
    public static void validateAnd(Object obj) {
        Class<?> objClass = obj.getClass();
        if (objClass.isAnnotationPresent(And.class)) {
            And and = objClass.getAnnotation(And.class);
            String[] values = and.values();
            allExist(obj, values);
        }
    }

    public static void validateOr(Object obj) {
        Class<?> objClass = obj.getClass();
        if (objClass.isAnnotationPresent(Or.class)) {
            Or or = objClass.getAnnotation(Or.class);
            String[] values = or.values();
            atLeastOneExist(obj, values);
        }
    }

    public static void validateIntricateAnd(Object obj) {
        Class<?> objClass = obj.getClass();
        if (objClass.isAnnotationPresent(IntricateAnd.class)) {
            IntricateAnd intricateAnd = objClass.getAnnotation(IntricateAnd.class);
            for (And and : intricateAnd.andRelations()) {
                String[] values = and.values();
                allExist(obj, values);
            }
            for (Or or : intricateAnd.orRelations()) {
                String[] values = or.values();
                atLeastOneExist(obj, values);
            }
        }
    }

    public static void validateIntricateOr(Object obj) {
        Class<?> objClass = obj.getClass();
        if (objClass.isAnnotationPresent(IntricateOr.class)) {
            IntricateOr intricateAnd = objClass.getAnnotation(IntricateOr.class);
            for (And and : intricateAnd.andRelations()) {
                String[] values = and.values();
                try {
                    allExist(obj, values);
                    return;
                } catch (Exception e) {
                    System.out.println("AndRelationS invalid");
                }
            }
            for (Or or : intricateAnd.orRelations()) {
                String[] values = or.values();
                try {
                    atLeastOneExist(obj, values);
                    return;
                } catch (Exception e) {
                    System.out.println("OrRelationS invalid ");
                }
            }
            throw new IntricateOrException("This intricateOr validation failed");
        }
    }

    private static void allExist(Object obj, String[] values) {
        for (String fieldStr : values) {
            try {
                Field field = obj.getClass().getField(fieldStr);
                field.setAccessible(true);
                if (field.get(obj) == null) {
                    throw new NoSuchParamException("No param: ".concat(fieldStr));
                }
            } catch (IllegalAccessException e1) {
                throw new NoAccessException("No access to get ".concat(fieldStr));
            } catch (NoSuchFieldException e2) {
                throw new NoThisFieldException("No field: ".concat(fieldStr));
            }
        }
    }

    private static void atLeastOneExist(Object obj, String[] values) {
        for (String fieldStr : values) {
            try {
                Field field = obj.getClass().getField(fieldStr);
                field.setAccessible(true);
                if (field.get(obj) != null) {
                    return;
                }
            } catch (IllegalAccessException e1) {
                throw new NoAccessException("No access to get ".concat(fieldStr));
            } catch (NoSuchFieldException e2) {
                throw new NoThisFieldException("No this field ".concat(fieldStr));
            }
        }
        throw new AllParamsNullException("All params are null");
    }
}
