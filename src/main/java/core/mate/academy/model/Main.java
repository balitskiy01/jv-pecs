package core.mate.academy;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import core.mate.academy.service.MachineService;
import core.mate.academy.service.MachineServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MachineService<Machine> machineService = new MachineServiceImpl<>();

        System.out.println("--- 1. Тест методу getAll() ---");
        List<Machine> bulldozers = machineService.getAll(Bulldozer.class);
        System.out.println("Отримано машин: " + bulldozers.size());

        System.out.println("\n--- 2. Тест методу startWorking() ---");
        machineService.startWorking(bulldozers);

        System.out.println("\n--- 3. Тест методу fill() ---");
        List<Machine> emptyList = new ArrayList<>();
        emptyList.add(null);
        emptyList.add(null);

        System.out.println("Список до fill: " + emptyList);

        Truck truckTemplate = new Truck();
        machineService.fill(emptyList, truckTemplate);

        System.out.println("Список після fill: " + emptyList);
    }
}
