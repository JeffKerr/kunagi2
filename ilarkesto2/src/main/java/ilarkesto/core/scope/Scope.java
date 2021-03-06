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
package ilarkesto.core.scope;

import static ilarkesto.core.base.Str.getSimpleName;
import static ilarkesto.core.scope.ScopeManager.getInstance;
import static ilarkesto.core.scope.ScopeUtil.getComponentName;
import java.util.List;

/**
 *
 *
 */
public abstract class Scope {

	/**
	 * Gets an initialized component by name.
         * @param name
         * @return 
	 */
	public abstract Object getComponent(String name);

    /**
     *
     * @return
     */
    public abstract List getAllComponents();

    /**
     *
     * @param <T>
     * @param name
     * @param component
     * @return
     */
    public abstract <T> T putComponent(String name, T component);

    /**
     *
     * @return
     */
    public String getName() {
		return getSimpleName(getClass());
	}

	@Override
	public String toString() {
		return getName();
	}

	// --- helper ---

    /**
     *
     * @param <T>
     * @param component
     * @return
     */
    
	public <T> T putComponent(T component) {
		if (component == null) {
                        throw new IllegalArgumentException("component == null");
                }
		return putComponent(getComponentName(component.getClass()), component);
	}

    /**
     *
     * @param <T>
     * @param type
     * @return
     */
    public <T> T getComponent(Class<T> type) {
		String name = getComponentName(type);
		return (T) getComponent(name);
	}

    /**
     *
     * @return
     */
    public static Scope get() {
		return getInstance().getScope();
	}

}