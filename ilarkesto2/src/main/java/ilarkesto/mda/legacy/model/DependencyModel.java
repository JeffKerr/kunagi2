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
package ilarkesto.mda.legacy.model;

/**
 *
 *
 */
public class DependencyModel extends AModel {

	private String type;

    /**
     *
     * @return
     */
    public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

        @Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof DependencyModel)) {
                        return false;
                }
		return getName().equals(((DependencyModel) obj).getName());
	}

	// --- dependencies ---

    /**
     *
     * @param type
     * @param name
     */
    
	public DependencyModel(String type, String name) {
		super(name);
		this.type = type;
	}

}
