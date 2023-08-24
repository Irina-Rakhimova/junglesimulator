package java.ru.rakhimova.junglesimulator.util;

import ru.rakhimova.junglesimulator.entity.Bear;

public class EventSimulator {

    public void startSimulation(Bear bear) {
        while (chekStatus(bear)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 10) {
                sleepEvent(bear);
            }
            if (eventNumber >= 10 && eventNumber < 20) {
                climbTree(bear);
            }
            if (eventNumber >= 20 && eventNumber < 30) {
                hideEvent(bear);
            }
            if (eventNumber >= 30 && eventNumber < 40) {
                eatRaspberry(bear);
            }
            if (eventNumber >= 40 && eventNumber < 50) {
                eatHoney(bear);
            }
            if (eventNumber >= 50 && eventNumber < 60) {
                meetMoose(bear);
            }
            if (eventNumber >= 60 && eventNumber < 70) {
                hunterAttack(bear);
            }
            if (eventNumber >= 70 && eventNumber < 80) {
                catchFish(bear);
            }
            if (eventNumber >= 80 && eventNumber < 90) {
                eatFish(bear);
            }
            if (eventNumber >= 90 && eventNumber <= 100) {
                observePrey(bear);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("Ооо нет, медведь умер! Конец!");
    }

    private void sleepEvent(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() + 8;
        bear.setEnergy(energy);
        chekEnergy(bear);
        chekMaxEnergy(bear);
        System.out.println("Медведь впал в спячку! Зарядился! + 6 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void climbTree(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() - 4;
        bear.setEnergy(energy);
        chekEnergy(bear);
        chekMinEnergy(bear);
        System.out.println("Медведь залез на дерево! Устал! -4 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void hideEvent(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() - 2;
        bear.setEnergy(energy);
        chekEnergy(bear);
        chekMinEnergy(bear);
        System.out.println("Медведь укрылся! Струсил! - 2 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void eatRaspberry(Bear bear) {
        int health = bear.getHealth();
        health = bear.getHealth() + 2;
        bear.setHealth(health);
        chekEnergy(bear);
        chekMaxHealth(bear);
        System.out.println("Медведь съел малину! Подкрепился! +3 здоровья. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void eatHoney(Bear bear) {
        int health = bear.getHealth();
        health = bear.getHealth() + 2;
        bear.setHealth(health);
        chekEnergy(bear);
        chekMaxHealth(bear);
        System.out.println("Медведь съел мед! Полакомился! + 4 здоровья. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void meetMoose(Bear bear) {
        int health = bear.getHealth();
        int energy = bear.getEnergy();
        health = (int) (health - (double) (bear.getClaws() * 4));
        energy = (int) (energy - (double) (bear.getFangs() * 4));
        bear.setEnergy(energy);
        bear.setHealth(health);
        chekEnergy(bear);
        chekMinHealth(bear);
        chekMinEnergy(bear);
        System.out.println("Медведь встретил лося! Поранился! - 10 здоровья,- 21 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void hunterAttack(Bear bear) {
        int health = bear.getHealth();
        int energy = bear.getEnergy();
        health = (int) (health - (double) (bear.getClaws() * 6));
        energy = (int) (energy - (double) (bear.getFangs() * 6));
        bear.setEnergy(energy);
        bear.setHealth(health);
        chekEnergy(bear);
        chekMinEnergy(bear);
        chekMinHealth(bear);
        System.out.println("На медведя напал охотник! Ой-ой-ой как больно! - 15 здоровья, -28 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void catchFish(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() - 4;
        bear.setEnergy(energy);
        chekEnergy(bear);
        chekMinEnergy(bear);
        System.out.println("Медведь ловит рыбку! Проголодался! - 7 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void eatFish(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() + 10;
        bear.setEnergy(energy);
        chekEnergy(bear);
        chekMaxEnergy(bear);
        System.out.println("Медведь съел рыбку! Объелся! + 5 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void observePrey(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() - 5;
        bear.setEnergy(energy);
        chekEnergy(bear);
        chekMinEnergy(bear);
        System.out.println("Медведь наблюдает за добычей! Скоро охота! - 5 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private boolean chekStatus(Bear bear) {
        System.out.println("hp: " + bear.getHealth() + " energy: " + bear.getEnergy());
        return bear.getHealth() > 0;
    }

    private void chekEnergy(Bear bear) {
        if (bear.getEnergy() <= 0) {
            int health = bear.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
            bear.setHealth(health);
        }
    }

    private void chekMaxEnergy(Bear bear) {
        int energy = bear.getEnergy();
        if (bear.getEnergy() <= 100) {
            energy = 100;
        }
        bear.setEnergy(energy);
    }

    private void chekMinEnergy(Bear bear) {
        int energy = bear.getEnergy();
        if (bear.getEnergy() < 0) {
            energy = 0;
        }
        bear.setEnergy(energy);
    }

    private void chekMaxHealth(Bear bear) {
        int health = bear.getHealth();
        if (bear.getHealth() > 100) {
            health = 100;
        }
        bear.setHealth(health);
    }

    private void chekMinHealth(Bear bear) {
        int health = bear.getHealth();
        if (bear.getHealth() < 0) {
            health = 0;
        }
        bear.setHealth(health);
    }
}
