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
package ilarkesto.pdf;

import com.itextpdf.text.BaseColor;
import static com.itextpdf.text.BaseColor.BLACK;

/**
 *
 *
 */
public final class FontStyle {

    /**
     *
     */
    public static final String FONT_UBUNTU = "fonts/Ubuntu-R.ttf";

    /**
     *
     */
    public static final String FONT_LIBERATION_MONO = "fonts/LiberationMono-Regular.ttf";

    /**
     *
     */
    public static final String FONT_DEFAULT = FONT_UBUNTU;

    /**
     *
     */
    public static final String FONT_DEFAULT_FIXED = FONT_LIBERATION_MONO;

	private String font = FONT_DEFAULT;
	private float size = 4f;
	private boolean italic;
	private boolean bold;
	private BaseColor color = BLACK;

    /**
     *
     * @return
     */
    public boolean isItalic() {
		return italic;
	}

    /**
     *
     * @param italic
     * @return
     */
    public FontStyle setItalic(boolean italic) {
		this.italic = italic;
		return this;
	}

    /**
     *
     * @return
     */
    public boolean isBold() {
		return bold;
	}

    /**
     *
     * @param bold
     * @return
     */
    public FontStyle setBold(boolean bold) {
		this.bold = bold;
		return this;
	}

    /**
     *
     * @return
     */
    public float getSize() {
		return size;
	}

    /**
     *
     * @param size
     * @return
     */
    public FontStyle setSize(float size) {
		this.size = size;
		return this;
	}

    /**
     *
     * @return
     */
    public BaseColor getColor() {
		return color;
	}

    /**
     *
     * @param color
     * @return
     */
    public FontStyle setColor(BaseColor color) {
		this.color = color;
		return this;
	}

    /**
     *
     * @return
     */
    public String getFont() {
		return font;
	}

    /**
     *
     * @param font
     * @return
     */
    public FontStyle setFont(String font) {
		this.font = font;
		return this;
	}

	// --- ---

    /**
     *
     * @param style
     */
    
	public FontStyle(FontStyle style) {
		this.font = style.font;
		this.size = style.size;
		this.bold = style.bold;
		this.italic = style.italic;
		this.color = style.color;
	}

    /**
     *
     */
    public FontStyle() {}

}
