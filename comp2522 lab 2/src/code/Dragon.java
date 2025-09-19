package ca.bcit.comp2522.Fantasy;

import java.util.Date;

public class Dragon extends Creature {

    private static final int MINIMUM_FIRE_POWER = 0;
    private static final int MAXIMUM_FIRE_POWER = 100;
    private static final int FIRE_POWER_DECREMENT= 10;
    private static final int DAMAGE_DECREMENT = 20;

    private int firePower;

    public Dragon(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int firePower ) {
        super(name,
                dateOfBirth,
                health);
        validateFirePower(firePower);

        this.firePower = firePower;
    }


    private void validateFirePower(final int firePower) {
        if (firePower < MINIMUM_FIRE_POWER ||
                firePower > MAXIMUM_FIRE_POWER) {
            throw new IllegalArgumentException("Fire power must be between 1 and 100.");
        }
    }

    @Override
    public void getDetails() {
        StringBuilder sb;
        sb = new StringBuilder();

        sb.append(name);
        sb.append(", born on ");
        sb.append(dateOfBirth);
        sb.append(" (age: ");
        sb.append(getAgeYear());
        sb.append(") has ");
        sb.append(health);
        sb.append(" health.");
        sb.append(firePower);
        sb.append(" firePower.");

        System.out.println(sb.toString());
    }

    public void breathFire(final Creature target) throws LowFirePowerException {
        if (firePower < FIRE_POWER_DECREMENT) {
            throw new LowFirePowerException ("Not enough firePower to breathe fire! ");
        }
        firePower -= FIRE_POWER_DECREMENT;
        target.takeDamage(DAMAGE_DECREMENT );
    }

    public final void restoreFirePower(final int amount) {
        if (amount < MINIMUM_FIRE_POWER) {
            throw new IllegalArgumentException("Fire power cannot be larger than 100.");
        }
        firePower += amount;

        if(firePower > MAXIMUM_FIRE_POWER) {
            firePower = MAXIMUM_FIRE_POWER;
        }
    }

}



