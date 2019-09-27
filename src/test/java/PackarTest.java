import com.mobiquityinc.exception.APIException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackarTest {

@Test
 public void CheckForFileisReading() throws APIException
{
    Packar packar =new Packar();
    String filePath ="";
    assertThrows( APIException.class,()->packar.pack(filePath));
}

}