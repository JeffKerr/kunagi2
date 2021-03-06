/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package ilarkesto.gwt.client.editor;

import ilarkesto.core.base.Utl;

/**
 *
 *
 * @param <T>
 */
public abstract class AEditorModel<T> extends AFieldModel<T> {

    /**
     *
     * @param value
     */
    public abstract void setValue(T value);

    /**
     *
     * @param oldValue
     * @param newValue
     */
    protected void onChangeValue(T oldValue, T newValue) {}

    /**
     *
     * @return
     */
    public boolean isEditable() {
		return true;
	}

    /**
     *
     * @param newValue
     */
    public void changeValue(T newValue) {
		T oldValue = getValue();
		if (Utl.equalObjects(oldValue, newValue)) {
                        return;
                }
		onChangeValue(oldValue, newValue);
		setValue(newValue);
	}

}
