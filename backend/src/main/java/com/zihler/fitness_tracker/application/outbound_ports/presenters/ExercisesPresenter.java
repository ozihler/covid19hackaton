package com.zihler.fitness_tracker.application.outbound_ports.presenters;

import com.zihler.fitness_tracker.application.outbound_ports.documents.ExercisesDocument;

public interface ExercisesPresenter {
    void present(ExercisesDocument exercisesDocument);
}
