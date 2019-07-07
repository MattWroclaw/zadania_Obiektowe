package com.model.day1.serializacja;

import javax.tools.Diagnostic;
import java.io.Serializable;
import java.util.List;

public class StacjaMevo implements Serializable {

    List<Rower> stacja1001;

    public StacjaMevo(List<Rower> stacja1001) {
        this.stacja1001 = stacja1001;
    }
}
