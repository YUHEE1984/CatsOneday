package org.yuhee.catsoneday.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CreateCatDto {

    private String name;
    private String sex;
    private String breeds;
    private int age;
    private int weightInKg;
    private String furColor;
    private String furPattern;
    private String eyeColor;

}
