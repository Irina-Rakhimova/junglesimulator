package ru.rakhimova.junglesimulator.util;

import ru.rakhimova.junglesimulator.entity.Bear;

public class EventSimulator {

    public void startSimulation(Bear bear) {
        Math.random();
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
        if (energy > 100) {
            energy = 100;
        }
        bear.setEnergy(energy);
        System.out.println("Медведь впал в спячку! Зарядился! + 6 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void climbTree(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() - 4;
        if (energy < 0) {
            energy = 0;
        }
        bear.setEnergy(energy);
        System.out.println("Медведь залез на дерево! Устал! -4 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void hideEvent(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() - 2;
        if (energy > 100) {
            energy = 100;
        }
        bear.setEnergy(energy);
        System.out.println("Медведь укрылся! Струсил! - 2 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void eatRaspberry(Bear bear) {
        int health = bear.getHealth();
        health = bear.getHealth() + 2;
        if (health > 100) {
            health = 100;
        }
        bear.setHealth(health);
        System.out.println("Медведь съел малину! Подкрепился! +3 здоровья. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void eatHoney(Bear bear) {
        int health = bear.getHealth();
        health = bear.getHealth() + 2;
        if (health > 100) {
            health = 100;
        }
        bear.setHealth(health);
        System.out.println("Медведь съел мед! Полакомился! + 4 здоровья. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void meetMoose(Bear bear) {
        int health = bear.getHealth();
        int energy = bear.getEnergy();
        health = (int) (health - (double) (bear.getClaws() * 4));
        if (health < 0) {
            health = 0;
        }
        energy = (int) (energy - (double) (bear.getFangs() * 4));
        if (energy < 0) {
            energy = 0;
        }
        bear.setHealth(health);
        bear.setEnergy(energy);
        System.out.println("Медведь встретил лося! Поранился! - 10 здоровья,- 21 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void hunterAttack(Bear bear) {
        int health = bear.getHealth();
        int energy = bear.getEnergy();
        health = (int) (health - (double) (bear.getClaws() * 6));
        if (health < 0) {
            health = 0;
        }
        energy = (int) (energy - (double) (bear.getFangs() * 6));
        if (energy < 0) {
            energy = 0;
        }
        bear.setHealth(health);
        bear.setEnergy(energy);
        System.out.println("На медведя напал охотник! Ой-ой-ой как больно! - 15 здоровья, -28 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void catchFish(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() - 4;
        if (energy < 0) {
            energy = 0;
        }
        bear.setEnergy(energy);
        System.out.println("Медведь ловит рыбку! Проголодался! - 7 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void eatFish(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() + 10;
        if (energy > 100) {
            energy = 100;
        }
        bear.setEnergy(energy);
        System.out.println("Медведь съел рыбку! Объелся! + 5 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private void observePrey(Bear bear) {
        int energy = bear.getEnergy();
        energy = bear.getEnergy() - 5;
        if (energy < 0) {
            energy = 0;
        }
        bear.setEnergy(energy);
        System.out.println("Медведь наблюдает за добычей! Скоро охота! - 5 энергии. Текущее здоровье: " + bear.getHealth() + " Текущая энергия: " + bear.getEnergy());
    }

    private boolean chekStatus(Bear bear) {
        System.out.println("hp: " + bear.getHealth() + " energy: " + bear.getEnergy());
        if (bear.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
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
}
