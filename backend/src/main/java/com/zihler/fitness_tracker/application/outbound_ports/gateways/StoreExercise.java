package com.zihler.fitness_tracker.application.outbound_ports.gateways;

import com.zihler.fitness_tracker.domain.values.Exercise;

public interface StoreExercise {
    Exercise withValues(Exercise exercise);
}
