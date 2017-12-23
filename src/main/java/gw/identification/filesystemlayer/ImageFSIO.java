package gw.identification.filesystemlayer;

import org.springframework.web.multipart.MultipartFile;

public interface ImageFSIO {
    boolean save(MultipartFile file, Long id);
}