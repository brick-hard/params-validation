package exceptions;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * desc:
 *
 * @author ljf
 * date: 2021/7/26
 */
public class AllParamsNullException extends ValueException {
    public AllParamsNullException(String message) {
        super(message);
    }

    public AllParamsNullException(String message, String str) {
        super(message.replaceAll("%n", str));
    }
}
