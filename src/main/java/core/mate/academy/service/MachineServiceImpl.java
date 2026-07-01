package core.mate.academy.service;
import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    @Override
    public List<T> getAll(Class<? extends Machine> type) {
        if (type == Bulldozer.class) {
            BulldozerProducer bulldozerProducer = new BulldozerProducer();
            List<? extends Machine> machines = bulldozerProducer.get();
            return new ArrayList<>((List<T>) machines);
        } else if (type == Excavator.class) {
            ExcavatorProducer excavatorProducer = new ExcavatorProducer();
            List<? extends Machine> machines = excavatorProducer.get();
            return new ArrayList<>((List<T>) machines);
        } else if (type == Truck.class) {
            TruckProducer truckProducer = new TruckProducer();
            List<? extends Machine> machines = truckProducer.get();
            return new ArrayList<>((List<T>) machines);
        }
        return new ArrayList<>();
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        Collections.fill(machines, value);
    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
