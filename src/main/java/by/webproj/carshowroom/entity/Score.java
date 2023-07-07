package by.webproj.carshowroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Score {
    private final Long id;
    private final String name;
    private final Long scope;
}
