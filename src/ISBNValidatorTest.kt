import org.junit.Test
import org.junit.Assert.*

class ISBNValidatorTest {

    @Test
    fun `ISBN with valid checksum should be valid`() {
        assertTrue("ISBN 3-598-21508-8 should be valid.", isValid("3-598-21508-8"))
    }

    @Test
    fun `ISBN with invalid checksum should be invalid`() {
        assertFalse("ISBN 3-598-21508-9 should be invalid.", isValid("3-598-21508-9"))
    }

    @Test
    fun `ISBN without dashes should be valid`() {
        assertTrue("ISBN 3598215088 should be valid.", isValid("3598215088"))
    }

    @Test
    fun `ISBN with X as check digit should be invalid`() {
        assertFalse("ISBN 0-596-90299-X should be invalid.", isValid("0-596-90299-X"))
    }

    @Test
    fun `ISBN with incorrect X position should be invalid`() {
        assertFalse("ISBN 0-596-9029X-1 should be invalid.", isValid("0-596-9029X-1"))
    }

    @Test
    fun `ISBN with invalid characters should be invalid`() {
        assertFalse("ISBN with invalid characters should be invalid.", isValid("3-598-P1581-8"))
    }

    @Test
    fun `ISBN with less than 10 characters should be invalid`() {
        assertFalse("ISBN with less than 10 characters should be invalid.", isValid("123456789"))
    }

    @Test
    fun `ISBN with more than 10 characters should be invalid`() {
        assertFalse("ISBN with more than 10 characters should be invalid.", isValid("1234567890123"))
    }
}
