package exceptions;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * desc:
 *
 * @author ljf
 * date: 2021/7/27
 */
public class IntricateOrException extends ValueException {

    public IntricateOrException(String message) {
        super(message);
    }

    public IntricateOrException(String message, String str) {
        super(message.replaceAll("%n", str));
    }
}
