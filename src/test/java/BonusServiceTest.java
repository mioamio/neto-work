import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() { //следует Рассчитать Для Зарегистрированных И Находящихся До Лимита
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000; // сумма покупки
        boolean registered = true; // статус пользователя
        long expected = 30; // ожидаемый результат

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() { // следует Рассчитать Для Зарегистрированных И Превышающих Лимит
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shoulBeCalculatedForunregisteredAndUnderLimit() { //следует Рассчитать Для неЗарегистрированных И Находящихся До Лимита
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000; // сумма покупки
        boolean registered = false; // статус пользователя
        long expected = 10; // ожидаемый результат

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void ItshouldBecalculatedForunregisteredAndExceedingLimit() { // следует Рассчитать Для неЗарегистрированных И Превышающих Лимит
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimitborder_1() { //граница лимита ==
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 16667; // сумма покупки
        boolean registered = true; // статус пользователя
        long expected = 500; // ожидаемый результат

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimitborder_2() { //граница лимита -1
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 16666; // сумма покупки
        boolean registered = true; // статус пользователя
        long expected = 499; // ожидаемый результат

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimitborder_3() { //граница лимита +1
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 16668; // сумма покупки
        boolean registered = true; // статус пользователя
        long expected = 500; // ожидаемый результат

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}