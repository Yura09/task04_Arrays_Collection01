package com.epam.collections.logicalTasksArrays.game;

import static com.epam.collections.logicalTasksArrays.game.Const.*;

public class MagicArtifact extends Door{

    public MagicArtifact() {
        power=RANDOM.nextInt(MAX_ARTIFACT_POWER-MIN_ARTIFACT_POWER)+MIN_ARTIFACT_POWER+1;

    }

    @Override
    public String toString() {
        return "MagicArtifact {" +
                "power=" + power +
                '}';
    }
}
