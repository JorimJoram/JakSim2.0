package com.twinkle.JakSim.model.dto.trainer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerImageDto {
    private int imageId;
    private String userId;
    private String imagePath;

}
