package exceptions;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * desc:
 *
 * @author ljf
 * date: 2021/7/26
 */
public class NoAccessException extends ValueException {
    public NoAccessException(String message) {
        super(message);
    }

    public NoAccessException(String message, String str) {
        super(message.replaceAll("%n", str));
    }
}
