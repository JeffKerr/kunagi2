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
// Copyright (c) 2006 Witoslaw Koczewski, http://www.koczewski.de
package ilarkesto.persistence;


import java.util.EventObject;

/**
 *
 * @param <E>
 */
public class EntityEvent<E extends AEntity> extends EventObject {
    private static final long serialVersionUID = 1L;

    private final E entity;

    /**
     *
     * @param source
     * @param entity
     */
    public EntityEvent(Object source, E entity) {
        super(source);
        this.entity = entity;
    }

    /**
     *
     * @return
     */
    public E getEntity() {
        return entity;
    }

    /**
     *
     * @param type
     * @return
     */
    public boolean isEntityType(Class<E> type) {
        return type.isAssignableFrom(entity.getClass());
    }

}
