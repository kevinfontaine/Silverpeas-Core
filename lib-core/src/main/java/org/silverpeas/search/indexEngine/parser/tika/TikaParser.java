/*
 * Copyright (C) 2000 - 2012 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Affero General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of the GPL, you may
 * redistribute this Program in connection with Free/Libre Open Source Software ("FLOSS")
 * applications as described in Silverpeas's FLOSS exception. You should have recieved a copy of the
 * text describing the FLOSS exception, and it is also available here:
 * "http://www.silverpeas.org/docs/core/legal/floss_exception.html"
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.silverpeas.search.indexEngine.parser.tika;

import com.stratelia.silverpeas.silvertrace.SilverTrace;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.apache.tika.Tika;
import org.silverpeas.search.indexEngine.parser.Parser;

/**
 *
 * @author ehugonnet
 */
public class TikaParser implements Parser {

  private final Tika tika = initTika();

  private Tika initTika() {
    return new Tika();
  }

  @Override
  public Reader getReader(String path, String encoding) {
    try {
      return tika.parse(new File(path));
    } catch (IOException ex) {
      SilverTrace.error("util", "OpenxmlParser.getReader", "root.EX_LOAD_IO_EXCEPTION", ex);
    }
    return new StringReader("");
  }
}