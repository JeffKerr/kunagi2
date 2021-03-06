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
package ilarkesto.pdf;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import static ilarkesto.pdf.AImage.Align.LEFT;
import static ilarkesto.pdf.AImage.Align.RIGHT;
import java.io.File;

/**
 *
 *
 */
public abstract class AImage extends AParagraphElement {

    /**
     *
     */
    public enum Align {

        /**
         *
         */
        LEFT, 

        /**
         *
         */
        RIGHT
	}

    /**
     *
     */
    protected byte[] data;

    /**
     *
     */
    protected File file;

    /**
     *
     */
    protected Float scaleByHeight;

    /**
     *
     */
    protected Float scaleByWidth;

    /**
     *
     */
    protected Align align;

    /**
     *
     */
    protected float marginTop = 0f;

    /**
     *
     */
    protected float marginRight = 0f;

    /**
     *
     */
    protected float marginBottom = 0f;

    /**
     *
     */
    protected float marginLeft = 0f;

    /**
     *
     * @param parent
     * @param data
     */
    @SuppressWarnings("EI_EXPOSE_REP2")
	public AImage(APdfElement parent, byte[] data) {
		super(parent);
		this.data = data;
	}

    /**
     *
     * @param parent
     * @param file
     */
    public AImage(APdfElement parent, File file) {
		super(parent);
		this.file = file;
	}

    /**
     *
     * @return
     */
    public Align getAlign() {
		return align;
	}

	// --- helper ---

    /**
     *
     * @return
     */
    
	public AImage setAlignLeft() {
		return setAlign(LEFT);
	}

    /**
     *
     * @return
     */
    public AImage setAlignRight() {
		return setAlign(RIGHT);
	}

    /**
     *
     * @param top
     * @param right
     * @param bottom
     * @param left
     * @return
     */
    public AImage setMargin(float top, float right, float bottom, float left) {
		setMarginTop(top);
		setMarginRight(right);
		setMarginBottom(bottom);
		setMarginLeft(left);
		return this;
	}

    /**
     *
     * @param topBottom
     * @param leftRight
     * @return
     */
    public AImage setMargin(float topBottom, float leftRight) {
		return setMargin(topBottom, leftRight, topBottom, leftRight);
	}

    /**
     *
     * @param margin
     * @return
     */
    public AImage setMargin(float margin) {
		setMarginTop(margin);
		setMarginRight(margin);
		setMarginBottom(margin);
		setMarginLeft(margin);
		return this;
	}

	// --- dependencies ---

    /**
     *
     * @param marginTop
     * @return
     */
    
	public AImage setMarginTop(float marginTop) {
		this.marginTop = marginTop;
		return this;
	}

    /**
     *
     * @param marginRight
     * @return
     */
    public AImage setMarginRight(float marginRight) {
		this.marginRight = marginRight;
		return this;
	}

    /**
     *
     * @param marginBottom
     * @return
     */
    public AImage setMarginBottom(float marginBottom) {
		this.marginBottom = marginBottom;
		return this;
	}

    /**
     *
     * @param marginLeft
     * @return
     */
    public AImage setMarginLeft(float marginLeft) {
		this.marginLeft = marginLeft;
		return this;
	}

    /**
     *
     * @param scaleByHeight
     * @return
     */
    public AImage setScaleByHeight(Float scaleByHeight) {
		this.scaleByHeight = scaleByHeight;
		return this;
	}

    /**
     *
     * @param scaleByWidth
     * @return
     */
    public AImage setScaleByWidth(Float scaleByWidth) {
		this.scaleByWidth = scaleByWidth;
		return this;
	}

    /**
     *
     * @param align
     * @return
     */
    public AImage setAlign(Align align) {
		this.align = align;
		return this;
	}

}
