package com.twinkle.JakSim.model.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileService {

    public boolean updateProfileImage(MultipartFile data) {
        return true;
    }
}
