package core.basesyntax.service.impl.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Operation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReturnOperationTest {
    private static final Operation OPERATION = Operation.RETURN;
    private static final String FRUIT = "banana";
    private static final int QUANTITY = 10;
    private static final int VALID_QUANTITY_AFTER = 20;
    private static final ReturnOperation RETURN_OPERATION = new ReturnOperation();
    private static FruitTransactionDto validTransactionDto;

    @BeforeAll
    static void setUp() {
        Storage.fruitStorage.put(FRUIT, QUANTITY);
        validTransactionDto = new FruitTransactionDto(OPERATION, FRUIT, QUANTITY);
    }

    @AfterAll
    static void clearStorage() {
        Storage.fruitStorage.clear();
    }

    @Test
    void handle_ReturnValidValue_Ok() {
        RETURN_OPERATION.handle(validTransactionDto);
        int actualQuantity = Storage.fruitStorage.get(FRUIT);
        assertEquals(VALID_QUANTITY_AFTER, actualQuantity);
        RETURN_OPERATION.handle(validTransactionDto);
        actualQuantity = Storage.fruitStorage.get(FRUIT);
        assertEquals(VALID_QUANTITY_AFTER + QUANTITY, actualQuantity);
    }
}