package core.utils.interfaces;

import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public interface FileUtil {

    /**
     * Using for reading list of values from file by path with type clazz
     *
     * @param path path to file with data
     * @param clazz of data
     * @param openOption option for file opening
     * @return List of type T
     * @param <T> returned type
     */
    <T> List<T> readListValueFromFile(Path path, Class<T> clazz, StandardOpenOption... openOption);

    /**
     *
     * @param path of file with data
     * @param data stream for writing
     * @param openOption option for file opening
     * @return result of writing to file
     */
    <T> boolean writeValueToFile(Path path, Stream<T> data, StandardOpenOption... openOption);

}
