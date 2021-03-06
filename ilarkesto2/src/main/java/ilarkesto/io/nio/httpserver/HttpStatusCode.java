/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>
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
package ilarkesto.io.nio.httpserver;

/**
 *
 *
 */
public enum HttpStatusCode {

    /**
     *
     */
    BAD_REQUEST(400, "Bad Request"), 

    /**
     *
     */
    NOT_FOUND(404, "Not Found"), 

    /**
     *
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"), 

    /**
     *
     */
    NOT_IMPLEMENTED(
			501, "Not Implemented");

	private int code;
	private String text;

	HttpStatusCode(int code, String text) {
		this.code = code;
		this.text = text;
	}

    /**
     *
     * @return
     */
    public int getCode() {
		return code;
	}

    /**
     *
     * @return
     */
    public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return code + " " + text;
	}

}
