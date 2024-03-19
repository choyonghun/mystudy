package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class EnginePropertyEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    String[] values = text.split(","); // model,maker,capacity,auto,createdDate

    Engine engine = new Engine();
    engine.setCc(Integer.parseInt(values[0]));
    engine.setModel(values[1]);
    engine.setValve(Integer.parseInt(values[2]));

    this.setValue(engine);

  }
}
