package org.yuhee.catsoneday.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CatInListDto {

    private Long id;
    private String name;
    private String sex;
    private String furColor;

}
