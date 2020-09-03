package ausyfinalproject.demo.Model.DAO;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateDeSerializer extends StdDeserializer<Date> {

    public DateDeSerializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.readValueAs(String.class);
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(value);
        } catch (DateTimeParseException | ParseException e) {
            //throw an error
            return null;
        }
    }

}