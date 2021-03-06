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
package ilarkesto.gwt.client;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import static com.google.gwt.event.dom.client.KeyCodes.KEY_ENTER;
import static com.google.gwt.event.dom.client.KeyCodes.KEY_ESCAPE;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import static ilarkesto.core.base.Str.isBlank;
import static ilarkesto.core.logging.ClientLog.DEBUG;
import ilarkesto.core.time.Time;

/**
 *
 *
 */
public abstract class ATimeViewEditWidget extends AViewEditWidget {

    private Label viewer;
    private TextBox editor;

    /**
     *
     * @return
     */
    @Override
    protected final Widget onViewerInitialization() {
        viewer = new Label();
        return viewer;
    }

    /**
     *
     * @return
     */
    @Override
    protected final Widget onEditorInitialization() {
        editor = new TextBox();
        editor.addFocusHandler(new EditorFocusHandler());
        editor.addKeyDownHandler(new EditorKeyboardListener());
        return editor;
    }

    /**
     *
     * @param value
     */
    public final void setViewerValue(Time value) {
        viewer.setText(value == null ? "." : value.toString());
    }

    /**
     *
     * @param value
     */
    public final void setEditorValue(Time value) {
        editor.setText(value == null ? null : value.toString());
        editor.setSelectionRange(0, editor.getText().length());
        editor.setFocus(true);
    }

    /**
     *
     * @return
     */
    public final Time getEditorValue() {
        String s = editor.getText();
        if (isBlank(s)) {
            return null;
        }
        try {
            return new Time(s);
        } catch (Exception ex) {
            DEBUG("Parsing time '" + s + "' failed: ", ex);
            return null;
        }
    }

    private class EditorKeyboardListener implements KeyDownHandler {

        @Override
        public void onKeyDown(KeyDownEvent event) {
            int keyCode = event.getNativeKeyCode();

            if (keyCode == KEY_ENTER) {
                submitEditor();
            } else if (keyCode == KEY_ESCAPE) {
                cancelEditor();
            }
        }
    }

    private class EditorFocusHandler implements FocusHandler {

        @Override
        public void onFocus(FocusEvent event) {
        }
    }
}
