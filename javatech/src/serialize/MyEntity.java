package serialize;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyEntity implements Serializable {
    public String name;
    public String age;
}
