package cn.jun.util;

/**
 * Created on 2022-10-29
 */
public class ExceptionUtils {

    public static <T> T safeSupply(ThrowableSupplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @FunctionalInterface
    public interface ThrowableSupplier<T> {
        T get() throws Exception;
    }
}
