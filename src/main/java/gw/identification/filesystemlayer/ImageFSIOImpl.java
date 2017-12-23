package gw.identification.filesystemlayer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
@PropertySource(value = "classpath:filesystem.properties")
public class ImageFSIOImpl implements ImageFSIO {
    @Value("${path}")
    private String location;
    @Value("${fileName}")
    private String fileName;

    @Override
    public boolean save(MultipartFile file, Long id) {
        String name = file.getOriginalFilename();
        String extension = name.substring(name.lastIndexOf(".")+1);;
        Path path = Paths.get(location + "/" + id + "_" + fileName + "." + extension);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, path);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}