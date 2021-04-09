package main.citizens;

import main.IAccuser;
import main.jurists.Attorney;

import java.util.HashSet;

public interface ICitizenAccuser extends IAccuser {
    HashSet<Attorney> getAttorneys();
}
