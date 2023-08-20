package ru.rakhimova.junglesimulator._main;

import ru.rakhimova.junglesimulator.entity.Bear;
import ru.rakhimova.junglesimulator.util.EventSimulator;

public class _Main {

    public static void main(String[] args) {
        Bear bear = new Bear();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(bear);
    }
}
