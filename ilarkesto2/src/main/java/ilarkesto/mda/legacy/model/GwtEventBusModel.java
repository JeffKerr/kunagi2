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
package ilarkesto.mda.legacy.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class GwtEventBusModel extends AModel {

	private List<EventModel> events = new ArrayList<>();

    /**
     *
     */
    public GwtEventBusModel() {
		super("EventBus");
	}

    /**
     *
     * @param name
     * @return
     */
    public EventModel addEvent(String name) {
		EventModel model = new EventModel(name);
		events.add(model);
		return model;
	}

    /**
     *
     * @return
     */
    public List<EventModel> getEvents() {
		return events;
	}

}
