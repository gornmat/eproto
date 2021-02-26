package com.demo.eproto.service;

import com.demo.eproto.model.ImageFile;
import com.demo.eproto.model.User;
import com.demo.eproto.repository.ImageFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class ImageFileService {

    private static final String UPLOAD_DIR = "./uploads/";

    private final ImageFileRepository repository;

    public String uploadFile(User user, MultipartFile file) {
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        //TODO store files
//        try {
//            Path path = Paths.get(UPLOAD_DIR + fileName);
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//            var img = file.getInputStream().readAllBytes();
//            ImageFile imageFile = new ImageFile(user.getId(), fileName, img);
//            repository.save(imageFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return fileName;
    }

    @Nullable
    public byte[] getImagePath(Long idParent) {
        var img = repository.findByIdParent(idParent);
        return img.isPresent() ?
                img.map(ImageFile::getImg).orElseThrow() :
                null;
    }
}
