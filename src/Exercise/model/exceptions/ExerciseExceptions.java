package Exercise.model.exceptions;

import java.io.Serial;

public class ExerciseExceptions extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public ExerciseExceptions (String msg){
        super(msg);
    }

}
