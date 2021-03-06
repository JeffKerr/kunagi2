/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package ilarkesto.form;

import ilarkesto.core.time.Time;
import java.util.Collection;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;

/**
 *
 *
 */
public class TimeFormField extends AFormField {

	private String value;

    /**
     *
     * @param name
     */
    public TimeFormField(String name) {
		super(name);
	}

    /**
     *
     * @param value
     * @return
     */
    public TimeFormField setValue(Time value) {
		this.value = value == null ? null : value.toString();
		return this;
	}

    /**
     *
     * @param data
     * @param uploadedFiles
     */
    @Override
	public void update(Map<String, String> data, Collection<FileItem> uploadedFiles) {
		String newValue = prepareValue(data.get(getName()));
		if (value == null ? newValue == null : value.equals(newValue)) {
                        return;
                }
		value = newValue;
		fireFieldValueChanged();

	}

	private static String prepareValue(String s) {
		if (s == null) {
                        return null;
                }
		s = s.trim();
		if (s.length() == 0) {
                        return null;
                }
		try {
			return new Time(s).toString();
		} catch (Exception ex) {
			return s;
		}
	}

    /**
     *
     * @throws ValidationException
     */
    @Override
	public void validate() throws ValidationException {
		if (value == null) {
			if (isRequired()) { throw new ValidationException("Eingabe erforderlich"); }
		} else {
			try {
				new Time(value);
			} catch (Exception ex) {
				throw new ValidationException("Eingabe muss eine Uhrzeit sein. " + ex.getMessage());
			}
		}

	}

    /**
     *
     * @return
     */
    @Override
	public String getValueAsString() {
		return value;
	}

    /**
     *
     * @return
     */
    public Time getValueAsTime() {
		return value == null ? null : new Time(value);
	}

}
