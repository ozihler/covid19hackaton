package com.zihler.fitness_tracker.application.use_cases.workouts.view_all_workouts;

import com.zihler.fitness_tracker.application.outbound_ports.gateways.FetchWorkouts;
import com.zihler.fitness_tracker.application.outbound_ports.presenters.WorkoutsInOverviewPresenter;
import com.zihler.fitness_tracker.application.use_cases.workouts.view_all_workouts.context.ViewAllWorkoutsContext;
import com.zihler.fitness_tracker.application.use_cases.workouts.view_all_workouts.inbound_port.ViewAllWorkouts;
import com.zihler.fitness_tracker.application.use_cases.workouts.view_all_workouts.roles.DisplayableWorkouts;

public class ViewAllWorkoutsUseCase implements ViewAllWorkouts {
    private FetchWorkouts fetchWorkouts;

    public ViewAllWorkoutsUseCase(FetchWorkouts fetchWorkouts) {
        this.fetchWorkouts = fetchWorkouts;
    }

    @Override
    public void invokeWith(WorkoutsInOverviewPresenter output) {
        ViewAllWorkoutsContext.initialize(fetchWorkouts, output)
                .enactUseCase();
    }

}
