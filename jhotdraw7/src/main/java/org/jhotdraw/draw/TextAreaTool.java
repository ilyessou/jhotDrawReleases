/*
 * @(#)TextTool.java  2.0  2006-01-14
 *
 * Copyright (c) 1996-2006 by the original authors of JHotDraw
 * and all its contributors ("JHotDraw.org")
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * JHotDraw.org ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with
 * JHotDraw.org.
 */


package org.jhotdraw.draw;

import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import org.jhotdraw.geom.*;
/**
 * A tool to create new or edit existing figures that implement the TextHolderFigure
 * interface, such as TextAreaFigure. The figure to be created is specified by a
 * prototype.
 * <p>
 * To create a figure using the TextAreaTool, the user does the following mouse
 * gestures on a DrawingView:
 * <ol>
 * <li>Press the mouse button over the DrawingView. This defines the
 * start point of the Figure bounds.</li>
 * <li>Drag the mouse while keeping the mouse button pressed, and then release
 * the mouse button. This defines the end point of the Figure bounds.</li>
 * </ol>
 * When the user has performed these mouse gesture, the TextAreaTool overlays
 * a text area over the drawing where the user can enter the text for the Figure.
 * <p>
 * To edit an existing text figure using the TextAreaTool, the user does the
 * following mouse gesture on a DrawingView:
 * <ol>
 * <li>Press the mouse button over a Figure on the DrawingView.</li>
 * </ol>
 * The TextAreaTool then uses Figure.findFigureInside to find a Figure that
 * implements the TextHolderFigure interface and that is editable. Then it overlays
 * a text area over the drawing where the user can enter the text for the Figure.
 *
 * @author Werner Randelshofer
 * @version 2.0 2006-01-14 Changed to support double precison coordinates.
 * <br>1.0 2003-12-01 Derived from JHotDraw 5.4b1.
 *
 * @see TextHolderFigure
 * @see FloatingTextArea
 */
public class TextAreaTool extends CreationTool implements ActionListener {
    private FloatingTextArea   textArea;
    private TextHolderFigure  typingTarget;
    /**
     * Rubberband color of the tool. When this is null, the tool does not
     * draw a rubberband.
     */
    private Color rubberbandColor = null;
    
    /** Creates a new instance. */
    public TextAreaTool(TextHolderFigure prototype) {
        super(prototype);
    }
    public TextAreaTool(TextHolderFigure prototype, Map attributes) {
        super(prototype, attributes);
    }
    
    /**
     * Sets the rubberband color for the tool. Setting this to null, disables
     * the rubberband.
     *
     * @param c Rubberband color or null.
     */
    public void setRubberbandColor(Color c) {
        rubberbandColor = c;
    }
    
    
    public void deactivate(DrawingEditor editor) {
        endEdit();
        super.deactivate(editor);
    }
    
    /**
     * Creates a new figure at the mouse location.
     * If editing is in progress, this finishes editing.
     */
    public void mousePressed(MouseEvent e) {
        TextHolderFigure textHolder = null;
        Figure pressedFigure = getDrawing().findFigureInside(getView().viewToDrawing(new Point(e.getX(), e.getY())));
        if (pressedFigure instanceof TextHolderFigure) {
            textHolder = (TextHolderFigure) pressedFigure;
            if (!textHolder.isEditable())
                textHolder = null;
        }
        
        if (textHolder != null) {
            createdFigure = null;
            beginEdit(textHolder);
            return;
        }
        if (typingTarget != null) {
            endEdit();
            fireToolDone();
        } else {
            super.mousePressed(e);
            // update view so the created figure is drawn before the floating text
            // figure is overlaid. (Note, fDamage should be null in StandardDrawingView
            // when the overlay figure is drawn because a JTextField cannot be scrolled)
            //view().checkDamage();
            /*
            textHolder = (TextHolderFigure)getCreatedFigure();
            beginEdit(textHolder);*/
        }
    }
    /**
     * This method allows subclasses to do perform additonal user interactions
     * after the new figure has been created.
     * The implementation of this class just invokes fireToolDone.
     */
    protected void creationFinished(Figure createdFigure) {
            beginEdit((TextHolderFigure) createdFigure);
    }
    /*
    public void mouseDragged(java.awt.event.MouseEvent e) {
    }
     */
    public void draw(Graphics2D g) {
        if (createdFigure != null && rubberbandColor != null) {
            g.setColor(rubberbandColor);
            g.draw(getView().drawingToView(createdFigure.getBounds()));
        }
    }
    
    protected void beginEdit(TextHolderFigure textHolder) {
        if (textArea == null) {
            textArea = new FloatingTextArea();
            
            //textArea.addActionListener(this);
        }
        
        if (textHolder != typingTarget && typingTarget != null) {
            endEdit();
        }
        textArea.createOverlay(getView(), textHolder);
        textArea.setBounds(getFieldBounds(textHolder), textHolder.getText());
        textArea.requestFocus();
        typingTarget = textHolder;
    }
    
    
    private Rectangle2D.Double getFieldBounds(TextHolderFigure figure) {
        Rectangle2D.Double r = figure.getDrawingArea();
        Insets2D.Double insets = figure.getInsets();
        insets.subtractTo(r);
        
        // FIXME - Find a way to determine the parameters for grow.
        //r.grow(1,2);
        //r.width += 16;
        r.x -= 1;
        r.y -= 2;
        r.width += 18;
        r.height += 4;
        return r;
    }
    /*
    public void mouseReleased(MouseEvent evt) {
        if (createdFigure != null) {
            TextHolderFigure textHolder = (TextHolderFigure) createdFigure;
            Rectangle2D.Double bounds = createdFigure.getBounds();
            if (bounds.width == 0 && bounds.height == 0) {
                getDrawing().remove(createdFigure);
            } else {
                if (bounds.width < 5 && bounds.height < 5) {
                    createdFigure.willChange();
                    createdFigure.setBounds(new Point2D.Double(bounds.x, bounds.y), new Point2D.Double(bounds.x + 100, bounds.y + 100));
                    createdFigure.changed();
                }
                getView().addToSelection(createdFigure);
            }
            if (createdFigure instanceof CompositeFigure) {
                ((CompositeFigure) createdFigure).layout();
            }
            createdFigure = null;
            getDrawing().fireUndoableEditHappened(creationEdit);
            beginEdit(textHolder);
        }
    }*/
    
    protected void endEdit() {
        if (typingTarget != null) {
            typingTarget.willChange();
            if (textArea.getText().length() > 0) {
                typingTarget.setText(textArea.getText());
            } else {
                if (createdFigure != null) {
                    getDrawing().remove((Figure)getAddedFigure());
                    // Fire undoable edit here!!
                } else {
                    typingTarget.setText("");
                }
            }
            // XXX - implement undo redo behavior here
            typingTarget.changed();
            typingTarget = null;
            
            textArea.endOverlay();
        }
        //	        view().checkDamage();
    }
    
    public void actionPerformed(ActionEvent event) {
        endEdit();
        fireToolDone();
    }
}
